package com.example.elgrande.model.user;

import com.example.elgrande.model.enums.enums_user.UserLevel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    public User() {
    }
    public User(String name, String password, String gender, int age, int weight, int height, UserLevel userLevel){
        this.weight = weight;
        this.height = height;
        this.gender=gender;
        this.age=age;
        this.name = name;
        this.password = password;
        this.userLevel = userLevel;
    }

    public double getBMI() {
        return weight / (Math.pow((double)height / 100, 2));
    }
}
