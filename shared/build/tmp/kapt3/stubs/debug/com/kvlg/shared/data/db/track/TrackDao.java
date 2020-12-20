package com.kvlg.shared.data.db.track;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u001c\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0018\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b2\u0006\u0010\n\u001a\u00020\u0005H\'J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\'J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\'J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\'J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\'\u00a8\u0006\u0012"}, d2 = {"Lcom/kvlg/shared/data/db/track/TrackDao;", "", "getTrackById", "Lcom/kvlg/shared/data/db/track/TrackEntity;", "id", "", "getTracksByAlbumId", "Landroidx/lifecycle/LiveData;", "", "getTracksByKeyword", "key", "insertTrack", "", "trackEntity", "loadFavoriteTracks", "updateTrack", "updateTrackLyrics", "lyrics", "shared_debug"})
public abstract interface TrackDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM tracks WHERE spotify_id = :id")
    public abstract com.kvlg.shared.data.db.track.TrackEntity getTrackById(@org.jetbrains.annotations.NotNull()
    java.lang.String id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM tracks WHERE album_id = :id")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.kvlg.shared.data.db.track.TrackEntity>> getTracksByAlbumId(@org.jetbrains.annotations.NotNull()
    java.lang.String id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM tracks WHERE name LIKE \'%\' || :key || \'%\' OR artists LIKE \'%\' || :key || \'%\'")
    public abstract java.util.List<com.kvlg.shared.data.db.track.TrackEntity> getTracksByKeyword(@org.jetbrains.annotations.NotNull()
    java.lang.String key);
    
    @androidx.room.Query(value = "UPDATE tracks SET lyrics = :lyrics WHERE spotify_id=:id")
    public abstract void updateTrackLyrics(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String lyrics);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM tracks WHERE isFavorite = 1 ORDER BY name ASC")
    public abstract java.util.List<com.kvlg.shared.data.db.track.TrackEntity> loadFavoriteTracks();
    
    @androidx.room.Update(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract void updateTrack(@org.jetbrains.annotations.NotNull()
    com.kvlg.shared.data.db.track.TrackEntity trackEntity);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract void insertTrack(@org.jetbrains.annotations.NotNull()
    com.kvlg.shared.data.db.track.TrackEntity trackEntity);
}