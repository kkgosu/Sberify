package com.example.sberify.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.android.components.ApplicationComponent.class})
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\nH\u0007J\b\u0010\f\u001a\u00020\rH\u0007J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0007J(\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0014H\u0007\u00a8\u0006\u001b"}, d2 = {"Lcom/example/sberify/di/RepositoryModule;", "", "()V", "provideDataConverter", "Lcom/example/sberify/data/DataConverter;", "provideDatabaseRepository", "Lcom/example/sberify/domain/DatabaseRepository;", "appDatabase", "Lcom/example/sberify/data/db/AppDatabase;", "dbConverter", "Lcom/example/sberify/data/DbConverter;", "provideDbConverter", "provideGeniusParser", "Lcom/example/sberify/data/GeniusParser;", "provideGeniusRepository", "Lcom/example/sberify/domain/IGeniusRepository;", "geniusParser", "geniusApi", "Lcom/example/sberify/data/api/IGeniusApi;", "provideResponseConverter", "Lcom/example/sberify/data/ResponseConverter;", "provideSpotifyRepository", "Lcom/example/sberify/domain/ISpotifyRepository;", "database", "spotifyApi", "Lcom/example/sberify/data/api/ISpotifyApi;", "responseConverter", "app_debug"})
@dagger.Module(includes = {com.example.sberify.di.ApiModule.class})
public final class RepositoryModule {
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.example.sberify.data.DataConverter provideDataConverter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.example.sberify.data.GeniusParser provideGeniusParser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.example.sberify.data.DbConverter provideDbConverter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.example.sberify.data.ResponseConverter provideResponseConverter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.example.sberify.domain.ISpotifyRepository provideSpotifyRepository(@org.jetbrains.annotations.NotNull()
    com.example.sberify.data.db.AppDatabase database, @org.jetbrains.annotations.NotNull()
    com.example.sberify.data.api.ISpotifyApi spotifyApi, @org.jetbrains.annotations.NotNull()
    com.example.sberify.data.DbConverter dbConverter, @org.jetbrains.annotations.NotNull()
    com.example.sberify.data.ResponseConverter responseConverter) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.example.sberify.domain.IGeniusRepository provideGeniusRepository(@org.jetbrains.annotations.NotNull()
    com.example.sberify.data.GeniusParser geniusParser, @org.jetbrains.annotations.NotNull()
    com.example.sberify.data.db.AppDatabase appDatabase, @org.jetbrains.annotations.NotNull()
    com.example.sberify.data.api.IGeniusApi geniusApi) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.example.sberify.domain.DatabaseRepository provideDatabaseRepository(@org.jetbrains.annotations.NotNull()
    com.example.sberify.data.db.AppDatabase appDatabase, @org.jetbrains.annotations.NotNull()
    com.example.sberify.data.DbConverter dbConverter) {
        return null;
    }
    
    public RepositoryModule() {
        super();
    }
}