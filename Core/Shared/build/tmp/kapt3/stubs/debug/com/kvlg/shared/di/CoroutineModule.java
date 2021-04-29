package com.kvlg.shared.di;

import java.lang.System;

/**
 * @author Konstantin Koval
 * @since 07.03.2021
 */
@dagger.hilt.InstallIn(value = {dagger.hilt.android.components.ActivityRetainedComponent.class})
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/kvlg/shared/di/CoroutineModule;", "", "()V", "providesDefaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "providesIoDispatcher", "providesMainDispatcher", "providesMainImmediateDispatcher", "Shared_debug"})
@dagger.Module()
public final class CoroutineModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.kvlg.shared.di.CoroutineModule INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    @DefaultDispatcher()
    @dagger.Provides()
    public final kotlinx.coroutines.CoroutineDispatcher providesDefaultDispatcher() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @IoDispatcher()
    @dagger.Provides()
    public final kotlinx.coroutines.CoroutineDispatcher providesIoDispatcher() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @MainDispatcher()
    @dagger.Provides()
    public final kotlinx.coroutines.CoroutineDispatcher providesMainDispatcher() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @MainImmediateDispatcher()
    @dagger.Provides()
    public final kotlinx.coroutines.CoroutineDispatcher providesMainImmediateDispatcher() {
        return null;
    }
    
    private CoroutineModule() {
        super();
    }
}