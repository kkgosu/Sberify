package com.kvlg.network.spotify

import com.kvlg.network.TokenData
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class SpotifyAuthInterceptor(
    private val tokenData: TokenData
) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request =
            chain.request()
                .newBuilder()
                .addHeader(
                    "Authorization",
                    "Bearer ${tokenData.getSpotifyToken()}"
                )
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .build()
        return chain.proceed(request)
    }
}