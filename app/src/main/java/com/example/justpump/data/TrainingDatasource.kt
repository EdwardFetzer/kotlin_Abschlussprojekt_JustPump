package com.example.justpump.data

import com.example.justpump.data.model.ExerciseCategory
import com.example.justpump.data.model.Training

class TrainingDatasource {

    fun loadTraining(): List<Training> {
        return listOf(
            Training(ExerciseCategory.BRUST,2,"Brust", "platzhalter"),
            Training(ExerciseCategory.SCHULTER,2,"Schulter", "platzhalter"),
            Training(ExerciseCategory.RUECKEN,2,"Rücken", "platzhalter"),
            Training(ExerciseCategory.BAUCH,2,"Bauch", "platzhalter"),
            Training(ExerciseCategory.ARME,2,"Arme", "platzhalter"),
            Training(ExerciseCategory.BEINE,2,"Beine", "platzhalter"),
        )
    }
}