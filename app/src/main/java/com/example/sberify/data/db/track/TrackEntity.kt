package com.example.sberify.data.db.track

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.sberify.models.domain.Artist
import com.example.sberify.models.domain.Image
import com.example.sberify.models.domain.Track

@Entity(
    tableName = "tracks"/*,
        foreignKeys = [ForeignKey(entity = AlbumEntity::class, parentColumns = ["spotify_id"],
                childColumns = ["album_id"])]*/
)
data class TrackEntity(
    @PrimaryKey
    @ColumnInfo(name = "spotify_id")
    val spotifyId: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "album_id")
    val albumId: String,

    @ColumnInfo(name = "lyrics")
    val lyrics: String?,

    @ColumnInfo(name = "artists")
    val artists: List<Artist>,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean,

    @ColumnInfo(name = "image_url")
    val image_url: String?,

    @ColumnInfo(name = "externalUrl")
    val externalUrl: String,

    @ColumnInfo(name = "isExplicit")
    val isExplicit: Boolean,

    @ColumnInfo(name = "isLocal")
    val isLocal: Boolean,

    @ColumnInfo(name = "markets")
    val markets: List<String>,
) {

    fun toTrack(): Track =
        Track(
            id = spotifyId,
            name = name,
            image = Image(image_url ?: "", 0, 0),
            artists = artists,
            lyrics = lyrics,
            isFavorite = isFavorite
        )

    companion object {
        fun from(track: Track): TrackEntity =
            TrackEntity(
                spotifyId = track.id,
                name = track.name,
                albumId = "",
                lyrics = track.lyrics,
                artists = track.artists,
                isFavorite = track.isFavorite,
                image_url = track.image?.url
            )
    }
}