package com.example.elgrande.data;

import com.example.elgrande.model.diet.Diet;
import com.example.elgrande.model.diet.Ingredient;
import com.example.elgrande.model.diet.Meal;
import com.example.elgrande.model.enums.Level;
import com.example.elgrande.model.enums.enums_diet.DietType;
import com.example.elgrande.model.enums.enums_diet.FoodType;
import com.example.elgrande.model.enums.enums_training.Body;
import com.example.elgrande.model.enums.enums_training.Type;
import com.example.elgrande.model.training.Exercise;
import com.example.elgrande.model.training.Training;
import com.example.elgrande.model.user.User;
import com.example.elgrande.repository.UserRepository;
import com.example.elgrande.service.diet_service.DietRepository;
import com.example.elgrande.service.diet_service.DietService;
import com.example.elgrande.service.diet_service.IngredientRepository;
import com.example.elgrande.service.diet_service.MealRepository;
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
    private DietRepository dietRepository;
    private MealRepository mealRepository;
    private IngredientRepository ingredientRepository;
@Autowired
    public DataInitializer(UserRepository userRepository, TrainingRepository trainingRepository, ExerciseRepository exerciseRepository, DietRepository dietRepository, MealRepository mealRepository, IngredientRepository ingredientRepository) {
        this.userRepository = userRepository;
        this.trainingRepository = trainingRepository;
        this.exerciseRepository = exerciseRepository;
        this.dietRepository = dietRepository;
        this.mealRepository = mealRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void run(String... args) throws Exception {

// public Diet(String dietName, List<Meal> mealsArray, FoodType foodType, DietType dietType)
// public Meal(String mealName, FoodType foodType, List<Ingredient> ingredients, List<Integer> gramsPerIngredient,  String perpInstructions)

        //Diets -----------------------------------------------------------------------------------------------------------------
/*
        Ingredient egg = new Ingredient("egg", 150);
        Ingredient ham = new Ingredient("ham", 200);

        Meal meal1 = new Meal("meal1", FoodType.NORMAL, List.of(egg, ham), List.of(210, 110), "no instructions");
        Meal meal2 = new Meal("meal2", FoodType.NORMAL, List.of(egg, ham), List.of(220, 120), "no instructions");
        Meal meal3 = new Meal("meal3", FoodType.NORMAL, List.of(egg, ham), List.of(230, 130), "no instructions");
        Meal meal4 = new Meal("meal4", FoodType.NORMAL, List.of(egg, ham), List.of(240, 140), "no instructions");
        Meal meal5 = new Meal("meal5", FoodType.NORMAL, List.of(egg, ham), List.of(250, 150), "no instructions");
        Meal meal6 = new Meal("meal6", FoodType.NORMAL, List.of(egg, ham), List.of(260, 160), "no instructions");
        Meal meal7 = new Meal("meal7", FoodType.NORMAL, List.of(egg, ham), List.of(270, 170), "no instructions");

        Diet diet1 = new Diet("diet1", List.of(meal1, meal2, meal3, meal4, meal5, meal6, meal7), FoodType.NORMAL, DietType.STAYING);
        Diet diet2 = new Diet("diet2", List.of(meal1, meal2, meal3, meal4, meal5, meal6, meal7), FoodType.NORMAL, DietType.STAYING);
        Diet diet3 = new Diet("diet3", List.of(meal1, meal2, meal3, meal4, meal5, meal6, meal7), FoodType.NORMAL, DietType.STAYING);

        ingredientRepository.saveAll(List.of(egg, ham));
        mealRepository.saveAll(List.of(meal1, meal2, meal3, meal4, meal5, meal6, meal7));
        dietRepository.saveAll(List.of(diet1, diet2, diet3));

            //Users -----------------------------------------------------------------------------------------------------------------
        User user1 = new User("User1", "password1", "MALE@gmail.com");
        User user2 = new User("User2", "password2", "FEMALE@gmail.com");
        User user3 = new User("User3", "password3", "MALE2@gmail.com");

        userRepository.saveAll(List.of(user1, user2, user3));
*/

        /*User user1 = new User("User1", "password1", "MALE",24,70, 170, Level.BEGINNER,24);
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

/*       User user1 = new User("User1", "password1", "MALE",24,70, 170, UserLevel.BEGINNER);
        User user2 = new User("User2", "password2", "FEMALE",26,75, 175, UserLevel.INTERMEDIATE);
        User user3 = new User("User3", "password3", "MALE",30,80, 180, UserLevel.PROFESSIONAL);
        User user4 = new User("User4", "password4", "FEMALE",34,85, 185, UserLevel.ELITE);
        User user5 = new User("User5", "password5", "MALE",44,90, 190, UserLevel.EXPERT);*/


        //Exercises-----------------------------------------------------------------------------------------------------------------
       /* Exercise barDipBeginner = new Exercise("Bar Dip", Type.CALISTHENICS, Body.CHEST, 5, 0, 3);
        Exercise barDipIntermediate = new Exercise("Bar Dip", Type.CALISTHENICS, Body.TRICEPS, 10, 0, 3);
        Exercise barDipAdvanced = new Exercise("Bar Dip", Type.CALISTHENICS, Body.TRICEPS, 15, 0, 3);
        Exercise barDipElite = new Exercise("Bar Dip", Type.CALISTHENICS, Body.TRICEPS, 25, 0, 4);
        Exercise barDipExpert = new Exercise("Bar Dip", Type.CALISTHENICS, Body.TRICEPS, 30, 0, 4);

        Exercise benchPressBeginner = new Exercise("Bench Press", Type.WEIGHTS, Body.CHEST, 10, 60, 3);
        Exercise benchPressIntermediate = new Exercise("Bench Press", Type.WEIGHTS, Body.CHEST, 10, 80, 3);
        Exercise benchPressAdvanced = new Exercise("Bench Press", Type.WEIGHTS, Body.CHEST, 5, 100, 4);
        Exercise benchPressElite = new Exercise("Bench Press", Type.WEIGHTS, Body.CHEST, 8, 140, 4);
        Exercise benchPressExpert = new Exercise("Bench Press", Type.WEIGHTS, Body.CHEST, 10, 180, 3);

        Exercise cableChestPressBeginner = new Exercise("Cable Chest Press", Type.WEIGHTS, Body.CHEST, 8, 15, 3);
        Exercise cableChestPressIntermediate = new Exercise("Cable Chest Press", Type.WEIGHTS, Body.CHEST, 10, 45, 3);
        Exercise cableChestPressAdvanced = new Exercise("Cable Chest Press", Type.WEIGHTS, Body.CHEST, 10, 70, 4);
        Exercise cableChestPressElite = new Exercise("Cable Chest Press", Type.WEIGHTS, Body.CHEST, 12, 100, 4);
        Exercise cableChestPressExpert = new Exercise("Cable Chest Press", Type.WEIGHTS, Body.CHEST, 15, 120, 5);

        Exercise dumbbellChestPressBeginner = new Exercise("Dumbbell Chest Press", Type.WEIGHTS, Body.CHEST, 5, 20, 3);
        Exercise dumbbellChestPressIntermediate = new Exercise("Dumbbell Chest Press", Type.WEIGHTS, Body.CHEST, 8, 30, 4);
        Exercise dumbbellChestPressAdvanced = new Exercise("Dumbbell Chest Press", Type.WEIGHTS, Body.CHEST, 10, 50, 4);
        Exercise dumbbellChestPressElite = new Exercise("Dumbbell Chest Press", Type.WEIGHTS, Body.CHEST, 10, 60, 4);
        Exercise dumbbellChestPressExpert = new Exercise("Dumbbell Chest Press", Type.WEIGHTS, Body.CHEST, 10, 80, 5);

        Exercise dumbbellChestFlyBeginner = new Exercise("Dumbbell Chest Fly", Type.WEIGHTS, Body.CHEST, 8, 20, 3);
        Exercise dumbbellChestFlyIntermediate = new Exercise("Dumbbell Chest Fly", Type.WEIGHTS, Body.CHEST, 10, 25, 4);
        Exercise dumbbellChestFlyAdvanced = new Exercise("Dumbbell Chest Fly", Type.WEIGHTS, Body.CHEST, 12, 30, 4);
        Exercise dumbbellChestFlyElite = new Exercise("Dumbbell Chest Fly", Type.WEIGHTS, Body.CHEST, 12, 35, 5);
        Exercise dumbbellChestFlyExpert = new Exercise("Dumbbell Chest Fly", Type.WEIGHTS, Body.CHEST, 15, 40, 5);

        Exercise pushUpBeginner = new Exercise("Push-Up", Type.CALISTHENICS, Body.CHEST, 5, 0, 3);
        Exercise pushUpIntermediate = new Exercise("Push-Up", Type.CALISTHENICS, Body.CHEST, 10, 0, 3);
        Exercise pushUpAdvanced = new Exercise("Push-Up", Type.CALISTHENICS, Body.CHEST, 15, 0, 4);
        Exercise pushUpElite = new Exercise("Push-Up", Type.CALISTHENICS, Body.CHEST, 25, 0, 4);
        Exercise pushUpExpert = new Exercise("Push-Up", Type.CALISTHENICS, Body.CHEST, 35, 0, 5);

        Exercise inclineBenchPressBeginner = new Exercise("Incline Bench Press", Type.WEIGHTS, Body.CHEST, 8, 40, 3);
        Exercise inclineBenchPressIntermediate = new Exercise("Incline Bench Press", Type.WEIGHTS, Body.CHEST, 10, 60,3);
        Exercise inclineBenchPressAdvanced = new Exercise("Incline Bench Press", Type.WEIGHTS, Body.CHEST, 10, 80, 3);
        Exercise inclineBenchPressElite = new Exercise("Incline Bench Press", Type.WEIGHTS, Body.CHEST, 15, 100, 4);
        Exercise inclineBenchPressExpert = new Exercise("Incline Bench Press", Type.WEIGHTS, Body.CHEST, 15, 140, 4);



        Exercise barbellFrontRaiseBeginner = new Exercise("Barbell Front Raise", Type.WEIGHTS, Body.SHOULDER, 5, 20, 3);
        Exercise barbellFrontRaiseIntermediate = new Exercise("Barbell Front Raise", Type.WEIGHTS, Body.SHOULDER, 8, 25, 3);
        Exercise barbellFrontRaiseAdvanced = new Exercise("Barbell Front Raise", Type.WEIGHTS, Body.SHOULDER, 10, 30, 3);
        Exercise barbellFrontRaiseElite = new Exercise("Barbell Front Raise", Type.WEIGHTS, Body.SHOULDER, 10, 35, 4);
        Exercise barbellFrontRaiseExpert = new Exercise("Barbell Front Raise", Type.WEIGHTS, Body.SHOULDER, 10, 40, 4);


        Training training = new Training("Chest Day!",Level.ELITE);

        //userRepository.saveAll(List.of(user1, user2, user3, user4, user5));
        exerciseRepository.saveAll(List.of(barDipElite,benchPressElite,cableChestPressElite,dumbbellChestFlyElite,pushUpElite));
        trainingRepository.saveAll(List.of(training));
*/

    }
}
