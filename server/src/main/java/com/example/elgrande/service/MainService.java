package com.example.elgrande.service;

import com.example.elgrande.forms.UserForm;
import com.example.elgrande.model.diet.Diet;
import com.example.elgrande.model.diet.Meal;
import com.example.elgrande.model.enums.Level;
import com.example.elgrande.model.enums.enums_diet.Allergy;
import com.example.elgrande.model.enums.enums_diet.DietType;
import com.example.elgrande.model.enums.enums_training.Type;
import com.example.elgrande.model.training.Exercise;
import com.example.elgrande.model.training.Training;
import com.example.elgrande.model.user.UserEntity;
import com.example.elgrande.service.diet_service.DietService;
import com.example.elgrande.service.training_service.ExerciseService;
import com.example.elgrande.service.training_service.TrainingService;
import com.example.elgrande.service.user_service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.time.LocalDate;
import java.util.*;




@Service
public class MainService {
    private ExerciseService exerciseService;
    private TrainingService trainingService;
    private UserService userService;
    private DietService dietService;
    Random rand = new Random();


    @Autowired
    public MainService(ExerciseService exerciseService, TrainingService trainingService, UserService userService, DietService dietService) {
        this.exerciseService = exerciseService;
        this.trainingService = trainingService;
        this.userService = userService;
        this.dietService = dietService;
    }


    public void setUserTrainingInfo(UserForm userForm, int id) {
        UserEntity user = userService.getUserById(id);
        user.setWeight(userForm.weight());
        user.setAge(userForm.age());
        user.setHeight(userForm.height());
        user.setGender(userForm.gender());
        user.setAllergies(userForm.allergies());

        double bmi = user.getBMI();
        int weeklyTrainingSessions = userForm.amountOfTrainingsPerWeek();


        if (bmi < 18.5) {
            user.setLevel(Level.BEGINNER);
        } else if (bmi >= 18.5 && bmi < 30) {
            if (user.getAge() < 16) {
                user.setLevel(Level.BEGINNER);
            } else if (user.getAge() >= 16 && user.getAge() < 50) {
                if (user.getGender().equals("Male")) {
                    if (weeklyTrainingSessions < 2) {
                        user.setLevel(Level.BEGINNER);
                    } else if (weeklyTrainingSessions >= 2 && weeklyTrainingSessions < 3) {
                        user.setLevel(Level.INTERMEDIATE);
                    } else if (weeklyTrainingSessions >= 3) {
                        user.setLevel(Level.PROFESSIONAL);
                    }
                } else if (user.getGender().equals("Female")) {
                    if (weeklyTrainingSessions < 3) {
                        user.setLevel(Level.BEGINNER);
                    } else if (weeklyTrainingSessions >= 3 && weeklyTrainingSessions < 5) {
                        user.setLevel(Level.INTERMEDIATE);
                    } else if (weeklyTrainingSessions >= 5) {
                        user.setLevel(Level.PROFESSIONAL);
                    }
                }
            } else if (user.getAge() >= 50) {
                if (user.getGender().equals("Male")) {
                    if (weeklyTrainingSessions < 3) {
                        user.setLevel(Level.BEGINNER);
                    } else if (weeklyTrainingSessions >= 3) {
                        user.setLevel(Level.INTERMEDIATE);
                    }
                } else if (user.getGender().equals("Female")) {
                    if (weeklyTrainingSessions < 4) {
                        user.setLevel(Level.BEGINNER);
                    } else if (weeklyTrainingSessions >= 4) {
                        user.setLevel(Level.INTERMEDIATE);
                    }
                }
            }
        } else if (bmi >= 30) {
            if (user.getAge() < 16) {
                user.setLevel(Level.BEGINNER);
            } else if (user.getAge() >= 16 && user.getAge() < 50) {
                if (user.getGender().equals("Male")) {
                    if (weeklyTrainingSessions < 2) {
                        user.setLevel(Level.BEGINNER);
                    } else if (weeklyTrainingSessions >= 2) {
                        user.setLevel(Level.INTERMEDIATE);
                    }
                } else if (user.getGender().equals("Female")) {
                    if (weeklyTrainingSessions < 3) {
                        user.setLevel(Level.BEGINNER);
                    } else if (weeklyTrainingSessions >= 3) {
                        user.setLevel(Level.INTERMEDIATE);
                    }
                }
            } else if (user.getAge() >= 50) {
                if (user.getGender().equals("Male")) {
                    if (weeklyTrainingSessions < 3) {
                        user.setLevel(Level.BEGINNER);
                    } else if (weeklyTrainingSessions >= 3) {
                        user.setLevel(Level.INTERMEDIATE);
                    }
                } else if (user.getGender().equals("Female")) {
                    if (weeklyTrainingSessions < 4) {
                        user.setLevel(Level.BEGINNER);
                    } else if (weeklyTrainingSessions >= 4) {
                        user.setLevel(Level.INTERMEDIATE);
                    }
                }
            }
        }
        userService.saveUser(user);
    }




