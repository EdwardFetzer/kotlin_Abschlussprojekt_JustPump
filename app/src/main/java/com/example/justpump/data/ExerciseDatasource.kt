package com.example.justpump.data

import com.example.justpump.R
import com.example.justpump.data.model.ExerciseCategory
import com.example.justpump.data.model.Exercise

class ExerciseDatasource {

    fun loadExercises(): List<Exercise> {
        return mutableListOf(
            Exercise(1,R.string.brustUebung1, R.drawable.krafttraining,"Beschreibung", "Brust"),
            Exercise(2,R.string.brustUebung2, R.drawable.krafttraining,"Beschreibung", "Brust"),
            Exercise(3,R.string.brustUebung3, R.drawable.krafttraining,"Beschreibung", "Brust"),
            Exercise(4,R.string.schulterUebung1, R.drawable.krafttraining,"Beschreibung", "Schulter"),
            Exercise(5,R.string.schulterUebung2, R.drawable.krafttraining,"Beschreibung", "Schulter"),
            Exercise(6,R.string.schulterUebung3, R.drawable.krafttraining,"Beschreibung", "Schulter"),
            Exercise(7,R.string.rueckenUebung1, R.drawable.krafttraining,"Beschreibung", "Rücken"),
            Exercise(8,R.string.rueckenUebung2, R.drawable.krafttraining,"Beschreibung", "Rücken"),
            Exercise(9,R.string.rueckenUebung3, R.drawable.krafttraining,"Beschreibung", "Rücken"),
            Exercise(10,R.string.armeUebung1, R.drawable.krafttraining,"Beschreibung", "Arme"),
            Exercise(11,R.string.armeUebung2, R.drawable.krafttraining,"Beschreibung", "Arme"),
            Exercise(12,R.string.armeUebung3, R.drawable.krafttraining,"Beschreibung", "Arme"),
            Exercise(13,R.string.armeUebung4, R.drawable.krafttraining,"Beschreibung", "Arme"),
            Exercise(14,R.string.armeUebung5, R.drawable.krafttraining,"Beschreibung", "Arme"),
            Exercise(15,R.string.armeUebung6, R.drawable.krafttraining,"Beschreibung", "Arme"),
            Exercise(16,R.string.bauchUebung1, R.drawable.krafttraining,"Beschreibung", "Bauch"),
            Exercise(17,R.string.bauchUebung2, R.drawable.krafttraining,"Beschreibung", "Bauch"),
            Exercise(18,R.string.bauchUebung3, R.drawable.krafttraining,"Beschreibung", "Bauch"),
            Exercise(19,R.string.beineUebung1, R.drawable.krafttraining,"Beschreibung", "Beine"),
            Exercise(20,R.string.beineUebung2, R.drawable.krafttraining,"Beschreibung", "Beine"),
            Exercise(21,R.string.beineUebung3, R.drawable.krafttraining,"Beschreibung", "Beine"),
        )
    }
}