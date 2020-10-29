package com.kvlg.shared.domain.album

import com.kvlg.model.presentation.Album
import com.kvlg.shared.data.AlbumRepository
import com.kvlg.shared.di.IoDispatcher
import com.kvlg.shared.domain.UseCase
import kotlinx.coroutines.CoroutineDispatcher

/**
 * @author Konstantin Koval
 * @since 29.10.2020
 */
class GetNewReleasesUseCase(
    private val repository: AlbumRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : UseCase<Unit, List<Album>>(dispatcher) {

    override suspend fun execute(parameters: Unit): List<Album> {
        return repository.getNewReleases()
    }
}