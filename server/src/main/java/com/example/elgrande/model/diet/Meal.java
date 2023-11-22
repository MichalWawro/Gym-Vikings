package com.example.elgrande.model.diet;

import com.example.elgrande.model.enums.enums_diet.DietType;
import com.example.elgrande.model.enums.enums_diet.FoodType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.sql.ast.tree.from.MappedByTableGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Entity
@Data
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mealName;
    private int mealCalories;
    private FoodType foodType;
    private String perpInstructions;
    @ManyToMany(mappedBy = "meals")
    @JsonIgnore
    private List<Diet> diets;
    @ManyToMany//(cascade = CascadeType.ALL)
    @JoinTable(name = "meals", joinColumns = @JoinColumn(name="meal_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private List<Ingredient> ingredients;
    @ElementCollection
    @CollectionTable(name = "meal_grams", joinColumns = @JoinColumn(name = "meal_id"))
    @Column(name = "gram_value")
    private List<Integer> grams;

    public Meal(String mealName, FoodType foodType, List<Ingredient> ingredients, List<Integer> gramsPerIngredient,  String perpInstructions) {
        this.mealName = mealName;
        this.mealCalories = calculateMealCalories(ingredients, gramsPerIngredient);
        this.foodType = foodType;
        this.perpInstructions = perpInstructions;
        this.ingredients = ingredients;
    }
    public Meal() {
    }

    public  int calculateMealCalories(List<Ingredient> ingredients, List<Integer> grams) {
        int sum = 0;
        for(int i = 0; i < ingredients.size(); i++) {
            sum += (ingredients.get(i).getKcalIn100g() * grams.get(i) / 100);
        }

        return sum;
    }


    public int getMealCalories() {
        return mealCalories;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "mealName='" + mealName + '\'' +
                ", mealCalories=" + mealCalories +
                ", foodType=" + foodType +
                ", mealIngredients=" + ingredients +
                ", perpInstructions='" + perpInstructions + '\'' +
                '}';
    }
}
