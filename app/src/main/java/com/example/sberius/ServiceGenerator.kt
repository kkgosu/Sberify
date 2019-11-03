package com.example.sberius

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenerator {
    const val TOKEN_URL = "https://accounts.spotify.com/api/token/"

    private val retrofitWeatherBuilder: Retrofit.Builder = Retrofit.Builder()
        .baseUrl(TOKEN_URL)
        .addConverterFactory(GsonConverterFactory.create())
    private val retrofitWeather = retrofitWeatherBuilder.build()
    private val requestWeatherApi: RequestApi = retrofitWeather.create(RequestApi::class.java)
    fun getRequestApi(): RequestApi = requestWeatherApi
}