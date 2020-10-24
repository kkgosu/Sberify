package com.example.sberify.data.api

import com.kvlg.model.data.genius.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Genius' API
 *
 * @author Konstantin Koval
 * @since 15.10.2020
 */
interface IGeniusApi {
    @GET("search")
    suspend fun getPath(
        @Query("q") query: String
    ): Response<SearchResponse>

    companion object {
        const val API_URL = "https://api.genius.com/"
    }
}