package com.example.justpump.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class AllMacros(
    val items: List<Macros>
)
@Entity
data class Macros(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val sugar_g: Float,
    val fiber_g: Float,
    val serving_size_g: Float,
    val sodium_mg: Float,
    val name: String,
    val potassium_mg: Float,
    val fat_saturated_g: Float,
    val fat_total_g: Float,
    val calories: Float,
    val cholesterol_mg: Float,
    val protein_g: Float,
    val carbohydrates_total_g: Float
)