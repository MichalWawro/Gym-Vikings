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

    Meal spaghettiBolognese = new Meal("Spaghetti Bolognese", FoodType.NORMAL, List.of(),
            List.of(250, 200, 150, 50, 10), "1. Cook spaghetti according to package instructions.\n");

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
}
