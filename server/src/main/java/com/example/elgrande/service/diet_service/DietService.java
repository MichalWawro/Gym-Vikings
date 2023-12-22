package com.example.elgrande.service.diet_service;

import com.example.elgrande.model.diet.Diet;
import com.example.elgrande.model.diet.Ingredient;
import com.example.elgrande.model.diet.Meal;
import com.example.elgrande.model.enums.enums_diet.Allergy;
import com.example.elgrande.model.enums.enums_diet.DietType;
import com.example.elgrande.model.enums.enums_diet.FoodType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

//    public void deleteDiet(int id) {
//        dbRepository.deleteById(id);
//    }

//    public Diet updateDiet(int id, Diet updatedDiet) {
//        Optional<Diet> dietToUpdate = dbRepository.findById(id);
//
//        if (dietToUpdate.isPresent()) {
//            Diet diet = dietToUpdate.get();
//            diet.setDietName(updatedDiet.getDietName());
//
//            return dbRepository.save(diet);
//        } else {
//            return null;
//        }
//    }

    //Business Logic
//    public List<Integer> checkForAllergies (List<Diet> diets, List<Allergy> allergies) {
//        List<Integer> dietsWithAllergies = new ArrayList<>();
//
//        if(allergies.isEmpty()) {
//            return null;
//        }
//        for(Diet diet : diets) {
//            for(Allergy allergy : allergies) {
//                if(diet.getAllergies().contains(allergy)) {
//                    dietsWithAllergies.add(diets.indexOf(diet));
//                    break;
//                }
//            }
//        }
//
//        return dietsWithAllergies;
//    }

//    public List<Diet> filterDiets(int dailyKcal) {
//        //Add diet sorting by favourites;
//
//        List<Diet> allDiets = getAllDiets();
//        List<Diet> filteredDiets = new ArrayList<>();
//        List<Allergy> allergiesInDiet = new ArrayList<>();
//
//        for(Diet diet : allDiets) {
////            if(diet.getDietName().contains(dietName) && (foodType == null || diet.getFoodType() == foodType)) {
//                filteredDiets.add(diet);
////            }
//        }
//
//        filteredDiets = changeIngredientQuantities(filteredDiets, dailyKcal);
//
//        return filteredDiets;
//    }

//Calculate calories for user
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

//    Ingredient broccoli = new Ingredient("Broccoli", 34);
//    Ingredient tofu = new Ingredient("Tofu", 76);
//    Ingredient tomatoes = new Ingredient("Tomatoes", 19);
//    Ingredient mozzarellaCheese = new Ingredient("Mozzarella Cheese", 248);
//    Meal capreseSalad = new Meal("Caprese Salad", FoodType.VEGETARIAN, List.of(mozzarellaCheese, tomatoes),
//            List.of(150, 100), "1. Slice fresh mozzarella, tomatoes, and arrange on a plate.\n" +
//            "2. Sprinkle fresh basil over the mozzarella and tomatoes.\n" +
//            "3. Drizzle balsamic glaze and olive oil on top.\n" +
//            "4. Season with salt and pepper to taste.");
//    Meal vegetarianStirFry = new Meal("Vegetarian Stir-Fry", FoodType.VEGAN, List.of(tofu, broccoli),
//            List.of(200, 150), "1. Press tofu to remove excess water and cut into cubes.\n" +
//            "2. Stir-fry tofu, broccoli, bell peppers, and carrots in a wok.\n" +
//            "3. Add soy sauce and toss until well-cooked.\n" +
//            "4. Serve over rice or noodles.");
//    Diet dietVegetarianNoMeat = new Diet("Vegetarian Diet with Animal Products", List.of(
//            vegetarianStirFry, capreseSalad),
//            FoodType.VEGETARIAN, "Vegetarian diet with absolutely no meat or fish", List.of(), "https://realfood.tesco.com/media/images/RFO-1400x919-Tomato-and-pesto-spaghetti-da6e99ed-0b77-4285-8122-124232a744b2-0-1400x919.jpg");


//Change quantities
    public Diet changeIngredientQuantities(Diet diet, Integer desiredCalories) {
        if(diet == null) {
            return null;
        }
        List<Meal> mealsArray = diet.getMealsArray();
        List<Integer> gramsArray = new ArrayList<>();

        Diet changedDiet;
        List <Meal> changedMeals = new ArrayList<>();
        List<Integer> gramsInMeal = new ArrayList<>();
        int mealCalories;
        double ingredientMultiplier;

        //Ingredient(String ingredientName, int kcalIn100g);
        //Meal(String mealName, FoodType foodType, List<Ingredient> ingredients, List<Integer> grams,  String perpInstructions);
        //Diet(String dietName, List<Meal> mealsArray, FoodType foodType, String dietDescription, List<Allergy> allergies, String imageUrl);
            for(Meal meal : mealsArray)
            {
                gramsArray.clear();
                gramsArray = meal.getGrams();
                gramsInMeal.clear();
                mealCalories = meal.getMealCalories();
                //Desired = Meal * Multiplier (1000kcal = 4000kcal * 0.25) Multiplier = Desired/Meal (1000/4000 = 0.25)
                ingredientMultiplier = desiredCalories/mealCalories;
                for(Integer grams : gramsArray) {
                    grams = (int) (grams * ingredientMultiplier);
                    gramsInMeal.add(grams);
                }
                changedMeals.add(new Meal(meal.getMealName(), meal.getFoodType(), meal.getIngredients(), gramsInMeal, meal.getPerpInstructions()));
            }
            changedDiet = new Diet(diet.getDietName(), changedMeals, diet.getFoodType(), diet.getDietDescription(), diet.getAllergies(), diet.getImageUrl());

        return changedDiet;
    }
}