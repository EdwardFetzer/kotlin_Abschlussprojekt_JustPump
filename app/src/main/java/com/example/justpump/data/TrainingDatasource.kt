package com.example.justpump.data

import com.example.justpump.data.model.Training

class TrainingDatasource {

    fun loadTraining(): List<Training> {
        return listOf(
            Training(1,"Kraftaufbau", "platzhalter"),
            Training(2,"Brust-training", "platzhalter"),
            Training(3,"Rücken-training", "platzhalter"),
            Training(4,"Schulter-training", "platzhalter"),
            Training(5,"Arm-training", "platzhalter"),
            Training(6,"Bauch-training", "platzhalter"),
            Training(7,"Bein-training", "platzhalter"),
        )
    }
}