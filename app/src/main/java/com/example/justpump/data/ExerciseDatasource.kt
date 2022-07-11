package com.example.justpump.data

import com.example.justpump.data.model.ExerciseCategory
import com.example.justpump.data.model.Exercise

class ExerciseDatasource {

    fun loadExercises(): MutableList<Exercise> {
        return mutableListOf(
            Exercise(listOf(ExerciseCategory.BRUST),1,"Liegestütze", "platzhalter"),
            Exercise(listOf(ExerciseCategory.BRUST),1,"Positive Liegestütze", "platzhalter"),
            Exercise(listOf(ExerciseCategory.BRUST),1,"Negative Liegestütze", "platzhalter"),
            Exercise(listOf(ExerciseCategory.SCHULTER),1,"Seitenheben-Kurzhantel", "platzhalter"),
            Exercise(listOf(ExerciseCategory.SCHULTER),1,"Frontheben-Kurzhantel", "platzhalter"),
            Exercise(listOf(ExerciseCategory.SCHULTER),1,"Vorgebeugtes Seitenheben", "platzhalter"),
            Exercise(listOf(ExerciseCategory.RUECKEN),1,"Klimmzüge", "platzhalter"),
            Exercise(listOf(ExerciseCategory.RUECKEN),1,"Rudern am Kabelzug", "platzhalter"),
            Exercise(listOf(ExerciseCategory.RUECKEN),1,"Klassisches Kreuzheben", "platzhalter"),
            Exercise(listOf(ExerciseCategory.ARME),1,"Kurzhantel Curls stehend", "platzhalter"),
            Exercise(listOf(ExerciseCategory.ARME),1,"Hammer Curls stehend", "platzhalter"),
            Exercise(listOf(ExerciseCategory.ARME),1,"Curls an der Bizepsmaschine", "platzhalter"),
            Exercise(listOf(ExerciseCategory.ARME),1,"Trizepsdrücken am Kabel: Pushdown", "platzhalter"),
            Exercise(listOf(ExerciseCategory.ARME),1,"Trizepsdrücken am Kabel: über Kopf", "platzhalter"),
            Exercise(listOf(ExerciseCategory.ARME),1,"Trizepsdrücken an der Trizepsmaschine", "platzhalter"),
            Exercise(listOf(ExerciseCategory.BAUCH),1,"Sit-Ups", "platzhalter"),
            Exercise(listOf(ExerciseCategory.BAUCH),1,"Cross Crunches", "platzhalter"),
            Exercise(listOf(ExerciseCategory.BAUCH),1,"Hüftheben auf der Bank", "platzhalter"),
            Exercise(listOf(ExerciseCategory.BEINE),1,"Beinpresse","platzhalter"),
            Exercise(listOf(ExerciseCategory.BEINE),1,"Beinpresse","platzhalter"),
            Exercise(listOf(ExerciseCategory.BEINE),1,"Beinpresse","platzhalter"),
        )
    }
}