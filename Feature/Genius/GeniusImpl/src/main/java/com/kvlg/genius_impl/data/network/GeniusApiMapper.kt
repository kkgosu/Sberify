package com.kvlg.genius_impl.data.network

import com.kvlg.genius_impl.models.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Genius' API
 *
 * @author Konstantin Koval
 * @since 15.10.2020
 */
internal interface GeniusApiMapper {
    @GET("search")
    suspend fun getPath(
        @Query("q") query: String
    ): Response<SearchResponse>

    companion object {
        const val API_URL = "https://api.genius.com/"
    }
}