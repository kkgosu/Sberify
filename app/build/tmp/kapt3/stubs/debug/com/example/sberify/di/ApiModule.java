package com.example.sberify.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.android.components.ActivityComponent.class})
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\nH\u0007J\b\u0010\u000f\u001a\u00020\bH\u0007J\u001a\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0013H\u0007J\u0012\u0010\u0015\u001a\u00020\f2\b\b\u0001\u0010\u0016\u001a\u00020\u0017H\u0007\u00a8\u0006\u0018"}, d2 = {"Lcom/example/sberify/di/ApiModule;", "", "()V", "provideGeniusApiService", "Lcom/example/sberify/data/api/IGeniusApi;", "okHttpClient", "Lokhttp3/OkHttpClient;", "gson", "Lretrofit2/converter/gson/GsonConverterFactory;", "provideGeniusInterceptor", "Lcom/example/sberify/data/api/GeniusAuthInterceptor;", "tokenData", "Lcom/example/sberify/domain/TokenData;", "provideGeniusOkHttpClient", "interceptor", "provideGsonConverterFactory", "provideSpotifyApiService", "Lcom/example/sberify/data/api/ISpotifyApi;", "provideSpotifyInterceptor", "Lcom/example/sberify/data/api/SpotifyAuthInterceptor;", "provideSpotifyOkHttpClient", "provideTokenData", "context", "Landroid/content/Context;", "app_debug"})
@dagger.Module()
public final class ApiModule {
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.example.sberify.domain.TokenData provideTokenData(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.example.sberify.data.api.SpotifyAuthInterceptor provideSpotifyInterceptor(@org.jetbrains.annotations.NotNull()
    com.example.sberify.domain.TokenData tokenData) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.example.sberify.data.api.GeniusAuthInterceptor provideGeniusInterceptor(@org.jetbrains.annotations.NotNull()
    com.example.sberify.domain.TokenData tokenData) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @SpotifyNetwork()
    @dagger.Provides()
    public final okhttp3.OkHttpClient provideSpotifyOkHttpClient(@org.jetbrains.annotations.NotNull()
    com.example.sberify.data.api.SpotifyAuthInterceptor interceptor) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @GeniusNetwork()
    @dagger.Provides()
    public final okhttp3.OkHttpClient provideGeniusOkHttpClient(@org.jetbrains.annotations.NotNull()
    com.example.sberify.data.api.GeniusAuthInterceptor interceptor) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final retrofit2.converter.gson.GsonConverterFactory provideGsonConverterFactory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.example.sberify.data.api.ISpotifyApi provideSpotifyApiService(@org.jetbrains.annotations.NotNull()
    @SpotifyNetwork()
    okhttp3.OkHttpClient okHttpClient, @org.jetbrains.annotations.NotNull()
    retrofit2.converter.gson.GsonConverterFactory gson) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.example.sberify.data.api.IGeniusApi provideGeniusApiService(@org.jetbrains.annotations.NotNull()
    @GeniusNetwork()
    okhttp3.OkHttpClient okHttpClient, @org.jetbrains.annotations.NotNull()
    retrofit2.converter.gson.GsonConverterFactory gson) {
        return null;
    }
    
    public ApiModule() {
        super();
    }
}