package com.example.elgrande.model.user;

import com.example.elgrande.model.enums.enums_user.UserLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private String name;
    private String password;
    private int weight;
    private final int height;
    private UserLevel userLevel;

    public User(String name, String password, int weight, int height, UserLevel userLevel){
        this.weight = weight;
        this.height = height;
        this.name = name;
        this.password = password;
        this.userLevel = userLevel;
    }

    public double getBMI() {
        return weight / (Math.pow((double)height / 100, 2));
    }
}
