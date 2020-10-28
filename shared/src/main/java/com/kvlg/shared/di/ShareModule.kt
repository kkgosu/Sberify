package com.kvlg.shared.di

import com.kvlg.network.genius.GeniusApi
import com.kvlg.network.genius.GeniusParser
import com.kvlg.network.spotify.DataConverter
import com.kvlg.network.spotify.SpotifyApi
import com.kvlg.shared.data.TrackRepository
import com.kvlg.shared.data.TrackRepositoryImpl
import com.kvlg.shared.data.db.AppDatabase
import com.kvlg.shared.data.genius.GeniusRepository
import com.kvlg.shared.data.genius.GeniusRepositoryImpl
import com.kvlg.shared.data.spotify.SpotifyRepository
import com.kvlg.shared.data.spotify.SpotifyRepositoryImpl
import com.kvlg.shared.data.suggestions.SuggestionRepositoryImpl
import com.kvlg.shared.data.suggestions.SuggestionsRepository
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
    fun provideGeniusRepository(
        appDatabase: AppDatabase,
        geniusParser: GeniusParser,
        geniusApi: GeniusApi
    ): GeniusRepository {
        return GeniusRepositoryImpl(appDatabase, geniusParser, geniusApi)
    }

    @Provides
    @Singleton
    fun provideSpotifyRepository(
        appDatabase: AppDatabase,
        spotifyApi: SpotifyApi
    ): SpotifyRepository {
        return SpotifyRepositoryImpl(appDatabase, spotifyApi)
    }

    @Provides
    @Singleton
    fun provideTrackRepository(
        appDatabase: AppDatabase,
        spotifyApi: SpotifyApi
    ): TrackRepository {
        return TrackRepositoryImpl(appDatabase, spotifyApi)
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
        converter: DataConverter,
        @IoDispatcher dispatcher: CoroutineDispatcher
    ): TrackUseCasesProvider {
        return TrackUseCasesProviderImpl(trackRepo, converter, dispatcher)
    }
}