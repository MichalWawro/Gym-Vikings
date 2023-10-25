package com.example.elgrande.model.training;

import com.example.elgrande.model.enums.enums_training.Level;
import com.example.elgrande.model.enums.enums_training.Type;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Level levelOfIntensity;
    @Enumerated(EnumType.STRING)
    private Type type;
    private int set;
    private int reps;
    private int weight;

    public Exercise(String name, Level levelOfIntensity, Type type, int set, int reps, int weight) {
        this.name = name;
        this.levelOfIntensity = levelOfIntensity;
        this.type = type;
        this.set = set;
        this.reps = reps;
        this.weight = weight;
    }

}
