package com.example.elgrande.controller;

import com.example.elgrande.model.diet.Meal;
import com.example.elgrande.model.enums.enums_diet.Allergy;
import com.example.elgrande.service.diet_service.MealService;
import org.springframework.web.bind.annotation.RestController;

import com.example.elgrande.model.diet.Diet;
import com.example.elgrande.service.diet_service.DietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/diets")
public class DietController {

    private final DietService dietService;
    private final MealService mealService;

    @Autowired
    public DietController(DietService dietService, MealService mealService) {
        this.dietService = dietService;
        this.mealService = mealService;
    }

//    @GetMapping("/{id}")
//    public Diet getDietById(@PathVariable int id) {
//        return dietService.getDietById(id);
//    }
    @GetMapping("/getMealById")
    public Meal getMealById(@RequestParam int mealId) {
        return mealService.getMealById(mealId);
    }

    @GetMapping("/getDietById")
    public Diet getDietById(@RequestParam int dietId) {
        return dietService.getDietById(dietId);
    }

    @GetMapping("/getAll")
    public List<Diet> getAllDiets() {
        return dietService.getAllDiets();
    }

    @GetMapping("/getAllMeals")
    public List<Meal> getAllMeals() {
        return mealService.getAllMeals();
    }

    @PostMapping
    public Diet createDiet(@RequestBody Diet diet) {
        return dietService.createDiet(diet);
    }

//    @DeleteMapping("/{id}")
//    public void deleteDiet(@PathVariable int id) {
//        dietService.deleteDiet(id);
//    }

//    @PutMapping("/{id}")
//    public Diet updateDiet(@PathVariable int id, @RequestBody Diet updatedDiet) {
//        return dietService.updateDiet(id, updatedDiet);
//    }

    //---------------------------------------------------------------------------------

//    @GetMapping("/user/checkForAllergies")
//    public List<Integer> checkForAllergies(@RequestParam List<Diet> diets, List<Allergy> allergies) {return dietService.checkForAllergies(diets, allergies);}
}

