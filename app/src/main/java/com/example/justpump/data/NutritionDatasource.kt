package com.example.justpump.data

import com.example.justpump.data.model.Nutrition

class NutritionDatasource {

    fun loadNutritions(): List<Nutrition> {
        return listOf(
            Nutrition(1,"Basic's", "platzhalter"),
            Nutrition(2,"Ernährungs Tipps", "platzhalter"),
            Nutrition(3,"Low-Carb", "platzhalter"),
            Nutrition(4,"Muskelaufbau", "platzhalter"),
        )
    }
}