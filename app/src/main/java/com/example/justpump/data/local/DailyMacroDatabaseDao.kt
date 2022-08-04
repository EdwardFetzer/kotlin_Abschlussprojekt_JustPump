package com.example.justpump.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.justpump.data.model.Macros

@Dao
interface DailyMacroDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(macros: Macros)

    @Update
    suspend fun update(macros: Macros)

    @Query("SELECT * FROM Macros")
    fun getAll(): LiveData<List<Macros>>

    @Query("DELETE FROM Macros WHERE id = :id")
    suspend fun deleteById(id: Long)

    @Query("DELETE FROM Macros")
    suspend fun deleteAll()
}