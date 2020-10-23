package com.kvlg.shared.data.db

import androidx.room.TypeConverter
import com.kvlg.model.presentation.Artist

object ArtistsConverter {

    @TypeConverter
    @JvmStatic
    fun fromList(from: List<Artist>): String =
            from.joinToString(DELIMITER_COMMA) {
                "${it.id}$DELIMITER_DASH${it.name}"
            }


    @TypeConverter
    @JvmStatic
    fun fromString(string: String): List<Artist> =
            string.split(DELIMITER_COMMA).map {
                val str = it.split(DELIMITER_DASH)
                Artist(str[0], null, str[1], emptyList())
            }

    private const val DELIMITER_DASH = "<-->"
    private const val DELIMITER_COMMA = ":::"
}