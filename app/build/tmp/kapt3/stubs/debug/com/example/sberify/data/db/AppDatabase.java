package com.example.sberify.data.db;

import java.lang.System;

@androidx.room.TypeConverters(value = {com.example.sberify.data.db.ListToStringConverter.class})
@androidx.room.Database(entities = {com.example.sberify.data.db.artists.ArtistEntity.class, com.example.sberify.data.db.album.AlbumEntity.class, com.example.sberify.data.db.track.TrackEntity.class, com.example.sberify.data.db.suggestions.SuggestionsEntity.class, com.example.sberify.data.db.album.AlbumArtistCrossRef.class, com.example.sberify.data.db.track.TrackArtistCrossRef.class}, version = 2, exportSchema = false)
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/example/sberify/data/db/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "getAlbumDao", "Lcom/example/sberify/data/db/album/AlbumDao;", "getArtistDao", "Lcom/example/sberify/data/db/artists/ArtistDao;", "getSuggestionsDao", "Lcom/example/sberify/data/db/suggestions/SuggestionsDao;", "getTrackDao", "Lcom/example/sberify/data/db/track/TrackDao;", "app_debug"})
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.sberify.data.db.artists.ArtistDao getArtistDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.sberify.data.db.album.AlbumDao getAlbumDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.sberify.data.db.track.TrackDao getTrackDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.sberify.data.db.suggestions.SuggestionsDao getSuggestionsDao();
    
    public AppDatabase() {
        super();
    }
}