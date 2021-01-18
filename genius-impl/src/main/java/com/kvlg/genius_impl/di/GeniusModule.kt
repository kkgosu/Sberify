package com.kvlg.genius_impl.di

import com.kvlg.core_db.database.AppDatabase
import com.kvlg.core_db.database.DbConverter
import com.kvlg.core_utils.models.TokenData
import com.kvlg.genius_impl.data.GeniusParser
import com.kvlg.genius_impl.data.GeniusRepository
import com.kvlg.genius_impl.data.GeniusRepositoryImpl
import com.kvlg.genius_impl.data.network.GeniusApiMapper
import com.kvlg.genius_impl.data.network.GeniusAuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton

/**
 * @author Konstantin Koval
 * @since 18.01.2021
 */
@Module
@InstallIn(ApplicationComponent::class)
object GeniusModule {
    @Provides
    fun provideGeniusInterceptor(tokenData: TokenData): GeniusAuthInterceptor {
        return GeniusAuthInterceptor(tokenData)
    }

    @Provides
    fun provideGeniusOkHttpClient(interceptor: GeniusAuthInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
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