package com.example.sberify.presentation.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u000e\u0010?\u001a\u00020\r2\u0006\u0010@\u001a\u000206J\u000e\u0010A\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0016J\u0006\u0010B\u001a\u00020\rJ\u000e\u0010*\u001a\u00020\r2\u0006\u0010C\u001a\u00020)J\u000e\u0010D\u001a\u00020\r2\u0006\u0010E\u001a\u000206J\u000e\u0010F\u001a\u00020\r2\u0006\u0010C\u001a\u00020)J\u0006\u0010G\u001a\u00020\rJ\u0006\u00101\u001a\u00020\rJ\u0006\u0010H\u001a\u00020\rJ\u000e\u0010I\u001a\u00020\r2\u0006\u0010@\u001a\u000206J\u000e\u0010J\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020KJ*\u0010L\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\u0010*\b\u0012\u0004\u0012\u0002060\u00102\u0006\u0010M\u001a\u00020 2\u0006\u0010@\u001a\u000206H\u0002R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00110\u00150\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R#\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00110\u00150\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#R\u001a\u0010&\u001a\u00020 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010!\"\u0004\b\'\u0010#R\u001d\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\u00150\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0018R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020)0\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00110\u00150\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0018R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020)0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0018R\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020)0\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020 0\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u00105\u001a\b\u0012\u0004\u0012\u0002060\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u00107\u001a\b\u0012\u0004\u0012\u0002060\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u00108\u001a\b\u0012\u0004\u0012\u0002060\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u00103R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0018R#\u0010=\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\u00110\u00150\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010\u0018\u00a8\u0006N"}, d2 = {"Lcom/example/sberify/presentation/ui/SharedViewModel;", "Landroidx/lifecycle/ViewModel;", "spotifyRepository", "Lcom/example/sberify/domain/ISpotifyRepository;", "geniusRepository", "Lcom/example/sberify/domain/IGeniusRepository;", "databaseRepository", "Lcom/example/sberify/domain/DatabaseRepository;", "tokenData", "Lcom/example/sberify/domain/TokenData;", "(Lcom/example/sberify/domain/ISpotifyRepository;Lcom/example/sberify/domain/IGeniusRepository;Lcom/example/sberify/domain/DatabaseRepository;Lcom/example/sberify/domain/TokenData;)V", "_refreshContentVisibility", "Lcom/example/sberify/presentation/ui/utils/SingleLiveEvent;", "", "_showFiltersFragment", "_suggestions", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/example/sberify/models/domain/Suggestion;", "album", "Landroidx/lifecycle/LiveData;", "Lcom/example/sberify/data/Result;", "Lcom/example/sberify/models/newdomain/AlbumDomainModel;", "getAlbum", "()Landroidx/lifecycle/LiveData;", "albumInfoTrigger", "albumsSearchResult", "getAlbumsSearchResult", "artistsSearchResult", "Lcom/example/sberify/models/newdomain/ArtistDomainModel;", "getArtistsSearchResult", "isAlbumChecked", "", "()Z", "setAlbumChecked", "(Z)V", "isArtistChecked", "setArtistChecked", "isTrackChecked", "setTrackChecked", "lyrics", "Lcom/example/sberify/models/newdomain/TrackDomainModel;", "getLyrics", "lyricsTrigger", "newReleases", "getNewReleases", "play", "getPlay", "playTrigger", "refreshContentVisibility", "getRefreshContentVisibility", "()Lcom/example/sberify/presentation/ui/utils/SingleLiveEvent;", "reloadTrigger", "searchAlbumTrigger", "", "searchArtistTrigger", "searchTrackTrigger", "showFiltersFragment", "getShowFiltersFragment", "suggestions", "getSuggestions", "tracksSearchResult", "getTracksSearchResult", "checkFiltersAndSearch", "keyword", "getAlbumInfo", "getAllSuggestions", "track", "insertSuggestion", "text", "onPlayClick", "refresh", "refreshLyrics", "search", "updateFavoriteAlbum", "Lcom/example/sberify/models/domain/Album;", "applySearch", "isChecked", "app_debug"})
public final class SharedViewModel extends androidx.lifecycle.ViewModel {
    private boolean isAlbumChecked = false;
    private boolean isArtistChecked = false;
    private boolean isTrackChecked = false;
    private final com.example.sberify.presentation.ui.utils.SingleLiveEvent<kotlin.Unit> _showFiltersFragment = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.sberify.presentation.ui.utils.SingleLiveEvent<kotlin.Unit> showFiltersFragment = null;
    private final com.example.sberify.presentation.ui.utils.SingleLiveEvent<kotlin.Unit> _refreshContentVisibility = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.sberify.presentation.ui.utils.SingleLiveEvent<kotlin.Unit> refreshContentVisibility = null;
    private final androidx.lifecycle.MutableLiveData<com.example.sberify.models.newdomain.AlbumDomainModel> albumInfoTrigger = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> reloadTrigger = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> searchArtistTrigger = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> searchAlbumTrigger = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> searchTrackTrigger = null;
    private final androidx.lifecycle.MutableLiveData<com.example.sberify.models.newdomain.TrackDomainModel> lyricsTrigger = null;
    private final androidx.lifecycle.MutableLiveData<com.example.sberify.models.newdomain.TrackDomainModel> playTrigger = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.example.sberify.models.newdomain.TrackDomainModel> play = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.example.sberify.data.Result<java.util.List<com.example.sberify.models.newdomain.AlbumDomainModel>>> newReleases = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.example.sberify.data.Result<java.util.List<com.example.sberify.models.newdomain.ArtistDomainModel>>> artistsSearchResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.example.sberify.data.Result<java.util.List<com.example.sberify.models.newdomain.AlbumDomainModel>>> albumsSearchResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.example.sberify.data.Result<java.util.List<com.example.sberify.models.newdomain.TrackDomainModel>>> tracksSearchResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.example.sberify.data.Result<com.example.sberify.models.newdomain.AlbumDomainModel>> album = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.example.sberify.data.Result<com.example.sberify.models.newdomain.TrackDomainModel>> lyrics = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.sberify.models.domain.Suggestion>> _suggestions = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.sberify.models.domain.Suggestion>> suggestions = null;
    private final com.example.sberify.domain.ISpotifyRepository spotifyRepository = null;
    private final com.example.sberify.domain.IGeniusRepository geniusRepository = null;
    private final com.example.sberify.domain.DatabaseRepository databaseRepository = null;
    
