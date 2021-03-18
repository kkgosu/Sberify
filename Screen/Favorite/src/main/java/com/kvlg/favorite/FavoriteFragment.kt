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
import com.kvlg.design.gone
import com.kvlg.favorite.databinding.FragmentFavoriteBinding
import com.kvlg.shared.SharedViewModel
import com.kvlg.spotify_common.adapters.AlbumInteraction
import com.kvlg.spotify_common.adapters.AlbumsHorizontalAdapter
import com.kvlg.spotify_common.adapters.TrackInteraction
import com.kvlg.spotify_common.adapters.TrackListedAdapter
import com.kvlg.spotify_common.presentation.AlbumModel
import com.kvlg.spotify_common.presentation.TrackModel
import com.kvlg.suggestion.Suggestion
import com.kvlg.suggestion.SuggestionAdapter
import com.kvlg.suggestion.SuggestionInteraction
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FavoriteFragment :
    BaseViewBindingFragment<FragmentFavoriteBinding>(),
    TrackInteraction,
    AlbumInteraction,
    SuggestionInteraction {

    @Inject
    lateinit var navigation: FavoriteNavigation

    private val favoriteViewModel: FavoriteViewModel by activityViewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()

    private val albumsHorizontalAdapter = AlbumsHorizontalAdapter(this)
    private val tracksAdapter = TrackListedAdapter(this)
    private val suggestionsAdapter = SuggestionAdapter(this)

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
            suggestionRecycler.adapter = suggestionsAdapter
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
        sharedViewModel.suggestions { suggestionsAdapter.items = it }
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

    override fun onSuggestionSelected(position: Int, item: Suggestion) {
        binding.searchView.setQuery(item.text, true)
    }

    override fun onResume() {
        super.onResume()
        hideKeyboard()
    }

    private fun setupSearchView() {
        binding.searchView.apply {
            clearFocus()
            (findViewById<View>(R.id.search_src_text) as EditText).apply {
                setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
                setHintTextColor(ContextCompat.getColor(requireContext(), R.color.gray_400))
            }
            findViewById<ImageView>(androidx.appcompat.R.id.search_close_btn)
                .setColorFilter(ContextCompat.getColor(requireContext(), R.color.white_100))

            setOnQueryTextFocusChangeListener { _, hasFocus ->
                binding.suggestionRecycler.visibility = if (hasFocus) {
                    binding.suggestionRecycler.scheduleLayoutAnimation()
                    showKeyboard()
                    View.VISIBLE
                } else {
                    hideKeyboard()
                    View.GONE
                }
            }

            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    query?.let {
                        sharedViewModel.insertSuggestion(it)
                        clearFocus()
                        binding.suggestionRecycler.gone()
                    }
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    newText?.let { query ->
                        this@FavoriteFragment.suggestionsAdapter.items = (
                                this@FavoriteFragment.suggestionsAdapter.items.filter { it.text.contains(query, true) }
                                )
                    }
                    return true
                }
            })
        }
    }
}