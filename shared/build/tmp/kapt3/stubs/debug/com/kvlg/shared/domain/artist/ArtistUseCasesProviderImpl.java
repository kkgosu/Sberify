package com.kvlg.shared.domain.artist;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/kvlg/shared/domain/artist/ArtistUseCasesProviderImpl;", "Lcom/kvlg/shared/domain/artist/ArtistUseCasesProvider;", "artistRepository", "Lcom/kvlg/shared/data/ArtistRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/kvlg/shared/data/ArtistRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getArtistFromDb", "Lcom/kvlg/shared/domain/artist/GetArtistFromDbUseCase;", "getGetArtistFromDb", "()Lcom/kvlg/shared/domain/artist/GetArtistFromDbUseCase;", "getArtistFromSpotify", "Lcom/kvlg/shared/domain/artist/GetArtistFromSpotifyUseCase;", "getGetArtistFromSpotify", "()Lcom/kvlg/shared/domain/artist/GetArtistFromSpotifyUseCase;", "saveArtistIntoDb", "Lcom/kvlg/shared/domain/artist/SaveArtistIntoDbUseCase;", "getSaveArtistIntoDb", "()Lcom/kvlg/shared/domain/artist/SaveArtistIntoDbUseCase;", "shared_debug"})
public final class ArtistUseCasesProviderImpl implements com.kvlg.shared.domain.artist.ArtistUseCasesProvider {
    private final com.kvlg.shared.data.ArtistRepository artistRepository = null;
    private final kotlinx.coroutines.CoroutineDispatcher dispatcher = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.kvlg.shared.domain.artist.GetArtistFromDbUseCase getGetArtistFromDb() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.kvlg.shared.domain.artist.GetArtistFromSpotifyUseCase getGetArtistFromSpotify() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.kvlg.shared.domain.artist.SaveArtistIntoDbUseCase getSaveArtistIntoDb() {
        return null;
    }
    
    public ArtistUseCasesProviderImpl(@org.jetbrains.annotations.NotNull()
    com.kvlg.shared.data.ArtistRepository artistRepository, @org.jetbrains.annotations.NotNull()
    @com.kvlg.shared.di.IoDispatcher()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        super();
    }
}