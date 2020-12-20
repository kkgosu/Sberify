package com.kvlg.shared.domain.lyrics;

import java.lang.System;

/**
 * @author Konstantin Koval
 * @since 31.10.2020
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/kvlg/shared/domain/lyrics/LyricsUseCasesProvider;", "", "getLyrics", "Lcom/kvlg/shared/domain/lyrics/GetLyricsUseCase;", "getGetLyrics", "()Lcom/kvlg/shared/domain/lyrics/GetLyricsUseCase;", "parseLyrics", "Lcom/kvlg/shared/domain/lyrics/ParseLyricsFromGeniusUseCase;", "getParseLyrics", "()Lcom/kvlg/shared/domain/lyrics/ParseLyricsFromGeniusUseCase;", "shared_debug"})
public abstract interface LyricsUseCasesProvider {
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.kvlg.shared.domain.lyrics.GetLyricsUseCase getGetLyrics();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.kvlg.shared.domain.lyrics.ParseLyricsFromGeniusUseCase getParseLyrics();
}