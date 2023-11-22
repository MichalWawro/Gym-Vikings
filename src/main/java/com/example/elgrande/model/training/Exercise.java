package com.example.elgrande.model.training;

import com.example.elgrande.model.enums.Level;
import com.example.elgrande.model.enums.enums_training.Type;
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
    private Level level;
    @Enumerated(EnumType.STRING)
    private Type type;
    private int set;
    private int reps;
    private double weight;
    @ManyToMany(mappedBy = "exercises")
    private List<Training> trainings;

    public Exercise(String name, Level level, Type type, int set, int reps, int weight) {
        this.name = name;
        this.level = level;
        this.type = type;
        this.set = set;
        this.reps = reps;
        this.weight = weight;
    }

}
