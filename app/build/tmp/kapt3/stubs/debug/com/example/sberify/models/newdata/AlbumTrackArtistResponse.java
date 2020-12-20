package com.example.sberify.models.newdata;

import java.lang.System;

/**
 * @author Konstantin Koval
 * @since 12.12.2020
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u00a2\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u00c6\u0003J3\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r\u00a8\u0006\u001a"}, d2 = {"Lcom/example/sberify/models/newdata/AlbumTrackArtistResponse;", "", "albumInfo", "Lcom/example/sberify/data/db/album/AlbumEntity;", "artists", "", "Lcom/example/sberify/data/db/artists/ArtistEntity;", "tracks", "Lcom/example/sberify/data/db/track/TrackEntity;", "(Lcom/example/sberify/data/db/album/AlbumEntity;Ljava/util/List;Ljava/util/List;)V", "getAlbumInfo", "()Lcom/example/sberify/data/db/album/AlbumEntity;", "getArtists", "()Ljava/util/List;", "getTracks", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
public final class AlbumTrackArtistResponse {
    @org.jetbrains.annotations.NotNull()
    private final com.example.sberify.data.db.album.AlbumEntity albumInfo = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.sberify.data.db.artists.ArtistEntity> artists = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.sberify.data.db.track.TrackEntity> tracks = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.sberify.data.db.album.AlbumEntity getAlbumInfo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.sberify.data.db.artists.ArtistEntity> getArtists() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.sberify.data.db.track.TrackEntity> getTracks() {
        return null;
    }
    
    public AlbumTrackArtistResponse(@org.jetbrains.annotations.NotNull()
    com.example.sberify.data.db.album.AlbumEntity albumInfo, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.sberify.data.db.artists.ArtistEntity> artists, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.sberify.data.db.track.TrackEntity> tracks) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.sberify.data.db.album.AlbumEntity component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.sberify.data.db.artists.ArtistEntity> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.sberify.data.db.track.TrackEntity> component3() {
        return null;
    }
    
    /**
     * @author Konstantin Koval
     * @since 12.12.2020
     */
    @org.jetbrains.annotations.NotNull()
    public final com.example.sberify.models.newdata.AlbumTrackArtistResponse copy(@org.jetbrains.annotations.NotNull()
    com.example.sberify.data.db.album.AlbumEntity albumInfo, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.sberify.data.db.artists.ArtistEntity> artists, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.sberify.data.db.track.TrackEntity> tracks) {
        return null;
    }
    
    /**
     * @author Konstantin Koval
     * @since 12.12.2020
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * @author Konstantin Koval
     * @since 12.12.2020
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * @author Konstantin Koval
     * @since 12.12.2020
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}