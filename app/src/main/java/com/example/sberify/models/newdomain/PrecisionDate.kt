package com.example.sberify.models.newdomain

import java.util.*

/**
 * @author Konstantin Koval
 * @since 07.12.2020
 */
data class PrecisionDate(
    val date: Date,
    val precision: Precision
)

enum class Precision(val format: String) {
    DAY("yyyy-MM-dd"), MONTH("yyyy-MM"), YEAR("yyyy")
}

