package com.example.elgrande.service.training_service;

import com.example.elgrande.model.enums.enums_training.Body;
import com.example.elgrande.model.enums.Level;
import com.example.elgrande.model.enums.enums_training.Type;
import com.example.elgrande.model.training.Exercise;
import com.example.elgrande.model.training.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class TrainingService {

    private TrainingRepository trainingRepository;
    @Autowired
    public TrainingService(TrainingRepository dbRepository) {
        this.trainingRepository = dbRepository;
    }

    public List<Training> getAllTrainings(){
        return trainingRepository.findAll();
    }

    public Training getTrainingById(int id){
        Optional<Training> training =  trainingRepository.findById(id);
        if(training.isPresent()){
            return training.get();
        }else {
            return null;
        }
    }


    public void addTraining(Training training){
        try {
            trainingRepository.save(training);
        }catch (Exception e){
            System.err.println("cant save training: "+e.getMessage());
        }
    }

    public void deleteTrainingById(int id){
        Training training = getTrainingById(id);
        trainingRepository.delete(training);
    }

    public Training createTraining(String name, Level levelOfIntencity, List<Body> bodyParts){

        Training training = new Training(name,levelOfIntencity,bodyParts);

        return training;
    }

    public List<Training> GetAllTrainings(){
        return trainingRepository.findAll();
    }


    //------------------------------------------UPDATES-------------------------------------------------------


    public Training updateTraining(int id, List<Exercise> exercises, String name, Level levelOfIntencity, List<Body> bodyParts){
        Training training = getTrainingById(id);

        try {
            training.setBodyParts(bodyParts);
            training.setLevel(levelOfIntencity);
            training.setName(name);
            training.setExercises(exercises);
        } catch (Exception e){
            System.err.println("couldnt update training: " + e.getMessage());
        }
        return training;
    }

    public Training updateTraining(int id, List<Exercise> exercises, Level levelOfIntencity, List<Body> bodyParts){
        Training training = getTrainingById(id);

        try {
            training.setLevel(levelOfIntencity);
            training.setBodyParts(bodyParts);
            training.setExercises(exercises);
        } catch (Exception e){
            System.err.println("couldnt update training: " + e.getMessage());
        }
        return training;
    }
    public Training updateTraining(int id, List<Exercise> exercises,Level levelOfInrencity){
        Training training = getTrainingById(id);

        try {
            training.setLevel(levelOfInrencity);
            training.setExercises(exercises);
        } catch (Exception e){
            System.err.println("couldnt update training: " + e.getMessage());
        }
        return training;
    }
    public Training updateTraining(int id, List<Exercise> exercises){
        Training training = getTrainingById(id);

        try {;
            training.setExercises(exercises);
        } catch (Exception e){
            System.err.println("couldnt update training: " + e.getMessage());
        }
        return training;
    }
    // ----------------------------------------------------------------------------

    public List<Training> getTrainingsByLevel(Level level){
        List<Training> trainings = getAllTrainings();
        List<Training> trainingsToExport = new ArrayList<>();
        for (Training training:
             trainings) {
            if(training.getLevel() == level){
                trainingsToExport.add(training);
            }
        }
        return trainingsToExport;
    }

    public List<Training> increaseExercises(double addedWeight, List<Training> trainings) {
        Random random = new Random();
        List<Training> userTrainings = trainings;
        for (Training training :
                userTrainings) {
            List<Exercise> exercises = training.getExercises();

            if (!exercises.isEmpty()) {
                Exercise exercise = exercises.get(random.nextInt(exercises.size()));
                if (exercise.getWeight() != 0 || exercise.getType() != Type.CARDIO) {
                    double weight = exercise.getWeight();
                    exercise.setWeight(weight + addedWeight);
                } else {
                    exercise.setReps(exercise.getReps() + 1);
                }
            }else{
                return null;
            }
        }
        return userTrainings;
    }

    public List<Training> prepareTrainings(List<Training> Trainings, int capacity) {
        Random random = new Random();

        List bodyParts = new ArrayList<>();

        List<Training> trainingsToSet = new ArrayList<>(capacity);

        if (Trainings.size() > 0) {

            for (int i = 0; i < Trainings.size(); i++) {

                Training training = Trainings.get(random.nextInt(Trainings.size()));
                Body bodyPart = training.getBodyParts().get(0);
                if (!bodyParts.contains(bodyPart)) {
                    bodyParts.add(bodyPart);
                    trainingsToSet.add(training);
                } else {
                    continue;
                }
            }
        }
        return trainingsToSet;
    }
}
