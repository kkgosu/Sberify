package com.example.sberify.data.api

import com.example.sberify.domain.TokenData
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class GeniusAuthInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request =
            chain.request()
                .newBuilder()
                .addHeader(
                    "Authorization",
                    "Bearer ${TokenData.getGeniusToken()}"
                )
                .addHeader("User-Agent", "CompuServe Classic/1.22")
                .addHeader("Accept", "application/json")
                .build()
        return chain.proceed(request)
    }
}