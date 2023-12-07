package com.example.elgrande.service;

import com.example.elgrande.forms.UserForm;
import com.example.elgrande.model.diet.Diet;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;




@Service
public class MainService {
    private ExerciseService exerciseService;
    private TrainingService trainingService;
    private UserService userService;
    private DietService dietService;

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


    public Training getTrainingFormUser(int trainingIndex, int userId){
        UserEntity user = userService.getUserById(userId);
        Training training = user.getTrainings().get(trainingIndex - 1);
        return training;
    }


    public Training getNextTrainingFromUser(UserEntity user){
        List<Training> userTrainings = user.getTrainings();
        for(int i =0;i<userTrainings.size();i++){
            int index = user.getAmountOfTrainingsDone() % 7;
            if(index == i){
                return userTrainings.get(index);
            }else {
                continue;
            }
        }
        return null;
    }


    public UserEntity getPropperUser(int id, int amountOfTrainingsToChange, double addedWeight){
        UserEntity user = userService.getUserById(id);

        List<Training> UserTrainings = user.getTrainings();

        if((user.getAmountOfTrainingsDone() % (amountOfTrainingsToChange * getIncreaseRate(user.getLevel()))) == 0 && user.getAmountOfTrainingsDone() != 0){
            int amountOfTimesToMultiply = user.getTimesToMultiply();
            user.setTimesToMultiply(amountOfTimesToMultiply + 1);
            userService.saveUser(user);
        }
        user.setTrainings(increaseBasedOnLevel(id,trainingService.increaseExercises(addedWeight * user.getTimesToMultiply(),UserTrainings)));
        return user;
    }


    public void levelUp(int userId){
        UserEntity user = userService.getUserById(userId);
        if(user.getAmountOfTrainingsDone() * getIncreaseRate(user.getLevel()) > 28 * getIncreaseRate(user.getLevel())){
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
                if(user.getLevel() != Level.BEGINNER) {
                    if (exercise.getWeight() != 0 || exercise.getType() != Type.CARDIO || exercise.getType() != Type.CALISTHENICS) {
                        exercise.setWeight(20 * getIncreaseRate(user.getLevel()));
                        exercise.setReps(2 * getIncreaseRate(user.getLevel()));
                    }else{
                        exercise.setReps(5 * getIncreaseRate(user.getLevel()));
                    }
                }else{
                    break;
                }
            }
        }
        return userTrainingsToExport;
    }

    public void deleteTrainingFromUser(int trainingid, int userid){
        UserEntity user = userService.getUserById(userid);
        user.getTrainings().remove(trainingid -1);
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


    public List<Diet> suggestDiet(int userId) {
        List<Diet> diets = new ArrayList<>();
        UserEntity user = userService.getUserById(userId);
        System.out.println(user);

        //Getting all required user info;
        String gender = user.getGender();
        int weight = user.getWeight();
        int height = user.getHeight();
        int age = user.getAge();
        int amountOfTrainingsPerWeek = 7;
        DietType dietType = user.getDietType();
        List<Allergy> userAllergies = user.getAllergies();

        //Calculating Daily Calorie Intake
        int dailyKcal = 0;
        dailyKcal = (int) dietService.calculateCalorieIntake(gender, weight, height, age, amountOfTrainingsPerWeek, dietType);

        //Searching for suiting diets;
        List<Diet> foundDiets = dietService.filterDiets("", dailyKcal, user.getFoodType());

        //Adding 3* of the foundDiets to diets list;
        if(foundDiets.isEmpty()) {
            throw new NoSuchElementException("FoundDiets list should not be empty");
        } else if(foundDiets.size() <= 3){
            for(Diet diet : foundDiets) {
                diets.add(diet);
            }
        } else {
            for(int i = 0; i < 3; i++) {
                diets.add(foundDiets.get(i));
            }
        }

        return diets;
    }
}