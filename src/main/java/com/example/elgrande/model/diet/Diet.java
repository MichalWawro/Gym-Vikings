package com.example.elgrande.model.diet;

import com.example.elgrande.model.enums.enums_diet.Allergy;
import com.example.elgrande.model.enums.enums_diet.DietType;
import com.example.elgrande.model.enums.enums_diet.FoodType;
import com.example.elgrande.model.user.User;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Diet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dietName;
    @ManyToMany
    @JoinTable(name = "diets", joinColumns = @JoinColumn(name="diet_id"),
            inverseJoinColumns = @JoinColumn(name = "meal_id"))
    private List<Meal> mealsArray;
    //    private List<User> favouritedBy;
    private List<Allergy> allergies;
    private FoodType foodType;
    private DietType dietType;
    private int dietCalories;
    private int favNumber;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    public Diet(String dietName, List<Meal> mealsArray, FoodType foodType, DietType dietType) {
        this.dietName = dietName;
        this.mealsArray = mealsArray;
        this.foodType = foodType;
        this.dietType = dietType;
        this.dietCalories = calculateDietCalories();
    }
    public Diet() {
    }

    private int calculateDietCalories() {
        int sum = 0;
        for(Meal meal : mealsArray) {
            sum += meal.getMealCalories();
        }
        return sum;
    }
    public void setUser(User user) {
        this.user = user;
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

    //Getters
    public String getDietName() {
        return dietName;
    }

    public List<Meal> getMealsArray() {
        return mealsArray;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public DietType getDietType() {
        return dietType;
    }

    public int getDietCalories() {
        return dietCalories;
    }

    public List<Allergy> getAllergies() {
        return allergies;
    }

    public int getFavNumber() {
        return favNumber;
    }

    //Setters
    public void setDietName(String dietName) {
        this.dietName = dietName;
    }

    public void setMealsArray(List<Meal> mealsArray) {
        this.mealsArray = mealsArray;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public void setDietType(DietType dietType) {
        this.dietType = dietType;
    }
}