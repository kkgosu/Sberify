package com.kvlg.shared.domain.lyrics;

import java.lang.System;

/**
 * @author Konstantin Koval
 * @since 25.10.2020
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0019\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0094@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/kvlg/shared/domain/lyrics/ParseLyricsFromGeniusUseCase;", "Lcom/kvlg/shared/domain/UseCase;", "Lcom/kvlg/model/presentation/Track;", "lyricsRepository", "Lcom/kvlg/shared/data/LyricsRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/kvlg/shared/data/LyricsRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "execute", "parameters", "(Lcom/kvlg/model/presentation/Track;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shared_debug"})
public final class ParseLyricsFromGeniusUseCase extends com.kvlg.shared.domain.UseCase<com.kvlg.model.presentation.Track, com.kvlg.model.presentation.Track> {
    private final com.kvlg.shared.data.LyricsRepository lyricsRepository = null;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    protected java.lang.Object execute(@org.jetbrains.annotations.NotNull()
    com.kvlg.model.presentation.Track parameters, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.kvlg.model.presentation.Track> p1) {
        return null;
    }
    
    public ParseLyricsFromGeniusUseCase(@org.jetbrains.annotations.NotNull()
    com.kvlg.shared.data.LyricsRepository lyricsRepository, @org.jetbrains.annotations.NotNull()
    @com.kvlg.shared.di.IoDispatcher()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        super(null);
    }
}