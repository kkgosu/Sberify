package com.kvlg.shared.domain.album

import com.kvlg.shared.data.AlbumRepository
import kotlinx.coroutines.CoroutineDispatcher

/**
 * @author Konstantin Koval
 * @since 29.10.2020
 */
interface AlbumUseCasesProvider {
    val getAlbumByIdDb: GetAlbumByIdDbUseCase
    val getAlbumByIdSpotify: GetAlbumByIdSpotifyUseCase
    val getAlbumsFromDb: GetAlbumsFromDbUseCase
    val getAlbumsFromSpotify: GetAlbumsFromSpotifyUseCase
    val getAllAlbums: GetAllAlbumsFromDbUseCase
    val getNewReleases: GetNewReleasesUseCase
    val saveAlbumIntoDb: SaveAlbumIntoDbUseCase
    val updateAlbumInDb: UpdateAlbumInDbUseCase
    val updateAlbumTracks: UpdateAlbumTracksUseCase
    val insertAlbum: InsertAlbumUseCase
    val getFavoriteTracks: GetFavoriteAlbumsUseCase
}

class AlbumUseCasesProviderImpl(
    private val repository: AlbumRepository,
    private val dispatcher: CoroutineDispatcher
) : AlbumUseCasesProvider {

    override val getAlbumByIdDb: GetAlbumByIdDbUseCase
        get() = GetAlbumByIdDbUseCase(repository, dispatcher)

    override val getAlbumByIdSpotify: GetAlbumByIdSpotifyUseCase
        get() = GetAlbumByIdSpotifyUseCase(repository, dispatcher)

    override val getAlbumsFromDb: GetAlbumsFromDbUseCase
        get() = GetAlbumsFromDbUseCase(repository, dispatcher)

    override val getAlbumsFromSpotify: GetAlbumsFromSpotifyUseCase
        get() = GetAlbumsFromSpotifyUseCase(repository, dispatcher)

    override val getAllAlbums: GetAllAlbumsFromDbUseCase
        get() = GetAllAlbumsFromDbUseCase(repository, dispatcher)

    override val getNewReleases: GetNewReleasesUseCase
        get() = GetNewReleasesUseCase(repository, dispatcher)

    override val saveAlbumIntoDb: SaveAlbumIntoDbUseCase
        get() = SaveAlbumIntoDbUseCase(repository, dispatcher)

    override val updateAlbumInDb: UpdateAlbumInDbUseCase
        get() = UpdateAlbumInDbUseCase(repository, dispatcher)

    override val updateAlbumTracks: UpdateAlbumTracksUseCase
        get() = UpdateAlbumTracksUseCase(repository, dispatcher)

    override val insertAlbum: InsertAlbumUseCase
        get() = InsertAlbumUseCase(repository, dispatcher)

    override val getFavoriteTracks: GetFavoriteAlbumsUseCase
        get() = GetFavoriteAlbumsUseCase(repository, dispatcher)

}