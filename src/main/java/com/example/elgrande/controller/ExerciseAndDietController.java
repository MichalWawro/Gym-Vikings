package com.example.elgrande.controller;

import com.example.elgrande.model.user.User;
import com.example.elgrande.model.enums.enums_user.UserLevel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExerciseAndDietController {

    // ---- to są testowe endpointy.
    @GetMapping("main")
    public User displayUser(){
        return new User("Bart", "123", "FEMALE",44,78, 190, UserLevel.INTERMEDIATE);
    }

    @GetMapping("bmi")
    public double displayBmi(){
        return new User("Bart", "123", "FEMALE",24,78, 190, UserLevel.INTERMEDIATE). getBMI();
    }

}
