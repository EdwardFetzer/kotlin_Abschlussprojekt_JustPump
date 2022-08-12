package com.example.justpump.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Diese Klasse repräsentiert eine Übung
 **/
@Parcelize
data class Exercise (
    val Id: Long,
    val stringResource: Int,
    val imageResource: Int,
    val description: String,
    val category: String
) : Parcelable