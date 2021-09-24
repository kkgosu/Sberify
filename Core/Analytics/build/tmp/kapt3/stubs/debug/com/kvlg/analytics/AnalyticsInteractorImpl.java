package com.kvlg.analytics;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/kvlg/analytics/AnalyticsInteractorImpl;", "Lcom/kvlg/analytics/AnalyticsInteractor;", "()V", "addFavoriteAlbum", "", "addFavoriteTrack", "onFavoriteOpen", "onNewReleasesOpen", "onSearchOpen", "pauseSession", "activity", "Landroid/app/Activity;", "resumeSession", "Companion", "Analytics_debug"})
public final class AnalyticsInteractorImpl implements com.kvlg.analytics.AnalyticsInteractor {
    @java.lang.Deprecated()
    private static final java.lang.String NEW_RELEASES_OPEN = "New Realeases Open";
    @java.lang.Deprecated()
    private static final java.lang.String SEARCH_OPEN = "Search Open";
    @java.lang.Deprecated()
    private static final java.lang.String FAVORITE_OPEN = "Favorite Open";
    @java.lang.Deprecated()
    private static final java.lang.String ADD_FAVORITE_TRACK = "Favorite Track Add";
    @java.lang.Deprecated()
    private static final java.lang.String ADD_FAVORITE_ALBUM = "Favorite Album Add";
    @org.jetbrains.annotations.NotNull()
    private static final com.kvlg.analytics.AnalyticsInteractorImpl.Companion Companion = null;
    
    @java.lang.Override()
    public void resumeSession(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
    }
    
    @java.lang.Override()
    public void pauseSession(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
    }
    
    @java.lang.Override()
    public void onNewReleasesOpen() {
    }
    
    @java.lang.Override()
    public void onSearchOpen() {
    }
    
    @java.lang.Override()
    public void onFavoriteOpen() {
    }
    
    @java.lang.Override()
    public void addFavoriteTrack() {
    }
    
    @java.lang.Override()
    public void addFavoriteAlbum() {
    }
    
    public AnalyticsInteractorImpl() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/kvlg/analytics/AnalyticsInteractorImpl$Companion;", "", "()V", "ADD_FAVORITE_ALBUM", "", "ADD_FAVORITE_TRACK", "FAVORITE_OPEN", "NEW_RELEASES_OPEN", "SEARCH_OPEN", "Analytics_debug"})
    static final class Companion {
        
        private Companion() {
            super();
        }
    }
}