package com.example.elgrande.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.elgrande.model.diet.Diet;
import com.example.elgrande.service.diet_service.DietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/diets")
public class DietController {

    private final DietService dietService;

    @Autowired
    public DietController(DietService dietService) {
        this.dietService = dietService;
    }

    @GetMapping("/{id}")
    public Diet getDietById(@PathVariable int id) {
        return dietService.getDietById(id);
    }

    @GetMapping
    public List<Diet> getAllDiets() {
        return dietService.getAllDiets();
    }

    @PostMapping
    public Diet createDiet(@RequestBody Diet diet) {
        return dietService.createDiet(diet);
    }

    @DeleteMapping("/{id}")
    public void deleteDiet(@PathVariable int id) {
        dietService.deleteDiet(id);
    }

    @PutMapping("/{id}")
    public Diet updateDiet(@PathVariable int id, @RequestBody Diet updatedDiet) {
        return dietService.updateDiet(id, updatedDiet);
    }
}

