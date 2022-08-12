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

    private val exerciseDatasource = ExerciseDatasource(getApplication<Application>().applicationContext)
    private val nutritionDatasource = NutritionDatasource(getApplication<Application>().applicationContext)
    private val mealDatasource = MealDatasource()

    private val database = getDatabase(application)
    val repository = AppRepository(NutritionApi, database)

    var macros = MutableLiveData<Macros>(Macros(0,0f,0f,0f,0f,"",0f,0f,0f,0f,0f,0f,0f))

    val dailyList = repository.dailyList

    fun insertDatabase(macros: Macros) {
        viewModelScope.launch {
            repository.insert(macros)
        }
    }

    /**
     * ruft die funktion aus der AppRepository auf und führt die im hintergrund aus
     */
    fun getMacrosAndInsert(foodName: String) {
        viewModelScope.launch {
            repository.getMacrosAndInsert(foodName)
        }
    }

    fun getMacros(foodName: String) {
        viewModelScope.launch {
            macros.value = repository.getMacros(foodName)[0]
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