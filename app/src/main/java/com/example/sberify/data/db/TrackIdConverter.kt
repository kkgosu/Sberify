package com.example.sberify.data.db

import androidx.room.TypeConverter
import com.example.sberify.domain.model.Track

class TrackIdConverter {
    @TypeConverter
    fun fromList(list: List<Track>): String =
            list.joinToString(", ") {
                it.id
            }

    @TypeConverter
    fun fromString(string: String): List<Track> =
            string.split(", ").map {
                Track(it, "", null, emptyList())
            }

}