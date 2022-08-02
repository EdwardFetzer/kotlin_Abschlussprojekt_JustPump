package com.example.justpump.data.model

import androidx.lifecycle.LiveData
import java.lang.Exception

class DailyDatabaseRepository(
    private val database: DailyMacroDatabase
) {
    val dailyList: LiveData<List<DatenbankClass>> = database.dailyMacroDatabaseDao.getAll()

    suspend fun insert(datenbankClass: DatenbankClass) {
        try {
            database.dailyMacroDatabaseDao.insert(datenbankClass)
        } catch (e: Exception) {}
    }
}