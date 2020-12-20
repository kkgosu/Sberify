package com.example.sberify.data.db.track;

import java.lang.System;

/**
 * @author Konstantin Koval
 * @since 10.12.2020
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/example/sberify/data/db/track/TrackWithArtists;", "", "track", "Lcom/example/sberify/data/db/track/TrackEntity;", "artists", "", "Lcom/example/sberify/data/db/artists/ArtistEntity;", "(Lcom/example/sberify/data/db/track/TrackEntity;Ljava/util/List;)V", "getArtists", "()Ljava/util/List;", "getTrack", "()Lcom/example/sberify/data/db/track/TrackEntity;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
public final class TrackWithArtists {
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Embedded()
    private final com.example.sberify.data.db.track.TrackEntity track = null;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Relation(parentColumn = "track_id", entityColumn = "artist_id", associateBy = @androidx.room.Junction(value = com.example.sberify.data.db.track.TrackArtistCrossRef.class))
    private final java.util.List<com.example.sberify.data.db.artists.ArtistEntity> artists = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.sberify.data.db.track.TrackEntity getTrack() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.sberify.data.db.artists.ArtistEntity> getArtists() {
        return null;
    }
    
    public TrackWithArtists(@org.jetbrains.annotations.NotNull()
    com.example.sberify.data.db.track.TrackEntity track, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.sberify.data.db.artists.ArtistEntity> artists) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.sberify.data.db.track.TrackEntity component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.sberify.data.db.artists.ArtistEntity> component2() {
        return null;
    }
    
    /**
     * @author Konstantin Koval
     * @since 10.12.2020
     */
    @org.jetbrains.annotations.NotNull()
    public final com.example.sberify.data.db.track.TrackWithArtists copy(@org.jetbrains.annotations.NotNull()
    com.example.sberify.data.db.track.TrackEntity track, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.sberify.data.db.artists.ArtistEntity> artists) {
        return null;
    }
    
    /**
     * @author Konstantin Koval
     * @since 10.12.2020
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * @author Konstantin Koval
     * @since 10.12.2020
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * @author Konstantin Koval
     * @since 10.12.2020
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}