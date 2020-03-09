package com.example.sberify.presentation.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.doOnPreDraw
import androidx.lifecycle.observe
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.sberify.R
import com.example.sberify.base.BaseFragment
import com.example.sberify.base.Interaction
import com.example.sberify.databinding.FragmentFavoriteBinding
import com.example.sberify.di.injectViewModel
import com.example.sberify.models.domain.Album
import com.example.sberify.models.domain.BaseModel
import com.example.sberify.models.domain.Track
import com.example.sberify.presentation.ui.Injectable
import com.example.sberify.presentation.ui.albuminfo.AlbumInfoAdapter
import com.example.sberify.presentation.ui.newreleases.NewReleasesAdapter
import com.example.sberify.presentation.ui.utils.setDivider

class FavoriteFragment : BaseFragment(), Interaction, Injectable {

    private lateinit var favoriteViewModel: FavoriteViewModel
    private lateinit var tracksAdapter: AlbumInfoAdapter<Track>
    private lateinit var albumsAdapter: NewReleasesAdapter<Album>
    private lateinit var gridLayoutManager: StaggeredGridLayoutManager
    private lateinit var recyclerViewTracks: RecyclerView
    private lateinit var recyclerViewAlbums: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        initBinding<FragmentFavoriteBinding>(R.layout.fragment_favorite, container)
        favoriteViewModel = injectViewModel(viewModelFactory)
        tracksAdapter = AlbumInfoAdapter(this)
        albumsAdapter = NewReleasesAdapter(this)
        gridLayoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)

        recyclerViewTracks = mView.findViewById(R.id.favorite_tracks_recycler)
        recyclerViewAlbums = mView.findViewById(R.id.favorite_albums_recycler)

        recyclerViewTracks.apply {
            adapter = tracksAdapter
            setDivider(R.drawable.divider)
        }
        recyclerViewAlbums.apply {
            layoutManager = gridLayoutManager
            adapter = albumsAdapter
        }

        favoriteViewModel.favoriteTracks.observe(viewLifecycleOwner) {
            tracksAdapter.submitList(it)
        }

        favoriteViewModel.favoriteAlbums.observe(viewLifecycleOwner) {
            albumsAdapter.submitList(it)
        }
        favoriteViewModel.loadFavorite()
        return mView
    }

    override fun onItemSelected(position: Int, item: BaseModel, view: View) {
        if (item is Track) {
            sharedViewModel.getLyrics(item)
            val extras = FragmentNavigatorExtras(
                view.findViewById<TextView>(R.id.track_name) to item.name)
            findNavController().navigate(R.id.action_favoriteFragment_to_lyricsFragment, null, null,
                extras)
        } else if (item is Album) {
            sharedViewModel.getAlbumInfo(item)
            val extras = FragmentNavigatorExtras(
                view.findViewById<TextView>(R.id.release_name) to "${item.name}album",
                view.findViewById<ImageView>(R.id.release_cover) to "${item.imageUrl}album",
                view.findViewById<TextView>(R.id.artist_name) to "${item.artist.name}album")

            findNavController().navigate(R.id.action_favoriteFragment_to_albumInfoFragment2, null,
                null, extras)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupAnimations()
        recyclerViewAlbums.doOnPreDraw {
            startPostponedEnterTransition()
        }
    }
}