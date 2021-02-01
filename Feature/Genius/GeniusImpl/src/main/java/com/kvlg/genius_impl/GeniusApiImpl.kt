package com.kvlg.genius_impl

import com.kvlg.genius_api.GeniusApi
import com.kvlg.genius_api.GeniusInteractor
import com.kvlg.genius_impl.data.GeniusRepository
import com.kvlg.spotify_api.converter.ViewModelConverter
import javax.inject.Inject

/**
 * @author Konstantin Koval
 * @since 27.01.2021
 */
class GeniusApiImpl @Inject constructor(
    private val repo: GeniusRepository,
    private val modelConverter: ViewModelConverter
) : GeniusApi {

    override fun interactor(): GeniusInteractor {
        return GeniusInteractorImpl(repo, modelConverter)
    }
}