package com.example.justpump.data

import android.content.Context
import com.example.justpump.R
import com.example.justpump.data.model.Nutrition

class NutritionDatasource(val context: Context) {

    fun loadNutritions(): List<Nutrition> {
        return listOf(
            Nutrition("Basic",R.drawable.nutritionbasics, context.getString(R.string.nutritionBasics)),
            Nutrition("Abnehmen",R.drawable.nutritionabnehmen, context.getString(R.string.nutritionAbnehmen)),
            Nutrition("Muskelaufbau",R.drawable.nutritionmuskelaufbau, context.getString(R.string.nutritionMuskelaufbau)),
            Nutrition("Basic",R.drawable.nutritionbasics, "platzhalter"),
        )
    }
}