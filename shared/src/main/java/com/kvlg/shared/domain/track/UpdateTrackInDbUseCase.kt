package com.kvlg.shared.domain.track

import com.kvlg.model.presentation.Track
import com.kvlg.shared.data.TrackRepository
import com.kvlg.shared.di.IoDispatcher
import com.kvlg.shared.domain.UseCase
import kotlinx.coroutines.CoroutineDispatcher

/**
 * @author Konstantin Koval
 * @since 29.10.2020
 */
class UpdateTrackInDbUseCase(
    private val trackRepository: TrackRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : UseCase<Track, Unit>(dispatcher) {

    override suspend fun execute(parameters: Track) {
        trackRepository.updateTrackInDb(parameters)
    }
}