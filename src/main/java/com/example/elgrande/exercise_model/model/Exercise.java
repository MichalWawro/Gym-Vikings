package com.example.elgrande.exercise_model.model;

import com.example.elgrande.exercise_model.enums.Level;
import com.example.elgrande.exercise_model.enums.Type;

public class Exercise {
    private String name;
    private Level levelOfIntensity;
    private Type type;
    private int reps;
    private int weight;

    public Exercise(String name, Level levelOfIntensity, Type type, int reps, int weight) {
        this.name = name;
        this.levelOfIntensity = levelOfIntensity;
        this.type = type;
        this.reps = reps;
        this.weight = weight;
    }
}
