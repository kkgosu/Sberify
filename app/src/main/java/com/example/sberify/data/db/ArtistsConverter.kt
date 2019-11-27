package com.example.sberify.data.db

import androidx.room.TypeConverter
import com.example.sberify.domain.model.Artist

object ArtistsConverter {

    @TypeConverter
    @JvmStatic
    fun fromList(from: List<Artist>): String =
            from.joinToString(", ") {
                it.id
            }

    @TypeConverter
    @JvmStatic
    fun fromString(string: String): List<Artist> =
            string.split(", ").map {
                Artist(it, null, "", emptyList())
            }
}