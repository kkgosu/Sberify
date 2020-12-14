package com.example.sberify.data.db.album

import androidx.room.Entity

/**
 * @author Konstantin Koval
 * @since 09.12.2020
 */
@Entity(primaryKeys = ["artist_id", "album_id"])
data class AlbumArtistCrossRef(
    val artist_id: Long,
    val album_id: Long
)
