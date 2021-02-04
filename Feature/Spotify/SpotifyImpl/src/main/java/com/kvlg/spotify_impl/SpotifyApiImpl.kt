package com.kvlg.spotify_impl

import com.kvlg.spotify_api.api.SpotifyApi
import com.kvlg.spotify_api.api.SpotifyInteractor
import com.kvlg.spotify_api.converter.ViewModelConverter
import com.kvlg.spotify_impl.data.SpotifyRepository
import javax.inject.Inject

/**
 * @author Konstantin Koval
 * @since 28.01.2021
 */
class SpotifyApiImpl @Inject constructor(
    private val repo: SpotifyRepository,
    private val converter: ViewModelConverter
) : SpotifyApi {

    override fun interactor(): SpotifyInteractor {
        return SpotifyInteractorImpl(repo, converter)
    }
}