package com.example.sberify.data.api

import com.example.sberify.BuildConfig
import com.example.sberify.data.model.AlbumsResponse
import com.example.sberify.domain.model.Token
import retrofit2.http.*
import retrofit2.http.Headers

interface ISpotifyApi {

    @FormUrlEncoded
    @Headers(BuildConfig.BASIC)
    @POST("https://accounts.spotify.com/api/token/")
    suspend fun getToken(@Field("grant_type") grandType: String = "client_credentials"): Token

    @Headers(HeadersValues.ACCEPT, HeadersValues.CONTENT_TYPE)
    @GET("browse/new-releases")
    suspend fun getNewReleases(@Header("Authorization") token: String): AlbumsResponse

    @Headers(HeadersValues.ACCEPT, HeadersValues.CONTENT_TYPE)
    @GET("search")
    suspend fun search(@Header("Authorization") token: String,
            @Query("q") keyword: String,
            @Query("type") vararg type: String): AlbumsResponse.Artist
}