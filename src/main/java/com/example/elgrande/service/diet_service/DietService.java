package com.example.elgrande.service.diet_service;

import com.example.elgrande.model.diet.Diet;
import com.example.elgrande.model.diet.Meal;
import com.example.elgrande.model.enums.enums_diet.Allergy;
import com.example.elgrande.model.enums.enums_diet.DietType;
import com.example.elgrande.model.enums.enums_diet.FoodType;
import com.example.elgrande.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class DietService {
    private DietRepository dbRepository;
    @Autowired
    public DietService(DietRepository dbRepository) {
        this.dbRepository = dbRepository;
    }

    public Diet getDietById(int id){
        Optional<Diet> diet =  dbRepository.findById(id);
        Diet dietToReturn = diet.get();
        return dietToReturn;
    }

    public List<Diet> getAllDiets() {
        List<Diet> diets = dbRepository.findAll();
        return diets;
    }

    public Diet createDiet(Diet diet) {
        return dbRepository.save(diet);
    }

    public void deleteDiet(int id) {
        dbRepository.deleteById(id);
    }

    public Diet updateDiet(int id, Diet updatedDiet) {
        Optional<Diet> dietToUpdate = dbRepository.findById(id);

        if (dietToUpdate.isPresent()) {
            Diet diet = dietToUpdate.get();

            diet.setDietName(updatedDiet.getDietName());
            //Tutaj wypisać więcej updatów

            return dbRepository.save(diet);
        } else {
            return null;
        }
    }

    //Business Logic
    public List<Diet> suggestDiet(User user) {
        List<Diet> diets = null;

        //Getting all required user info;
        String gender = user.getGender();
        int weight = user.getWeight();
        int height = user.getHeight();
        int age = user.getAge();
        int amountOfTrainingsPerWeek = user.getTrainingsPerWeek();
        List<Allergy> userAllergies = user.getAllergies();

        int minDailyKcal = 0;
        int maxDailyKcal = 0;
        int desiredCalorieIntake = (int) calculateCalorieIntake(gender, weight, height, age, amountOfTrainingsPerWeek);

        //Calculating minMaxDailyKcal
        switch(user.getDietType()) {
            case CUTTING:
                minDailyKcal = (int) (desiredCalorieIntake * 0.85 - desiredCalorieIntake * 0.1);
                maxDailyKcal = (int) (desiredCalorieIntake * 0.85 + desiredCalorieIntake * 0.1);
                break;
            case STAYING:
                minDailyKcal = (int) (desiredCalorieIntake - desiredCalorieIntake * 0.1);
                maxDailyKcal = (int) (desiredCalorieIntake + desiredCalorieIntake * 0.1);
                break;
            case BULKING:
                minDailyKcal = (int) (desiredCalorieIntake * 1.15 - desiredCalorieIntake * 0.1);
                maxDailyKcal = (int) (desiredCalorieIntake * 1.15 + desiredCalorieIntake * 0.1);
                break;
        }

        //Searching for suiting diets;
        List<Diet> foundDiets = filterDiets(" ", minDailyKcal, maxDailyKcal, user.getFoodType(), user.getDietType(), user.getAllergies());

        //Adding 3* of the foundDiets to diets list;
        if(foundDiets.isEmpty()) {
            throw new NoSuchElementException("FoundDiets list should not be empty");
        }
        else if(foundDiets.size() <= 3){
            for(Diet diet : foundDiets) {
                diets.add(diet);
            }
        }
        else {
            for(int i = 0; i < 3; i++) {
                diets.add(foundDiets.get(i));
            }
        }

        return diets;
    }

    public List<Diet> filterDiets(String dietName, int minKcal, int maxKcal, FoodType foodType, DietType dietType, List<Allergy> allergies) {
        //FoodType and DietType filtering needs rework to support multiple choices
        List<Diet> allDiets = getAllDiets();
        List<Diet> filteredDiets = null;
        List<Allergy> allergiesInDiet;
        boolean isAllergic = false;

        for(Diet diet : allDiets) {
            if(dietName.contains(diet.getDietName()) && diet.getDietCalories() > minKcal &&
                    diet.getDietCalories() < maxKcal && diet.getFoodType() == foodType &&
                    diet.getDietType() == dietType) {
                isAllergic = false;
                allergiesInDiet = diet.getAllergies();
                for(Allergy allergy : allergies) {
                    if(allergiesInDiet.contains(allergy)) {
                        isAllergic = true;
                    }
                }
                if(!isAllergic) {
                    filteredDiets.add(diet);
                }
            }
        }
        //Add diet sorting by favourites;
        return filteredDiets;
    }

    public double calculateCalorieIntake(String gender, int weight, int height, int age, int numberOfTrainings) {
        double activityMultiplier = 0;
        switch (numberOfTrainings) {
            case 1:
            case 2:
                activityMultiplier = 1.4;
                break;
            case 3:
            case 4:
            case 5:
                activityMultiplier = 1.65;
                break;
            case 6:
            case 7:
                activityMultiplier = 1.95;
                break;
            default:
                activityMultiplier = 1.2;
                break;
        }
        if(gender == "Male") {
            return Math.round((10 * weight + 6.25 * height - 5 * age + 5) * activityMultiplier);
        } else if (gender == "Female") {
            return Math.round((10 * weight + 6.25 * height - 5 * age - 161) * activityMultiplier);
        } else {
            throw new IllegalArgumentException("Invalid gender. Provided gender should be either 'Male' or 'Female'");
        }
    }

    //What meal should user eat each day
    public Meal whatMealToday (Diet diet) {
        List<Meal> mealsArray = diet.getMealsArray();

        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(LocalDate.now());
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

        return mealsArray.get(dayOfWeek - 1);
    }
}