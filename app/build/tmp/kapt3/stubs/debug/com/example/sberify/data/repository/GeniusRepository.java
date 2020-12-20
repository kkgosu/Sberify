package com.example.sberify.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002J%\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lcom/example/sberify/data/repository/GeniusRepository;", "Lcom/example/sberify/domain/IGeniusRepository;", "geniusParser", "Lcom/example/sberify/data/GeniusParser;", "database", "Lcom/example/sberify/data/db/AppDatabase;", "geniusApi", "Lcom/example/sberify/data/api/IGeniusApi;", "(Lcom/example/sberify/data/GeniusParser;Lcom/example/sberify/data/db/AppDatabase;Lcom/example/sberify/data/api/IGeniusApi;)V", "filterQuery", "", "query", "filterTrackName", "name", "getLyrics", "Landroidx/lifecycle/LiveData;", "Lcom/example/sberify/data/Result;", "Lcom/example/sberify/models/newdomain/TrackDomainModel;", "track", "(Lcom/example/sberify/models/newdomain/TrackDomainModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public final class GeniusRepository implements com.example.sberify.domain.IGeniusRepository {
    private final com.example.sberify.data.GeniusParser geniusParser = null;
    private final com.example.sberify.data.db.AppDatabase database = null;
    private final com.example.sberify.data.api.IGeniusApi geniusApi = null;
    private static final kotlin.text.Regex notAllowedChars = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.sberify.data.repository.GeniusRepository.Companion Companion = null;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getLyrics(@org.jetbrains.annotations.NotNull()
    com.example.sberify.models.newdomain.TrackDomainModel track, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super androidx.lifecycle.LiveData<com.example.sberify.data.Result<com.example.sberify.models.newdomain.TrackDomainModel>>> p1) {
        return null;
    }
    
    private final java.lang.String filterTrackName(java.lang.String name) {
        return null;
    }
    
    private final java.lang.String filterQuery(java.lang.String query) {
        return null;
    }
    
    @javax.inject.Inject()
    public GeniusRepository(@org.jetbrains.annotations.NotNull()
    com.example.sberify.data.GeniusParser geniusParser, @org.jetbrains.annotations.NotNull()
    com.example.sberify.data.db.AppDatabase database, @org.jetbrains.annotations.NotNull()
    com.example.sberify.data.api.IGeniusApi geniusApi) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/sberify/data/repository/GeniusRepository$Companion;", "", "()V", "notAllowedChars", "Lkotlin/text/Regex;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}