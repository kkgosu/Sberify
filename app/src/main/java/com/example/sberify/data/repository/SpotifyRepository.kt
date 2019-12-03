package com.example.sberify.data.repository

import com.example.sberify.data.DataConverter
import com.example.sberify.data.Result
import com.example.sberify.data.api.BaseResponseHandler
import com.example.sberify.data.api.ISpotifyApi
import com.example.sberify.data.api.SearchTypes
import com.example.sberify.data.db.AppDatabase
import com.example.sberify.data.db.album.AlbumEntity
import com.example.sberify.data.db.artists.ArtistEntity
import com.example.sberify.domain.ISpotifyRepository
import com.example.sberify.domain.model.Album
import com.example.sberify.domain.model.Artist
import com.example.sberify.domain.model.Token
import com.example.sberify.domain.model.Track
import javax.inject.Inject

class SpotifyRepository @Inject constructor(
        private val dataConverter: DataConverter,
        private val database: AppDatabase,
        private val mSpotifyApi: ISpotifyApi) : BaseResponseHandler(), ISpotifyRepository {

    override suspend fun getToken(callback: (Token) -> Unit) {
        val response = getResult { mSpotifyApi.getToken() }
        handleResponse(response) {
            callback(it)
        }
    }

    override suspend fun getNewReleases(): List<Album> {
        val response = getResult { mSpotifyApi.getNewReleases() }
        handleResponse(response) {
            val albums = dataConverter.convertAlbums(it.albums.items)
            albums.forEach { album ->
                database.getArtistDao()
                        .insertArtist(ArtistEntity.from(album.artist))
                database.getAlbumDao()
                        .insertAlbum(AlbumEntity.from(album))
            }
            return albums
        }
        return emptyList()
    }

    override suspend fun getAlbumInfo(id: String): List<Album> {
        val response = getResult { mSpotifyApi.getAlbumInfo(id) }
        handleResponse(response) {
            val albumInfo = dataConverter.convertAlbums(listOf(it))
            albumInfo.forEach { album ->
                database.getAlbumDao()
                        .updateAlbumTracks(album.id, album.tracks!!)
            }
            return albumInfo
        }
        return emptyList()
    }

    override suspend fun searchArtist(keyword: String): List<Artist> {
        val response = getResult { mSpotifyApi.searchArtist(keyword, SearchTypes.ARTIST) }
        handleResponse(response) {
            val artists = dataConverter.convertArtists(it.artists.items)
            artists.forEach { artist ->
                database.getArtistDao()
                        .insertArtist(ArtistEntity.from(artist))
            }
            return artists
        }
        return emptyList()
    }

    override suspend fun searchAlbum(keyword: String): List<Album> {
        val response = getResult { mSpotifyApi.searchAlbum(keyword, SearchTypes.ALBUM) }
        handleResponse(response) {
            return dataConverter.convertAlbums(it.albums.items)
        }
        return emptyList()
    }

    override suspend fun searchTrack(keyword: String): List<Track> {
        val response = getResult { mSpotifyApi.searchTrack(keyword, SearchTypes.TRACK) }
        handleResponse(response) {
            return dataConverter.convertTracks(it.tracks.items)
        }
        return emptyList()
    }

    private inline fun <T> handleResponse(response: Result<T>, callback: (T) -> Unit) {
        if (response.status == Result.Status.SUCCESS) {
            callback(response.data!!)
        } else if (response.status == Result.Status.ERROR) {
            postError(response.message!!)
        }
    }

    private fun postError(message: String) {
        println("An error happened: $message")
    }
}