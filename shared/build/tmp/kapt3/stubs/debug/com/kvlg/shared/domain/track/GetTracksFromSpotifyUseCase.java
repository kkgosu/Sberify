package com.kvlg.shared.domain.track;

import java.lang.System;

/**
 * Search tracks in spotify
 *
 * @author Konstantin Koval
 * @since 27.10.2020
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ!\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0094@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/kvlg/shared/domain/track/GetTracksFromSpotifyUseCase;", "Lcom/kvlg/shared/domain/UseCase;", "", "", "Lcom/kvlg/model/presentation/Track;", "repository", "Lcom/kvlg/shared/data/TrackRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/kvlg/shared/data/TrackRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "execute", "parameters", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shared_debug"})
public final class GetTracksFromSpotifyUseCase extends com.kvlg.shared.domain.UseCase<java.lang.String, java.util.List<? extends com.kvlg.model.presentation.Track>> {
    private final com.kvlg.shared.data.TrackRepository repository = null;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    protected java.lang.Object execute(@org.jetbrains.annotations.NotNull()
    java.lang.String parameters, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.kvlg.model.presentation.Track>> p1) {
        return null;
    }
    
    public GetTracksFromSpotifyUseCase(@org.jetbrains.annotations.NotNull()
    com.kvlg.shared.data.TrackRepository repository, @org.jetbrains.annotations.NotNull()
    @com.kvlg.shared.di.IoDispatcher()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        super(null);
    }
}