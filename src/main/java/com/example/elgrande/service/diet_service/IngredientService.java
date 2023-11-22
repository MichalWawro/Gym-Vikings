package com.example.elgrande.service.diet_service;

import com.example.elgrande.model.diet.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredientService {
    private IngredientRepository dbRepository;
    @Autowired
    public IngredientService(IngredientRepository dbRepository) {
        this.dbRepository = dbRepository;
    }

    public Ingredient getIngredientById(int id){
        Optional<Ingredient> ingredient =  dbRepository.findById(id);
        Ingredient ingredientToReturn = ingredient.get();
        return ingredientToReturn;
    }
}
