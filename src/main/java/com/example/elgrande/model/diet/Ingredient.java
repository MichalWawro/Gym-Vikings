package com.example.elgrande.model.diet;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int kcalIn100g;
    @ManyToMany(mappedBy = "ingredients")//, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Meal> meals;
    public Ingredient(String name, int kcalIn100g) {
        this.name = name;
        this.kcalIn100g = kcalIn100g;
    }

//    public int getKcal(int grams){ return (int)((kcalIn100g/100)*grams);}
    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", kcalIn100g=" + kcalIn100g +
                '}';
    }
}
