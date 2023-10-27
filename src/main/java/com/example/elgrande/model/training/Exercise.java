package com.example.elgrande.model.training;

import com.example.elgrande.model.enums.enums_training.Body;
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
    private Type type;
    @Enumerated(EnumType.STRING)
    private Body body;
    private int set;
    private int reps;
    private int weight;

    public Exercise(String name, Type type, Body body, int reps, int weight, int set) {
        this.name = name;
        this.type = type;
        this.body = body;
        this.set = set;
        this.reps = reps;
        this.weight = weight;
    }

}
