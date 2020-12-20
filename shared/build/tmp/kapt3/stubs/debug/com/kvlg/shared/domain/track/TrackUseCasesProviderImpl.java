package com.kvlg.shared.domain.track;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001b"}, d2 = {"Lcom/kvlg/shared/domain/track/TrackUseCasesProviderImpl;", "Lcom/kvlg/shared/domain/track/TrackUseCasesProvider;", "trackRepo", "Lcom/kvlg/shared/data/TrackRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/kvlg/shared/data/TrackRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getFavoriteTracks", "Lcom/kvlg/shared/domain/track/GetFavoriteTracksUseCase;", "getGetFavoriteTracks", "()Lcom/kvlg/shared/domain/track/GetFavoriteTracksUseCase;", "getTrackFromSpotify", "Lcom/kvlg/shared/domain/track/GetTracksFromSpotifyUseCase;", "getGetTrackFromSpotify", "()Lcom/kvlg/shared/domain/track/GetTracksFromSpotifyUseCase;", "getTracksFromDb", "Lcom/kvlg/shared/domain/track/GetTracksFromDbUseCase;", "getGetTracksFromDb", "()Lcom/kvlg/shared/domain/track/GetTracksFromDbUseCase;", "saveTrackIntoDb", "Lcom/kvlg/shared/domain/track/SaveTrackIntoDbUseCase;", "getSaveTrackIntoDb", "()Lcom/kvlg/shared/domain/track/SaveTrackIntoDbUseCase;", "updateTrackInDb", "Lcom/kvlg/shared/domain/track/UpdateTrackInDbUseCase;", "getUpdateTrackInDb", "()Lcom/kvlg/shared/domain/track/UpdateTrackInDbUseCase;", "shared_debug"})
public final class TrackUseCasesProviderImpl implements com.kvlg.shared.domain.track.TrackUseCasesProvider {
    private final com.kvlg.shared.data.TrackRepository trackRepo = null;
    private final kotlinx.coroutines.CoroutineDispatcher dispatcher = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.kvlg.shared.domain.track.GetTracksFromDbUseCase getGetTracksFromDb() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.kvlg.shared.domain.track.GetTracksFromSpotifyUseCase getGetTrackFromSpotify() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.kvlg.shared.domain.track.SaveTrackIntoDbUseCase getSaveTrackIntoDb() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.kvlg.shared.domain.track.UpdateTrackInDbUseCase getUpdateTrackInDb() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.kvlg.shared.domain.track.GetFavoriteTracksUseCase getGetFavoriteTracks() {
        return null;
    }
    
    public TrackUseCasesProviderImpl(@org.jetbrains.annotations.NotNull()
    com.kvlg.shared.data.TrackRepository trackRepo, @org.jetbrains.annotations.NotNull()
    @com.kvlg.shared.di.IoDispatcher()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        super();
    }
}