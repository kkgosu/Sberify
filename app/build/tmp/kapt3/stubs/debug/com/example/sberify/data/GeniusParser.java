package com.example.sberify.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00072\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0004\u00a8\u0006\u0017"}, d2 = {"Lcom/example/sberify/data/GeniusParser;", "", "()V", "cleanPreserveLineBreaks", "", "bodyHtml", "error", "Lcom/example/sberify/data/Result;", "T", "message", "filterLyrics", "doc", "Lorg/jsoup/nodes/Document;", "getResult", "call", "Lkotlin/Function0;", "Lorg/jsoup/Connection$Response;", "makeRequest", "trackUrl", "parseLyrics", "Lcom/example/sberify/models/newdomain/TrackDomainModel;", "track", "path", "app_debug"})
public final class GeniusParser {
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.sberify.data.Result<com.example.sberify.models.newdomain.TrackDomainModel> parseLyrics(@org.jetbrains.annotations.NotNull()
    com.example.sberify.models.newdomain.TrackDomainModel track, @org.jetbrains.annotations.NotNull()
    java.lang.String path) {
        return null;
    }
    
    private final com.example.sberify.data.Result<org.jsoup.nodes.Document> makeRequest(java.lang.String trackUrl) {
        return null;
    }
    
    private final java.lang.String filterLyrics(org.jsoup.nodes.Document doc) {
        return null;
    }
    
    private final java.lang.String cleanPreserveLineBreaks(java.lang.String bodyHtml) {
        return null;
    }
    
    private final com.example.sberify.data.Result<org.jsoup.nodes.Document> getResult(kotlin.jvm.functions.Function0<? extends org.jsoup.Connection.Response> call) {
        return null;
    }
    
    private final <T extends java.lang.Object>com.example.sberify.data.Result<T> error(java.lang.String message) {
        return null;
    }
    
    public GeniusParser() {
        super();
    }
}