    public Level getNextLevel(Level currentLevel) {
        switch (currentLevel) {
            case BEGINNER:
                return Level.INTERMEDIATE;
            case INTERMEDIATE:
                return Level.PROFESSIONAL;
            case PROFESSIONAL:
                return Level.ELITE;
            case ELITE:
                return Level.EXPERT;
            case EXPERT:
                return Level.MASTER;
            case MASTER:
                return Level.MASTER;
            default:
                return null;
        }
    }


    public int getIncreaseRate(Level currentLevel) {
        switch (currentLevel) {
            case BEGINNER:
                return 1;
            case INTERMEDIATE:
                return 2;
            case PROFESSIONAL:
                return 3;
            case ELITE:
                return 4;
            case EXPERT:
                return 5;
            case MASTER:
                return 6;
            default:
                return 1;
        }
    }


    public Training getTrainingFormUser(int trainingId, int userId){
        UserEntity user = userService.getUserById(userId);
        for(Training training:user.getTrainings()){
            if(training.getId() == trainingId){
                return training;
            }
        }
        return null;
    }


    public Training getNextTrainingFromUser(UserEntity user){
        Random random = new Random();
        List<Training> userTrainings = user.getTrainings();
        return userTrainings.get(random.nextInt(userTrainings.size()));
    }


    public UserEntity getPropperUser(int id, int amountOfTrainingsToChange, double addedWeight, int addedReps){
        UserEntity user = userService.getUserById(id);

        List<Training> UserTrainings = user.getTrainings();

        if((user.getAmountOfTrainingsDone() % (amountOfTrainingsToChange * getIncreaseRate(user.getLevel()))) == 0 && user.getAmountOfTrainingsDone() != 0){
            int amountOfTimesToMultiply = user.getTimesToMultiply();
            user.setTimesToMultiply(amountOfTimesToMultiply + 1);
            userService.saveUser(user);
        }
        user.setTrainings(increaseBasedOnLevel(id,trainingService.increaseExercises((addedWeight * user.getTimesToMultiply()),UserTrainings,  (addedReps * getIncreaseRate(user.getLevel())))));
        return user;
    }


    public void levelUp(int userId){
        UserEntity user = userService.getUserById(userId);
        if(user.getAmountOfTrainingsDone() % (28 * getIncreaseRate(user.getLevel())) == 0){
            user.setLevel(getNextLevel(user.getLevel()));
        }
        userService.saveUser(user);
    }


    public List<Training> increaseBasedOnLevel(int userId, List<Training> userTrainings){
        UserEntity user = userService.getUserById(userId);

        List<Training> userTrainingsToExport = userTrainings;

            for (Training training:
             userTrainings) {
            List<Exercise> exercises = training.getExercises();
                    for (Exercise exercise:
                        exercises) {
                    if (exercise.getWeight() == 0) {
                        exercise.setReps(exercise.getReps() + (2 * getIncreaseRate(user.getLevel())));
                    }else{
                        double weight = exercise.getWeight();
                        exercise.setWeight(weight + (5 * getIncreaseRate(user.getLevel())));
                        exercise.setReps(exercise.getReps() + 1);
                    }
                }
            }
        return userTrainingsToExport;
    }

    public void deleteTrainingFromUser(int trainingId, int userid) {
        UserEntity user = userService.getUserById(userid);
        List<Training> trainings = user.getTrainings();

        for(int i=0;i<trainings.size();i++){
            Training training = trainings.get(i);
            if(training.getId() == trainingId){
                trainings.remove(training);
            }
        }

        userService.saveUser(user);
    }

    public  LocalDate addOneWeek(LocalDate date) {
        return date.plusWeeks(1);
    }

