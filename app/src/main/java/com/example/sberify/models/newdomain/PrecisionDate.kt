package com.example.sberify.models.newdomain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

/**
 * @author Konstantin Koval
 * @since 07.12.2020
 */
@Parcelize
data class PrecisionDate(
    val date: Date,
    val precision: Precision
) : Parcelable

enum class Precision(val format: String) {
    DAY("yyyy-MM-dd"), MONTH("yyyy-MM"), YEAR("yyyy")
}

