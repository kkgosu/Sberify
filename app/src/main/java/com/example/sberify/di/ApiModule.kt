package com.example.sberify.di

import com.example.sberify.data.api.GeniusAuthInterceptor
import com.example.sberify.data.api.IGeniusApi
import com.example.sberify.data.api.ISpotifyApi
import com.example.sberify.data.api.SpotifyAuthInterceptor
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule {
    @Provides
    fun provideSpotifyInterceptor(): SpotifyAuthInterceptor {
        return SpotifyAuthInterceptor()
    }

    @Provides
    fun provideGeniusInterceptor(): GeniusAuthInterceptor {
        return GeniusAuthInterceptor()
    }

    @Provides
    @Named("spotify")
    fun provideSpotifyOkHttpClient(interceptor: SpotifyAuthInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Named("genius")
    fun provideGeniusOkHttpClient(interceptor: GeniusAuthInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory =
        GsonConverterFactory.create(gson)

    @Provides
    @Named("spotify")
    fun provideRetrofit(@Named("spotify") okHttpClient: OkHttpClient, gson: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ISpotifyApi.API_URL)
            .client(okHttpClient)
            .addConverterFactory(gson)
            .build()
    }

    @Provides
    @Named("genius")
    fun provideGeniusRetrofit(@Named("genius") okHttpClient: OkHttpClient, gson: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(IGeniusApi.API_URL)
            .client(okHttpClient)
            .addConverterFactory(gson)
            .build()
    }

    @Provides
    fun provideSpotifyApiService(@Named("spotify") retrofit: Retrofit): ISpotifyApi {
        return retrofit.create(ISpotifyApi::class.java)
    }

    @Provides
    fun provideGeniusApiService(@Named("genius") retrofit: Retrofit): IGeniusApi {
        return retrofit.create(IGeniusApi::class.java)
    }
}