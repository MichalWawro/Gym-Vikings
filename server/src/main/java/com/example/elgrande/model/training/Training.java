package com.example.elgrande.model.training;

import com.example.elgrande.model.enums.enums_training.Body;
import com.example.elgrande.model.enums.Level;
import com.example.elgrande.model.user.UserEntity;
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
    @ElementCollection(targetClass = Body.class)
    @CollectionTable(name = "body_parts", joinColumns = @JoinColumn(name = "your_entity_id"))
    @Enumerated(EnumType.STRING)
    private List<Body> bodyParts;
    @ManyToMany(mappedBy = "trainings")
    @JsonIgnore
    private List<UserEntity> users;
    @ManyToMany
    @JoinTable(name = "training_exercise",
    joinColumns = @JoinColumn(name="training_id"),
    inverseJoinColumns = @JoinColumn(name = "exercise_id"))
    private List<Exercise> exercises;

    public Training(String name, List<Body> bodyParts, List<Exercise> exercises) {
        this.name = name;
        this.bodyParts = bodyParts;
        this.exercises = exercises;
    }
}
