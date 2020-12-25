package com.example.sberify.models.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * @author Konstantin Koval
 * @since 07.12.2020
 */
@Parcelize
data class PrecisionDate(
    val uiValue: String,
    val precision: Precision
) : Parcelable

enum class Precision(val format: String) {
    DAY("yyyy-MM-dd"), MONTH("yyyy-MM"), YEAR("yyyy")
}

