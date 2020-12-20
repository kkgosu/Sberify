package com.example.sberify.presentation.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00016B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0013H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ\u0018\u0010\u001c\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\n \u001e*\u0004\u0018\u00010\"0\"H\u0002J\"\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\u0012\u0010*\u001a\u00020$2\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\b\u0010-\u001a\u00020$H\u0002J\u0010\u0010.\u001a\u00020$2\u0006\u0010+\u001a\u00020,H\u0014J\b\u0010/\u001a\u00020$H\u0014J\b\u00100\u001a\u00020$H\u0014J\b\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u00020$H\u0002J\b\u00104\u001a\u00020$H\u0002J\b\u00105\u001a\u00020$H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00067"}, d2 = {"Lcom/example/sberify/presentation/ui/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroidx/lifecycle/LifecycleOwner;", "()V", "accessCode", "", "accessToken", "binding", "Lcom/example/sberify/databinding/ActivityMainBinding;", "currentNavController", "Landroidx/lifecycle/LiveData;", "Landroidx/navigation/NavController;", "sharedViewModel", "Lcom/example/sberify/presentation/ui/SharedViewModel;", "getSharedViewModel", "()Lcom/example/sberify/presentation/ui/SharedViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "spotifyAppRemote", "Lcom/spotify/android/appremote/api/SpotifyAppRemote;", "tokenData", "Lcom/example/sberify/domain/TokenData;", "getTokenData", "()Lcom/example/sberify/domain/TokenData;", "setTokenData", "(Lcom/example/sberify/domain/TokenData;)V", "connectToAppRemote", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAuthenticationRequest", "Lcom/spotify/sdk/android/auth/AuthorizationRequest;", "kotlin.jvm.PlatformType", "type", "Lcom/spotify/sdk/android/auth/AuthorizationResponse$Type;", "getRedirectUri", "Landroid/net/Uri;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestCodeClicked", "onRestoreInstanceState", "onStart", "onStop", "onSupportNavigateUp", "", "requestToken", "setupBottomNavBar", "showSnackbar", "Companion", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity implements androidx.lifecycle.LifecycleOwner {
    @javax.inject.Inject()
    public com.example.sberify.domain.TokenData tokenData;
    private final kotlin.Lazy sharedViewModel$delegate = null;
    private androidx.lifecycle.LiveData<androidx.navigation.NavController> currentNavController;
    private com.example.sberify.databinding.ActivityMainBinding binding;
    private java.lang.String accessToken;
    private java.lang.String accessCode;
    private com.spotify.android.appremote.api.SpotifyAppRemote spotifyAppRemote;
    private static final java.lang.String CLIENT_ID = "49e110cda5b64d6d89476f40687725c4";
    private static final java.lang.String REDIRECT_URL = "spotify-sdk://auth";
    private static final int AUTH_TOKEN_REQUEST_CODE = 16;
    private static final int AUTH_CODE_REQUEST_CODE = 17;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.sberify.presentation.ui.MainActivity.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.sberify.domain.TokenData getTokenData() {
        return null;
    }
    
    public final void setTokenData(@org.jetbrains.annotations.NotNull()
    com.example.sberify.domain.TokenData p0) {
    }
    
    private final com.example.sberify.presentation.ui.SharedViewModel getSharedViewModel() {
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
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @java.lang.Override()
    public boolean onSupportNavigateUp() {
        return false;
    }
    
    private final void onRequestCodeClicked() {
    }
    
    private final void requestToken() {
    }
    
    private final com.spotify.sdk.android.auth.AuthorizationRequest getAuthenticationRequest(com.spotify.sdk.android.auth.AuthorizationResponse.Type type) {
        return null;
    }
    
    private final android.net.Uri getRedirectUri() {
        return null;
    }
    
    private final void setupBottomNavBar() {
    }
    
    private final void showSnackbar() {
    }
    
    public MainActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/sberify/presentation/ui/MainActivity$Companion;", "", "()V", "AUTH_CODE_REQUEST_CODE", "", "AUTH_TOKEN_REQUEST_CODE", "CLIENT_ID", "", "REDIRECT_URL", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}