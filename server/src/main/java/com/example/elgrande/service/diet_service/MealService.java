package com.example.elgrande.service.diet_service;

import com.example.elgrande.model.diet.Diet;
import com.example.elgrande.model.diet.Meal;
import com.example.elgrande.model.enums.enums_diet.FoodType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealService {
    private MealRepository dbRepository;

    public void saveAll(List<Meal> meals) {
        dbRepository.saveAll(meals);
    }
    @Autowired
    public MealService(MealRepository dbRepository) {
        this.dbRepository = dbRepository;
    }

    public Meal getMealById(int id){
        Optional<Meal> meal =  dbRepository.findById(id);
        Meal mealToReturn = meal.get();
        return mealToReturn;
    }

    public List<Meal> getAllMeals() {
        List<Meal> meals = dbRepository.findAll();
        return meals;
    }
}
