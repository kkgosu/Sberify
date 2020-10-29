package com.kvlg.shared.domain.artist

import com.kvlg.model.presentation.Artist
import com.kvlg.shared.data.ArtistRepository
import com.kvlg.shared.di.IoDispatcher
import com.kvlg.shared.domain.UseCase
import kotlinx.coroutines.CoroutineDispatcher

/**
 * @author Konstantin Koval
 * @since 29.10.2020
 */
class GetArtistFromDbUseCase(
    private val artistRepository: ArtistRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : UseCase<String, List<Artist?>>(dispatcher) {

    override suspend fun execute(parameters: String): List<Artist?> {
        return artistRepository.getArtistFromDb(parameters)
    }
}