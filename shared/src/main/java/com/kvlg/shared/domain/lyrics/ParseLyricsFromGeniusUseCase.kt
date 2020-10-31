package com.kvlg.shared.domain.lyrics

import com.kvlg.model.presentation.Track
import com.kvlg.shared.data.LyricsRepository
import com.kvlg.shared.di.IoDispatcher
import com.kvlg.shared.domain.UseCase
import kotlinx.coroutines.CoroutineDispatcher

/**
 * @author Konstantin Koval
 * @since 25.10.2020
 */
class ParseLyricsFromGeniusUseCase(
    private val lyricsRepository: LyricsRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : UseCase<Track, Track>(dispatcher) {

    override suspend fun execute(parameters: Track): Track {
        return lyricsRepository.parseLyricsFromGenius(parameters)
    }
}