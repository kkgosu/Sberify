package com.example.sberius.data.repository

import com.example.sberius.data.api.ISpotifyApi
import com.example.sberius.domain.ISpotifyRepository
import com.example.sberius.domain.model.Token
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

    override suspend fun getToken(): Token = mSpotifyApi.getToken()

    companion object {
        private const val TOKEN_URL = "https://accounts.spotify.com/api/token/"
    }
}