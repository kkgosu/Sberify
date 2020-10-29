package com.kvlg.shared.domain.track

import com.kvlg.shared.data.TrackRepository
import com.kvlg.shared.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher

/**
 * Provide track's use cases
 *
 * @author Konstantin Koval
 * @since 28.10.2020
 */
interface TrackUseCasesProvider {
    val getTrackFromDb: GetTrackFromDbUseCase
    val getTrackFromSpotify: GetTracksFromSpotifyUseCase
    val saveTrackIntoDb: SaveTrackIntoDbUseCase
    val updateTrackInDb: UpdateTrackInDbUseCase
    val getFavoriteTracks: GetFavoriteTracksUseCase
}

class TrackUseCasesProviderImpl(
    private val trackRepo: TrackRepository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : TrackUseCasesProvider {

    override val getTrackFromDb: GetTrackFromDbUseCase
        get() = GetTrackFromDbUseCase(trackRepo, dispatcher)

    override val getTrackFromSpotify: GetTracksFromSpotifyUseCase
        get() = GetTracksFromSpotifyUseCase(trackRepo, dispatcher)

    override val saveTrackIntoDb: SaveTrackIntoDbUseCase
        get() = SaveTrackIntoDbUseCase(trackRepo, dispatcher)

    override val updateTrackInDb: UpdateTrackInDbUseCase
        get() = UpdateTrackInDbUseCase(trackRepo, dispatcher)

    override val getFavoriteTracks: GetFavoriteTracksUseCase
        get() = GetFavoriteTracksUseCase(trackRepo, dispatcher)
}