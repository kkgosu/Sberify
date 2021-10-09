package com.kvlg.spotify_impl.data.network

import com.kvlg.core_utils.models.TokenData
import com.kvlg.spotify_impl.BuildConfig
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import timber.log.Timber
import java.io.IOException

internal class SpotifyInterceptor(
    private val tokenData: TokenData
) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = if (chain.request().url().toString() == SpotifyApiMapper.AUTH_URL) {
            chain.request()
                .newBuilder()
                .addHeader("Authorization", "Basic ${BuildConfig.SPOTIFY_AUTH_BASIC}")
                .build()
        } else {
            chain.request()
                .newBuilder()
                .addHeader(
                    "Authorization",
                    "Bearer ${tokenData.getSpotifyToken()}"
                )
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .build()
        }
        Timber.d(request.url().toString())
        return chain.proceed(request)
    }
}