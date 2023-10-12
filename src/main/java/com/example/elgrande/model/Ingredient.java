package com.example.elgrande.model;

public class Ingredient {
    private String name;
    private int kcalIn100g;
    public Ingredient(String name, int kcalIn100g) {
        this.name = name;
        this.kcalIn100g = kcalIn100g;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", kcalIn100g=" + kcalIn100g +
                '}';
    }
}
