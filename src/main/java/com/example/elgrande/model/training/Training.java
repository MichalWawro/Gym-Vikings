package com.example.elgrande.model.training;

import com.example.elgrande.model.enums.enums_training.Body;
import com.example.elgrande.model.enums.enums_training.Level;
import com.example.elgrande.model.user.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Body bodyParts;
    @Enumerated(EnumType.STRING)
    private Level level;
    @ManyToOne
    private User user;
    @ManyToMany
    @JoinTable(name = "trainings",
    joinColumns = @JoinColumn(name="training_id"),
    inverseJoinColumns = @JoinColumn(name = "exercise_id"))
    private List<Exercise> exercises;

    public Training(String name, Body bodyParts, Level level) {
        this.name = name;
        this.bodyParts = bodyParts;
        this.level = level;
    }
}
