package com.example.justpump.data.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DaillyMacroDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(datenbankKlasse: DatenbankClass)

    @Update
    suspend fun update(datenbankKlasse: DatenbankClass)

    @Query("SELECT * FROM DatenbankClass")
    fun getAll(): LiveData<List<DatenbankClass>>
}