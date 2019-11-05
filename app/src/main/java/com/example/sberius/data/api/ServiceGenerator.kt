package com.example.sberius.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenerator {
    const val TOKEN_URL = "https://accounts.spotify.com/api/token/"

    private val retrofitToken by lazy {
        Retrofit.Builder()
            .baseUrl(TOKEN_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RequestApi::class.java)
    }

    fun getTokenApi(): RequestApi = retrofitToken
}