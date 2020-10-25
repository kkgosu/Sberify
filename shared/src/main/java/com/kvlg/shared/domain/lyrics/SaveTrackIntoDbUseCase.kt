package com.kvlg.shared.domain.lyrics

import com.kvlg.model.presentation.Track
import com.kvlg.shared.data.genius.GeniusRepository
import com.kvlg.shared.di.IoDispatcher
import com.kvlg.shared.domain.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * Save track in Db
 *
 * @author Konstantin Koval
 * @since 25.10.2020
 */
class SaveTrackIntoDbUseCase @Inject constructor(
    private val geniusRepository: GeniusRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : UseCase<Track, Unit>(dispatcher) {

    override suspend fun execute(parameters: Track) {
        geniusRepository.saveLyricsIntoDb(parameters)
    }
}