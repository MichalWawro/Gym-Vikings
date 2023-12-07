package com.example.elgrande.controller;


import com.example.elgrande.forms.LoginForm;
import com.example.elgrande.forms.RegisterForm;
import com.example.elgrande.forms.UserForm;
//import com.example.elgrande.forms.loginForm;
import com.example.elgrande.model.diet.Diet;
import com.example.elgrande.model.training.Training;
import com.example.elgrande.model.user.UserEntity;
import com.example.elgrande.service.MainService;
import com.example.elgrande.service.user_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
//@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private MainService mainService;

    @Autowired
    public UserController(UserService userService, MainService mainService) {
        this.userService = userService;
        this.mainService = mainService;
    }

    @GetMapping("/user/getAllUsers")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/user/register")
    public ResponseEntity<UserEntity> createUser(@RequestBody RegisterForm registerForm) {
        try {
            UserEntity user = userService.registerUser(registerForm);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/user/login")
    public UserEntity login(@RequestBody LoginForm loginForm){
        return userService.login(loginForm);
    }

    @PatchMapping("/user/formDone")
    public ResponseEntity<String> getForm(@RequestParam int userId, @RequestBody UserForm userForm){
            try {
            mainService.setUserInfo(userForm, userId);
            mainService.updateTrainingPlan(userId, 25);
            return ResponseEntity.ok("User information set successfully");
        } catch (Exception e) {
            // Handle exceptions appropriately (e.g., log and return an error response)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error setting user information");
        }
    }
    @PutMapping("/user/trainingDone")
    public UserEntity trainingDone(@RequestParam int userId) {
        try {
            userService.trainingDone(userId);

            mainService.updateTrainingPlan(userId, 25);
            return mainService.getPropperUser(userId, 10, 2.5);
            //return ResponseEntity.ok("Training done successfully");
        } catch (Exception e) {
            //return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                   // .body("Error processing training done request: " + e.getMessage());
        }
        return null;
    }

    @GetMapping("/user/suggestDiets")
    public List<Diet> suggestDiet(@RequestParam int userId){
        return mainService.suggestDiet(userId);
    }

    @GetMapping("/training/provideNextTraining")
    public Training provideTraining(@RequestParam int userId){
        UserEntity user = mainService.getPropperUser(userId,10,2.5);
        return mainService.getOneTrainingFromUser(user);
    }

    @GetMapping("/user/getUserInfo")
    public UserEntity getUserInfo(@RequestParam int userId) {
        UserEntity user = mainService.getPropperUser(userId,10,2.5);
        return user;
    }
    @PostMapping("/user/userData")
    public String submitFormData(@RequestBody UserEntity userData) {
        System.out.println("Received form data: " + userData.getUsername());
        return "Form data received successfully!";
    }
}