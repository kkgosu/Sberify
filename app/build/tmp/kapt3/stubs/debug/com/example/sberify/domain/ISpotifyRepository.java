package com.example.sberify.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\u00040\u0003H&J\"\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\u00040\u00032\u0006\u0010\u000b\u001a\u00020\u0007H&J\"\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\t0\u00040\u00032\u0006\u0010\u000b\u001a\u00020\u0007H&J\"\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\t0\u00040\u00032\u0006\u0010\u000b\u001a\u00020\u0007H&\u00a8\u0006\u0010"}, d2 = {"Lcom/example/sberify/domain/ISpotifyRepository;", "", "getAlbumInfo", "Landroidx/lifecycle/LiveData;", "Lcom/example/sberify/data/Result;", "Lcom/example/sberify/models/newdomain/AlbumDomainModel;", "id", "", "getNewReleases", "", "searchAlbum", "keyword", "searchArtist", "Lcom/example/sberify/models/newdomain/ArtistDomainModel;", "searchTrack", "Lcom/example/sberify/models/newdomain/TrackDomainModel;", "app_debug"})
public abstract interface ISpotifyRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<com.example.sberify.data.Result<java.util.List<com.example.sberify.models.newdomain.AlbumDomainModel>>> getNewReleases();
    
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<com.example.sberify.data.Result<com.example.sberify.models.newdomain.AlbumDomainModel>> getAlbumInfo(@org.jetbrains.annotations.NotNull()
    java.lang.String id);
    
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<com.example.sberify.data.Result<java.util.List<com.example.sberify.models.newdomain.ArtistDomainModel>>> searchArtist(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword);
    
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<com.example.sberify.data.Result<java.util.List<com.example.sberify.models.newdomain.AlbumDomainModel>>> searchAlbum(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword);
    
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<com.example.sberify.data.Result<java.util.List<com.example.sberify.models.newdomain.TrackDomainModel>>> searchTrack(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword);
}