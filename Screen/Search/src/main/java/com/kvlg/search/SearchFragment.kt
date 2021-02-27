package com.kvlg.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearSnapHelper
import com.kvlg.core_utils.applyResultObserver
import com.kvlg.design.BaseViewBindingFragment
import com.kvlg.design.gone
import com.kvlg.design.onClick
import com.kvlg.design.visible
import com.kvlg.search.FilterBottomSheetFragment.Companion.ALBUM_SWITCH_CHECKED_KEY
import com.kvlg.search.FilterBottomSheetFragment.Companion.ARTIST_SWITCH_CHECKED_KEY
import com.kvlg.search.FilterBottomSheetFragment.Companion.TRACK_SWITCH_CHECKED_KEY
import com.kvlg.search.databinding.FragmentSearchBinding
import com.kvlg.shared.SharedViewModel
import com.kvlg.spotify_common.adapters.AlbumInteraction
import com.kvlg.spotify_common.adapters.AlbumsHorizontalAdapter
import com.kvlg.spotify_common.adapters.ArtistInteraction
import com.kvlg.spotify_common.adapters.ArtistsAdapter
import com.kvlg.spotify_common.adapters.TrackInteraction
import com.kvlg.spotify_common.adapters.TrackListedAdapter
import com.kvlg.spotify_common.presentation.AlbumModel
import com.kvlg.spotify_common.presentation.ArtistModel
import com.kvlg.spotify_common.presentation.TrackModel
import com.kvlg.suggestion.Suggestion
import com.kvlg.suggestion.SuggestionAdapter
import com.kvlg.suggestion.SuggestionInteraction
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SearchFragment :
    BaseViewBindingFragment<FragmentSearchBinding>(),
    AlbumInteraction,
    ArtistInteraction,
    TrackInteraction,
    SuggestionInteraction {

    @Inject
    lateinit var navigation: SearchNavigation

    private val sharedViewModel: SharedViewModel by activityViewModels()

    private val suggestionsAdapter = SuggestionAdapter(this)
    private val artistsAdapter = ArtistsAdapter(this)
    private val albumsAdapter = AlbumsHorizontalAdapter(this)
    private val tracksListedAdapter = TrackListedAdapter(this)

    private var keyword: String = ""

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupViews() {
        setupSearchView()
        setupAnimationsForRecyclers(binding.artistsResults, binding.albumsResults, binding.tracksResults)
        binding.suggestionRecycler.adapter = suggestionsAdapter
        binding.artistsResults.apply {
            adapter = artistsAdapter
            LinearSnapHelper().attachToRecyclerView(this)
        }
        binding.albumsResults.apply {
            adapter = albumsAdapter
            LinearSnapHelper().attachToRecyclerView(this)
        }
        binding.tracksResults.adapter = tracksListedAdapter
        binding.filterButton.onClick {
            showFilterBottomSheet()
            hideKeyboard()
        }

        sharedViewModel.artistsSearchResult.applyResultObserver(viewLifecycleOwner,
            success = {
                sharedViewModel.refreshContentVisibility()
                artistsAdapter.items = it
            },
            loading = { binding.artistTitleTextView.visibility = View.GONE },
            error = { shortToast(it.toString()) }
        )

        sharedViewModel.albumsSearchResult.applyResultObserver(viewLifecycleOwner,
            success = {
                sharedViewModel.refreshContentVisibility()
                albumsAdapter.items = it
            },
            loading = { binding.albumsTitleTextView.visibility = View.GONE },
            error = { shortToast(it.toString()) }
        )

        sharedViewModel.tracksSearchResult.applyResultObserver(viewLifecycleOwner,
            success = {
                sharedViewModel.refreshContentVisibility()
                tracksListedAdapter.items = it
            },
            loading = { binding.tracksTitleTextView.visibility = View.GONE },
            error = { shortToast(it.toString()) }
        )

        with(sharedViewModel) {
            suggestions { suggestionsAdapter.items = it }
            showFiltersFragment { showFilterBottomSheet() }
            refreshContentVisibility { setContentVisibility() }
        }

        childFragmentManager.setFragmentResultListener("requestKey", this) { _, bundle ->
            sharedViewModel.isArtistChecked = bundle.getBoolean(ARTIST_SWITCH_CHECKED_KEY, false)
            sharedViewModel.isAlbumChecked = bundle.getBoolean(ALBUM_SWITCH_CHECKED_KEY, false)
            sharedViewModel.isTrackChecked = bundle.getBoolean(TRACK_SWITCH_CHECKED_KEY, false)
            sharedViewModel.search(keyword)
        }
    }

    override fun onPause() {
        super.onPause()
        hideKeyboard()
    }

    override fun onAlbumSelected(item: AlbumModel, view: View) {
        sharedViewModel.getAlbumInfo(item)
        val extras = FragmentNavigatorExtras(
            view to view.transitionName
        )

        navigation.navigateToAlbumDetails(findNavController(), item, extras)
    }

    override fun onArtistSelected(item: ArtistModel, view: View) {

    }

    override fun onTrackSelected(item: TrackModel, view: View) {
        sharedViewModel.getLyrics(item)
        val extras = FragmentNavigatorExtras(
            view to view.transitionName
        )

        navigation.navigateToLyrics(findNavController(), item, extras)
    }

    override fun onSuggestionSelected(position: Int, item: Suggestion) {
        binding.searchView.setQuery(item.text, true)
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
                    sharedViewModel.getAllSuggestions()
                    binding.suggestionRecycler.scheduleLayoutAnimation()
                    showKeyboard()
                    View.VISIBLE
                } else {
                    View.GONE
                }
            }

            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    query?.let {
                        sharedViewModel.insertSuggestion(it)
                        keyword = it
                        clearFocus()
                        binding.suggestionRecycler.gone()
                    }
                    sharedViewModel.checkFiltersAndSearch(keyword)
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    newText?.let { query ->
                        this@SearchFragment.suggestionsAdapter.items = (
                                this@SearchFragment.suggestionsAdapter.items.filter { it.text.contains(query, true) }
                                )
                    }
                    return true
                }
            })

            if (artistsAdapter.itemCount == 0 && albumsAdapter.itemCount == 0 && tracksListedAdapter.itemCount == 0) {
                requestFocus()
                binding.suggestionRecycler.visible()
            } else {
                clearFocus()
                binding.suggestionRecycler.gone()
            }
        }
    }

    private fun setContentVisibility() {
        binding.artistsResults.visible(sharedViewModel.isArtistChecked)
        binding.artistTitleTextView.visible(sharedViewModel.isArtistChecked)
        binding.albumsResults.visible(sharedViewModel.isAlbumChecked)
        binding.albumsTitleTextView.visible(sharedViewModel.isAlbumChecked)
        binding.tracksResults.visible(sharedViewModel.isTrackChecked)
        binding.tracksTitleTextView.visible(sharedViewModel.isTrackChecked)
    }

    private fun showFilterBottomSheet() {
        val bundle = bundleOf(
            ARTIST_SWITCH_CHECKED_KEY to sharedViewModel.isArtistChecked,
            ALBUM_SWITCH_CHECKED_KEY to sharedViewModel.isAlbumChecked,
            TRACK_SWITCH_CHECKED_KEY to sharedViewModel.isTrackChecked
        )
        childFragmentManager.setFragmentResult("showFilter", bundle)
        FilterBottomSheetFragment().show(childFragmentManager, FilterBottomSheetFragment.TAG)
    }


}