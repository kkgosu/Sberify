package com.kvlg.network.di

import android.content.Context
import androidx.preference.PreferenceManager
import com.google.gson.Gson
import com.kvlg.network.TokenData
import com.kvlg.network.genius.GeniusApi
import com.kvlg.network.genius.GeniusAuthInterceptor
import com.kvlg.network.genius.GeniusParser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @author Konstantin Koval
 * @since 25.10.2020
 */
@Module
@InstallIn(ApplicationComponent::class)
class NetworkModule {

    @Provides
    fun provideTokenData(@ApplicationContext context: Context) = TokenData(PreferenceManager.getDefaultSharedPreferences(context))

    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create(Gson())

    @Provides
    fun provideGeniusInterceptor(tokenData: TokenData): GeniusAuthInterceptor {
        return GeniusAuthInterceptor(tokenData)
    }

    @Provides
    fun provideGeniusApiService(interceptor: GeniusAuthInterceptor, gson: GsonConverterFactory): GeniusApi {
        return Retrofit.Builder()
            .baseUrl(GeniusApi.API_URL)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build()
            )
            .addConverterFactory(gson)
            .build()
            .create(GeniusApi::class.java)
    }

    @Provides
    @Singleton
    fun provideGeniusParser(): GeniusParser {
        return GeniusParser()
    }

}