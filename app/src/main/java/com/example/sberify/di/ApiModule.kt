package com.example.sberify.di

import com.kvlg.network.TokenData
import com.kvlg.network.spotify.SpotifyApi
import com.kvlg.network.spotify.SpotifyAuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ActivityComponent::class)
class ApiModule {

    @Provides
    fun provideSpotifyInterceptor(tokenData: TokenData): SpotifyAuthInterceptor {
        return SpotifyAuthInterceptor(tokenData)
    }

    @Provides
    @SpotifyNetwork
    fun provideSpotifyOkHttpClient(interceptor: SpotifyAuthInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    fun provideSpotifyApiService(@SpotifyNetwork okHttpClient: OkHttpClient, gson: GsonConverterFactory): SpotifyApi {
        return Retrofit.Builder()
            .baseUrl(SpotifyApi.API_URL)
            .client(okHttpClient)
            .addConverterFactory(gson)
            .build()
            .create(SpotifyApi::class.java)
    }
}