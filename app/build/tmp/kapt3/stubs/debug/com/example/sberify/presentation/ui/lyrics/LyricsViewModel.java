package com.example.sberify.presentation.ui.lyrics;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/sberify/presentation/ui/lyrics/LyricsViewModel;", "Landroidx/lifecycle/ViewModel;", "databaseRepository", "Lcom/kvlg/core_db/DatabaseRepository;", "(Lcom/kvlg/core_db/DatabaseRepository;)V", "updateTrack", "", "track", "Lcom/kvlg/spotify_models/presentation/TrackModel;", "app_debug"})
public final class LyricsViewModel extends androidx.lifecycle.ViewModel {
    private final com.kvlg.core_db.DatabaseRepository databaseRepository = null;
    
    public final void updateTrack(@org.jetbrains.annotations.NotNull()
    com.kvlg.spotify_models.presentation.TrackModel track) {
    }
    
    @androidx.hilt.lifecycle.ViewModelInject()
    public LyricsViewModel(@org.jetbrains.annotations.NotNull()
    com.kvlg.core_db.DatabaseRepository databaseRepository) {
        super();
    }
}