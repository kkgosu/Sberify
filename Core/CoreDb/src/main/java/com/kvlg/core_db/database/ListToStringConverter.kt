package com.kvlg.core.database

import androidx.room.TypeConverter

object ListToStringConverter {

    @TypeConverter
    @JvmStatic
    fun fromList(list: List<String>): String =
        list.joinToString()

    @TypeConverter
    @JvmStatic
    fun fromString(string: String): List<String> =
        string.split(", ")
}