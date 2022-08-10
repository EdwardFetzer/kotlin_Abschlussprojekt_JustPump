package com.example.justpump.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.justpump.R
import com.example.justpump.data.local.DailyMacroDatabase
import com.example.justpump.data.model.Macros

import com.example.justpump.data.model.TrainingCategory
import com.example.justpump.data.remote.NutritionApi

class AppRepository (
    private val api: NutritionApi,
    private val database: DailyMacroDatabase
        ) {
    val dailyList: LiveData<List<Macros>> = database.dailyMacroDatabaseDao.getAll()


    val trainings = MutableLiveData(loadTraining())

    fun loadTraining(): List<TrainingCategory> {
        return listOf(
            TrainingCategory( "Brust", R.drawable.brust),
            TrainingCategory( "Schulter", R.drawable.schulter),
            TrainingCategory( "Rücken", R.drawable.ruecken),
            TrainingCategory( "Bauch", R.drawable.krafttraining),
            TrainingCategory( "Arme", R.drawable.krafttraining),
            TrainingCategory( "Beine", R.drawable.krafttraining),
        )
    }

    /**
     * ruft den API call auf und speichert dies in der Datenbank
     */
    suspend fun getMacrosAndInsert(foodName: String) {
        try {
            val macros = api.retrofitService.getMacros(foodName).items
            database.dailyMacroDatabaseDao.insert(macros[0])
        } catch (e: Exception) {
            Log.e("AppRepository", " Error loading data from API: $e")
        }
    }

    /**
     * neuer eintrag wird hinzugefügt falls noch keiner vorhanden ist
     */
    suspend fun insert(macros: Macros) {
        try {
            database.dailyMacroDatabaseDao.insert(macros)
        } catch (e: Exception) {
            Log.e("AppRepository", "insert to database failed: $e")
        }
    }

    /**
     * ein gewünschter eintrag wird gelöscht
     */
    suspend fun deleteById(macros: Macros) {
        try {
            database.dailyMacroDatabaseDao.deleteById(macros.id)
        } catch (e: Exception) {
            Log.e("AppRepository", "delete id from database failed: $e")
        }
    }

    /**
     * alle einträge werden gelöscht
     */
    suspend fun deleteAll() {
        try {
            database.dailyMacroDatabaseDao.deleteAll()
        } catch (e: Exception) {
            Log.e("AppRepository", "delete all from database failed: $e")
        }
    }

    /**
     * ein eintrag wird aktuallisiert
     */
    suspend fun update(macros: Macros) {
        try {
            database.dailyMacroDatabaseDao.update(macros)
        } catch (e: Exception) {
            Log.e("AppRepository", "update to database failed: $e")
        }
    }
}