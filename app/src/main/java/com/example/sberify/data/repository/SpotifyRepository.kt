package com.example.sberify.data.repository

import com.example.sberify.data.DataConverter
import com.example.sberify.data.Result
import com.example.sberify.data.api.AuthInterceptor
import com.example.sberify.data.api.BaseResponseHandler
import com.example.sberify.data.api.ISpotifyApi
import com.example.sberify.data.api.SearchTypes
import com.example.sberify.data.db.album.AlbumDao
import com.example.sberify.data.db.album.AlbumEntity
import com.example.sberify.domain.ISpotifyRepository
import com.example.sberify.domain.model.Album
import com.example.sberify.domain.model.Artist
import com.example.sberify.domain.model.Token
import com.example.sberify.domain.model.Track
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SpotifyRepository(
        private val dataConverter: DataConverter,
        private val albumDao: AlbumDao) : BaseResponseHandler(), ISpotifyRepository {

    private val okHttpClient by lazy {
        OkHttpClient.Builder()
                .addInterceptor(AuthInterceptor())
                .build()
    }

    private val mSpotifyApi by lazy {
        Retrofit.Builder()
                .baseUrl(ISpotifyApi.API_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ISpotifyApi::class.java)
    }

    override suspend fun getToken(callback: (Token) -> Unit) {
        val response = getResult { mSpotifyApi.getToken() }
        handleResponse(response) {
            callback(it)
        }
    }

    override suspend fun getNewReleases(callback: (List<Album>) -> Unit) {
        val response = getResult { mSpotifyApi.getNewReleases() }
        handleResponse(response) {
            val albums = dataConverter.convertAlbums(it.albums.items)
            albums.forEach { album ->
                albumDao.insertAlbum(AlbumEntity.from(album))
            }
            callback(albums)
        }
    }

    override suspend fun getAlbumInfo(id: String, callback: (List<Album>) -> Unit) {
        val response = getResult { mSpotifyApi.getAlbumInfo(id) }
        handleResponse(response) {
            callback(dataConverter.convertAlbums(listOf(it)))
        }
    }

    override suspend fun searchArtist(keyword: String, callback: (List<Artist>) -> Unit) {
        val response = getResult { mSpotifyApi.searchArtist(keyword, SearchTypes.ARTIST) }
        handleResponse(response) {
            callback(dataConverter.convertArtists(it.artists.items))
        }
    }

    override suspend fun searchAlbum(keyword: String, callback: (List<Album>) -> Unit) {
        val response = getResult { mSpotifyApi.searchAlbum(keyword, SearchTypes.ALBUM) }
        handleResponse(response) {
            callback(dataConverter.convertAlbums(it.albums.items))
        }
    }

    override suspend fun searchTrack(keyword: String, callback: (List<Track>) -> Unit) {
        val response = getResult { mSpotifyApi.searchTrack(keyword, SearchTypes.TRACK) }
        handleResponse(response) {
            callback(dataConverter.convertTracks(it.tracks.items))
        }
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