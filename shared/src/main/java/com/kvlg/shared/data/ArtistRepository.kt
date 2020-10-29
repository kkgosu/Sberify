package com.kvlg.shared.data

import com.kvlg.model.presentation.Artist
import com.kvlg.model.presentation.Image
import com.kvlg.network.spotify.DataConverter
import com.kvlg.network.spotify.SpotifyApi
import com.kvlg.shared.data.db.AppDatabase
import com.kvlg.shared.data.db.artists.ArtistEntity

/**
 * @author Konstantin Koval
 * @since 29.10.2020
 */
interface ArtistRepository {
    suspend fun getArtistFromSpotify(keyword: String): List<Artist>
    fun getArtistFromDb(keyword: String): List<Artist?>
    fun saveArtistIntoDb(artist: Artist)
}

class ArtistRepositoryImpl(
    private val database: AppDatabase,
    private val spotifyApi: SpotifyApi,
    private val converter: DataConverter
) : ArtistRepository {

    override suspend fun getArtistFromSpotify(keyword: String): List<Artist> {
        return getResponse { spotifyApi.searchArtist(keyword) }.artists.items.let {
            converter.convertArtists(it)
        }
    }

    override fun getArtistFromDb(keyword: String): List<Artist?> {
        return database.getArtistDao().getArtistByKeyword(keyword).map {
            Artist(
                id = it.spotifyId,
                name = it.name,
                image = Image(it.imageUrl, 0, 0),
                genres = null
            )
        }
    }

    override fun saveArtistIntoDb(artist: Artist) {
        database.getArtistDao().insertArtist(
            ArtistEntity(
                spotifyId = artist.id,
                name = artist.name,
                imageUrl = artist.image?.url
            )
        )
    }
}