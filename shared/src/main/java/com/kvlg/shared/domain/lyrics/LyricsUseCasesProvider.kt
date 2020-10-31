package com.kvlg.shared.domain.lyrics

import com.kvlg.shared.data.LyricsRepository
import kotlinx.coroutines.CoroutineDispatcher

/**
 * @author Konstantin Koval
 * @since 31.10.2020
 */
interface LyricsUseCasesProvider {
    val getLyrics: GetLyricsUseCase
    val parseLyrics: ParseLyricsFromGeniusUseCase
}

class LyricsUseCasesProviderImpl(
    private val repository: LyricsRepository,
    private val dispatcher: CoroutineDispatcher
) : LyricsUseCasesProvider {

    override val getLyrics: GetLyricsUseCase
        get() = GetLyricsUseCase(repository, dispatcher)
    override val parseLyrics: ParseLyricsFromGeniusUseCase
        get() = ParseLyricsFromGeniusUseCase(repository, dispatcher)
}