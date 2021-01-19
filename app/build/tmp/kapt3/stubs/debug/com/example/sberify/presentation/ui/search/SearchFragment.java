package com.example.sberify.presentation.ui.search;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u0005\u00a2\u0006\u0002\u0010\u0007J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010 \u001a\u00020!H\u0002J\u0018\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0019H\u0016J\u0018\u0010&\u001a\u00020!2\u0006\u0010#\u001a\u00020\'2\u0006\u0010%\u001a\u00020\u0019H\u0016J\b\u0010(\u001a\u00020!H\u0016J\u0018\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020+2\u0006\u0010#\u001a\u00020,H\u0016J\u0018\u0010-\u001a\u00020!2\u0006\u0010#\u001a\u00020.2\u0006\u0010%\u001a\u00020\u0019H\u0016J\b\u0010/\u001a\u00020!H\u0002J\b\u00100\u001a\u00020!H\u0002J\b\u00101\u001a\u00020!H\u0014J\b\u00102\u001a\u00020!H\u0002J\b\u00103\u001a\u00020!H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00064"}, d2 = {"Lcom/example/sberify/presentation/ui/search/SearchFragment;", "Lcom/example/sberify/base/BaseViewBindingFragment;", "Lcom/example/sberify/databinding/FragmentSearchBinding;", "Lcom/example/sberify/adapters/AlbumInteraction;", "Lcom/example/sberify/adapters/ArtistInteraction;", "Lcom/example/sberify/adapters/TrackInteraction;", "Lcom/example/sberify/adapters/SuggestionInteraction;", "()V", "albumsAdapter", "Lcom/example/sberify/adapters/AlbumsHorizontalAdapter;", "artistsAdapter", "Lcom/example/sberify/adapters/ArtistsAdapter;", "keyword", "", "sharedViewModel", "Lcom/example/sberify/presentation/ui/SharedViewModel;", "getSharedViewModel", "()Lcom/example/sberify/presentation/ui/SharedViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "suggestionsAdapter", "Lcom/example/sberify/adapters/SuggestionAdapter;", "tracksListedAdapter", "Lcom/example/sberify/adapters/TrackListedAdapter;", "getViewBinding", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "hideKeyboard", "", "onAlbumSelected", "item", "Lcom/kvlg/spotify_models/presentation/AlbumModel;", "view", "onArtistSelected", "Lcom/kvlg/spotify_models/presentation/ArtistModel;", "onPause", "onSuggestionSelected", "position", "", "Lcom/kvlg/core_utils/models/Suggestion;", "onTrackSelected", "Lcom/kvlg/spotify_models/presentation/TrackModel;", "setContentVisibility", "setupSearchView", "setupViews", "showFilterBottomSheet", "showKeyboard", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class SearchFragment extends com.example.sberify.base.BaseViewBindingFragment<com.example.sberify.databinding.FragmentSearchBinding> implements com.example.sberify.adapters.AlbumInteraction, com.example.sberify.adapters.ArtistInteraction, com.example.sberify.adapters.TrackInteraction, com.example.sberify.adapters.SuggestionInteraction {
    private final kotlin.Lazy sharedViewModel$delegate = null;
    private final com.example.sberify.adapters.SuggestionAdapter suggestionsAdapter = null;
    private final com.example.sberify.adapters.ArtistsAdapter artistsAdapter = null;
    private final com.example.sberify.adapters.AlbumsHorizontalAdapter albumsAdapter = null;
    private final com.example.sberify.adapters.TrackListedAdapter tracksListedAdapter = null;
    private java.lang.String keyword = "";
    
    private final com.example.sberify.presentation.ui.SharedViewModel getSharedViewModel() {
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
    public void onPause() {
    }
    
    @java.lang.Override()
    public void onAlbumSelected(@org.jetbrains.annotations.NotNull()
    com.kvlg.spotify_models.presentation.AlbumModel item, @org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    @java.lang.Override()
    public void onArtistSelected(@org.jetbrains.annotations.NotNull()
    com.kvlg.spotify_models.presentation.ArtistModel item, @org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    @java.lang.Override()
    public void onTrackSelected(@org.jetbrains.annotations.NotNull()
    com.kvlg.spotify_models.presentation.TrackModel item, @org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    @java.lang.Override()
    public void onSuggestionSelected(int position, @org.jetbrains.annotations.NotNull()
    com.kvlg.core_utils.models.Suggestion item) {
    }
    
    private final void setupSearchView() {
    }
    
    private final void setContentVisibility() {
    }
    
    private final void showFilterBottomSheet() {
    }
    
    private final void showKeyboard() {
    }
    
    private final void hideKeyboard() {
    }
    
    public SearchFragment() {
        super();
    }
}