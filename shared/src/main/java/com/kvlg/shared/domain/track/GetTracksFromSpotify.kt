package com.kvlg.shared.domain.track

import com.kvlg.model.presentation.Track
import com.kvlg.shared.data.spotify.SpotifyRepository
import com.kvlg.shared.di.IoDispatcher
import com.kvlg.shared.domain.UseCase
import kotlinx.coroutines.CoroutineDispatcher

/**
 * @author Konstantin Koval
 * @since 27.10.2020
 */
class GetTracksFromSpotify(
    private val repository: SpotifyRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : UseCase<String, List<Track?>>(dispatcher) {

    override suspend fun execute(parameters: String): List<Track?> {
        TODO()
    }
}