package com.kvlg.core_db.database.album

import androidx.room.Embedded
import androidx.room.Relation
import com.kvlg.spotify_common.entity.AlbumEntity
import com.kvlg.spotify_common.entity.TrackEntity

/**
 * @author Konstantin Koval
 * @since 09.12.2020
 */
data class AlbumWithTracks(
    @Embedded val albumEntity: AlbumEntity,
    @Relation(
        parentColumn = "album_id",
        entityColumn = "album_id"
    )
    val tracksEntities: List<TrackEntity>
)
