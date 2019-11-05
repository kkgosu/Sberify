package com.example.sberify.data.api

import com.example.sberify.BuildConfig
import com.example.sberify.domain.model.Token
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface ISpotifyApi {
    @FormUrlEncoded
    @Headers(BuildConfig.BASIC)
    @POST(".")
    suspend fun getToken(@Field("grant_type") grandType: String = "client_credentials"): Token
}