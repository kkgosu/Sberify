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
class GetAlbumByIdDbUseCase(
    private val repository: AlbumRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : UseCase<String, Album>(dispatcher) {

    override suspend fun execute(parameters: String): Album {
        return repository.getAlbumInfoFromDb(parameters)
    }
}