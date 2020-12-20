package com.example.sberify.data.db.track;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u001c\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n0\u00032\u0006\u0010\u000b\u001a\u00020\u0006H\'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\'J\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n0\u0003H\'J!\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/example/sberify/data/db/track/TrackDao;", "", "getTrackById", "Landroidx/lifecycle/LiveData;", "Lcom/example/sberify/data/db/track/TrackEntity;", "id", "", "getTrackWithArtists", "Lcom/example/sberify/data/db/track/TrackWithArtists;", "getTracksByQuery", "", "query", "insertTrack", "", "trackEntity", "loadFavoriteTracks", "setTrackIsFavorite", "isFavorite", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTrackLyrics", "lyrics", "app_debug"})
public abstract interface TrackDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM tracks WHERE track_id = :id")
    public abstract androidx.lifecycle.LiveData<com.example.sberify.data.db.track.TrackEntity> getTrackById(@org.jetbrains.annotations.NotNull()
    java.lang.String id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM tracks WHERE name LIKE \'%\' || :query || \'%\'")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.sberify.data.db.track.TrackEntity>> getTracksByQuery(@org.jetbrains.annotations.NotNull()
    java.lang.String query);
    
    @androidx.room.Query(value = "UPDATE tracks SET lyrics = :lyrics WHERE track_id=:id")
    public abstract void updateTrackLyrics(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String lyrics);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM tracks WHERE is_favorite = 1 ORDER BY name ASC")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.sberify.data.db.track.TrackEntity>> loadFavoriteTracks();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "UPDATE tracks SET is_favorite = :isFavorite WHERE track_id = :id")
    public abstract java.lang.Object setTrackIsFavorite(@org.jetbrains.annotations.NotNull()
    java.lang.String id, boolean isFavorite, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p2);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract void insertTrack(@org.jetbrains.annotations.NotNull()
    com.example.sberify.data.db.track.TrackEntity trackEntity);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM tracks WHERE track_id = :id")
    @androidx.room.Transaction()
    public abstract com.example.sberify.data.db.track.TrackWithArtists getTrackWithArtists(@org.jetbrains.annotations.NotNull()
    java.lang.String id);
}