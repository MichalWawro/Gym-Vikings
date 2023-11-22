package com.example.elgrande.model.user;

import com.example.elgrande.model.diet.Diet;
import com.example.elgrande.model.enums.enums_user.UserLevel;
import com.example.elgrande.model.training.Training;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "\'User\'") // Enclosing "User" in double quotes to indicate it's an identifier
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String gender;
    private int age;
    private int weight;
    private int height;
    @Enumerated(EnumType.STRING)
    private UserLevel userLevel;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Training> training;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Diet> diets = new ArrayList<>();

    public User(String name, String password, String gender, int age, int weight, int height, UserLevel userLevel){
        this.weight = weight;
        this.height = height;
        this.gender=gender;
        this.age=age;
        this.name = name;
        this.password = password;
        this.userLevel = userLevel;
    }

    public User() {
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
