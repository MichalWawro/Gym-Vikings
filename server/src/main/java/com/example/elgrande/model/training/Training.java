package com.example.elgrande.model.training;

import com.example.elgrande.model.enums.enums_training.Body;
import com.example.elgrande.model.enums.Level;
import com.example.elgrande.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Level level;
    @Enumerated(EnumType.STRING)
    private Body bodyParts;
    @ManyToMany(mappedBy = "trainings")
    @JsonIgnore
    private List<User> users;
    @ManyToMany
    @JoinTable(name = "training_exercise",
    joinColumns = @JoinColumn(name="training_id"),
    inverseJoinColumns = @JoinColumn(name = "exercise_id"))
    private List<Exercise> exercises;

    public Training(String name, Level level, Body bodyParts) {
        this.name = name;
        this.level = level;
        this.bodyParts = bodyParts;
    }
}