    public final boolean isAlbumChecked() {
        return false;
    }
    
    public final void setAlbumChecked(boolean p0) {
    }
    
    public final boolean isArtistChecked() {
        return false;
    }
    
    public final void setArtistChecked(boolean p0) {
    }
    
    public final boolean isTrackChecked() {
        return false;
    }
    
    public final void setTrackChecked(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.sberify.presentation.ui.utils.SingleLiveEvent<kotlin.Unit> getShowFiltersFragment() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.sberify.presentation.ui.utils.SingleLiveEvent<kotlin.Unit> getRefreshContentVisibility() {
        return null;
    }
    
    public final void checkFiltersAndSearch(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.sberify.models.newdomain.TrackDomainModel> getPlay() {
        return null;
    }
    
    public final void onPlayClick(@org.jetbrains.annotations.NotNull()
    com.example.sberify.models.newdomain.TrackDomainModel track) {
    }
    
    public final void getAlbumInfo(@org.jetbrains.annotations.NotNull()
    com.example.sberify.models.newdomain.AlbumDomainModel album) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.sberify.data.Result<java.util.List<com.example.sberify.models.newdomain.AlbumDomainModel>>> getNewReleases() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.sberify.data.Result<java.util.List<com.example.sberify.models.newdomain.ArtistDomainModel>>> getArtistsSearchResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.sberify.data.Result<java.util.List<com.example.sberify.models.newdomain.AlbumDomainModel>>> getAlbumsSearchResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.sberify.data.Result<java.util.List<com.example.sberify.models.newdomain.TrackDomainModel>>> getTracksSearchResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.sberify.data.Result<com.example.sberify.models.newdomain.AlbumDomainModel>> getAlbum() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.sberify.data.Result<com.example.sberify.models.newdomain.TrackDomainModel>> getLyrics() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.sberify.models.domain.Suggestion>> getSuggestions() {
        return null;
    }
    
    public final void search(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword) {
    }
    
    public final void refreshContentVisibility() {
    }
    
    public final void refresh() {
    }
    
    public final void getLyrics(@org.jetbrains.annotations.NotNull()
    com.example.sberify.models.newdomain.TrackDomainModel track) {
    }
    
    public final void refreshLyrics() {
    }
    
    public final void insertSuggestion(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    public final void getAllSuggestions() {
    }
    
    public final void updateFavoriteAlbum(@org.jetbrains.annotations.NotNull()
    com.example.sberify.models.domain.Album album) {
    }
    
    private final androidx.lifecycle.MutableLiveData<java.lang.String> applySearch(androidx.lifecycle.MutableLiveData<java.lang.String> $this$applySearch, boolean isChecked, java.lang.String keyword) {
        return null;
    }
    
    @androidx.hilt.lifecycle.ViewModelInject()
    public SharedViewModel(@org.jetbrains.annotations.NotNull()
    com.example.sberify.domain.ISpotifyRepository spotifyRepository, @org.jetbrains.annotations.NotNull()
    com.example.sberify.domain.IGeniusRepository geniusRepository, @org.jetbrains.annotations.NotNull()
    com.example.sberify.domain.DatabaseRepository databaseRepository, @org.jetbrains.annotations.NotNull()
    com.example.sberify.domain.TokenData tokenData) {
        super();
    }
}