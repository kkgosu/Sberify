package com.kvlg.shared.di

import com.kvlg.network.genius.GeniusApi
import com.kvlg.network.genius.GeniusParser
import com.kvlg.network.spotify.DataConverter
import com.kvlg.network.spotify.SpotifyApi
import com.kvlg.shared.data.*
import com.kvlg.shared.data.db.AppDatabase
import com.kvlg.shared.domain.album.AlbumUseCasesProvider
import com.kvlg.shared.domain.album.AlbumUseCasesProviderImpl
import com.kvlg.shared.domain.artist.ArtistUseCasesProvider
import com.kvlg.shared.domain.artist.ArtistUseCasesProviderImpl
import com.kvlg.shared.domain.suggestions.SuggestionUseCasesProvider
import com.kvlg.shared.domain.suggestions.SuggestionUseCasesProviderImpl
import com.kvlg.shared.domain.track.TrackUseCasesProvider
import com.kvlg.shared.domain.track.TrackUseCasesProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

/**
 * @author Konstantin Koval
 * @since 24.10.2020
 */
@Module
@InstallIn(ApplicationComponent::class)
object ShareModule {

    @Singleton
    @Provides
    fun provideSuggestionsRepository(
        database: AppDatabase
    ): SuggestionsRepository {
        return SuggestionRepositoryImpl(database)
    }

    @Provides
    @Singleton
    fun provideTrackRepository(
        appDatabase: AppDatabase,
        spotifyApi: SpotifyApi,
        converter: DataConverter
    ): TrackRepository {
        return TrackRepositoryImpl(appDatabase, spotifyApi, converter)
    }

    @Provides
    @Singleton
    fun provideLyricsRepository(
        database: AppDatabase,
        geniusApi: GeniusApi,
        geniusParser: GeniusParser
    ): LyricsRepository {
        return LyricsRepositoryImpl(database, geniusApi, geniusParser)
    }

    @Provides
    @Singleton
    fun provideArtistRepository(
        database: AppDatabase,
        spotifyApi: SpotifyApi,
        dataConverter: DataConverter
    ): ArtistRepository {
        return ArtistRepositoryImpl(database, spotifyApi, dataConverter)
    }

    @Provides
    @Singleton
    fun provideAlbumRepository(
        database: AppDatabase,
        spotifyApi: SpotifyApi,
        converter: DataConverter
    ): AlbumRepository {
        return AlbumsRepositoryImpl(database, spotifyApi, converter)
    }

    @Provides
    @Singleton
    fun provideSuggestionUseCasesProvider(
        repository: SuggestionsRepository,
        @IoDispatcher dispatcher: CoroutineDispatcher
    ): SuggestionUseCasesProvider {
        return SuggestionUseCasesProviderImpl(repository, dispatcher)
    }

    @Provides
    @Singleton
    fun provideTrackUseCasesRepository(
        trackRepo: TrackRepository,
        @IoDispatcher dispatcher: CoroutineDispatcher
    ): TrackUseCasesProvider {
        return TrackUseCasesProviderImpl(trackRepo, dispatcher)
    }

    @Provides
    @Singleton
    fun provideArtistUseCasesProvider(
        artistRepository: ArtistRepository,
        @IoDispatcher dispatcher: CoroutineDispatcher
    ): ArtistUseCasesProvider {
        return ArtistUseCasesProviderImpl(artistRepository, dispatcher)
    }

    @Provides
    @Singleton
    fun provideAlbumUseCasesProvider(
        repository: AlbumRepository,
        @IoDispatcher dispatcher: CoroutineDispatcher
    ): AlbumUseCasesProvider {
        return AlbumUseCasesProviderImpl(repository, dispatcher)
    }
}