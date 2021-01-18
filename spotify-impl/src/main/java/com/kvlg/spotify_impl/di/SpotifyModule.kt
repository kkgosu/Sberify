package com.kvlg.spotify_impl.di

import com.google.gson.Gson
import com.kvlg.core_utils.models.TokenData
import com.kvlg.spotify_impl.converter.ViewModelConverter
import com.kvlg.spotify_impl.data.SpotifyRepository
import com.kvlg.spotify_impl.data.SpotifyRepositoryImpl
import com.kvlg.spotify_impl.data.converters.DbConverter
import com.kvlg.spotify_impl.data.converters.ResponseConverter
import com.kvlg.spotify_impl.data.database.AppDatabase
import com.kvlg.spotify_impl.data.network.SpotifyApiMapper
import com.kvlg.spotify_impl.data.network.SpotifyAuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @author Konstantin Koval
 * @since 18.01.2021
 */
@Module
@InstallIn(ApplicationComponent::class)
object SpotifyModule {

    @Provides
    fun provideSpotifyInterceptor(tokenData: TokenData): SpotifyAuthInterceptor {
        return SpotifyAuthInterceptor(tokenData)
    }

    @Provides
    fun provideSpotifyOkHttpClient(interceptor: SpotifyAuthInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create(Gson())

    @Provides
    fun provideSpotifyApiService(okHttpClient: OkHttpClient, gson: GsonConverterFactory): SpotifyApiMapper {
        return Retrofit.Builder()
            .baseUrl(SpotifyApiMapper.API_URL)
            .client(okHttpClient)
            .addConverterFactory(gson)
            .build()
            .create(SpotifyApiMapper::class.java)
    }

    @Provides
    fun provideViewModelConverter(): ViewModelConverter {
        return ViewModelConverter()
    }

    @Provides
    fun provideDbConverter(): DbConverter {
        return DbConverter()
    }

    @Provides
    @Singleton
    fun provideSpotifyRepository(
        database: AppDatabase,
        spotifyApi: SpotifyApiMapper,
        dbConverter: DbConverter,
    ): SpotifyRepository {
        return SpotifyRepositoryImpl(database, spotifyApi, dbConverter, ResponseConverter())
    }
}