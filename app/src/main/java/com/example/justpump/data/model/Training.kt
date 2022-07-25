package com.example.justpump.data.model

/**
 * Diese Klasse repräsentiert einen Trainingsplan
 **/
data class Training(
    //val category: ExerciseCategory,
    val id: Long,
    val stringResource: Int,
    val imageResource: Int,
    //val description: String,
    val category: String
)