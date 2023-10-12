package com.example.elgrande.model;

import com.example.elgrande.model.enums.DietType;
import com.example.elgrande.model.enums.FoodType;

import java.util.ArrayList;

public class Diet {
    private String dietName;
    private ArrayList<Meal> mealsArray;
    private FoodType foodType;
    private DietType dietType;
    private int dietCalories;

    public Diet(String dietName, ArrayList<Meal> mealsArray, FoodType foodType, DietType dietType) {
        this.dietName = dietName;
        this.mealsArray = mealsArray;
        this.foodType = foodType;
        this.dietType = dietType;
        this.dietCalories = calculateDietCalories();
    }

    private int calculateDietCalories() {
        int sum = 0;
        for(Meal meal : mealsArray) {
            sum += meal.getMealCalories();
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Diet{" +
                "dietName='" + dietName + '\'' +
                ", mealsArray=" + mealsArray +
                ", foodType=" + foodType +
                ", dietType=" + dietType +
                ", dietCalories=" + dietCalories +
                '}';
    }
}
