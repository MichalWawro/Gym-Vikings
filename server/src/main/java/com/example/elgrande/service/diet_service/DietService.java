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

    public void saveAll(List<Diet> diets) {
        dbRepository.saveAll(diets);
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
    public List<Integer> checkForAllergies (List<Diet> diets, List<Allergy> allergies) {
        List<Integer> dietsWithAllergies = new ArrayList<>();

        if(allergies.isEmpty()) {
            return null;
        }
        for(Diet diet : diets) {
            for(Allergy allergy : allergies) {
                if(diet.getAllergies().contains(allergy)) {
                    dietsWithAllergies.add(diets.indexOf(diet));
                    break;
                }
            }
        }

        return dietsWithAllergies;
    }

    public List<Diet> filterDiets(String dietName, int dailyKcal, FoodType foodType) {
        //Add diet sorting by favourites;

        List<Diet> allDiets = getAllDiets();
        List<Diet> filteredDiets = new ArrayList<>();
        List<Allergy> allergiesInDiet = new ArrayList<>();

        for(Diet diet : allDiets) {
            if(diet.getDietName().contains(dietName) && (foodType == null || diet.getFoodType() == foodType)) {
                filteredDiets.add(diet);
            }
        }

        filteredDiets = changeIngredientQuantities(filteredDiets, dailyKcal);

        return filteredDiets;
    }

    public List<Diet> changeIngredientQuantities(List<Diet> diets, Integer desiredCalories) {
        List<Diet> changedDiets = diets;
        List<Integer> gramsInMeal;
        int mealCalories;
        double multiplier;

        for (Diet diet : changedDiets) {
            List<Meal> mealsInDiet = diet.getMeals();
            for (Meal meal : mealsInDiet) {
                mealCalories = meal.getMealCalories();
                multiplier = calculateMultiplier(mealCalories, desiredCalories);
                gramsInMeal = meal.getGrams();
                for (Integer grams : gramsInMeal) {
                    grams = (int) (grams * multiplier);
                }
            }
        }

        return changedDiets;
    }

    public double calculateMultiplier(int mealCalories, int desiredCalories) {
        //Desired = Meal * Multiplier (1000kcal = 4000kcal * 0.25) Multiplier = Desired/Meal (1000/4000 = 0.25)
        return desiredCalories / mealCalories;
    }

    public double calculateCalorieIntake(String gender, int weight, int height, int age, int numberOfTrainings, DietType dietType) {
        int desiredCalorieIntake = 0;
        double activityMultiplier = 0;
        //Number of trainings
        switch (numberOfTrainings) {
            case 1:
            case 2:
                activityMultiplier = 1.4;
                break;
            case 3:
            case 4:
            case 5:
                activityMultiplier = 2; //1.65
                break;
            case 6:
            case 7:
                activityMultiplier = 1.95;
                break;
            default:
                activityMultiplier = 1.2;
                break;
        }

        //Formula
        if(gender.equals("Male")) {
            desiredCalorieIntake = (int) Math.round((10 * weight + 6.25 * height - 5 * age + 5) * activityMultiplier);
        } else if (gender.equals("Female")) {
            desiredCalorieIntake = (int) Math.round((10 * weight + 6.25 * height - 5 * age - 161) * activityMultiplier);
        } else {
            throw new IllegalArgumentException("Invalid gender. Provided gender should be either 'Male' or 'Female'");
        }

        //Diet Type
        switch(dietType) {
            case CUTTING:
                return ((int) (desiredCalorieIntake * 0.85));
            case STAYING:
                return (desiredCalorieIntake);
            case BULKING:
                return((int) (desiredCalorieIntake * 1.15));
            default:
                throw new IllegalArgumentException("Invalid Diet Type in: DietService.java, calculateCalorieIntake()");
        }
    }

    //What meal should user eat each day
//    public Meal whatMealToday (Diet diet) {
//        List<Meal> mealsArray = diet.getMealsArray();
//
//        Calendar c = Calendar.getInstance();
//        c.setFirstDayOfWeek(Calendar.MONDAY);
//        c.setTime(LocalDate.now());
//        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
//
//        return mealsArray.get(dayOfWeek - 1);
//    }
}