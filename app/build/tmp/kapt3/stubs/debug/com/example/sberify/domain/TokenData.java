package com.example.sberify.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0006J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/example/sberify/domain/TokenData;", "", "prefs", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "getGeniusToken", "", "getSpotifyToken", "setGeniusCode", "", "code", "setGeniusToken", "token", "setSpotifyCode", "setSpotifyToken", "setString", "pref", "str", "Companion", "app_debug"})
public final class TokenData {
    private final android.content.SharedPreferences prefs = null;
    private static final java.lang.String SPOTIFY_OAUTHTOKEN = "SPOTIFY_OAUTHTOKEN";
    private static final java.lang.String SPOTIFY_CODE = "SPOTIFY_CODE";
    private static final java.lang.String GENIUS_OAUTHTOKEN = "GENIUS_OAUTHTOKEN";
    private static final java.lang.String GENIUS_CODE = "GENIUS_CODE";
    @org.jetbrains.annotations.NotNull()
    public static final com.example.sberify.domain.TokenData.Companion Companion = null;
    
    public final void setSpotifyToken(@org.jetbrains.annotations.NotNull()
    java.lang.String token) {
    }
    
    public final void setGeniusToken(@org.jetbrains.annotations.NotNull()
    java.lang.String token) {
    }
    
    public final void setSpotifyCode(@org.jetbrains.annotations.NotNull()
    java.lang.String code) {
    }
    
    public final void setGeniusCode(@org.jetbrains.annotations.NotNull()
    java.lang.String code) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSpotifyToken() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getGeniusToken() {
        return null;
    }
    
    private final void setString(java.lang.String pref, java.lang.String str) {
    }
    
    public TokenData(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences prefs) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/example/sberify/domain/TokenData$Companion;", "", "()V", "GENIUS_CODE", "", "GENIUS_OAUTHTOKEN", "SPOTIFY_CODE", "SPOTIFY_OAUTHTOKEN", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}