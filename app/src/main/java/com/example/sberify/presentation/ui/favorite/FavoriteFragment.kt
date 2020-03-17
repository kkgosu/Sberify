package com.example.sberify.presentation.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnNextLayout
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.sberify.R
import com.example.sberify.base.BaseFragment
import com.example.sberify.base.Interaction
import com.example.sberify.databinding.FragmentFavoriteBinding
import com.example.sberify.models.domain.Album
import com.example.sberify.models.domain.BaseModel
import com.example.sberify.models.domain.Track
import com.example.sberify.presentation.ui.Injectable
import com.example.sberify.presentation.ui.albuminfo.AlbumDetailsAdapter
import com.example.sberify.presentation.ui.albuminfo.AlbumInfoAdapter
import com.example.sberify.presentation.ui.albuminfo.AlbumInfoFragmentDirections
import com.example.sberify.presentation.ui.newreleases.NewReleasesAdapter
import com.example.sberify.presentation.ui.newreleases.NewReleasesAdapter1
import com.example.sberify.presentation.ui.newreleases.NewReleasesFragmentDirections
import com.google.android.material.transition.Hold
import kotlinx.android.synthetic.main.fragment_favorite.*

class FavoriteFragment : BaseFragment(), Interaction, Injectable, AlbumDetailsAdapter.Interaction,
    NewReleasesAdapter1.Interaction {

    private val favoriteViewModel: FavoriteViewModel by viewModels { viewModelFactory }
    private lateinit var tracksAdapter: AlbumInfoAdapter<Track>
    private lateinit var albumsAdapter: NewReleasesAdapter<Album>
    private lateinit var gridLayoutManager: StaggeredGridLayoutManager
    private lateinit var recyclerViewTracks: RecyclerView
    private lateinit var recyclerViewAlbums: RecyclerView

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
            tracksAdapter = AlbumDetailsAdapter()
            albumsAdapter = NewReleasesAdapter1()

            favoriteViewModel.loadFavorite()
        }.root
    }

    override fun onItemSelected(position: Int, item: BaseModel, view: View) {
/*        if (item is Track) {
            sharedViewModel.getLyrics(item)
            val extras = FragmentNavigatorExtras(
                view.findViewById<TextView>(R.id.track_name) to item.name
            )
            findNavController().navigate(
                R.id.action_favoriteFragment_to_lyricsFragment, null, null,
                extras
            )
        } else if (item is Album) {
            sharedViewModel.getAlbumInfo(item)
            val extras = FragmentNavigatorExtras(
                view.findViewById<TextView>(R.id.release_name) to "${item.name}album",
                view.findViewById<ImageView>(R.id.release_cover) to "${item.imageUrl}album",
                view.findViewById<TextView>(R.id.artist_name) to "${item.artist.name}album"
            )

            findNavController().navigate(
                R.id.action_favoriteFragment_to_albumInfoFragment2, null,
                null, extras
            )
        }*/
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
            AlbumInfoFragmentDirections.navigateToLyricsFragment(item), extras
        )
    }

    override fun onAlbumSelected(item: Album, view: View) {
        sharedViewModel.getAlbumInfo(item)
        val extras = FragmentNavigatorExtras(
            view to view.transitionName
        )
        findNavController().navigate(
            NewReleasesFragmentDirections.actionNewReleasesFragmentToAlbumInfoFragment(
                item
            ), extras
        )
    }
}