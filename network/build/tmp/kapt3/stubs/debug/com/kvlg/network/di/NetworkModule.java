package com.kvlg.network.di;

import java.lang.System;

/**
 * @author Konstantin Koval
 * @since 25.10.2020
 */
@dagger.hilt.InstallIn(value = {dagger.hilt.android.components.ApplicationComponent.class})
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0007J\b\u0010\u0010\u001a\u00020\nH\u0007J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0007J\u0012\u0010\u0015\u001a\u00020\r2\b\b\u0001\u0010\u0016\u001a\u00020\u0017H\u0007\u00a8\u0006\u0018"}, d2 = {"Lcom/kvlg/network/di/NetworkModule;", "", "()V", "provideDataConverter", "Lcom/kvlg/network/spotify/DataConverter;", "provideGeniusApiService", "Lcom/kvlg/network/genius/GeniusApi;", "interceptor", "Lcom/kvlg/network/genius/GeniusAuthInterceptor;", "gson", "Lretrofit2/converter/gson/GsonConverterFactory;", "provideGeniusInterceptor", "tokenData", "Lcom/kvlg/network/TokenData;", "provideGeniusParser", "Lcom/kvlg/network/genius/GeniusParser;", "provideGsonConverterFactory", "provideSpotifyApiService", "Lcom/kvlg/network/spotify/SpotifyApi;", "Lcom/kvlg/network/spotify/SpotifyAuthInterceptor;", "provideSpotifyAuthInterceptor", "provideTokenData", "context", "Landroid/content/Context;", "network_debug"})
@dagger.Module()
public final class NetworkModule {
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.kvlg.network.TokenData provideTokenData(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final retrofit2.converter.gson.GsonConverterFactory provideGsonConverterFactory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.kvlg.network.genius.GeniusAuthInterceptor provideGeniusInterceptor(@org.jetbrains.annotations.NotNull()
    com.kvlg.network.TokenData tokenData) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.kvlg.network.spotify.SpotifyAuthInterceptor provideSpotifyAuthInterceptor(@org.jetbrains.annotations.NotNull()
    com.kvlg.network.TokenData tokenData) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.kvlg.network.genius.GeniusApi provideGeniusApiService(@org.jetbrains.annotations.NotNull()
    com.kvlg.network.genius.GeniusAuthInterceptor interceptor, @org.jetbrains.annotations.NotNull()
    retrofit2.converter.gson.GsonConverterFactory gson) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.kvlg.network.spotify.SpotifyApi provideSpotifyApiService(@org.jetbrains.annotations.NotNull()
    com.kvlg.network.spotify.SpotifyAuthInterceptor interceptor, @org.jetbrains.annotations.NotNull()
    retrofit2.converter.gson.GsonConverterFactory gson) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kvlg.network.genius.GeniusParser provideGeniusParser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kvlg.network.spotify.DataConverter provideDataConverter() {
        return null;
    }
    
    public NetworkModule() {
        super();
    }
}