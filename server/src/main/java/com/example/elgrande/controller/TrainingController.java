package com.example.elgrande.controller;

import com.example.elgrande.model.training.Training;
import com.example.elgrande.service.training_service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrainingController {
    private TrainingService trainingService;
    @Autowired
    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @GetMapping("/training/getTraining")
    public Training getTrainingById(@RequestParam int id){
        return trainingService.getTrainingById(id);
    }

    @GetMapping("/training/getAllTrainings")
    public List<Training> getAllTrainings(){
        return trainingService.GetAllTrainings();
    }


}
