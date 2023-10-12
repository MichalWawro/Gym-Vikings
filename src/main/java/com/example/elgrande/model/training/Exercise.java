package com.example.elgrande.model.training;

import com.example.elgrande.model.enums.enums_training.Level;
import com.example.elgrande.model.enums.enums_training.Type;

public class Exercise {
    private String name;
    private Level levelOfIntensity;
    private Type type;
    private int set;
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
