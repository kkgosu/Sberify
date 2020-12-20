package com.kvlg.shared.data.db.album;

import java.lang.System;

@androidx.room.Entity(tableName = "albums")
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0001+BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u000eH\u00c6\u0003Ja\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000eH\u00c6\u0001J\u0013\u0010$\u001a\u00020\u000e2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010&\u001a\u00020\'H\u00d6\u0001J\u0006\u0010(\u001a\u00020)J\t\u0010*\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0015R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006,"}, d2 = {"Lcom/kvlg/shared/data/db/album/AlbumEntity;", "", "spotifyId", "", "artistId", "artist", "Lcom/kvlg/shared/data/db/artists/ArtistEntity;", "name", "trackIds", "", "Lcom/kvlg/model/presentation/Track;", "imageUrl", "releaseDate", "isFavorite", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/kvlg/shared/data/db/artists/ArtistEntity;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Z)V", "getArtist", "()Lcom/kvlg/shared/data/db/artists/ArtistEntity;", "getArtistId", "()Ljava/lang/String;", "getImageUrl", "()Z", "getName", "getReleaseDate", "getSpotifyId", "getTrackIds", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toAlbum", "Lcom/kvlg/model/presentation/Album;", "toString", "Companion", "shared_debug"})
public final class AlbumEntity {
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "spotify_id", index = true)
    @androidx.room.PrimaryKey()
    private final java.lang.String spotifyId = null;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "artist_id", index = true)
    private final java.lang.String artistId = null;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Embedded(prefix = "m")
    private final com.kvlg.shared.data.db.artists.ArtistEntity artist = null;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "name")
    private final java.lang.String name = null;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "track_ids")
    private final java.util.List<com.kvlg.model.presentation.Track> trackIds = null;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "image_url")
    private final java.lang.String imageUrl = null;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "release_date")
    private final java.lang.String releaseDate = null;
    @androidx.room.ColumnInfo(name = "isFavorite")
    private final boolean isFavorite = false;
    @org.jetbrains.annotations.NotNull()
    public static final com.kvlg.shared.data.db.album.AlbumEntity.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.kvlg.model.presentation.Album toAlbum() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSpotifyId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getArtistId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kvlg.shared.data.db.artists.ArtistEntity getArtist() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.kvlg.model.presentation.Track> getTrackIds() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getImageUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getReleaseDate() {
        return null;
    }
    
    public final boolean isFavorite() {
        return false;
    }
    
    public AlbumEntity(@org.jetbrains.annotations.NotNull()
    java.lang.String spotifyId, @org.jetbrains.annotations.NotNull()
    java.lang.String artistId, @org.jetbrains.annotations.NotNull()
    com.kvlg.shared.data.db.artists.ArtistEntity artist, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.util.List<com.kvlg.model.presentation.Track> trackIds, @org.jetbrains.annotations.NotNull()
    java.lang.String imageUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String releaseDate, boolean isFavorite) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kvlg.shared.data.db.artists.ArtistEntity component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.kvlg.model.presentation.Track> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    public final boolean component8() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kvlg.shared.data.db.album.AlbumEntity copy(@org.jetbrains.annotations.NotNull()
    java.lang.String spotifyId, @org.jetbrains.annotations.NotNull()
    java.lang.String artistId, @org.jetbrains.annotations.NotNull()
    com.kvlg.shared.data.db.artists.ArtistEntity artist, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.util.List<com.kvlg.model.presentation.Track> trackIds, @org.jetbrains.annotations.NotNull()
    java.lang.String imageUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String releaseDate, boolean isFavorite) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/kvlg/shared/data/db/album/AlbumEntity$Companion;", "", "()V", "from", "Lcom/kvlg/shared/data/db/album/AlbumEntity;", "album", "Lcom/kvlg/model/presentation/Album;", "shared_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.kvlg.shared.data.db.album.AlbumEntity from(@org.jetbrains.annotations.NotNull()
        com.kvlg.model.presentation.Album album) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}