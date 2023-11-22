package com.example.elgrande.controller;


import com.example.elgrande.forms.LoginForm;
import com.example.elgrande.forms.RegisterForm;
import com.example.elgrande.forms.UserForm;
import com.example.elgrande.model.training.Training;
import com.example.elgrande.model.user.User;
import com.example.elgrande.service.MainService;
import com.example.elgrande.service.user_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/user/register")
    public ResponseEntity<String> createUser(@RequestBody RegisterForm registerForm) {
        try {
            userService.registerUser(registerForm);
            return new ResponseEntity<>("User successfully registered", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error registering user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/user/login")
    public User login(@RequestBody LoginForm loginForm){
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
    public ResponseEntity<String> trainingDone(@RequestParam int userId) {
        try {
            userService.trainingDone(userId);
            mainService.increaseAmountOfWeight(userId, 10, 2.5);
            mainService.updateTrainingPlan(userId, 25);
            return ResponseEntity.ok("Training done successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error processing training done request: " + e.getMessage());
        }
    }

    @GetMapping("/training/provideNextTraining")
    public Training provideTraining(@RequestParam int userId){
        return mainService.getOneTrainingFromUser(userId);
    }
}