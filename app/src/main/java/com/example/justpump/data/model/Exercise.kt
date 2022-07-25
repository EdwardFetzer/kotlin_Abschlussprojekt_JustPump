package com.example.justpump.data.model

/**
 * Diese Klasse repräsentiert eine Übung
 **/
data class Exercise (
    val Id: Long,
    val stringResource: Int,
    val imageResource: Int,
    val description: String,
    val category: String
    //val categories: List<ExerciseCategory>,
)