package com.example.sberify.di

import android.content.Context
import androidx.preference.PreferenceManager
import com.example.sberify.data.api.GeniusAuthInterceptor
import com.example.sberify.data.api.IGeniusApi
import com.example.sberify.data.api.ISpotifyApi
import com.example.sberify.data.api.SpotifyAuthInterceptor
import com.example.sberify.domain.TokenData
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ActivityComponent::class)
class ApiModule {

    @Provides
    fun provideTokenData(@ApplicationContext context: Context) = TokenData(PreferenceManager.getDefaultSharedPreferences(context))

    @Provides
    fun provideSpotifyInterceptor(tokenData: TokenData): SpotifyAuthInterceptor {
        return SpotifyAuthInterceptor(tokenData)
    }

    @Provides
    fun provideGeniusInterceptor(tokenData: TokenData): GeniusAuthInterceptor {
        return GeniusAuthInterceptor(tokenData)
    }

    @Provides
    @SpotifyNetwork
    fun provideSpotifyOkHttpClient(interceptor: SpotifyAuthInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @GeniusNetwork
    fun provideGeniusOkHttpClient(interceptor: GeniusAuthInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create(Gson())

    @Provides
    fun provideSpotifyApiService(@SpotifyNetwork okHttpClient: OkHttpClient, gson: GsonConverterFactory): ISpotifyApi {
        return Retrofit.Builder()
            .baseUrl(ISpotifyApi.API_URL)
            .client(okHttpClient)
            .addConverterFactory(gson)
            .build()
            .create(ISpotifyApi::class.java)
    }

    @Provides
    fun provideGeniusApiService(@GeniusNetwork okHttpClient: OkHttpClient, gson: GsonConverterFactory): IGeniusApi {
        return Retrofit.Builder()
            .baseUrl(IGeniusApi.API_URL)
            .client(okHttpClient)
            .addConverterFactory(gson)
            .build()
            .create(IGeniusApi::class.java)
    }
}