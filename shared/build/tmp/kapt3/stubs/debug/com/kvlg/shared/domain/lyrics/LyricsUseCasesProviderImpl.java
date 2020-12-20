package com.kvlg.shared.domain.lyrics;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/kvlg/shared/domain/lyrics/LyricsUseCasesProviderImpl;", "Lcom/kvlg/shared/domain/lyrics/LyricsUseCasesProvider;", "repository", "Lcom/kvlg/shared/data/LyricsRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/kvlg/shared/data/LyricsRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getLyrics", "Lcom/kvlg/shared/domain/lyrics/GetLyricsUseCase;", "getGetLyrics", "()Lcom/kvlg/shared/domain/lyrics/GetLyricsUseCase;", "parseLyrics", "Lcom/kvlg/shared/domain/lyrics/ParseLyricsFromGeniusUseCase;", "getParseLyrics", "()Lcom/kvlg/shared/domain/lyrics/ParseLyricsFromGeniusUseCase;", "shared_debug"})
public final class LyricsUseCasesProviderImpl implements com.kvlg.shared.domain.lyrics.LyricsUseCasesProvider {
    private final com.kvlg.shared.data.LyricsRepository repository = null;
    private final kotlinx.coroutines.CoroutineDispatcher dispatcher = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.kvlg.shared.domain.lyrics.GetLyricsUseCase getGetLyrics() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.kvlg.shared.domain.lyrics.ParseLyricsFromGeniusUseCase getParseLyrics() {
        return null;
    }
    
    public LyricsUseCasesProviderImpl(@org.jetbrains.annotations.NotNull()
    com.kvlg.shared.data.LyricsRepository repository, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        super();
    }
}