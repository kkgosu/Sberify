package com.example.sberify.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H&J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\r0\u0007H&J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u0010H&J(\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00072\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00020\u0015H&\u00a8\u0006\u0016"}, d2 = {"Lcom/example/sberify/domain/IConverter;", "From", "Lcom/example/sberify/models/data/BaseDataModel;", "To", "Lcom/example/sberify/models/domain/BaseModel;", "", "convertAlbums", "", "Lcom/example/sberify/models/domain/Album;", "from", "Lcom/example/sberify/models/data/AlbumData;", "convertArtists", "Lcom/example/sberify/models/domain/Artist;", "Lcom/example/sberify/models/data/ArtistData;", "convertImages", "Lcom/example/sberify/models/domain/Image;", "Lcom/example/sberify/models/data/ImageData;", "convertTracks", "Lcom/example/sberify/models/domain/Track;", "Lcom/example/sberify/models/data/TrackData;", "image", "", "app_debug"})
public abstract interface IConverter<From extends com.example.sberify.models.data.BaseDataModel, To extends com.example.sberify.models.domain.BaseModel> {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.example.sberify.models.domain.Album> convertAlbums(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.sberify.models.data.AlbumData> from);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.example.sberify.models.domain.Artist> convertArtists(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.sberify.models.data.ArtistData> from);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.util.List<com.example.sberify.models.domain.Track> convertTracks(@org.jetbrains.annotations.Nullable()
    java.util.List<com.example.sberify.models.data.TrackData> from, @org.jetbrains.annotations.NotNull()
    java.lang.String image);
    
    @org.jetbrains.annotations.Nullable()
    public abstract com.example.sberify.models.domain.Image convertImages(@org.jetbrains.annotations.Nullable()
    com.example.sberify.models.data.ImageData from);
}