package com.kvlg.network.spotify;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006H\u0016J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006H\u0016J\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u000fH\u0016J(\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00062\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/kvlg/network/spotify/DataConverter;", "Lcom/kvlg/network/spotify/IConverter;", "Lcom/kvlg/model/data/spotify/BaseDataModel;", "Lcom/kvlg/model/presentation/BaseModel;", "()V", "convertAlbums", "", "Lcom/kvlg/model/presentation/Album;", "from", "Lcom/kvlg/model/data/spotify/AlbumData;", "convertArtists", "Lcom/kvlg/model/presentation/Artist;", "Lcom/kvlg/model/data/spotify/ArtistData;", "convertImages", "Lcom/kvlg/model/presentation/Image;", "Lcom/kvlg/model/data/spotify/ImageData;", "convertTracks", "Lcom/kvlg/model/presentation/Track;", "Lcom/kvlg/model/data/spotify/TrackData;", "image", "", "network_debug"})
public final class DataConverter implements com.kvlg.network.spotify.IConverter<com.kvlg.model.data.spotify.BaseDataModel, com.kvlg.model.presentation.BaseModel> {
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<com.kvlg.model.presentation.Album> convertAlbums(@org.jetbrains.annotations.Nullable()
    java.util.List<com.kvlg.model.data.spotify.AlbumData> from) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<com.kvlg.model.presentation.Artist> convertArtists(@org.jetbrains.annotations.NotNull()
    java.util.List<com.kvlg.model.data.spotify.ArtistData> from) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.util.List<com.kvlg.model.presentation.Track> convertTracks(@org.jetbrains.annotations.Nullable()
    java.util.List<com.kvlg.model.data.spotify.TrackData> from, @org.jetbrains.annotations.NotNull()
    java.lang.String image) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public com.kvlg.model.presentation.Image convertImages(@org.jetbrains.annotations.Nullable()
    com.kvlg.model.data.spotify.ImageData from) {
        return null;
    }
    
    public DataConverter() {
        super();
    }
}