package com.kvlg.shared.data

import com.kvlg.model.presentation.Image
import com.kvlg.model.presentation.Track
import com.kvlg.network.spotify.DataConverter
import com.kvlg.network.spotify.SpotifyApi
import com.kvlg.shared.data.db.AppDatabase
import com.kvlg.shared.data.db.track.TrackEntity

/**
 * @author Konstantin Koval
 * @since 28.10.2020
 */
interface TrackRepository {
    suspend fun getTracksFromSpotify(keyword: String): List<Track>?
    fun getTracksFromDb(keyword: String): List<Track?>
    fun saveTrackIntoDb(track: Track)
    fun updateTrackInDb(track: Track)
    fun getFavoriteTracks(): List<Track>
}

class TrackRepositoryImpl(
    private val database: AppDatabase,
    private val spotifyApi: SpotifyApi,
    private val converter: DataConverter
) : TrackRepository {

    override fun getFavoriteTracks(): List<Track> {
        return database.getTrackDao().loadFavoriteTracks().map {
            it.toTrack()
        }
    }

    override suspend fun getTracksFromSpotify(keyword: String): List<Track>? {
        return getResponse { spotifyApi.searchTrack(keyword) }.tracks.items.let {
            converter.convertTracks(it, "")
        }
    }

    override fun getTracksFromDb(keyword: String): List<Track?> {
        return database.getTrackDao().getTracksByKeyword(keyword).map {
            it?.let { trackEntity ->
                Track(
                    id = trackEntity.spotifyId,
                    name = trackEntity.name,
                    image = Image(trackEntity.image_url ?: "", 0, 0),
                    artists = trackEntity.artists,
                    lyrics = trackEntity.lyrics,
                    isFavorite = trackEntity.isFavorite
                )
            }
        }
    }

    override fun saveTrackIntoDb(track: Track) {
        database.getTrackDao().insertTrack(track.toEntity())
    }

    override fun updateTrackInDb(track: Track) {
        database.getTrackDao().updateTrack(track.toEntity())
    }

    private fun TrackEntity.toTrack() =
        Track(
            id = spotifyId,
            name = name,
            image = Image(image_url ?: "", 0, 0),
            artists = artists,
            lyrics = lyrics,
            isFavorite = isFavorite
        )

    private fun Track.toEntity() =
        TrackEntity(
            spotifyId = id,
            name = name,
            albumId = "",
            lyrics = lyrics,
            artists = artists,
            isFavorite = isFavorite,
            image_url = image?.url
        )
}