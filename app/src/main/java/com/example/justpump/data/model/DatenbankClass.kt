package com.example.justpump.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class DatenbankClass(
    @PrimaryKey(autoGenerate = true)
    val id: Long =0,
    val nutritionName: String,
    val nutritionValue: Float,
    val date: String
)
