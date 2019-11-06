package com.example.sberify.data.repository

import com.example.sberify.data.AlbumsResponse
import com.example.sberify.data.api.ISpotifyApi
import com.example.sberify.domain.ISpotifyRepository
import com.example.sberify.domain.model.Token
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SpotifyRepository : ISpotifyRepository {

    private val mSpotifyApi by lazy {
        Retrofit.Builder()
                .baseUrl(TOKEN_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ISpotifyApi::class.java)
    }

    override suspend fun getToken(): Token {
        return mSpotifyApi.getToken()
    }

    override suspend fun getNewReleases(accessToken: String): AlbumsResponse.Items =
            mSpotifyApi.getNewReleases(accessToken).albums


    companion object {
        private const val TOKEN_URL = "https://accounts.spotify.com/"
        private const val API_URL = "https://api.spotify.com"
    }
}