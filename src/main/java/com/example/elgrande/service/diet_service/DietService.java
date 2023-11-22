package com.example.elgrande.service.diet_service;

import com.example.elgrande.model.diet.Diet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DietService {
    private DietRepository dbRepository;
    @Autowired
    public DietService(DietRepository dbRepository) {
        this.dbRepository = dbRepository;
    }

    public Diet getDietById(int id){
        Optional<Diet> diet =  dbRepository.findById(id);
        Diet dietToReturn = diet.get();
        return dietToReturn;
    }

    public List<Diet> getAllDiets() {
        List<Diet> diets = dbRepository.findAll();
        return diets;
    }

    public Diet createDiet(Diet diet) {
        return dbRepository.save(diet);
    }

    public void deleteDiet(int id) {
        dbRepository.deleteById(id);
    }

    public Diet updateDiet(int id, Diet updatedDiet) {
        Optional<Diet> dietToUpdate = dbRepository.findById(id);

        if (dietToUpdate.isPresent()) {
            Diet diet = dietToUpdate.get();

            diet.setDietName(updatedDiet.getDietName());
            //Tutaj wypisać więcej updatów

            return dbRepository.save(diet);
        } else {
            return null;
        }
    }
}
