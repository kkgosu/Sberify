package com.kvlg.shared.domain.track

import com.kvlg.network.spotify.DataConverter
import com.kvlg.shared.data.TrackRepository
import com.kvlg.shared.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

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
}

class TrackUseCasesProviderImpl @Inject constructor(
    private val trackRepo: TrackRepository,
    private val converter: DataConverter,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : TrackUseCasesProvider {

    override val getTrackFromDb: GetTrackFromDbUseCase
        get() = GetTrackFromDbUseCase(trackRepo, dispatcher)

    override val getTrackFromSpotify: GetTracksFromSpotifyUseCase
        get() = GetTracksFromSpotifyUseCase(trackRepo, converter, dispatcher)

    override val saveTrackIntoDb: SaveTrackIntoDbUseCase
        get() = SaveTrackIntoDbUseCase(trackRepo, dispatcher)

    override val updateTrackInDb: UpdateTrackInDbUseCase
        get() = UpdateTrackInDbUseCase(trackRepo, dispatcher)
}