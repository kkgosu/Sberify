package com.kvlg.shared.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\u0006\u0010\u0011\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH\u0016J\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\nH\u0016J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\nH\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\nH\u0016J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\nH\u0016J\f\u0010\u001d\u001a\u00020\n*\u00020\u001eH\u0002J\f\u0010\u001f\u001a\u00020\u001e*\u00020\nH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"Lcom/kvlg/shared/data/AlbumsRepositoryImpl;", "Lcom/kvlg/shared/data/AlbumRepository;", "database", "Lcom/kvlg/shared/data/db/AppDatabase;", "spotifyApi", "Lcom/kvlg/network/spotify/SpotifyApi;", "converter", "Lcom/kvlg/network/spotify/DataConverter;", "(Lcom/kvlg/shared/data/db/AppDatabase;Lcom/kvlg/network/spotify/SpotifyApi;Lcom/kvlg/network/spotify/DataConverter;)V", "getAlbumInfoFromDb", "Lcom/kvlg/model/presentation/Album;", "id", "", "getAlbumInfoFromSpotify", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAlbumsFromDb", "keyword", "getAlbumsFromSpotify", "getAllAlbumsFromDb", "getFavoriteAlbums", "getNewReleases", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertAlbum", "", "album", "saveAlbumIntoDb", "updateAlbumInfoInDb", "updateAlbumTracks", "toAlbum", "Lcom/kvlg/shared/data/db/album/AlbumEntity;", "toEntity", "shared_debug"})
public final class AlbumsRepositoryImpl implements com.kvlg.shared.data.AlbumRepository {
    private final com.kvlg.shared.data.db.AppDatabase database = null;
    private final com.kvlg.network.spotify.SpotifyApi spotifyApi = null;
    private final com.kvlg.network.spotify.DataConverter converter = null;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getAlbumsFromSpotify(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.kvlg.model.presentation.Album>> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getAlbumInfoFromSpotify(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.kvlg.model.presentation.Album>> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getNewReleases(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.kvlg.model.presentation.Album>> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<com.kvlg.model.presentation.Album> getAlbumsFromDb(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword) {
        return null;
    }
    
    @java.lang.Override()
    public void saveAlbumIntoDb(@org.jetbrains.annotations.NotNull()
    com.kvlg.model.presentation.Album album) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.kvlg.model.presentation.Album getAlbumInfoFromDb(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    @java.lang.Override()
    public void updateAlbumInfoInDb(@org.jetbrains.annotations.NotNull()
    com.kvlg.model.presentation.Album album) {
    }
    
    @java.lang.Override()
    public void updateAlbumTracks(@org.jetbrains.annotations.NotNull()
    com.kvlg.model.presentation.Album album) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<com.kvlg.model.presentation.Album> getAllAlbumsFromDb() {
        return null;
    }
    
    @java.lang.Override()
    public void insertAlbum(@org.jetbrains.annotations.NotNull()
    com.kvlg.model.presentation.Album album) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<com.kvlg.model.presentation.Album> getFavoriteAlbums() {
        return null;
    }
    
    private final com.kvlg.model.presentation.Album toAlbum(com.kvlg.shared.data.db.album.AlbumEntity $this$toAlbum) {
        return null;
    }
    
    private final com.kvlg.shared.data.db.album.AlbumEntity toEntity(com.kvlg.model.presentation.Album $this$toEntity) {
        return null;
    }
    
    public AlbumsRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.kvlg.shared.data.db.AppDatabase database, @org.jetbrains.annotations.NotNull()
    com.kvlg.network.spotify.SpotifyApi spotifyApi, @org.jetbrains.annotations.NotNull()
    com.kvlg.network.spotify.DataConverter converter) {
        super();
    }
}