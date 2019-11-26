package com.example.sberify.data.repository

import com.example.sberify.data.DataConverter
import com.example.sberify.data.api.AuthInterceptor
import com.example.sberify.data.api.ISpotifyApi
import com.example.sberify.data.api.SearchTypes
import com.example.sberify.domain.ISpotifyRepository
import com.example.sberify.domain.model.Album
import com.example.sberify.domain.model.Artist
import com.example.sberify.domain.model.Token
import com.example.sberify.domain.model.Track
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SpotifyRepository(private val dataConverter: DataConverter) : ISpotifyRepository {

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

    override suspend fun getToken(): Token {
        return mSpotifyApi.getToken()
    }

    override suspend fun getNewReleases(): List<Album> {
        val items = mSpotifyApi.getNewReleases()
        return dataConverter.convertAlbums(items.albums.items)
    }

    override suspend fun getAlbumInfo(id: String): List<Album> {
        val albumInfo = mSpotifyApi.getAlbumInfo(id)
        return dataConverter.convertAlbums(listOf(albumInfo))
    }

    override suspend fun searchArtist(keyword: String): List<Artist> {
        val results = mSpotifyApi.searchArtist(keyword, SearchTypes.ARTIST)
        return dataConverter.convertArtists(results.artists.items)
    }

    override suspend fun searchAlbum(keyword: String): List<Album> {
        val results = mSpotifyApi.searchAlbum(keyword, SearchTypes.ALBUM)
        return dataConverter.convertAlbums(results.albums.items)
    }

    override suspend fun searchTrack(keyword: String): List<Track> {
        val results = mSpotifyApi.searchTrack(keyword, SearchTypes.TRACK)
        return dataConverter.convertTracks(results.tracks.items)
    }
}