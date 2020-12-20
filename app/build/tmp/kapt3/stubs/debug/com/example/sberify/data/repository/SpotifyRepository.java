package com.example.sberify.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00120\r0\fH\u0016J\"\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00120\r0\f2\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\"\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00120\r0\f2\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\"\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00120\r0\f2\u0006\u0010\u0014\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/example/sberify/data/repository/SpotifyRepository;", "Lcom/example/sberify/domain/ISpotifyRepository;", "database", "Lcom/example/sberify/data/db/AppDatabase;", "spotifyApi", "Lcom/example/sberify/data/api/ISpotifyApi;", "dbConverter", "Lcom/example/sberify/data/DbConverter;", "responseConverter", "Lcom/example/sberify/data/ResponseConverter;", "(Lcom/example/sberify/data/db/AppDatabase;Lcom/example/sberify/data/api/ISpotifyApi;Lcom/example/sberify/data/DbConverter;Lcom/example/sberify/data/ResponseConverter;)V", "getAlbumInfo", "Landroidx/lifecycle/LiveData;", "Lcom/example/sberify/data/Result;", "Lcom/example/sberify/models/newdomain/AlbumDomainModel;", "id", "", "getNewReleases", "", "searchAlbum", "keyword", "searchArtist", "Lcom/example/sberify/models/newdomain/ArtistDomainModel;", "searchTrack", "Lcom/example/sberify/models/newdomain/TrackDomainModel;", "app_debug"})
public final class SpotifyRepository implements com.example.sberify.domain.ISpotifyRepository {
    private final com.example.sberify.data.db.AppDatabase database = null;
    private final com.example.sberify.data.api.ISpotifyApi spotifyApi = null;
    private final com.example.sberify.data.DbConverter dbConverter = null;
    private final com.example.sberify.data.ResponseConverter responseConverter = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.LiveData<com.example.sberify.data.Result<java.util.List<com.example.sberify.models.newdomain.AlbumDomainModel>>> getNewReleases() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.LiveData<com.example.sberify.data.Result<com.example.sberify.models.newdomain.AlbumDomainModel>> getAlbumInfo(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.LiveData<com.example.sberify.data.Result<java.util.List<com.example.sberify.models.newdomain.ArtistDomainModel>>> searchArtist(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.LiveData<com.example.sberify.data.Result<java.util.List<com.example.sberify.models.newdomain.AlbumDomainModel>>> searchAlbum(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.LiveData<com.example.sberify.data.Result<java.util.List<com.example.sberify.models.newdomain.TrackDomainModel>>> searchTrack(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword) {
        return null;
    }
    
    @javax.inject.Inject()
    public SpotifyRepository(@org.jetbrains.annotations.NotNull()
    com.example.sberify.data.db.AppDatabase database, @org.jetbrains.annotations.NotNull()
    com.example.sberify.data.api.ISpotifyApi spotifyApi, @org.jetbrains.annotations.NotNull()
    com.example.sberify.data.DbConverter dbConverter, @org.jetbrains.annotations.NotNull()
    com.example.sberify.data.ResponseConverter responseConverter) {
        super();
    }
}