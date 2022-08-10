package com.example.justpump.data

import com.example.justpump.R
import com.example.justpump.data.model.Nutrition

class NutritionDatasource {

    fun loadNutritions(): List<Nutrition> {
        return listOf(
            Nutrition("Basic",R.drawable.krafttraining, "platzhalter"),
            Nutrition("Basic",R.drawable.krafttraining, "platzhalter"),
            Nutrition("Basic",R.drawable.krafttraining, "platzhalter"),
            Nutrition("Basic",R.drawable.krafttraining, "platzhalter"),
        )
    }
}