package com.example.elgrande.model.user;

import com.example.elgrande.model.diet.Diet;
import com.example.elgrande.model.enums.Level;
import com.example.elgrande.model.enums.enums_diet.Allergy;
import com.example.elgrande.model.training.Exercise;
import com.example.elgrande.model.training.Training;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Data
@Entity(name = "\'User\'")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @CreationTimestamp
    private Date creationDate;
    private String name;
    private String password;
    private String email;
    private String gender;
    private int age;
    private int weight;
    private int height;
    @Enumerated(EnumType.STRING)
    private Level level;
    private int amountOfTrainingsDone;
    private int TrainingsPerWeek;
    @Enumerated(EnumType.STRING)
    private List<Allergy> allergies;
    @ManyToMany
    @JoinTable(name = "user_training",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name = "trening_id"))
    private List<Training> trainings;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Diet> diets;

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public void addDiet(Diet diet) {
        diet.setUser(this);
        diets.add(diet);
    }

    public void removeDiet(Diet diet) {
        diet.setUser(null);
        diets.remove(diet);
    }
    public double getBMI() {
        return weight / (Math.pow((double)height / 100, 2));
    }
}
