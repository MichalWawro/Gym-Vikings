package com.example.elgrande.model.diet;

import com.example.elgrande.model.enums.enums_diet.Allergy;
import com.example.elgrande.model.enums.enums_diet.DietType;
import com.example.elgrande.model.enums.enums_diet.FoodType;
import com.example.elgrande.model.user.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Diet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dietName;
    @ManyToMany
    @JoinTable(name = "diets", joinColumns = @JoinColumn(name="diet_id"),
            inverseJoinColumns = @JoinColumn(name = "meal_id"))
    private List<Meal> meals;
    //    private List<User> favouritedBy;
    private List<Allergy> allergies;
    private FoodType foodType;
    private DietType dietType;
    private int dietCaloriesPerDay;
    private int favNumber;

    @ManyToMany(mappedBy = "diets")
    @JsonIgnore
    private List<UserEntity> users;
    public Diet(String dietName, List<Meal> mealsArray, FoodType foodType, DietType dietType) {
        this.dietName = dietName;
        this.meals = mealsArray;
        this.foodType = foodType;
        this.dietType = dietType;
        this.dietCaloriesPerDay = calculateDailyCalories();
    }

    public Diet() {
    }

    private int calculateDailyCalories() {
        double sum = 0;
        for(Meal meal : meals) {
            sum += meal.getMealCalories();
        }
        return (int) sum/7;
    }

    public void setUser(List<UserEntity> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Diet{" +
                "dietName='" + dietName + '\'' +
                ", mealsArray=" + meals +
                ", foodType=" + foodType +
                ", dietType=" + dietType +
                ", dietCalories=" + dietCaloriesPerDay +
                '}';
    }

    //Getters
    public String getDietName() {
        return dietName;
    }

    public List<Meal> getMealsArray() {
        return meals;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public DietType getDietType() {
        return dietType;
    }

    public int getDailyCalories() {
        return dietCaloriesPerDay;
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
        this.meals = mealsArray;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public void setDietType(DietType dietType) {
        this.dietType = dietType;
    }
}