package com.kvlg.shared.domain.album;

import java.lang.System;

/**
 * @author Konstantin Koval
 * @since 29.10.2020
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0017X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\u001bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0012\u0010\u001e\u001a\u00020\u001fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010!R\u0012\u0010\"\u001a\u00020#X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010%R\u0012\u0010&\u001a\u00020\'X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010)R\u0012\u0010*\u001a\u00020+X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u0010-\u00a8\u0006."}, d2 = {"Lcom/kvlg/shared/domain/album/AlbumUseCasesProvider;", "", "getAlbumByIdDb", "Lcom/kvlg/shared/domain/album/GetAlbumByIdDbUseCase;", "getGetAlbumByIdDb", "()Lcom/kvlg/shared/domain/album/GetAlbumByIdDbUseCase;", "getAlbumByIdSpotify", "Lcom/kvlg/shared/domain/album/GetAlbumByIdSpotifyUseCase;", "getGetAlbumByIdSpotify", "()Lcom/kvlg/shared/domain/album/GetAlbumByIdSpotifyUseCase;", "getAlbumsFromDb", "Lcom/kvlg/shared/domain/album/GetAlbumsFromDbUseCase;", "getGetAlbumsFromDb", "()Lcom/kvlg/shared/domain/album/GetAlbumsFromDbUseCase;", "getAlbumsFromSpotify", "Lcom/kvlg/shared/domain/album/GetAlbumsFromSpotifyUseCase;", "getGetAlbumsFromSpotify", "()Lcom/kvlg/shared/domain/album/GetAlbumsFromSpotifyUseCase;", "getAllAlbums", "Lcom/kvlg/shared/domain/album/GetAllAlbumsFromDbUseCase;", "getGetAllAlbums", "()Lcom/kvlg/shared/domain/album/GetAllAlbumsFromDbUseCase;", "getFavoriteTracks", "Lcom/kvlg/shared/domain/album/GetFavoriteAlbumsUseCase;", "getGetFavoriteTracks", "()Lcom/kvlg/shared/domain/album/GetFavoriteAlbumsUseCase;", "getNewReleases", "Lcom/kvlg/shared/domain/album/GetNewReleasesUseCase;", "getGetNewReleases", "()Lcom/kvlg/shared/domain/album/GetNewReleasesUseCase;", "insertAlbum", "Lcom/kvlg/shared/domain/album/InsertAlbumUseCase;", "getInsertAlbum", "()Lcom/kvlg/shared/domain/album/InsertAlbumUseCase;", "saveAlbumIntoDb", "Lcom/kvlg/shared/domain/album/SaveAlbumIntoDbUseCase;", "getSaveAlbumIntoDb", "()Lcom/kvlg/shared/domain/album/SaveAlbumIntoDbUseCase;", "updateAlbumInDb", "Lcom/kvlg/shared/domain/album/UpdateAlbumInDbUseCase;", "getUpdateAlbumInDb", "()Lcom/kvlg/shared/domain/album/UpdateAlbumInDbUseCase;", "updateAlbumTracks", "Lcom/kvlg/shared/domain/album/UpdateAlbumTracksUseCase;", "getUpdateAlbumTracks", "()Lcom/kvlg/shared/domain/album/UpdateAlbumTracksUseCase;", "shared_debug"})
public abstract interface AlbumUseCasesProvider {
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.kvlg.shared.domain.album.GetAlbumByIdDbUseCase getGetAlbumByIdDb();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.kvlg.shared.domain.album.GetAlbumByIdSpotifyUseCase getGetAlbumByIdSpotify();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.kvlg.shared.domain.album.GetAlbumsFromDbUseCase getGetAlbumsFromDb();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.kvlg.shared.domain.album.GetAlbumsFromSpotifyUseCase getGetAlbumsFromSpotify();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.kvlg.shared.domain.album.GetAllAlbumsFromDbUseCase getGetAllAlbums();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.kvlg.shared.domain.album.GetNewReleasesUseCase getGetNewReleases();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.kvlg.shared.domain.album.SaveAlbumIntoDbUseCase getSaveAlbumIntoDb();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.kvlg.shared.domain.album.UpdateAlbumInDbUseCase getUpdateAlbumInDb();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.kvlg.shared.domain.album.UpdateAlbumTracksUseCase getUpdateAlbumTracks();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.kvlg.shared.domain.album.InsertAlbumUseCase getInsertAlbum();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.kvlg.shared.domain.album.GetFavoriteAlbumsUseCase getGetFavoriteTracks();
}