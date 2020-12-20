package com.kvlg.shared.domain.track;

import java.lang.System;

/**
 * Provide track's use cases
 *
 * @author Konstantin Koval
 * @since 28.10.2020
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/kvlg/shared/domain/track/TrackUseCasesProvider;", "", "getFavoriteTracks", "Lcom/kvlg/shared/domain/track/GetFavoriteTracksUseCase;", "getGetFavoriteTracks", "()Lcom/kvlg/shared/domain/track/GetFavoriteTracksUseCase;", "getTrackFromSpotify", "Lcom/kvlg/shared/domain/track/GetTracksFromSpotifyUseCase;", "getGetTrackFromSpotify", "()Lcom/kvlg/shared/domain/track/GetTracksFromSpotifyUseCase;", "getTracksFromDb", "Lcom/kvlg/shared/domain/track/GetTracksFromDbUseCase;", "getGetTracksFromDb", "()Lcom/kvlg/shared/domain/track/GetTracksFromDbUseCase;", "saveTrackIntoDb", "Lcom/kvlg/shared/domain/track/SaveTrackIntoDbUseCase;", "getSaveTrackIntoDb", "()Lcom/kvlg/shared/domain/track/SaveTrackIntoDbUseCase;", "updateTrackInDb", "Lcom/kvlg/shared/domain/track/UpdateTrackInDbUseCase;", "getUpdateTrackInDb", "()Lcom/kvlg/shared/domain/track/UpdateTrackInDbUseCase;", "shared_debug"})
public abstract interface TrackUseCasesProvider {
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.kvlg.shared.domain.track.GetTracksFromDbUseCase getGetTracksFromDb();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.kvlg.shared.domain.track.GetTracksFromSpotifyUseCase getGetTrackFromSpotify();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.kvlg.shared.domain.track.SaveTrackIntoDbUseCase getSaveTrackIntoDb();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.kvlg.shared.domain.track.UpdateTrackInDbUseCase getUpdateTrackInDb();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.kvlg.shared.domain.track.GetFavoriteTracksUseCase getGetFavoriteTracks();
}