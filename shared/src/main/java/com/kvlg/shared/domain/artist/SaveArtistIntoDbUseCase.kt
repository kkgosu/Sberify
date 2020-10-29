package com.kvlg.shared.domain.artist

import com.kvlg.model.presentation.Artist
import com.kvlg.shared.data.ArtistRepository
import com.kvlg.shared.di.IoDispatcher
import com.kvlg.shared.domain.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * @author Konstantin Koval
 * @since 29.10.2020
 */
class SaveArtistIntoDbUseCase @Inject constructor(
    private val artistRepository: ArtistRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : UseCase<Artist, Unit>(dispatcher) {

    override suspend fun execute(parameters: Artist) {
        artistRepository.saveArtistIntoDb(parameters)
    }
}