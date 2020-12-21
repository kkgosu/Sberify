package com.example.sberify.data.api

import com.example.sberify.domain.TokenData
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import timber.log.Timber
import java.io.IOException

class GeniusAuthInterceptor(
    private val tokenData: TokenData
) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request =
            chain.request()
                .newBuilder()
                .addHeader(
                    "Authorization",
                    "Bearer ${tokenData.getGeniusToken()}"
                )
                .addHeader("User-Agent", "CompuServe Classic/1.22")
                .addHeader("Accept", "application/json")
                .build()
        Timber.d(request.url().toString())
        return chain.proceed(request)
    }
}