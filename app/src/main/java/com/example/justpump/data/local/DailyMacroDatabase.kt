package com.example.justpump.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.justpump.data.model.Macros

@Database(entities = [Macros::class], version = 1)
abstract class DailyMacroDatabase : RoomDatabase() {

    abstract val dailyMacroDatabaseDao: DailyMacroDatabaseDao
}

private lateinit var INSTANCE: DailyMacroDatabase

@Synchronized
fun getDatabase(context: Context): DailyMacroDatabase {
    if (!::INSTANCE.isInitialized) {
        INSTANCE = Room.databaseBuilder(
            context.applicationContext,
            DailyMacroDatabase::class.java,
            "dailyMacroDatabase"
        )
            .build()

    }
    return INSTANCE
}