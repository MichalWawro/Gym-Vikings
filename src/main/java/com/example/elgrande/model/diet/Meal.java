package com.example.elgrande.model.diet;

import com.example.elgrande.model.enums.enums_diet.DietType;
import com.example.elgrande.model.enums.enums_diet.FoodType;
import jakarta.persistence.*;

import java.util.List;
import java.util.Map;
@Entity
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mealName;
    private int mealCalories;
    private FoodType foodType;
    private DietType dietType;
//    private Map<Ingredient, Integer> mealIngredients; //Ingredient // gram
    @ManyToMany
    @JoinTable(name = "meals", joinColumns = @JoinColumn(name="meal_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private List<Ingredient> mealIngredients;
    private String perpInstructions;

    public Meal(String mealName, int mealCalories, FoodType foodType, DietType dietType, String perpInstructions) {
        this.mealName = mealName;
        this.mealCalories = mealCalories;
        this.foodType = foodType;
        this.dietType = dietType;
        this.perpInstructions = perpInstructions;
    }
    public Meal() {
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
