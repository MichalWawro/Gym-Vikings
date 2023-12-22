package com.example.elgrande.model.diet;

import com.example.elgrande.model.enums.enums_diet.DietType;
import com.example.elgrande.model.enums.enums_diet.FoodType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
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
    @Column(length = 510)
    private String perpInstructions;
    @ManyToMany(mappedBy = "meals")
    @JsonIgnore
    private List<Diet> diets;
    @ManyToMany//(cascade = CascadeType.ALL)
    @JoinTable(name = "meal_to_ingredients", joinColumns = @JoinColumn(name="meal_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private List<Ingredient> ingredients;

    @ElementCollection
    @CollectionTable(name = "meal_grams", joinColumns = @JoinColumn(name = "meal_id"))
    @Column(name = "gram_value")
    @OrderColumn(name = "gram_order") // Add this annotation to maintain the order
//    @Cascade(CascadeType.ALL)
    private List<Integer> grams;

//    @ElementCollection
//    @CollectionTable(name = "meal_grams", joinColumns = @JoinColumn(name = "meal_id"))
//    @Column(name = "gram_value")
//    private List<Integer> grams;

    public Meal(String mealName, FoodType foodType, List<Ingredient> ingredients, List<Integer> grams,  String perpInstructions) {
        this.mealName = mealName;
        this.mealCalories = calculateMealCalories(ingredients, grams);
        this.foodType = foodType;
        this.ingredients = ingredients;
        this.grams = grams;
        this.perpInstructions = perpInstructions;
    }
    public Meal() {
    }

    public int calculateMealCalories(List<Ingredient> ingredients, List<Integer> grams) {
        System.out.println(ingredients);
        System.out.println(grams);
//        System.out.println(ingredients.get(0));
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
