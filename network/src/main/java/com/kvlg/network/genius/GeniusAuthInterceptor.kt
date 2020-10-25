package com.kvlg.network.genius

import com.kvlg.network.TokenData
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
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
        return chain.proceed(request)
    }
}