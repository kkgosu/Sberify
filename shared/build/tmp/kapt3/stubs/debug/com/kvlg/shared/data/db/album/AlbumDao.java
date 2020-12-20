package com.kvlg.shared.data.db.album;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\'J\u001c\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00070\t2\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\u000b\u001a\u00020\u0005H\'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\'J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\'J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\'J\u0019\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u001e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0007H\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lcom/kvlg/shared/data/db/album/AlbumDao;", "", "getAlbumById", "Lcom/kvlg/shared/data/db/album/AlbumEntity;", "id", "", "getAlbums", "", "getAlbumsByArtistId", "Landroidx/lifecycle/LiveData;", "getAlbumsByKeyword", "key", "insertAlbum", "", "albumEntity", "loadFavoriteAlbums", "updateAlbum", "updateAlbumTracks", "(Lcom/kvlg/shared/data/db/album/AlbumEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tracks", "Lcom/kvlg/model/presentation/Track;", "shared_debug"})
public abstract interface AlbumDao {
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract void insertAlbum(@org.jetbrains.annotations.NotNull()
    com.kvlg.shared.data.db.album.AlbumEntity albumEntity);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM albums ORDER BY release_date DESC LIMIT 50")
    public abstract java.util.List<com.kvlg.shared.data.db.album.AlbumEntity> getAlbums();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM albums WHERE name LIKE \'%\' || :key || \'%\' OR mname LIKE \'%\' || :key || \'%\'")
    public abstract java.util.List<com.kvlg.shared.data.db.album.AlbumEntity> getAlbumsByKeyword(@org.jetbrains.annotations.NotNull()
    java.lang.String key);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM albums WHERE spotify_id = :id")
    public abstract com.kvlg.shared.data.db.album.AlbumEntity getAlbumById(@org.jetbrains.annotations.NotNull()
    java.lang.String id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM albums WHERE artist_id = :id")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.kvlg.shared.data.db.album.AlbumEntity>> getAlbumsByArtistId(@org.jetbrains.annotations.NotNull()
    java.lang.String id);
    
    @androidx.room.Query(value = "UPDATE albums SET track_ids =:tracks WHERE spotify_id =:id")
    public abstract void updateAlbumTracks(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.util.List<com.kvlg.model.presentation.Track> tracks);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Update(entity = com.kvlg.shared.data.db.album.AlbumEntity.class, onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object updateAlbumTracks(@org.jetbrains.annotations.NotNull()
    com.kvlg.shared.data.db.album.AlbumEntity albumEntity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    @androidx.room.Update(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract void updateAlbum(@org.jetbrains.annotations.NotNull()
    com.kvlg.shared.data.db.album.AlbumEntity albumEntity);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM albums WHERE isFavorite = 1 ORDER BY name ASC")
    public abstract java.util.List<com.kvlg.shared.data.db.album.AlbumEntity> loadFavoriteAlbums();
}