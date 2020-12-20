package com.kvlg.shared.data.db.artists;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\t\u001a\u00020\u0006H\'J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\'\u00a8\u0006\r"}, d2 = {"Lcom/kvlg/shared/data/db/artists/ArtistDao;", "", "getArtistById", "Landroidx/lifecycle/LiveData;", "Lcom/kvlg/shared/data/db/artists/ArtistEntity;", "id", "", "getArtistByKeyword", "", "key", "insertArtist", "", "artistEntity", "shared_debug"})
public abstract interface ArtistDao {
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insertArtist(@org.jetbrains.annotations.NotNull()
    com.kvlg.shared.data.db.artists.ArtistEntity artistEntity);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM artists WHERE spotify_id = :id")
    public abstract androidx.lifecycle.LiveData<com.kvlg.shared.data.db.artists.ArtistEntity> getArtistById(@org.jetbrains.annotations.NotNull()
    java.lang.String id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM artists WHERE name LIKE \'%\' || :key || \'%\'")
    public abstract java.util.List<com.kvlg.shared.data.db.artists.ArtistEntity> getArtistByKeyword(@org.jetbrains.annotations.NotNull()
    java.lang.String key);
}