package com.example.sberify.presentation.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnNextLayout
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.sberify.R
import com.example.sberify.base.BaseFragment
import com.example.sberify.databinding.FragmentFavoriteBinding
import com.example.sberify.models.domain.Album
import com.example.sberify.models.domain.Track
import com.example.sberify.presentation.ui.Injectable
import com.example.sberify.presentation.ui.albuminfo.AlbumDetailsAdapter
import com.example.sberify.presentation.ui.newreleases.AlbumsAdapter
import com.google.android.material.transition.Hold
import kotlinx.android.synthetic.main.fragment_favorite.*

class FavoriteFragment : BaseFragment(), Injectable, AlbumDetailsAdapter.Interaction,
    AlbumsAdapter.Interaction {

    private val favoriteViewModel: FavoriteViewModel by viewModels { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentFavoriteBinding>(
            inflater,
            R.layout.fragment_favorite,
            container
        ).apply {
            lifecycleOwner = this@FavoriteFragment
            favoriteVM = favoriteViewModel
            tracksAdapter = AlbumDetailsAdapter(this@FavoriteFragment)
            albumsAdapter = AlbumsAdapter(this@FavoriteFragment)

            favoriteViewModel.loadFavorite()
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postponeEnterTransition()
        favorite_tracks_recycler.doOnNextLayout {
            startPostponedEnterTransition()
        }

        favorite_albums_recycler.doOnNextLayout {
            startPostponedEnterTransition()
        }

        exitTransition = Hold().apply {
            duration = 450
        }
    }

    override fun onTrackSelected(item: Track, view: View) {
        sharedViewModel.getLyrics(item)
        val extras = FragmentNavigatorExtras(
            view to view.transitionName
        )
        findNavController().navigate(
            FavoriteFragmentDirections.actionFavoriteFragmentToLyricsFragment(item), extras
        )
    }

    override fun onAlbumSelected(item: Album, view: View) {
        sharedViewModel.getAlbumInfo(item)
        val extras = FragmentNavigatorExtras(
            view to view.transitionName
        )
        findNavController().navigate(
            FavoriteFragmentDirections.actionFavoriteFragmentToAlbumInfoFragment2(
                item
            ), extras
        )
    }
}