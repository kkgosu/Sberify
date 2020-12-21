package com.example.sberify.domain

import com.example.sberify.models.newdomain.Precision
import com.example.sberify.models.newdomain.PrecisionDate
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author Konstantin Koval
 * @since 07.12.2020
 */

fun getDateFromString(stringDate: String, precision: String): PrecisionDate {
    return if (stringDate.isNotEmpty() && precision.isNotEmpty()) {
        try {
            val prec = precisionMap[precision] ?: Precision.DAY
            val sdf = SimpleDateFormat(prec.format, Locale.getDefault())
            val date = sdf.parse(stringDate)!!
            val uiValue = formatDate(date)
            PrecisionDate(uiValue, prec)
        } catch (e: ParseException) {
            PrecisionDate(formatDate(Date(0)), Precision.DAY)
        }
    } else {
        PrecisionDate(formatDate(Date(0)), Precision.DAY)
    }
}

private fun formatDate(date: Date): String = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(date.time)

private val precisionMap = mapOf(
    "day" to Precision.DAY,
    "month" to Precision.MONTH,
    "year" to Precision.YEAR,
)