package com.example.elgrande.controller;

import com.example.elgrande.model.training.Training;
import com.example.elgrande.service.training_service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainingController {
    private TrainingService trainingService;
    @Autowired
    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @GetMapping("/training")
    public Training getTrainingById(@RequestParam int id){
        return trainingService.getTrainingById(id);
    }
}
