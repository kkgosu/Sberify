package com.kvlg.lyrics;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\r\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fJ\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001f\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/kvlg/lyrics/LyricsViewModel;", "Landroidx/lifecycle/ViewModel;", "geniusApi", "Lcom/kvlg/genius_api/GeniusApi;", "databaseRepository", "Lcom/kvlg/core_db/DatabaseRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/kvlg/genius_api/GeniusApi;Lcom/kvlg/core_db/DatabaseRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "lyrics", "Landroidx/lifecycle/LiveData;", "Lcom/kvlg/core_utils/Result;", "Lcom/kvlg/spotify_common/presentation/TrackModel;", "getLyrics", "()Landroidx/lifecycle/LiveData;", "lyricsTrigger", "Landroidx/lifecycle/MutableLiveData;", "Lcom/kvlg/core_utils/models/RawTrackModel;", "", "track", "updateTrack", "Lyrics_debug"})
public final class LyricsViewModel extends androidx.lifecycle.ViewModel {
    private final androidx.lifecycle.MutableLiveData<com.kvlg.core_utils.models.RawTrackModel> lyricsTrigger = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.kvlg.core_utils.Result<com.kvlg.spotify_common.presentation.TrackModel>> lyrics = null;
    private final com.kvlg.genius_api.GeniusApi geniusApi = null;
    private final com.kvlg.core_db.DatabaseRepository databaseRepository = null;
    private final kotlinx.coroutines.CoroutineDispatcher dispatcher = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.kvlg.core_utils.Result<com.kvlg.spotify_common.presentation.TrackModel>> getLyrics() {
        return null;
    }
    
    public final void getLyrics(@org.jetbrains.annotations.NotNull()
    com.kvlg.spotify_common.presentation.TrackModel track) {
    }
    
    public final void updateTrack(@org.jetbrains.annotations.NotNull()
    com.kvlg.spotify_common.presentation.TrackModel track) {
    }
    
    @androidx.hilt.lifecycle.ViewModelInject()
    public LyricsViewModel(@org.jetbrains.annotations.NotNull()
    com.kvlg.genius_api.GeniusApi geniusApi, @org.jetbrains.annotations.NotNull()
    com.kvlg.core_db.DatabaseRepository databaseRepository, @org.jetbrains.annotations.NotNull()
    @com.kvlg.shared.di.IoDispatcher()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        super();
    }
}