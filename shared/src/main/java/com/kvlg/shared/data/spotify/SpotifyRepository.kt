package com.kvlg.shared.data.spotify

import com.kvlg.model.common.Result
import com.kvlg.model.presentation.Album
import com.kvlg.model.presentation.Artist
import com.kvlg.network.spotify.SpotifyApi
import com.kvlg.shared.data.db.AppDatabase
import javax.inject.Singleton

/**
 * Repository for working with spotify's API
 *
 * @author Konstantin Koval
 * @since 26.10.2020
 */
interface SpotifyRepository {
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