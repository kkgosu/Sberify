package com.kvlg.shared.data.spotify

import com.kvlg.model.common.Result
import com.kvlg.model.data.spotify.TracksData
import com.kvlg.model.presentation.Album
import com.kvlg.model.presentation.Artist
import com.kvlg.model.presentation.Image
import com.kvlg.model.presentation.Track
import com.kvlg.network.spotify.SpotifyApi
import com.kvlg.shared.data.db.AppDatabase
import com.kvlg.shared.data.db.track.TrackEntity
import com.kvlg.shared.data.getResponse
import javax.inject.Singleton

/**
 * Repository for working with spotify's API
 *
 * @author Konstantin Koval
 * @since 26.10.2020
 */
interface SpotifyRepository {
    //region Track
    suspend fun getTracksFromSpotify(keyword: String): TracksData
    fun getTracksFromDb(keyword: String): List<Track?>
    fun saveTrackIntoDb(track: Track)

    //region Album
    suspend fun getAlbumsFromSpotify(keyword: String): Result<List<Album>>
    suspend fun getAlbumInfoFromSpotify(id: String): Result<Album>
    suspend fun getNewReleases(): Result<List<Album>>
    fun getAlbumsFromDb(keyword: String): List<Album>
    fun saveAlbumIntoDb(track: Album)
    fun getAlbumInfoFromDb(id: String): Album
    fun updateAlbumInfoInDb(album: Album)
    fun getAllAlbumsFromDb(): List<Album>

    //region Artist
    suspend fun getArtistFromSpotify(keyword: String): Result<List<Artist>>
    fun saveArtistIntoDb(artist: Artist)
    fun getArtistFromDb(keyword: String): List<Artist>
}

@Singleton
class SpotifyRepositoryImpl(
    private val database: AppDatabase,
    private val spotifyApi: SpotifyApi,
) : SpotifyRepository {

    override suspend fun getTracksFromSpotify(keyword: String): TracksData {
        return getResponse { spotifyApi.searchTrack(keyword) }
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
        database.getTrackDao().insertTrack(
            TrackEntity(
                spotifyId = track.id,
                name = track.name,
                albumId = "",
                lyrics = track.lyrics,
                artists = track.artists,
                isFavorite = track.isFavorite,
                image_url = track.image?.url
            )
        )
    }

    override fun getAlbumsFromDb(keyword: String): List<Album> {
        TODO("Not yet implemented")
    }

    override suspend fun getAlbumsFromSpotify(keyword: String): Result<List<Album>> {
        TODO("Not yet implemented")
    }

    override fun saveAlbumIntoDb(track: Album) {
        TODO("Not yet implemented")
    }

    override fun getAlbumInfoFromDb(id: String): Album {
        TODO("Not yet implemented")
    }

    override suspend fun getAlbumInfoFromSpotify(id: String): Result<Album> {
        TODO("Not yet implemented")
    }

    override fun updateAlbumInfoInDb(album: Album) {
        TODO("Not yet implemented")
    }

    override fun getAllAlbumsFromDb(): List<Album> {
        TODO("Not yet implemented")
    }

    override suspend fun getNewReleases(): Result<List<Album>> {
        TODO("Not yet implemented")
    }

    override fun saveArtistIntoDb(artist: Artist) {
        TODO("Not yet implemented")
    }

    override fun getArtistFromDb(keyword: String): List<Artist> {
        TODO("Not yet implemented")
    }

    override suspend fun getArtistFromSpotify(keyword: String): Result<List<Artist>> {
        TODO("Not yet implemented")
    }

}