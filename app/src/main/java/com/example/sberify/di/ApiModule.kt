package com.example.sberify.di

import com.example.sberify.data.api.GeniusApi
import com.example.sberify.data.api.GeniusAuthInterceptor
import com.google.gson.Gson
import com.kvlg.core_utils.models.TokenData
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
    fun provideGeniusInterceptor(tokenData: TokenData): GeniusAuthInterceptor {
        return GeniusAuthInterceptor(tokenData)
    }

    @Provides
    @GeniusNetwork
    fun provideGeniusOkHttpClient(interceptor: GeniusAuthInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    fun provideGeniusApiService(@GeniusNetwork okHttpClient: OkHttpClient): GeniusApi {
        return Retrofit.Builder()
            .baseUrl(GeniusApi.API_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
            .create(GeniusApi::class.java)
    }
}