    public void giveUserAnotherTrainingPlan(int userId){
        LocalDate date = LocalDate.now();
        UserEntity user = userService.getUserById(userId);

        if(user.getDateOfTrainingAssosiation().isAfter(addOneWeek(user.getDateOfTrainingAssosiation()))){
            List<Training> updatedtrainings = trainingService.getTrainings();

            List<Training> trainingsToSet = trainingService.prepareTrainings(updatedtrainings);
            user.setTrainings(trainingsToSet);
            user.setDateOfTrainingAssosiation(date);
        }
        userService.saveUser(user);
    }

    public void giveUserFirstTrainingPlan(int userId){
        LocalDate date = LocalDate.now();
        UserEntity user = userService.getUserById(userId);
        List<Training> updatedtrainings = trainingService.getTrainings();

        List<Training> trainingsToSet = trainingService.prepareTrainings(updatedtrainings);
        user.setTrainings(trainingsToSet);
        user.setDateOfTrainingAssosiation(date);
        userService.saveUser(user);
    }

//Diets diets diets diets diets
//    public List<Diet> getDietsFormUser(int userId) { // get Diet (bez listy)
//        UserEntity user = userService.getUserById(userId);
//        List<Diet> diets = user.getDiets();
//        if(diets.isEmpty()) {
//            List<Diet> empty = new ArrayList<>();
//            return empty;
//        }
//        return diets;
//    }
//    public void randomizeMeals(int userId) {
//        UserEntity user = userService.getUserById(userId);
//        Diet diet = user.getDiet(0);
//        List<Meal> currentMealsArray = diet.getMealsArray();
//        List<Meal> randomizedMealsArray = new ArrayList<>();
//        int indexToMove = 0;
//
//        while(!currentMealsArray.isEmpty()) {
//            indexToMove = rand.nextInt(currentMealsArray.size());
//            randomizedMealsArray.add(currentMealsArray.get(indexToMove));
//            currentMealsArray.remove(indexToMove);
//        }
//
//        diet.setMeals(randomizedMealsArray);
//    }
//    public Meal getNextMealFromUserDiet(int userId) {
//        UserEntity user = userService.getUserById(userId);
////        if(user.getLastUpdatedDate() + 7days > new Date()) {
////            randomizeMeals(userId);
////            user = userService.getUserById(userId);
////        }
//        Diet diet = user.getDiet(0);
//
//        List<Meal> mealsArray = diet.getMealsArray();
//
//        Calendar c = Calendar.getInstance();
//        c.setFirstDayOfWeek(Calendar.MONDAY);
//        c.setTime(new Date());
//        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
//        int mealIndex = dayOfWeek % mealsArray.size();
//
////        user.setDietUpdateDate(new Date());
//        return mealsArray.get(mealIndex);
//    }


    public int dailyKcalForUser (int userId) {
        UserEntity user = userService.getUserById(userId);
        List<Diet> diets = dietService.getAllDiets();
        //Diet diet = dietService.getDietById(user.getDiet().getDietId());

        String gender = user.getGender();
        int weight = user.getWeight();
        int height = user.getHeight();
        int age = user.getAge();
        int amountOfTrainingsPerWeek = 7;
        DietType dietType = user.getDietType();

        int dailyKcal = 0;
        dailyKcal = (int) dietService.calculateCalorieIntake(gender, weight, height, age, amountOfTrainingsPerWeek, dietType);

        return dailyKcal;
    }

    public List<Diet> getAllDietsChanged (int userId) {
        UserEntity user = userService.getUserById(userId);
        List<Diet> diets = dietService.getAllDiets();
        List<Diet> changedDiets = new ArrayList<>();
        int dailyKcal = dailyKcalForUser(userId);

        for(Diet diet : diets) {
            changedDiets.add(dietService.changeIngredientQuantities(diet, dailyKcal));
        }

        return changedDiets;
    }

    public Diet getDietChanged (int userId) {
        UserEntity user = userService.getUserById(userId);
        Diet diet = user.getDiet();
        if(diet == null) {
            return null;
        }
        Diet changedDiet;
        int dailyKcal = dailyKcalForUser(userId);

        changedDiet = dietService.changeIngredientQuantities(diet, dailyKcal);

        return changedDiet;
    }

    public Diet setDiet(int userId, int dietId) {
        UserEntity user = userService.getUserById(userId);
        Diet diet = dietService.getDietById(dietId);

        user.setDiet(diet);
        userService.saveUser(user);

        return diet;
    }
}