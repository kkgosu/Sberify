package com.kvlg.analytics.di;

import java.lang.System;

/**
 * @author Konstantin Koval
 * @since 13.05.2021
 */
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2 = {"Lcom/kvlg/analytics/di/AnalyticsModule;", "", "()V", "provideAnalyticsInteractor", "Lcom/kvlg/analytics/AnalyticsInteractor;", "Analytics_debug"})
@dagger.Module()
public final class AnalyticsModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.kvlg.analytics.di.AnalyticsModule INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kvlg.analytics.AnalyticsInteractor provideAnalyticsInteractor() {
        return null;
    }
    
    private AnalyticsModule() {
        super();
    }
}