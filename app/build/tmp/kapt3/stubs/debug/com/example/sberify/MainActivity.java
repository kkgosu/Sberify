package com.example.sberify;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00010B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0011\u0010\u001c\u001a\u00020\u001bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\u0018\u0010\u001e\u001a\n \u0014*\u0004\u0018\u00010\u001f0\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\n \u0014*\u0004\u0018\u00010#0#H\u0002J\u0012\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0014J\u0010\u0010(\u001a\u00020%2\u0006\u0010&\u001a\u00020\'H\u0014J\b\u0010)\u001a\u00020%H\u0014J\b\u0010*\u001a\u00020%H\u0014J\b\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020%H\u0002J\b\u0010.\u001a\u00020%H\u0002J\b\u0010/\u001a\u00020%H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00130\u00130\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00061"}, d2 = {"Lcom/example/sberify/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroidx/lifecycle/LifecycleOwner;", "()V", "binding", "Lcom/example/sberify/databinding/ActivityMainBinding;", "bnvAnimator", "Lcom/example/sberify/BnvAnimator;", "currentNavController", "Landroidx/lifecycle/LiveData;", "Landroidx/navigation/NavController;", "loginViewModel", "Lcom/example/sberify/LoginViewModel;", "getLoginViewModel", "()Lcom/example/sberify/LoginViewModel;", "loginViewModel$delegate", "Lkotlin/Lazy;", "resultTokenHandler", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "sharedViewModel", "Lcom/kvlg/shared/SharedViewModel;", "getSharedViewModel", "()Lcom/kvlg/shared/SharedViewModel;", "sharedViewModel$delegate", "spotifyAppRemote", "Lcom/spotify/android/appremote/api/SpotifyAppRemote;", "connectToAppRemote", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAuthenticationRequest", "Lcom/spotify/sdk/android/auth/AuthorizationRequest;", "type", "Lcom/spotify/sdk/android/auth/AuthorizationResponse$Type;", "getRedirectUri", "Landroid/net/Uri;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onRestoreInstanceState", "onStart", "onStop", "onSupportNavigateUp", "", "requestToken", "setupBottomNavBar", "showSnackbar", "Companion", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity implements androidx.lifecycle.LifecycleOwner {
    private com.example.sberify.databinding.ActivityMainBinding binding;
    private com.example.sberify.BnvAnimator bnvAnimator;
    private final kotlin.Lazy sharedViewModel$delegate = null;
    private final kotlin.Lazy loginViewModel$delegate = null;
    private androidx.lifecycle.LiveData<androidx.navigation.NavController> currentNavController;
    private com.spotify.android.appremote.api.SpotifyAppRemote spotifyAppRemote;
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> resultTokenHandler = null;
    private static final java.lang.String CLIENT_ID = "49e110cda5b64d6d89476f40687725c4";
    private static final java.lang.String REDIRECT_URL = "spotify-sdk://auth";
    @org.jetbrains.annotations.NotNull()
    public static final com.example.sberify.MainActivity.Companion Companion = null;
    
    private final com.kvlg.shared.SharedViewModel getSharedViewModel() {
        return null;
    }
    
    private final com.example.sberify.LoginViewModel getLoginViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    @java.lang.Override()
    protected void onStop() {
    }
    
    @java.lang.Override()
    protected void onRestoreInstanceState(@org.jetbrains.annotations.NotNull()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public boolean onSupportNavigateUp() {
        return false;
    }
    
    private final void setupBottomNavBar() {
    }
    
    private final void showSnackbar() {
    }
    
    private final void requestToken() {
    }
    
    private final com.spotify.sdk.android.auth.AuthorizationRequest getAuthenticationRequest(com.spotify.sdk.android.auth.AuthorizationResponse.Type type) {
        return null;
    }
    
    private final android.net.Uri getRedirectUri() {
        return null;
    }
    
    public MainActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/sberify/MainActivity$Companion;", "", "()V", "CLIENT_ID", "", "REDIRECT_URL", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}