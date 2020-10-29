package com.kvlg.shared.domain.track

import com.kvlg.model.presentation.Track
import com.kvlg.shared.data.TrackRepository
import com.kvlg.shared.di.IoDispatcher
import com.kvlg.shared.domain.UseCase
import kotlinx.coroutines.CoroutineDispatcher

/**
 * Save track in Db
 *
 * @author Konstantin Koval
 * @since 25.10.2020
 */
class SaveTrackIntoDbUseCase(
    private val geniusRepository: TrackRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : UseCase<Track, Unit>(dispatcher) {

    override suspend fun execute(parameters: Track) {
        geniusRepository.saveTrackIntoDb(parameters)
    }
}