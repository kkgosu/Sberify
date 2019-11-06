package com.example.sberify.data.api

import com.example.sberify.BuildConfig
import com.example.sberify.data.AlbumsResponse
import com.example.sberify.domain.model.Token
import retrofit2.Response
import retrofit2.http.*

interface ISpotifyApi {

    @FormUrlEncoded
    @Headers(BuildConfig.BASIC)
    @POST("api/token/")
    suspend fun getToken(@Field("grant_type") grandType: String = "client_credentials"): Token

    @Headers("Accept: application/json", "Content-Type: application/json")
    @GET("https://api.spotify.com/v1/browse/new-releases")
    suspend fun getNewReleases(@Header("Authorization") header: String): AlbumsResponse
}