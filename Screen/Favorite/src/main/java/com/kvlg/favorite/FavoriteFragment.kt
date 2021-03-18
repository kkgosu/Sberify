package com.kvlg.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearSnapHelper
import com.kvlg.design.BaseViewBindingFragment
import com.kvlg.favorite.databinding.FragmentFavoriteBinding
import com.kvlg.shared.SharedViewModel
import com.kvlg.spotify_common.adapters.AlbumInteraction
import com.kvlg.spotify_common.adapters.AlbumsHorizontalAdapter
import com.kvlg.spotify_common.adapters.TrackInteraction
import com.kvlg.spotify_common.adapters.TrackListedAdapter
import com.kvlg.spotify_common.presentation.AlbumModel
import com.kvlg.spotify_common.presentation.TrackModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FavoriteFragment :
    BaseViewBindingFragment<FragmentFavoriteBinding>(),
    TrackInteraction,
    AlbumInteraction {

    @Inject
    lateinit var navigation: FavoriteNavigation

    private val favoriteViewModel: FavoriteViewModel by activityViewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()

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
        setupSearchView()

        with(binding) {
            setupAnimationsForRecyclers(favoriteArtistsRecycler, favoriteAlbumsRecycler, favoriteTracksRecycler)
            favoriteTracksRecycler.adapter = tracksAdapter
            favoriteAlbumsRecycler.apply {
                adapter = albumsHorizontalAdapter
                LinearSnapHelper().attachToRecyclerView(this)
            }
        }

        with(favoriteViewModel) {
            favoriteAlbums { albumsHorizontalAdapter.items = it }
            favoriteTracks { tracksAdapter.items = it }
            loadFavorite()
        }
    }

    override fun onTrackSelected(item: TrackModel, view: View) {
        val extras = FragmentNavigatorExtras(
            view to view.transitionName
        )
        navigation.navigateToLyrics(findNavController(), item, extras)
    }

    override fun onAlbumSelected(item: AlbumModel, view: View) {
        sharedViewModel.getAlbumInfo(item)
        val extras = FragmentNavigatorExtras(
            view to view.transitionName
        )
        navigation.navigateToAlbumDetails(findNavController(), item, extras)
    }

    override fun onResume() {
        super.onResume()
        hideKeyboard()
    }

    //TODO: change to EditText
    private fun setupSearchView() {
        binding.searchView.apply {
            clearFocus()
            (findViewById<View>(R.id.search_src_text) as EditText).apply {
                setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
                setHintTextColor(ContextCompat.getColor(requireContext(), R.color.gray_400))
            }
            findViewById<ImageView>(androidx.appcompat.R.id.search_close_btn)
                .setColorFilter(ContextCompat.getColor(requireContext(), R.color.white_100))

            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String): Boolean {
                    favoriteViewModel.loadFavorite(newText)
                    return true
                }
            })
        }
    }
}