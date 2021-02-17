package com.kvlg.core_db.database

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