package com.example.sberify.data;

import java.lang.System;

/**
 * @author Konstantin Koval
 * @since 07.12.2020
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/example/sberify/data/ResponseConverter;", "", "()V", "convertAlbumToDomain", "Lcom/example/sberify/models/newdomain/AlbumDomainModel;", "response", "Lcom/example/sberify/models/newdata/AlbumInfoResponse;", "convertAlbumToEntity", "Lcom/example/sberify/models/newdata/AlbumTrackArtistResponse;", "convertArtistToDomain", "Lcom/example/sberify/models/newdomain/ArtistDomainModel;", "Lcom/example/sberify/models/newdata/ArtistResponse;", "convertArtistToEntity", "Lcom/example/sberify/data/db/artists/ArtistEntity;", "convertCopyrightToDomain", "Lcom/example/sberify/models/newdomain/CopyrightDomainModel;", "Lcom/example/sberify/models/newdata/CopyrightResponse;", "convertExternalUrlToDomain", "Lcom/example/sberify/models/newdomain/ExternalUrlDomainModel;", "Lcom/example/sberify/models/newdata/ExternalUrlResponse;", "convertImageResponseToDomain", "Lcom/example/sberify/models/newdomain/ImageDomainModel;", "Lcom/example/sberify/models/newdata/ImageResponse;", "convertTrackToDomain", "Lcom/example/sberify/models/newdomain/TrackDomainModel;", "Lcom/example/sberify/models/newdata/TrackItemResponse;", "convertTrackToEntity", "Lcom/example/sberify/data/db/track/TrackEntity;", "app_debug"})
public final class ResponseConverter {
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.sberify.models.newdomain.ImageDomainModel convertImageResponseToDomain(@org.jetbrains.annotations.NotNull()
    com.example.sberify.models.newdata.ImageResponse response) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.sberify.models.newdomain.CopyrightDomainModel convertCopyrightToDomain(@org.jetbrains.annotations.NotNull()
    com.example.sberify.models.newdata.CopyrightResponse response) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.sberify.models.newdomain.ExternalUrlDomainModel convertExternalUrlToDomain(@org.jetbrains.annotations.NotNull()
    com.example.sberify.models.newdata.ExternalUrlResponse response) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.sberify.models.newdomain.TrackDomainModel convertTrackToDomain(@org.jetbrains.annotations.NotNull()
    com.example.sberify.models.newdata.TrackItemResponse response) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.sberify.models.newdomain.ArtistDomainModel convertArtistToDomain(@org.jetbrains.annotations.NotNull()
    com.example.sberify.models.newdata.ArtistResponse response) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.sberify.models.newdomain.AlbumDomainModel convertAlbumToDomain(@org.jetbrains.annotations.NotNull()
    com.example.sberify.models.newdata.AlbumInfoResponse response) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.sberify.models.newdata.AlbumTrackArtistResponse convertAlbumToEntity(@org.jetbrains.annotations.NotNull()
    com.example.sberify.models.newdata.AlbumInfoResponse response) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.sberify.data.db.track.TrackEntity convertTrackToEntity(@org.jetbrains.annotations.NotNull()
    com.example.sberify.models.newdata.TrackItemResponse response) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.sberify.data.db.artists.ArtistEntity convertArtistToEntity(@org.jetbrains.annotations.NotNull()
    com.example.sberify.models.newdata.ArtistResponse response) {
        return null;
    }
    
    public ResponseConverter() {
        super();
    }
}