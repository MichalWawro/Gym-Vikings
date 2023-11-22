package com.example.elgrande.data;

import com.example.elgrande.model.enums.Level;
import com.example.elgrande.model.enums.enums_training.Body;
import com.example.elgrande.model.enums.enums_training.Type;
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
      /* User user1 = new User("User1", "password1", "MALE",24,70, 170, Level.BEGINNER,24);
       User user2 = new User("User2", "password2", "FEMALE",26,75, 175, Level.INTERMEDIATE, 10);
       User user3 = new User("User3", "password3", "MALE",30,80, 180, Level.PROFESSIONAL,5);
       User user4 = new User("User4", "password4", "FEMALE",34,85, 185, Level.ELITE,4);
       User user5 = new User("User5", "password5", "MALE",44,90, 190, Level.EXPERT,0);

       Exercise squats = new Exercise("Squats", Level.BEGINNER, Type.WEIGHTS,4,10,100);
       Exercise running = new Exercise("Running", Level.EXPERT, Type.CARDIO, 1, 30, 0); // 0.0 for no weight
       Exercise pushUps = new Exercise("Push-Ups", Level.BEGINNER, Type.WEIGHTS, 3, 15, 0);
       Exercise deadlifts = new Exercise("Deadlifts", Level.INTERMEDIATE, Type.WEIGHTS, 3, 6, 225);
       Exercise yoga = new Exercise("Yoga", Level.EXPERT, Type.CALISCENICKS, 1, 60, 0);

       Training t1 = new Training("xd", Body.BICEPS,Level.BEGINNER);
       Training t2 = new Training("tako",Body.CHEST,Level.INTERMEDIATE);
       Training t3 = new Training("XDX", Body.BACK,Level.EXPERT);

        userRepository.saveAll(List.of(user1, user2, user3, user4, user5));
        exerciseRepository.saveAll(List.of(squats,running,pushUps,deadlifts));
        trainingRepository.saveAll(List.of(t1,t2,t3));*/
    }
}
