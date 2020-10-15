package com.example.sberify.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Konstantin Koval
 * @since 15.10.2020
 */
interface IGeniusApi {
    @GET("search")
    suspend fun getToken(
        @Query("q") query: String = "Juice WRLD Hi Tech Talk"
    ): Response<Any>

    companion object {
        const val API_URL = "https://api.genius.com/"
    }
}