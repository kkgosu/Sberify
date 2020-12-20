package com.example.sberify.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00030\u000bH&J\u0014\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00030\u000bH&J!\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J!\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/example/sberify/domain/DatabaseRepository;", "", "getAllSuggestions", "", "Lcom/example/sberify/models/domain/Suggestion;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSuggestion", "", "suggestion", "(Lcom/example/sberify/models/domain/Suggestion;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadFavoriteAlbums", "Landroidx/lifecycle/LiveData;", "Lcom/example/sberify/models/newdomain/AlbumDomainModel;", "loadFavoriteTracks", "Lcom/example/sberify/models/newdomain/TrackDomainModel;", "setAlbumIsFavorite", "id", "", "isFavorite", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setTrackIsFavorite", "app_debug"})
public abstract interface DatabaseRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllSuggestions(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.sberify.models.domain.Suggestion>> p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertSuggestion(@org.jetbrains.annotations.NotNull()
    com.example.sberify.models.domain.Suggestion suggestion, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object setAlbumIsFavorite(@org.jetbrains.annotations.NotNull()
    java.lang.String id, boolean isFavorite, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p2);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object setTrackIsFavorite(@org.jetbrains.annotations.NotNull()
    java.lang.String id, boolean isFavorite, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p2);
    
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.sberify.models.newdomain.TrackDomainModel>> loadFavoriteTracks();
    
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.sberify.models.newdomain.AlbumDomainModel>> loadFavoriteAlbums();
}