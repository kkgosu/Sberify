package com.kvlg.shared.data;

import java.lang.System;

/**
 * @author Konstantin Koval
 * @since 29.10.2020
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0019\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007"}, d2 = {"Lcom/kvlg/shared/data/LyricsRepository;", "", "getLyricsFromDb", "Lcom/kvlg/model/presentation/Track;", "track", "parseLyricsFromGenius", "(Lcom/kvlg/model/presentation/Track;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shared_debug"})
public abstract interface LyricsRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract com.kvlg.model.presentation.Track getLyricsFromDb(@org.jetbrains.annotations.NotNull()
    com.kvlg.model.presentation.Track track);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object parseLyricsFromGenius(@org.jetbrains.annotations.NotNull()
    com.kvlg.model.presentation.Track track, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.kvlg.model.presentation.Track> p1);
}