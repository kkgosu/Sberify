package com.kvlg.analytics;

import java.lang.System;

/**
 * @author Konstantin Koval
 * @since 13.05.2021
 */
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&\u00a8\u0006\f"}, d2 = {"Lcom/kvlg/analytics/AnalyticsInteractor;", "", "addFavoriteAlbum", "", "addFavoriteTrack", "onFavoriteOpen", "onNewReleasesOpen", "onSearchOpen", "pauseSession", "activity", "Landroid/app/Activity;", "resumeSession", "Analytics_debug"})
public abstract interface AnalyticsInteractor {
    
    public abstract void resumeSession(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity);
    
    public abstract void pauseSession(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity);
    
    public abstract void onNewReleasesOpen();
    
    public abstract void onSearchOpen();
    
    public abstract void onFavoriteOpen();
    
    public abstract void addFavoriteTrack();
    
    public abstract void addFavoriteAlbum();
}