package com.example.sberius.data.api

import com.example.sberius.BuildConfig
import com.example.sberius.domain.model.Token
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface RequestApi {
    @FormUrlEncoded
    @Headers(BuildConfig.BASIC)
    @POST(".")
    suspend fun getToken(@Field("grant_type") grandType: String = "client_credentials"): Token
}