package com.example.elgrande.model.training;

import com.example.elgrande.model.enums.enums_training.Body;
import com.example.elgrande.model.enums.enums_training.Level;

import java.util.List;

public class Training {
    private String name;
    private Body bodyParts;
    private Level level;

    private List<Exercise> exercises;

    public Training(String name, Body bodyParts, Level level) {
        this.name = name;
        this.bodyParts = bodyParts;
        this.level = level;
    }
}
