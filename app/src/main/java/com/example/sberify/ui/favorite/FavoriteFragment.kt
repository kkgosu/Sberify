package com.example.sberify.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearSnapHelper
import com.example.sberify.adapters.AlbumInteraction
import com.example.sberify.adapters.AlbumsHorizontalAdapter
import com.example.sberify.adapters.TrackInteraction
import com.example.sberify.adapters.TrackListedAdapter
import com.example.sberify.base.BaseViewBindingFragment
import com.example.sberify.databinding.FragmentFavoriteBinding
import com.example.sberify.ui.SharedViewModel
import com.example.sberify.ui.lyrics.LyricsViewModel
import com.kvlg.model.presentation.Album
import com.kvlg.model.presentation.Track
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment :
    BaseViewBindingFragment<FragmentFavoriteBinding>(),
    TrackInteraction,
    AlbumInteraction {

    private val favoriteViewModel: FavoriteViewModel by activityViewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val lyricsViewModel: LyricsViewModel by activityViewModels()

    private val albumsHorizontalAdapter = AlbumsHorizontalAdapter(this)
    private val tracksAdapter = TrackListedAdapter(this)

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupViews() {
        setupAnimationsForRecyclers(binding.favoriteAlbumsRecycler, binding.favoriteTracksRecycler)
        binding.favoriteAlbumsRecycler.apply {
            adapter = albumsHorizontalAdapter
            LinearSnapHelper().attachToRecyclerView(this)
        }
        binding.favoriteTracksRecycler.adapter = tracksAdapter

        favoriteViewModel.favoriteAlbums.observe(viewLifecycleOwner) {
            albumsHorizontalAdapter.items = it
        }

        favoriteViewModel.favoriteTracks.observe(viewLifecycleOwner) {
            tracksAdapter.items = it
        }

        favoriteViewModel.loadFavorite()
    }

    override fun onTrackSelected(item: Track, view: View) {
        lyricsViewModel.getLyrics(item)
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