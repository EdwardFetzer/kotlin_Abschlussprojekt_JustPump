package com.example.justpump.ui.exercises

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.justpump.data.ExerciseDatasource
import com.example.justpump.data.model.Exercise
import com.example.justpump.data.model.ExerciseCategory

class ExerciseViewModel(application: Application) : AndroidViewModel(application) {

    private val repExercise = ExerciseDatasource()

    private val _chestExerciseList = MutableLiveData(listOf(ExerciseCategory.BRUST))
    val chestExerciseList: MutableLiveData<List<ExerciseCategory>>
        get() = _chestExerciseList
}