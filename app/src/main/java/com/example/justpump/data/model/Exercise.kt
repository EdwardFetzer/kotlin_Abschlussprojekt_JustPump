package com.example.justpump.data.model

/**
 * Diese Klasse repräsentiert einen Trainingsplan
 **/
data class Exercise (
    val categories: List<ExerciseCategory>,
    val imageId: Int,
    val title: String,
    val description: String
)