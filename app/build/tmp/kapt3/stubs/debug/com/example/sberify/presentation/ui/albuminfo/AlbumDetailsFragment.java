package com.example.sberify.presentation.ui.albuminfo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014H\u0016J\b\u0010 \u001a\u00020\u001cH\u0014J\b\u0010!\u001a\u00020\u001cH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\""}, d2 = {"Lcom/example/sberify/presentation/ui/albuminfo/AlbumDetailsFragment;", "Lcom/example/sberify/base/BaseViewBindingFragment;", "Lcom/example/sberify/databinding/FragmentAlbumDetailsBinding;", "Lcom/example/sberify/adapters/TrackInteraction;", "()V", "adapter", "Lcom/example/sberify/adapters/TrackListedAdapter;", "navArgs", "Lcom/example/sberify/presentation/ui/albuminfo/AlbumDetailsFragmentArgs;", "getNavArgs", "()Lcom/example/sberify/presentation/ui/albuminfo/AlbumDetailsFragmentArgs;", "navArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "sharedViewModel", "Lcom/example/sberify/presentation/ui/SharedViewModel;", "getSharedViewModel", "()Lcom/example/sberify/presentation/ui/SharedViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "getViewBinding", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onTrackSelected", "", "item", "Lcom/example/sberify/models/newdomain/TrackDomainModel;", "view", "setupViews", "subscribeToObservers", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class AlbumDetailsFragment extends com.example.sberify.base.BaseViewBindingFragment<com.example.sberify.databinding.FragmentAlbumDetailsBinding> implements com.example.sberify.adapters.TrackInteraction {
    private final kotlin.Lazy sharedViewModel$delegate = null;
    private final androidx.navigation.NavArgsLazy navArgs$delegate = null;
    private com.example.sberify.adapters.TrackListedAdapter adapter;
    
    private final com.example.sberify.presentation.ui.SharedViewModel getSharedViewModel() {
        return null;
    }
    
    private final com.example.sberify.presentation.ui.albuminfo.AlbumDetailsFragmentArgs getNavArgs() {
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
    public void onTrackSelected(@org.jetbrains.annotations.NotNull()
    com.example.sberify.models.newdomain.TrackDomainModel item, @org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    private final void subscribeToObservers() {
    }
    
    public AlbumDetailsFragment() {
        super();
    }
}