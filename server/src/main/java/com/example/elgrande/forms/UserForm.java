package com.example.elgrande.forms;

import com.example.elgrande.model.enums.enums_diet.Allergy;

import java.util.List;

public record UserForm(
                       String gender,
                       int age,
                       int weight,
                       int height, int amountOfTrainingsPerWeek, int amountoftrainigsperweekwanted, List<Allergy> allergies) {
}
