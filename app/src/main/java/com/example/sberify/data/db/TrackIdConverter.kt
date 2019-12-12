package com.example.sberify.data.db

import androidx.room.TypeConverter
import com.example.sberify.models.domain.Image
import com.example.sberify.models.domain.Track

object TrackIdConverter {
    @TypeConverter
    @JvmStatic
    fun fromList(list: List<Track>?): String? = list?.let { tracks ->
        tracks.joinToString(DELIMITER_DASH) {
            it.id + DELIMITER_COMMA + it.name + DELIMITER_COMMA + it.lyrics + DELIMITER_COMMA + it.isFavorite + DELIMITER_COMMA + ArtistsConverter.fromList(
                    it.artists) + DELIMITER_COMMA + it.image?.url
        }
    }


    @TypeConverter
    @JvmStatic
    fun fromString(string: String?): List<Track>? =
            string?.let {
                it.split(DELIMITER_DASH).map {
                    val track = it.split(DELIMITER_COMMA)
                    if (track.size < 2) {
                        Track(id = track[0],
                                name = "",
                                lyrics = "",
                                isFavorite = false,
                                artists = emptyList(),
                                image = null)
                    } else {
                        Track(id = track[0],
                                name = track[1],
                                lyrics = track[2],
                                isFavorite = track[3].toBoolean(),
                                artists = ArtistsConverter.fromString(track[4]),
                                image = Image(track[5]))
                    }
                }
            }

    private const val DELIMITER_DASH = "<---->"
    private const val DELIMITER_COMMA = ":::::"
}

