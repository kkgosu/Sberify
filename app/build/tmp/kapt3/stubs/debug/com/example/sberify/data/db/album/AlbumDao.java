package com.example.sberify.data.db.album;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n0\u0003H\'J\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n0\u00032\u0006\u0010\f\u001a\u00020\u0006H\'J\u001c\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n0\u00032\u0006\u0010\u000e\u001a\u00020\u0006H\'J\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n0\u0003H\'J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\'J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n0\u0003H\'J!\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001aH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/example/sberify/data/db/album/AlbumDao;", "", "getAlbumById", "Landroidx/lifecycle/LiveData;", "Lcom/example/sberify/data/db/album/AlbumEntity;", "id", "", "getAlbumTracks", "Lcom/example/sberify/data/db/album/AlbumWithTracks;", "getAlbums", "", "getAlbumsByKeyword", "key", "getAlbumsByQuery", "query", "getAllAlbums", "getArtistsByAlbumId", "Lcom/example/sberify/data/db/album/AlbumWithArtists;", "albumId", "insertAlbum", "", "albumEntity", "(Lcom/example/sberify/data/db/album/AlbumEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadFavoriteAlbums", "updateAlbum", "isFavorite", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAlbumTracks", "app_debug"})
public abstract interface AlbumDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract java.lang.Object insertAlbum(@org.jetbrains.annotations.NotNull()
    com.example.sberify.data.db.album.AlbumEntity albumEntity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM albums ORDER BY release_date DESC LIMIT 50")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.sberify.data.db.album.AlbumEntity>> getAlbums();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM albums WHERE name LIKE \'%\' || :key || \'%\'")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.sberify.data.db.album.AlbumEntity>> getAlbumsByKeyword(@org.jetbrains.annotations.NotNull()
    java.lang.String key);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM albums WHERE album_id = :id")
    public abstract androidx.lifecycle.LiveData<com.example.sberify.data.db.album.AlbumEntity> getAlbumById(@org.jetbrains.annotations.NotNull()
    java.lang.String id);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Update(entity = com.example.sberify.data.db.album.AlbumEntity.class, onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object updateAlbumTracks(@org.jetbrains.annotations.NotNull()
    com.example.sberify.data.db.album.AlbumEntity albumEntity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "UPDATE albums SET is_favorite = :isFavorite WHERE album_id = :id")
    public abstract java.lang.Object updateAlbum(@org.jetbrains.annotations.NotNull()
    java.lang.String id, boolean isFavorite, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p2);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM albums WHERE is_favorite = 1 ORDER BY name ASC")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.sberify.data.db.album.AlbumEntity>> loadFavoriteAlbums();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM albums WHERE album_id = :id")
    @androidx.room.Transaction()
    public abstract androidx.lifecycle.LiveData<com.example.sberify.data.db.album.AlbumWithTracks> getAlbumTracks(@org.jetbrains.annotations.NotNull()
    java.lang.String id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM albums ORDER BY release_date DESC LIMIT 50")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.sberify.data.db.album.AlbumEntity>> getAllAlbums();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM albums WHERE name LIKE \'%\' || :query || \'%\'")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.sberify.data.db.album.AlbumEntity>> getAlbumsByQuery(@org.jetbrains.annotations.NotNull()
    java.lang.String query);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM albums WHERE album_id = :albumId")
    @androidx.room.Transaction()
    public abstract com.example.sberify.data.db.album.AlbumWithArtists getArtistsByAlbumId(@org.jetbrains.annotations.NotNull()
    java.lang.String albumId);
}