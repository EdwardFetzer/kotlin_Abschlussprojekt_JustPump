package com.example.justpump.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.justpump.data.model.NutritionMacro
import com.example.justpump.data.model.Nutritions
import com.example.justpump.data.remote.NutritionApi

class NutritionRepository(private val nutritionsApi: NutritionApi) {

    private val _macros = MutableLiveData<Nutritions>()
    val macros: LiveData<Nutritions>
        get() = _macros

    private val _protein = MutableLiveData<NutritionMacro>()
    val protein: LiveData<NutritionMacro>
        get() = _protein

    suspend fun getMacros(macro: String) {
        try {
            _macros.value = nutritionsApi.retrofitService.getMacros(macro)
        } catch (e: Exception) {
            Log.e("macroTest", "Error loading data from API: $e")
        }
    }
    suspend fun getProtein(proteinMacro: String) {
        try {
            _protein.value = nutritionsApi.retrofitService.get
        }
    }
}