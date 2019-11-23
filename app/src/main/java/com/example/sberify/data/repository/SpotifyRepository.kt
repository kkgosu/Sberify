package com.example.sberify.data.repository

import com.example.sberify.data.DataConverter
import com.example.sberify.data.api.ISpotifyApi
import com.example.sberify.data.api.SearchTypes
import com.example.sberify.data.model.ArtistData
import com.example.sberify.data.model.ArtistsData
import com.example.sberify.domain.ISpotifyRepository
import com.example.sberify.domain.PrefUtil
import com.example.sberify.domain.model.Album
import com.example.sberify.domain.model.Artist
import com.example.sberify.domain.model.Token
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SpotifyRepository(private val dataConverter: DataConverter) : ISpotifyRepository {

    private val mSpotifyApi by lazy {
        Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ISpotifyApi::class.java)
    }

    override suspend fun getToken(): Token {
        return mSpotifyApi.getToken()
    }

    override suspend fun getNewReleases(): List<Album> {
        val items = mSpotifyApi.getNewReleases(PrefUtil.getStringDefaultBlank("oauthtoken")!!)
        return dataConverter.convertAlbums(items.albums.items)
    }

    override suspend fun searchArtist(keyword: String): List<Artist> {
        val results = mSpotifyApi.searchArtist(PrefUtil.getStringDefaultBlank("oauthtoken")!!,
                keyword,
                SearchTypes.ARTIST)
        return dataConverter.convertArtists(results.artists.items)
    }

    override suspend fun getAlbumInfo(id: String): List<Album> {
        val albumInfo = mSpotifyApi.getAlbumInfo(PrefUtil.getStringDefaultBlank("oauthtoken")!!, id)
        return dataConverter.convertAlbums(listOf(albumInfo))
    }

    companion object {
        private const val TOKEN_URL = "https://accounts.spotify.com/"
        private const val API_URL = "https://api.spotify.com/v1/"
    }
}