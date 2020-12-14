package com.example.sberify.data.db

import androidx.room.TypeConverter

object ListToStringConverter {

    @TypeConverter
    @JvmStatic
    fun fromList(list: List<String>): String =
        list.joinToString { it }

    @TypeConverter
    @JvmStatic
    fun fromString(string: String): List<String> =
        string.split(", ")
}