package com.example.justpump.data

import com.example.justpump.R
import com.example.justpump.data.model.ExerciseCategory
import com.example.justpump.data.model.Training

class TrainingDatasource {

    fun loadTraining(): List<Training> {
        return listOf(
            Training(1, R.string.brustTitel, R.drawable.brust, "Brust"),
            Training(2, R.string.schulterTitel, R.drawable.schulter, "Schulter"),
            Training(3, R.string.rueckenTitel, R.drawable.ruecken, "Rücken"),
            Training(4, R.string.bauchTitel, R.drawable.krafttraining, "Bauch"),
            Training(5, R.string.armeTitel, R.drawable.krafttraining, "Arme"),
            Training(6, R.string.beineTitel, R.drawable.krafttraining, "Beine"),
        )
    }
}