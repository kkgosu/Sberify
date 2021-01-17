package com.kvlg.spotify_impl.data.database.album

import androidx.room.Embedded
import androidx.room.Relation
import com.kvlg.spotify_api.models.entity.AlbumEntity
import com.kvlg.spotify_api.models.entity.TrackEntity

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
