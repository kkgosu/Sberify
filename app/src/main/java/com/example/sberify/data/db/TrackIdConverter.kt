package com.example.sberify.data.db

import androidx.room.TypeConverter
import com.example.sberify.models.domain.Track

object TrackIdConverter {
    @TypeConverter
    @JvmStatic
    fun fromList(list: List<Track>): String =
            list.joinToString(", ") {
                it.id
            }

    @TypeConverter
    @JvmStatic
    fun fromString(string: String): List<Track> =
            string.split(", ").map {
                Track(it, "", null, emptyList())
            }

}