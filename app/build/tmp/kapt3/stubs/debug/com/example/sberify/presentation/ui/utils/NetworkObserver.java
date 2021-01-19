package com.example.sberify.presentation.ui.utils;

import java.lang.System;

/**
 * Network state observer
 *
 * @author Konstantin Koval
 * @since 13.07.2020
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0003J\b\u0010\r\u001a\u00020\fH\u0015J\b\u0010\u000e\u001a\u00020\fH\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/sberify/presentation/ui/utils/NetworkObserver;", "Landroidx/lifecycle/LiveData;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "connectivityManager", "Landroid/net/ConnectivityManager;", "networkCallback", "Landroid/net/ConnectivityManager$NetworkCallback;", "connectivityManagerCallback", "lollipopNetworkRequest", "", "onActive", "onInactive", "Companion", "app_debug"})
public final class NetworkObserver extends androidx.lifecycle.LiveData<java.lang.Boolean> {
    private android.net.ConnectivityManager connectivityManager;
    private android.net.ConnectivityManager.NetworkCallback networkCallback;
    private static final int CURRENT_VERSION = 0;
    private static final int LOLLIPOP = android.os.Build.VERSION_CODES.LOLLIPOP;
    private static final int NOUGAT = android.os.Build.VERSION_CODES.N;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.sberify.presentation.ui.utils.NetworkObserver.Companion Companion = null;
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    @java.lang.Override()
    protected void onActive() {
    }
    
    @java.lang.Override()
    protected void onInactive() {
    }
    
    @androidx.annotation.RequiresPermission(value = "android.permission.ACCESS_NETWORK_STATE")
    @android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.LOLLIPOP)
    private final void lollipopNetworkRequest() {
    }
    
    private final android.net.ConnectivityManager.NetworkCallback connectivityManagerCallback() {
        return null;
    }
    
    public NetworkObserver(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/example/sberify/presentation/ui/utils/NetworkObserver$Companion;", "", "()V", "CURRENT_VERSION", "", "LOLLIPOP", "NOUGAT", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}