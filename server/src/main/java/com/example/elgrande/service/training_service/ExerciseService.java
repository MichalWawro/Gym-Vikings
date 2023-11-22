package com.example.elgrande.service.training_service;

import com.example.elgrande.model.enums.Level;
import com.example.elgrande.model.enums.enums_training.Body;
import com.example.elgrande.model.enums.enums_training.Type;
import com.example.elgrande.model.training.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExerciseService {
    private ExerciseRepository exerciseRepository;
@Autowired
    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public Exercise getExerciseById(int id){
    Optional<Exercise> exercise = exerciseRepository.findById(id);
    if(exercise.isPresent()){
        return exercise.get();
    }else{
        return null;
        }
    }

    public void addExercise(Exercise exercise){
    exerciseRepository.save(exercise);
    }



    public void deleteExerciseById(int id){
        Exercise exercise = getExerciseById(id);
        exerciseRepository.delete(exercise);
    }

    public Exercise createExercise(String name, Level level, Type type, Body body, int set, int reps, int weight){
    Exercise exercise = new Exercise(name,level,type,body,set,reps,weight);
    return exercise;
    }

}
