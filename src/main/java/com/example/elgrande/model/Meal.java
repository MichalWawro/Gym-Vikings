package com.example.elgrande.model;

import com.example.elgrande.model.enums.DietType;
import com.example.elgrande.model.enums.FoodType;

import java.util.Map;

public class Meal {
    private String mealName;
    private int mealCalories;
    private FoodType foodType;
    private DietType dietType;
    private Map<Ingredient, Integer> mealIngredients; //Ingredient // gram
    private String perpInstructions;

    public Meal(String mealName, int mealCalories, FoodType foodType, DietType dietType, Map<Ingredient, Integer> mealIngredients, String perpInstructions) {
        this.mealName = mealName;
        this.mealCalories = mealCalories;
        this.foodType = foodType;
        this.dietType = dietType;
        this.mealIngredients = mealIngredients;
        this.perpInstructions = perpInstructions;
    }

    public int getMealCalories() {
        return mealCalories;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "mealName='" + mealName + '\'' +
                ", mealCalories=" + mealCalories +
                ", foodType=" + foodType +
                ", dietType=" + dietType +
                ", mealIngredients=" + mealIngredients +
                ", perpInstructions='" + perpInstructions + '\'' +
                '}';
    }
}
