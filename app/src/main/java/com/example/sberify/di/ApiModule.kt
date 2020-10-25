package com.example.sberify.di

import com.example.sberify.data.api.ISpotifyApi
import com.example.sberify.data.api.SpotifyAuthInterceptor
import com.kvlg.network.TokenData
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
    fun provideSpotifyApiService(@SpotifyNetwork okHttpClient: OkHttpClient, gson: GsonConverterFactory): ISpotifyApi {
        return Retrofit.Builder()
            .baseUrl(ISpotifyApi.API_URL)
            .client(okHttpClient)
            .addConverterFactory(gson)
            .build()
            .create(ISpotifyApi::class.java)
    }
}