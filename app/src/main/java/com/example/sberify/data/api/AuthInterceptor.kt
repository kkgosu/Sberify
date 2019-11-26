package com.example.sberify.data.api

import com.example.sberify.BuildConfig
import com.example.sberify.domain.TokenData
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class AuthInterceptor() : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = if (chain.request().url().toString().contains(
                    ISpotifyApi.TOKEN_URL)) {
            chain.request()
                    .newBuilder()
                    .addHeader("Authorization", BuildConfig.BASIC)
                    .build()
        } else {
            chain.request()
                    .newBuilder()
                    .addHeader("Authorization",
                            "Bearer ${TokenData.getToken()}")
                    .addHeader("Accept", "application/json")
                    .addHeader("Content-Type", "application/json")
                    .build()
        }
        return chain.proceed(request)
    }
}