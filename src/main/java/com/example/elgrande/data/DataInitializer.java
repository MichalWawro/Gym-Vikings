package com.example.elgrande.data;

import com.example.elgrande.model.enums.enums_training.Body;
import com.example.elgrande.model.enums.enums_training.Level;
import com.example.elgrande.model.enums.enums_training.Type;
import com.example.elgrande.model.enums.enums_user.UserLevel;
import com.example.elgrande.model.training.Exercise;
import com.example.elgrande.model.training.Training;
import com.example.elgrande.model.user.User;
import com.example.elgrande.repository.UserRepository;
import com.example.elgrande.service.training_service.ExerciseRepository;
import com.example.elgrande.service.training_service.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {
    private final UserRepository userRepository;
    private TrainingRepository trainingRepository;
    private ExerciseRepository exerciseRepository;
@Autowired
    public DataInitializer(UserRepository userRepository, TrainingRepository trainingRepository, ExerciseRepository exerciseRepository) {
        this.userRepository = userRepository;
        this.trainingRepository = trainingRepository;
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        User user1 = new User("User1", "password1", "MALE",24,70, 170, UserLevel.BEGINNER);
//        User user2 = new User("User2", "password2", "FEMALE",26,75, 175, UserLevel.INTERMEDIATE);
//        User user3 = new User("User3", "password3", "MALE",30,80, 180, UserLevel.PROFESSIONAL);
//        User user4 = new User("User4", "password4", "FEMALE",34,85, 185, UserLevel.ELITE);
//        User user5 = new User("User5", "password5", "MALE",44,90, 190, UserLevel.EXPERT);
//
//        Exercise squats = new Exercise("Squats", Level.Elite, Type.CALISCENICKS, 4, 8, 100);
//        Exercise running = new Exercise("Running", Level.Expert, Type.CARDIO, 1, 30, 0); // 0.0 for no weight
//        Exercise pushUps = new Exercise("Push-Ups", Level.Beginner, Type.WEIGHTS, 3, 15, 0);
//        Exercise deadlifts = new Exercise("Deadlifts", Level.Intermediate, Type.WEIGHTS, 3, 6, 225);
//        Exercise yoga = new Exercise("Yoga", Level.Expert, Type.CALISCENICKS, 1, 60, 0);
//
//        Training t1 = new Training("xd", Body.BICEPS, Level.Elite);
//
//
//        userRepository.saveAll(List.of(user1, user2, user3, user4, user5));
//        exerciseRepository.saveAll(List.of(squats,running,pushUps,deadlifts));
//        trainingRepository.saveAll(List.of(t1));
    }
}
