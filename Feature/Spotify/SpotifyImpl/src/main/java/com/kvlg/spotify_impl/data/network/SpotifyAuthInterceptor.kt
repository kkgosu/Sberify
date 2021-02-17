package com.kvlg.spotify_impl.data.network

import com.kvlg.core.models.TokenData
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import timber.log.Timber
import java.io.IOException

internal class SpotifyAuthInterceptor(
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
        Timber.d(request.url().toString())
        return chain.proceed(request)
    }
}