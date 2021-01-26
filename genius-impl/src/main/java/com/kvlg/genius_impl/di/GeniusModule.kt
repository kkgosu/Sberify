package com.kvlg.genius_impl.di

import com.google.gson.Gson
import com.kvlg.core_db.database.AppDatabase
import com.kvlg.core_db.database.DbConverter
import com.kvlg.core_utils.models.TokenData
import com.kvlg.genius_api.GeniusApi
import com.kvlg.genius_impl.GeniusApiImpl
import com.kvlg.genius_impl.data.GeniusParser
import com.kvlg.genius_impl.data.GeniusRepository
import com.kvlg.genius_impl.data.GeniusRepositoryImpl
import com.kvlg.genius_impl.data.network.GeniusApiMapper
import com.kvlg.genius_impl.data.network.GeniusAuthInterceptor
import com.kvlg.spotify_api.converter.ViewModelConverter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

/**
 * @author Konstantin Koval
 * @since 18.01.2021
 */
@Module
@InstallIn(ApplicationComponent::class)
object GeniusModule {

    @Provides
    fun provideGeniusApi(repo: GeniusRepository, viewModelConverter: ViewModelConverter): GeniusApi {
        return GeniusApiImpl(repo, viewModelConverter)
    }

    @Provides
    fun provideGeniusInterceptor(tokenData: TokenData): GeniusAuthInterceptor {
        return GeniusAuthInterceptor(tokenData)
    }

    @Provides
    @Named("genius")
    fun provideGeniusOkHttpClient(interceptor: GeniusAuthInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    fun provideGeniusApiService(@Named("genius") okHttpClient: OkHttpClient): GeniusApiMapper {
        return Retrofit.Builder()
            .baseUrl(GeniusApiMapper.API_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
            .create(GeniusApiMapper::class.java)
    }

    @Provides
    @Singleton
    fun provideGeniusRepository(
        appDatabase: AppDatabase,
        geniusApi: GeniusApiMapper,
        dbConverter: DbConverter,
    ): GeniusRepository {
        return GeniusRepositoryImpl(GeniusParser(), appDatabase, dbConverter, geniusApi)
    }
}