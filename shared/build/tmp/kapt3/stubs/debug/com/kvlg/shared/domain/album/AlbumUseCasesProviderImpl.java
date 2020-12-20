package com.kvlg.shared.domain.album;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001c8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020 8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020$8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010&R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\'\u001a\u00020(8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020,8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b-\u0010.R\u0014\u0010/\u001a\u0002008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b1\u00102\u00a8\u00063"}, d2 = {"Lcom/kvlg/shared/domain/album/AlbumUseCasesProviderImpl;", "Lcom/kvlg/shared/domain/album/AlbumUseCasesProvider;", "repository", "Lcom/kvlg/shared/data/AlbumRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/kvlg/shared/data/AlbumRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getAlbumByIdDb", "Lcom/kvlg/shared/domain/album/GetAlbumByIdDbUseCase;", "getGetAlbumByIdDb", "()Lcom/kvlg/shared/domain/album/GetAlbumByIdDbUseCase;", "getAlbumByIdSpotify", "Lcom/kvlg/shared/domain/album/GetAlbumByIdSpotifyUseCase;", "getGetAlbumByIdSpotify", "()Lcom/kvlg/shared/domain/album/GetAlbumByIdSpotifyUseCase;", "getAlbumsFromDb", "Lcom/kvlg/shared/domain/album/GetAlbumsFromDbUseCase;", "getGetAlbumsFromDb", "()Lcom/kvlg/shared/domain/album/GetAlbumsFromDbUseCase;", "getAlbumsFromSpotify", "Lcom/kvlg/shared/domain/album/GetAlbumsFromSpotifyUseCase;", "getGetAlbumsFromSpotify", "()Lcom/kvlg/shared/domain/album/GetAlbumsFromSpotifyUseCase;", "getAllAlbums", "Lcom/kvlg/shared/domain/album/GetAllAlbumsFromDbUseCase;", "getGetAllAlbums", "()Lcom/kvlg/shared/domain/album/GetAllAlbumsFromDbUseCase;", "getFavoriteTracks", "Lcom/kvlg/shared/domain/album/GetFavoriteAlbumsUseCase;", "getGetFavoriteTracks", "()Lcom/kvlg/shared/domain/album/GetFavoriteAlbumsUseCase;", "getNewReleases", "Lcom/kvlg/shared/domain/album/GetNewReleasesUseCase;", "getGetNewReleases", "()Lcom/kvlg/shared/domain/album/GetNewReleasesUseCase;", "insertAlbum", "Lcom/kvlg/shared/domain/album/InsertAlbumUseCase;", "getInsertAlbum", "()Lcom/kvlg/shared/domain/album/InsertAlbumUseCase;", "saveAlbumIntoDb", "Lcom/kvlg/shared/domain/album/SaveAlbumIntoDbUseCase;", "getSaveAlbumIntoDb", "()Lcom/kvlg/shared/domain/album/SaveAlbumIntoDbUseCase;", "updateAlbumInDb", "Lcom/kvlg/shared/domain/album/UpdateAlbumInDbUseCase;", "getUpdateAlbumInDb", "()Lcom/kvlg/shared/domain/album/UpdateAlbumInDbUseCase;", "updateAlbumTracks", "Lcom/kvlg/shared/domain/album/UpdateAlbumTracksUseCase;", "getUpdateAlbumTracks", "()Lcom/kvlg/shared/domain/album/UpdateAlbumTracksUseCase;", "shared_debug"})
public final class AlbumUseCasesProviderImpl implements com.kvlg.shared.domain.album.AlbumUseCasesProvider {
    private final com.kvlg.shared.data.AlbumRepository repository = null;
    private final kotlinx.coroutines.CoroutineDispatcher dispatcher = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.kvlg.shared.domain.album.GetAlbumByIdDbUseCase getGetAlbumByIdDb() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.kvlg.shared.domain.album.GetAlbumByIdSpotifyUseCase getGetAlbumByIdSpotify() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.kvlg.shared.domain.album.GetAlbumsFromDbUseCase getGetAlbumsFromDb() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.kvlg.shared.domain.album.GetAlbumsFromSpotifyUseCase getGetAlbumsFromSpotify() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.kvlg.shared.domain.album.GetAllAlbumsFromDbUseCase getGetAllAlbums() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.kvlg.shared.domain.album.GetNewReleasesUseCase getGetNewReleases() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.kvlg.shared.domain.album.SaveAlbumIntoDbUseCase getSaveAlbumIntoDb() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.kvlg.shared.domain.album.UpdateAlbumInDbUseCase getUpdateAlbumInDb() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.kvlg.shared.domain.album.UpdateAlbumTracksUseCase getUpdateAlbumTracks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.kvlg.shared.domain.album.InsertAlbumUseCase getInsertAlbum() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.kvlg.shared.domain.album.GetFavoriteAlbumsUseCase getGetFavoriteTracks() {
        return null;
    }
    
    public AlbumUseCasesProviderImpl(@org.jetbrains.annotations.NotNull()
    com.kvlg.shared.data.AlbumRepository repository, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        super();
    }
}