package com.kvlg.shared.domain.track

import com.kvlg.model.presentation.Track
import com.kvlg.network.spotify.DataConverter
import com.kvlg.shared.data.TrackRepository
import com.kvlg.shared.di.IoDispatcher
import com.kvlg.shared.domain.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * Search tracks in spotify
 *
 * @author Konstantin Koval
 * @since 27.10.2020
 */
class GetTracksFromSpotifyUseCase @Inject constructor(
    private val repository: TrackRepository,
    private val converter: DataConverter,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : UseCase<String, List<Track>?>(dispatcher) {

    override suspend fun execute(parameters: String): List<Track>? {
        return repository.getTracksFromSpotify(parameters).tracks.items.let {
            converter.convertTracks(it, "")
        }?.also {
            it.forEach(repository::saveTrackIntoDb)
        }
    }
}