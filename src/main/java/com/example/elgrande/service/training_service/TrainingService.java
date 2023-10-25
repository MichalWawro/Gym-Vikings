package com.example.elgrande.service.training_service;

import com.example.elgrande.model.training.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrainingService {

    private TrainingRepository dbRepository;
    @Autowired
    public TrainingService(TrainingRepository dbRepository) {
        this.dbRepository = dbRepository;
    }

    public Training getTrainingById(int id){
        Optional<Training> training =  dbRepository.findById(id);
        Training trainingToReturn = training.get();
        return trainingToReturn;
    }
}
