package com.example.sberify.data;

import java.lang.System;

/**
 * @author Konstantin Koval
 * @since 07.12.2020
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\b\u00a8\u0006\u0012"}, d2 = {"Lcom/example/sberify/data/DbConverter;", "", "()V", "convertAlbumEntityToDomain", "Lcom/example/sberify/models/newdomain/AlbumDomainModel;", "albumEntity", "Lcom/example/sberify/data/db/album/AlbumEntity;", "tracksEntities", "", "Lcom/example/sberify/data/db/track/TrackEntity;", "convertArtistEntityToDomain", "Lcom/example/sberify/models/newdomain/ArtistDomainModel;", "artistEntity", "Lcom/example/sberify/data/db/artists/ArtistEntity;", "convertTrackEntityToDomain", "Lcom/example/sberify/models/newdomain/TrackDomainModel;", "trackEntity", "artistEntities", "app_debug"})
public final class DbConverter {
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.sberify.models.newdomain.ArtistDomainModel convertArtistEntityToDomain(@org.jetbrains.annotations.NotNull()
    com.example.sberify.data.db.artists.ArtistEntity artistEntity) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.sberify.models.newdomain.TrackDomainModel convertTrackEntityToDomain(@org.jetbrains.annotations.NotNull()
    com.example.sberify.data.db.track.TrackEntity trackEntity, @org.jetbrains.annotations.Nullable()
    java.util.List<com.example.sberify.data.db.artists.ArtistEntity> artistEntities) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.sberify.models.newdomain.AlbumDomainModel convertAlbumEntityToDomain(@org.jetbrains.annotations.NotNull()
    com.example.sberify.data.db.album.AlbumEntity albumEntity, @org.jetbrains.annotations.Nullable()
    java.util.List<com.example.sberify.data.db.track.TrackEntity> tracksEntities) {
        return null;
    }
    
    public DbConverter() {
        super();
    }
}