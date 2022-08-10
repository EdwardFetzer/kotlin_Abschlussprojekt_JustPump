package com.example.justpump

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.justpump.data.*
import com.example.justpump.data.local.getDatabase
import com.example.justpump.data.model.*
import com.example.justpump.data.remote.NutritionApi
import kotlinx.coroutines.launch

class ViewModel(application: Application) : AndroidViewModel(application) {

    //private val trainingDatasource = TrainingDatasource()
    private val exerciseDatasource = ExerciseDatasource(getApplication<Application>().applicationContext)
    private val nutritionDatasource = NutritionDatasource()
    private val mealDatasource = MealDatasource()

    private val database = getDatabase(application)
    val repository = AppRepository(NutritionApi, database)

    val dailyList = repository.dailyList

    fun insertDatabase(macros: Macros) {
        viewModelScope.launch {
            repository.insert(macros)
        }
    }

    fun getMacrosAndInsert(foodName: String) {
        viewModelScope.launch {
            repository.getMacrosAndInsert(foodName)
        }
    }

    private val _trainings = repository.trainings
    val trainings: LiveData<List<TrainingCategory>>
        get() = _trainings

    private val _exercises = MutableLiveData<List<Exercise>>()
    val exercises: LiveData<List<Exercise>>
        get() = _exercises

    private val _nutrition = MutableLiveData<List<Nutrition>>()
    val nutrition: LiveData<List<Nutrition>>
        get() = _nutrition


    init {
        _exercises.value = exerciseDatasource.loadExercises()
        _nutrition.value = nutritionDatasource.loadNutritions()
    }
}