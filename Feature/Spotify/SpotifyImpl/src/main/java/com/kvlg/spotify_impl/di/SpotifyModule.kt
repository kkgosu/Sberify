package com.kvlg.spotify_impl.di

import com.google.gson.Gson
import com.kvlg.core_db.database.AppDatabase
import com.kvlg.core_db.database.DbConverter
import com.kvlg.core_utils.models.TokenData
import com.kvlg.spotify_impl.data.SpotifyRepository
import com.kvlg.spotify_impl.data.SpotifyRepositoryImpl
import com.kvlg.spotify_impl.data.converters.ResponseConverter
import com.kvlg.spotify_impl.data.network.SpotifyApiMapper
import com.kvlg.spotify_impl.data.network.SpotifyInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

/**
 * @author Konstantin Koval
 * @since 18.01.2021
 */
@Module
@InstallIn(ActivityRetainedComponent::class)
internal object SpotifyModule {

    @Provides
    fun provideSpotifyInterceptor(tokenData: TokenData): SpotifyInterceptor {
        return SpotifyInterceptor(tokenData)
    }

    @Provides
    @Named("spotify")
    fun provideSpotifyOkHttpClient(
        interceptor: SpotifyInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    fun provideSpotifyApiService(@Named("spotify") okHttpClient: OkHttpClient): SpotifyApiMapper {
        return Retrofit.Builder()
            .baseUrl(SpotifyApiMapper.API_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
            .create(SpotifyApiMapper::class.java)
    }

    @Provides
    fun provideSpotifyRepository(
        database: AppDatabase,
        spotifyApi: SpotifyApiMapper,
        dbConverter: DbConverter,
    ): SpotifyRepository {
        return SpotifyRepositoryImpl(database, spotifyApi, dbConverter, ResponseConverter())
    }
}