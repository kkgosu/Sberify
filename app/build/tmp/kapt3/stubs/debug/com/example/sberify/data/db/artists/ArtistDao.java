package com.example.sberify.data.db.artists;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\t\u001a\u00020\u0006H\'J\u001c\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b0\u00032\u0006\u0010\f\u001a\u00020\u0006H\'J\u001c\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b0\u00032\u0006\u0010\u000e\u001a\u00020\u0006H\'J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bH\'\u00a8\u0006\u0014"}, d2 = {"Lcom/example/sberify/data/db/artists/ArtistDao;", "", "getAlbums", "Landroidx/lifecycle/LiveData;", "Lcom/example/sberify/data/db/artists/ArtistWithAlbums;", "artistId", "", "getArtistById", "Lcom/example/sberify/data/db/artists/ArtistEntity;", "id", "getArtistByKeyword", "", "key", "getArtistByQuery", "query", "getArtistWithSongs", "Lcom/example/sberify/data/db/artists/ArtistWithTracks;", "insertArtist", "", "artistEntity", "app_debug"})
public abstract interface ArtistDao {
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insertArtist(@org.jetbrains.annotations.NotNull()
    com.example.sberify.data.db.artists.ArtistEntity artistEntity);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM artists WHERE artist_id = :id")
    public abstract androidx.lifecycle.LiveData<com.example.sberify.data.db.artists.ArtistEntity> getArtistById(@org.jetbrains.annotations.NotNull()
    java.lang.String id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM artists WHERE name LIKE \'%\' || :key || \'%\'")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.sberify.data.db.artists.ArtistEntity>> getArtistByKeyword(@org.jetbrains.annotations.NotNull()
    java.lang.String key);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM artists WHERE artist_id = :artistId")
    @androidx.room.Transaction()
    public abstract androidx.lifecycle.LiveData<com.example.sberify.data.db.artists.ArtistWithAlbums> getAlbums(@org.jetbrains.annotations.NotNull()
    java.lang.String artistId);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM artists WHERE name LIKE \'%\' || :query || \'%\'")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.sberify.data.db.artists.ArtistEntity>> getArtistByQuery(@org.jetbrains.annotations.NotNull()
    java.lang.String query);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM artists WHERE artist_id = :artistId")
    @androidx.room.Transaction()
    public abstract com.example.sberify.data.db.artists.ArtistWithTracks getArtistWithSongs(@org.jetbrains.annotations.NotNull()
    java.lang.String artistId);
}