package com.example.elgrande.exercise_model.model;

import com.example.elgrande.exercise_model.enums.Body;
import com.example.elgrande.exercise_model.enums.Level;

public class Training {
    private String name;
    private Body bodyParts;
    private Level level;

    public Training(String name, Body bodyParts, Level level) {
        this.name = name;
        this.bodyParts = bodyParts;
        this.level = level;
    }
}
