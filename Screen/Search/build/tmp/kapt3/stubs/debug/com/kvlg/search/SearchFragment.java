package com.kvlg.search;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u0005\u00a2\u0006\u0002\u0010\u0007J$\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\u0018\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001fH\u0016J\u0018\u0010+\u001a\u00020\'2\u0006\u0010(\u001a\u00020,2\u0006\u0010*\u001a\u00020\u001fH\u0016J\b\u0010-\u001a\u00020\'H\u0016J\u0018\u0010.\u001a\u00020\'2\u0006\u0010/\u001a\u0002002\u0006\u0010(\u001a\u000201H\u0016J\u0018\u00102\u001a\u00020\'2\u0006\u0010(\u001a\u0002032\u0006\u0010*\u001a\u00020\u001fH\u0016J\b\u00104\u001a\u00020\'H\u0002J\b\u00105\u001a\u00020\'H\u0002J\b\u00106\u001a\u00020\'H\u0014J\b\u00107\u001a\u00020\'H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00068"}, d2 = {"Lcom/kvlg/search/SearchFragment;", "Lcom/kvlg/design/BaseViewBindingFragment;", "Lcom/kvlg/search/databinding/FragmentSearchBinding;", "Lcom/kvlg/spotify_common/adapters/AlbumInteraction;", "Lcom/kvlg/spotify_common/adapters/ArtistInteraction;", "Lcom/kvlg/spotify_common/adapters/TrackInteraction;", "Lcom/kvlg/suggestion/SuggestionInteraction;", "()V", "albumsAdapter", "Lcom/kvlg/spotify_common/adapters/AlbumsHorizontalAdapter;", "artistsAdapter", "Lcom/kvlg/spotify_common/adapters/ArtistsAdapter;", "keyword", "", "navigation", "Lcom/kvlg/search/SearchNavigation;", "getNavigation", "()Lcom/kvlg/search/SearchNavigation;", "setNavigation", "(Lcom/kvlg/search/SearchNavigation;)V", "sharedViewModel", "Lcom/kvlg/shared/SharedViewModel;", "getSharedViewModel", "()Lcom/kvlg/shared/SharedViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "suggestionsAdapter", "Lcom/kvlg/suggestion/SuggestionAdapter;", "tracksListedAdapter", "Lcom/kvlg/spotify_common/adapters/TrackListedAdapter;", "getViewBinding", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onAlbumSelected", "", "item", "Lcom/kvlg/spotify_common/presentation/AlbumModel;", "view", "onArtistSelected", "Lcom/kvlg/spotify_common/presentation/ArtistModel;", "onPause", "onSuggestionSelected", "position", "", "Lcom/kvlg/suggestion/Suggestion;", "onTrackSelected", "Lcom/kvlg/spotify_common/presentation/TrackModel;", "setContentVisibility", "setupSearchView", "setupViews", "showFilterBottomSheet", "Search_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class SearchFragment extends com.kvlg.design.BaseViewBindingFragment<com.kvlg.search.databinding.FragmentSearchBinding> implements com.kvlg.spotify_common.adapters.AlbumInteraction, com.kvlg.spotify_common.adapters.ArtistInteraction, com.kvlg.spotify_common.adapters.TrackInteraction, com.kvlg.suggestion.SuggestionInteraction {
    @javax.inject.Inject()
    public com.kvlg.search.SearchNavigation navigation;
    private final kotlin.Lazy sharedViewModel$delegate = null;
    private final com.kvlg.suggestion.SuggestionAdapter suggestionsAdapter = null;
    private final com.kvlg.spotify_common.adapters.ArtistsAdapter artistsAdapter = null;
    private final com.kvlg.spotify_common.adapters.AlbumsHorizontalAdapter albumsAdapter = null;
    private final com.kvlg.spotify_common.adapters.TrackListedAdapter tracksListedAdapter = null;
    private java.lang.String keyword = "";
    
    @org.jetbrains.annotations.NotNull()
    public final com.kvlg.search.SearchNavigation getNavigation() {
        return null;
    }
    
    public final void setNavigation(@org.jetbrains.annotations.NotNull()
    com.kvlg.search.SearchNavigation p0) {
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
    public void onPause() {
    }
    
    @java.lang.Override()
    public void onAlbumSelected(@org.jetbrains.annotations.NotNull()
    com.kvlg.spotify_common.presentation.AlbumModel item, @org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    @java.lang.Override()
    public void onArtistSelected(@org.jetbrains.annotations.NotNull()
    com.kvlg.spotify_common.presentation.ArtistModel item, @org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    @java.lang.Override()
    public void onTrackSelected(@org.jetbrains.annotations.NotNull()
    com.kvlg.spotify_common.presentation.TrackModel item, @org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    @java.lang.Override()
    public void onSuggestionSelected(int position, @org.jetbrains.annotations.NotNull()
    com.kvlg.suggestion.Suggestion item) {
    }
    
    private final void setupSearchView() {
    }
    
    private final void setContentVisibility() {
    }
    
    private final void showFilterBottomSheet() {
    }
    
    public SearchFragment() {
        super();
    }
}