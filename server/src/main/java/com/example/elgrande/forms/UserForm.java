package com.example.elgrande.forms;

import com.example.elgrande.model.enums.enums_diet.Allergy;

import java.util.List;

public record UserForm(String gender, int age, int weight, int amountOfTrainingsPerWeek, int height, List<Allergy> allergies) {

}
