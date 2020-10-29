package com.kvlg.shared.domain.artist

import com.kvlg.shared.data.ArtistRepository
import com.kvlg.shared.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher

/**
 * @author Konstantin Koval
 * @since 29.10.2020
 */
interface ArtistUseCasesProvider {
    val getArtistFromDb: GetArtistFromDbUseCase
    val getArtistFromSpotify: GetArtistFromSpotifyUseCase
    val saveArtistIntoDb: SaveArtistIntoDbUseCase
}

class ArtistUseCasesProviderImpl(
    private val artistRepository: ArtistRepository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : ArtistUseCasesProvider {

    override val getArtistFromDb: GetArtistFromDbUseCase
        get() = GetArtistFromDbUseCase(artistRepository, dispatcher)

    override val getArtistFromSpotify: GetArtistFromSpotifyUseCase
        get() = GetArtistFromSpotifyUseCase(artistRepository, dispatcher)

    override val saveArtistIntoDb: SaveArtistIntoDbUseCase
        get() = SaveArtistIntoDbUseCase(artistRepository, dispatcher)
}