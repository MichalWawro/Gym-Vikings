package com.example.elgrande.model.training;


import com.example.elgrande.model.enums.Level;

import com.example.elgrande.model.enums.enums_training.Body;

import com.example.elgrande.model.enums.enums_training.Type;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Enumerated(EnumType.STRING)

    private Type type;
    @Enumerated(EnumType.STRING)
    private Body body;
    private int set;
    private int reps;
    private double weight;
    private String img;
    private String video;
    @ManyToMany(mappedBy = "exercises")
    @JsonIgnore
    private List<Training> trainings;


    public Exercise(String name,Type type, Body body, int reps, int weight, int set, String img,String video) {
        this.name = name;
        this.type = type;
        this.body = body;
        this.set = set;
        this.reps = reps;
        this.weight = weight;
        this.img = img;
        this.video = video;
    }

}
