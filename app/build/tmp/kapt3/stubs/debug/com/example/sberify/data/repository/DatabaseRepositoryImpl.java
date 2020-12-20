package com.example.sberify.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\u0010H\u0016J\u0014\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\b0\u0010H\u0016J!\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J!\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/example/sberify/data/repository/DatabaseRepositoryImpl;", "Lcom/example/sberify/domain/DatabaseRepository;", "database", "Lcom/example/sberify/data/db/AppDatabase;", "dbConverter", "Lcom/example/sberify/data/DbConverter;", "(Lcom/example/sberify/data/db/AppDatabase;Lcom/example/sberify/data/DbConverter;)V", "getAllSuggestions", "", "Lcom/example/sberify/models/domain/Suggestion;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSuggestion", "", "suggestion", "(Lcom/example/sberify/models/domain/Suggestion;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadFavoriteAlbums", "Landroidx/lifecycle/LiveData;", "Lcom/example/sberify/models/newdomain/AlbumDomainModel;", "loadFavoriteTracks", "Lcom/example/sberify/models/newdomain/TrackDomainModel;", "setAlbumIsFavorite", "id", "", "isFavorite", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setTrackIsFavorite", "app_debug"})
public final class DatabaseRepositoryImpl implements com.example.sberify.domain.DatabaseRepository {
    private final com.example.sberify.data.db.AppDatabase database = null;
    private final com.example.sberify.data.DbConverter dbConverter = null;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object insertSuggestion(@org.jetbrains.annotations.NotNull()
    com.example.sberify.models.domain.Suggestion suggestion, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getAllSuggestions(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.sberify.models.domain.Suggestion>> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object setTrackIsFavorite(@org.jetbrains.annotations.NotNull()
    java.lang.String id, boolean isFavorite, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p2) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.LiveData<java.util.List<com.example.sberify.models.newdomain.TrackDomainModel>> loadFavoriteTracks() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object setAlbumIsFavorite(@org.jetbrains.annotations.NotNull()
    java.lang.String id, boolean isFavorite, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p2) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.LiveData<java.util.List<com.example.sberify.models.newdomain.AlbumDomainModel>> loadFavoriteAlbums() {
        return null;
    }
    
    @javax.inject.Inject()
    public DatabaseRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.example.sberify.data.db.AppDatabase database, @org.jetbrains.annotations.NotNull()
    com.example.sberify.data.DbConverter dbConverter) {
        super();
    }
}