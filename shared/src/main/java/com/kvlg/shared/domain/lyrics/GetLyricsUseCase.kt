package com.kvlg.shared.domain.lyrics

import com.kvlg.model.presentation.Track
import com.kvlg.shared.data.genius.GeniusRepository
import com.kvlg.shared.di.IoDispatcher
import com.kvlg.shared.domain.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * Get lyrics from Db
 *
 * @author Konstantin Koval
 * @since 25.10.2020
 */
class GetLyricsUseCase @Inject constructor(
    private val repository: GeniusRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : UseCase<Track, Track?>(dispatcher) {

    override suspend fun execute(parameters: Track): Track? {
        return repository.getLyricsFromDb(parameters)
    }
}