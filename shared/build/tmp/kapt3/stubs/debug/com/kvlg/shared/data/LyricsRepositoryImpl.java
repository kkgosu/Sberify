package com.kvlg.shared.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0019\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/kvlg/shared/data/LyricsRepositoryImpl;", "Lcom/kvlg/shared/data/LyricsRepository;", "database", "Lcom/kvlg/shared/data/db/AppDatabase;", "geniusApi", "Lcom/kvlg/network/genius/GeniusApi;", "geniusParser", "Lcom/kvlg/network/genius/GeniusParser;", "(Lcom/kvlg/shared/data/db/AppDatabase;Lcom/kvlg/network/genius/GeniusApi;Lcom/kvlg/network/genius/GeniusParser;)V", "filterQuery", "", "query", "filterTrackName", "name", "getLyricsFromDb", "Lcom/kvlg/model/presentation/Track;", "track", "parseLyricsFromGenius", "(Lcom/kvlg/model/presentation/Track;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "shared_debug"})
public final class LyricsRepositoryImpl implements com.kvlg.shared.data.LyricsRepository {
    private final com.kvlg.shared.data.db.AppDatabase database = null;
    private final com.kvlg.network.genius.GeniusApi geniusApi = null;
    private final com.kvlg.network.genius.GeniusParser geniusParser = null;
    private static final kotlin.text.Regex notAllowedChars = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.kvlg.shared.data.LyricsRepositoryImpl.Companion Companion = null;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public com.kvlg.model.presentation.Track getLyricsFromDb(@org.jetbrains.annotations.NotNull()
    com.kvlg.model.presentation.Track track) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object parseLyricsFromGenius(@org.jetbrains.annotations.NotNull()
    com.kvlg.model.presentation.Track track, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.kvlg.model.presentation.Track> p1) {
        return null;
    }
    
    private final java.lang.String filterTrackName(java.lang.String name) {
        return null;
    }
    
    private final java.lang.String filterQuery(java.lang.String query) {
        return null;
    }
    
    public LyricsRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.kvlg.shared.data.db.AppDatabase database, @org.jetbrains.annotations.NotNull()
    com.kvlg.network.genius.GeniusApi geniusApi, @org.jetbrains.annotations.NotNull()
    com.kvlg.network.genius.GeniusParser geniusParser) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/kvlg/shared/data/LyricsRepositoryImpl$Companion;", "", "()V", "notAllowedChars", "Lkotlin/text/Regex;", "shared_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}