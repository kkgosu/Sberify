package com.kvlg.shared.data;

import java.lang.System;

/**
 * @author Konstantin Koval
 * @since 29.10.2020
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\n\u001a\u00020\u0005H&J\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\n\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H&J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H&J\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H&J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H&J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H&J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/kvlg/shared/data/AlbumRepository;", "", "getAlbumInfoFromDb", "Lcom/kvlg/model/presentation/Album;", "id", "", "getAlbumInfoFromSpotify", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAlbumsFromDb", "keyword", "getAlbumsFromSpotify", "getAllAlbumsFromDb", "getFavoriteAlbums", "getNewReleases", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertAlbum", "", "album", "saveAlbumIntoDb", "updateAlbumInfoInDb", "updateAlbumTracks", "shared_debug"})
public abstract interface AlbumRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAlbumsFromSpotify(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.kvlg.model.presentation.Album>> p1);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAlbumInfoFromSpotify(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.kvlg.model.presentation.Album>> p1);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getNewReleases(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.kvlg.model.presentation.Album>> p0);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.kvlg.model.presentation.Album> getAlbumsFromDb(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword);
    
    public abstract void saveAlbumIntoDb(@org.jetbrains.annotations.NotNull()
    com.kvlg.model.presentation.Album album);
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.kvlg.model.presentation.Album getAlbumInfoFromDb(@org.jetbrains.annotations.NotNull()
    java.lang.String id);
    
    public abstract void updateAlbumInfoInDb(@org.jetbrains.annotations.NotNull()
    com.kvlg.model.presentation.Album album);
    
    public abstract void updateAlbumTracks(@org.jetbrains.annotations.NotNull()
    com.kvlg.model.presentation.Album album);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.kvlg.model.presentation.Album> getAllAlbumsFromDb();
    
    public abstract void insertAlbum(@org.jetbrains.annotations.NotNull()
    com.kvlg.model.presentation.Album album);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.kvlg.model.presentation.Album> getFavoriteAlbums();
}