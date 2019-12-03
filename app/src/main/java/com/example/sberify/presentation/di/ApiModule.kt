package com.example.sberify.presentation.di

import com.example.sberify.data.api.AuthInterceptor
import com.example.sberify.data.api.ISpotifyApi
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {
    @Provides
    @Singleton
    fun provideInterceptor(): AuthInterceptor {
        return AuthInterceptor()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(interceptor: AuthInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
    }

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    @Singleton
    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory =
            GsonConverterFactory.create(gson)

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
                .baseUrl(ISpotifyApi.API_URL)
                .client(okHttpClient)
                .addConverterFactory(gson)
                .build()
    }

    @Provides
    @Singleton
    fun provideSpotifyApiService(retrofit: Retrofit): ISpotifyApi {
        return retrofit.create(ISpotifyApi::class.java)
    }
}