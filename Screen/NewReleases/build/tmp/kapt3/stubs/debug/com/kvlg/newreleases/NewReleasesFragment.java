package com.kvlg.newreleases;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014H\u0016J\b\u0010 \u001a\u00020\u001cH\u0014J\b\u0010!\u001a\u00020\u001cH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\""}, d2 = {"Lcom/kvlg/newreleases/NewReleasesFragment;", "Lcom/kvlg/design/BaseViewBindingFragment;", "Lcom/kvlg/newreleases/databinding/FragmentNewReleasesBinding;", "Lcom/kvlg/spotify_common/adapters/AlbumInteraction;", "()V", "adapter", "Lcom/kvlg/spotify_common/adapters/AlbumsAdapter;", "navigation", "Lcom/kvlg/newreleases/NewReleasesNavigation;", "getNavigation", "()Lcom/kvlg/newreleases/NewReleasesNavigation;", "setNavigation", "(Lcom/kvlg/newreleases/NewReleasesNavigation;)V", "sharedViewModel", "Lcom/kvlg/shared/SharedViewModel;", "getSharedViewModel", "()Lcom/kvlg/shared/SharedViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "getViewBinding", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onAlbumSelected", "", "item", "Lcom/kvlg/spotify_common/presentation/AlbumModel;", "view", "setupViews", "subscribeToObservers", "NewReleases_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class NewReleasesFragment extends com.kvlg.design.BaseViewBindingFragment<com.kvlg.newreleases.databinding.FragmentNewReleasesBinding> implements com.kvlg.spotify_common.adapters.AlbumInteraction {
    @javax.inject.Inject()
    public com.kvlg.newreleases.NewReleasesNavigation navigation;
    private final kotlin.Lazy sharedViewModel$delegate = null;
    private com.kvlg.spotify_common.adapters.AlbumsAdapter adapter;
    
    @org.jetbrains.annotations.NotNull()
    public final com.kvlg.newreleases.NewReleasesNavigation getNavigation() {
        return null;
    }
    
    public final void setNavigation(@org.jetbrains.annotations.NotNull()
    com.kvlg.newreleases.NewReleasesNavigation p0) {
    }
    
    private final com.kvlg.shared.SharedViewModel getSharedViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected android.view.View getViewBinding(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    protected void setupViews() {
    }
    
    @java.lang.Override()
    public void onAlbumSelected(@org.jetbrains.annotations.NotNull()
    com.kvlg.spotify_common.presentation.AlbumModel item, @org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    private final void subscribeToObservers() {
    }
    
    public NewReleasesFragment() {
        super();
    }
}