package com.kvlg.shared.di;

import java.lang.System;

/**
 * @author Konstantin Koval
 * @since 24.10.2020
 */
@dagger.hilt.InstallIn(value = {dagger.hilt.android.components.ApplicationComponent.class})
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0007J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\nH\u0007J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00112\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0007J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u001a\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00172\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0007J\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010\r\u001a\u00020!2\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\"\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J \u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u001a\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020$2\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0007\u00a8\u0006)"}, d2 = {"Lcom/kvlg/shared/di/ShareModule;", "", "()V", "provideAlbumRepository", "Lcom/kvlg/shared/data/AlbumRepository;", "database", "Lcom/kvlg/shared/data/db/AppDatabase;", "spotifyApi", "Lcom/kvlg/network/spotify/SpotifyApi;", "converter", "Lcom/kvlg/network/spotify/DataConverter;", "provideAlbumUseCasesProvider", "Lcom/kvlg/shared/domain/album/AlbumUseCasesProvider;", "repository", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "provideArtistRepository", "Lcom/kvlg/shared/data/ArtistRepository;", "dataConverter", "provideArtistUseCasesProvider", "Lcom/kvlg/shared/domain/artist/ArtistUseCasesProvider;", "artistRepository", "provideLyricsRepository", "Lcom/kvlg/shared/data/LyricsRepository;", "geniusApi", "Lcom/kvlg/network/genius/GeniusApi;", "geniusParser", "Lcom/kvlg/network/genius/GeniusParser;", "provideLyricsUseCasesProvider", "Lcom/kvlg/shared/domain/lyrics/LyricsUseCasesProvider;", "lyricsRepository", "provideSuggestionUseCasesProvider", "Lcom/kvlg/shared/domain/suggestions/SuggestionUseCasesProvider;", "Lcom/kvlg/shared/data/SuggestionsRepository;", "provideSuggestionsRepository", "provideTrackRepository", "Lcom/kvlg/shared/data/TrackRepository;", "appDatabase", "provideTrackUseCasesRepository", "Lcom/kvlg/shared/domain/track/TrackUseCasesProvider;", "trackRepo", "shared_debug"})
@dagger.Module()
public final class ShareModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.kvlg.shared.di.ShareModule INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.kvlg.shared.data.SuggestionsRepository provideSuggestionsRepository(@org.jetbrains.annotations.NotNull()
    com.kvlg.shared.data.db.AppDatabase database) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kvlg.shared.data.TrackRepository provideTrackRepository(@org.jetbrains.annotations.NotNull()
    com.kvlg.shared.data.db.AppDatabase appDatabase, @org.jetbrains.annotations.NotNull()
    com.kvlg.network.spotify.SpotifyApi spotifyApi, @org.jetbrains.annotations.NotNull()
    com.kvlg.network.spotify.DataConverter converter) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kvlg.shared.data.LyricsRepository provideLyricsRepository(@org.jetbrains.annotations.NotNull()
    com.kvlg.shared.data.db.AppDatabase database, @org.jetbrains.annotations.NotNull()
    com.kvlg.network.genius.GeniusApi geniusApi, @org.jetbrains.annotations.NotNull()
    com.kvlg.network.genius.GeniusParser geniusParser) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kvlg.shared.data.ArtistRepository provideArtistRepository(@org.jetbrains.annotations.NotNull()
    com.kvlg.shared.data.db.AppDatabase database, @org.jetbrains.annotations.NotNull()
    com.kvlg.network.spotify.SpotifyApi spotifyApi, @org.jetbrains.annotations.NotNull()
    com.kvlg.network.spotify.DataConverter dataConverter) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kvlg.shared.data.AlbumRepository provideAlbumRepository(@org.jetbrains.annotations.NotNull()
    com.kvlg.shared.data.db.AppDatabase database, @org.jetbrains.annotations.NotNull()
    com.kvlg.network.spotify.SpotifyApi spotifyApi, @org.jetbrains.annotations.NotNull()
    com.kvlg.network.spotify.DataConverter converter) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kvlg.shared.domain.suggestions.SuggestionUseCasesProvider provideSuggestionUseCasesProvider(@org.jetbrains.annotations.NotNull()
    com.kvlg.shared.data.SuggestionsRepository repository, @org.jetbrains.annotations.NotNull()
    @IoDispatcher()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kvlg.shared.domain.track.TrackUseCasesProvider provideTrackUseCasesRepository(@org.jetbrains.annotations.NotNull()
    com.kvlg.shared.data.TrackRepository trackRepo, @org.jetbrains.annotations.NotNull()
    @IoDispatcher()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kvlg.shared.domain.artist.ArtistUseCasesProvider provideArtistUseCasesProvider(@org.jetbrains.annotations.NotNull()
    com.kvlg.shared.data.ArtistRepository artistRepository, @org.jetbrains.annotations.NotNull()
    @IoDispatcher()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kvlg.shared.domain.album.AlbumUseCasesProvider provideAlbumUseCasesProvider(@org.jetbrains.annotations.NotNull()
    com.kvlg.shared.data.AlbumRepository repository, @org.jetbrains.annotations.NotNull()
    @IoDispatcher()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kvlg.shared.domain.lyrics.LyricsUseCasesProvider provideLyricsUseCasesProvider(@org.jetbrains.annotations.NotNull()
    com.kvlg.shared.data.LyricsRepository lyricsRepository, @org.jetbrains.annotations.NotNull()
    @IoDispatcher()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        return null;
    }
    
    private ShareModule() {
        super();
    }
}