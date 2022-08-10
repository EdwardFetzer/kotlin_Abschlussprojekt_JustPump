package com.example.justpump.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Diese Klasse repräsentiert einen Ernährungsplan
 **/
@Parcelize
data class Nutrition(
    val name: String,
    val imageResource: Int,
    val description: String
) : Parcelable