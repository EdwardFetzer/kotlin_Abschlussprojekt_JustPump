package com.example.justpump.data

import android.content.Context
import com.example.justpump.R
import com.example.justpump.data.model.Exercise

class ExerciseDatasource(val context: Context) {

    fun loadExercises(): List<Exercise> {
        return mutableListOf(
            Exercise(1,R.string.brustUebung1, R.drawable.liegestuetze1_1,context.getString(R.string.liegestuetze), "Brust"),
            Exercise(2,R.string.brustUebung2, R.drawable.positiveliegestuetze1_1,context.getString(R.string.positiveLiegestuetze), "Brust"),
            Exercise(3,R.string.brustUebung3, R.drawable.negativeliegestuetze1_1,context.getString(R.string.negativeLiegestuetze), "Brust"),
            Exercise(4,R.string.schulterUebung1, R.drawable.seitenhebenkurzhantel,context.getString(R.string.seitenhebenKurzhantel), "Schulter"),
            Exercise(5,R.string.schulterUebung2, R.drawable.fronthebenkurzhantel1_1,context.getString(R.string.fronthebenKurzhantel), "Schulter"),
            Exercise(6,R.string.schulterUebung3, R.drawable.vorgebeugtesseitenheben1_2,context.getString(R.string.vorgebeugtesSeitenheben), "Schulter"),
            Exercise(7,R.string.rueckenUebung1, R.drawable.klimmzuege,context.getString(R.string.klimmzuege), "Rücken"),
            Exercise(8,R.string.rueckenUebung2, R.drawable.rudern,context.getString(R.string.rudernAmKabelzug), "Rücken"),
            Exercise(9,R.string.rueckenUebung3, R.drawable.kreuzheben,context.getString(R.string.klassischesKreuzheben), "Rücken"),
            Exercise(10,R.string.armeUebung1, R.drawable.hammercurls,context.getString(R.string.kurzhantelCurlsStehend), "Arme"),
            Exercise(11,R.string.armeUebung2, R.drawable.krafttraining,context.getString(R.string.hammerCurlsStehend), "Arme"),
            Exercise(12,R.string.armeUebung3, R.drawable.krafttraining,context.getString(R.string.curlsBizepsmaschiene), "Arme"),
            Exercise(13,R.string.armeUebung4, R.drawable.krafttraining,context.getString(R.string.trizepsKabelPushdown), "Arme"),
            Exercise(14,R.string.armeUebung5, R.drawable.krafttraining,context.getString(R.string.trizepsKabelUeberkopf), "Arme"),
            Exercise(15,R.string.armeUebung6, R.drawable.krafttraining,context.getString(R.string.trizepsTrizepsmaschiene), "Arme"),
            Exercise(16,R.string.bauchUebung1, R.drawable.krafttraining,context.getString(R.string.situps), "Bauch"),
            Exercise(17,R.string.bauchUebung2, R.drawable.krafttraining,context.getString(R.string.crossCrunches), "Bauch"),
            Exercise(18,R.string.bauchUebung3, R.drawable.krafttraining,context.getString(R.string.huefthebenAufBank), "Bauch"),
            Exercise(19,R.string.beineUebung1, R.drawable.krafttraining,context.getString(R.string.beinpresse), "Beine"),
            Exercise(20,R.string.beineUebung2, R.drawable.krafttraining,context.getString(R.string.beinstreckerMaschiene), "Beine"),
            Exercise(21,R.string.beineUebung3, R.drawable.krafttraining,context.getString(R.string.kniebeugenLanghantel), "Beine"),
        )
    }
}