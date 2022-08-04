package com.example.justpump.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.justpump.data.local.DailyMacroDatabase
import com.example.justpump.data.model.Macros
import com.example.justpump.data.remote.NutritionApi

class AppRepository (
    private val api: NutritionApi,
    private val database: DailyMacroDatabase
        ) {
    val dailyList: LiveData<List<Macros>> = database.dailyMacroDatabaseDao.getAll()

    //ruft den API call auf und speichert dies in der Datenbank
    suspend fun getMacrosAndInsert(foodName: String) {
        try {
            val macros = api.retrofitService.getMacros(foodName).items
            database.dailyMacroDatabaseDao.insert(macros[0])
        } catch (e: Exception) {
            Log.e("AppRepository", " Error loading data from API: $e")
        }
    }

    // neuen eintrag hinzufügen falls nicht vorhanden
    suspend fun insert(macros: Macros) {
        try {
            database.dailyMacroDatabaseDao.insert(macros)
        } catch (e: Exception) {
            Log.e("AppRepository", "insert to database failed: $e")
        }
    }

    suspend fun deleteById(macros: Macros) {
        try {
            database.dailyMacroDatabaseDao.deleteById(macros.id)
        } catch (e: Exception) {
            Log.e("AppRepository", "delete id from database failed: $e")
        }
    }

    suspend fun deleteAll() {
        try {
            database.dailyMacroDatabaseDao.deleteAll()
        } catch (e: Exception) {
            Log.e("AppRepository", "delete all from database failed: $e")
        }
    }

    suspend fun update(macros: Macros) {
        try {
            database.dailyMacroDatabaseDao.update(macros)
        } catch (e: Exception) {
            Log.e("AppRepository", "update to database failed: $e")
        }
    }
}