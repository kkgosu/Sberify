package com.kvlg.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
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

    override fun onResume() {
        super.onResume()
        hideOrShowKeyboard()
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
        val extras = FragmentNavigatorExtras(
            view to view.transitionName
        )

        navigation.navigateToLyrics(findNavController(), item, extras)
    }

    override fun onSuggestionSelected(position: Int, item: Suggestion) {
        binding.searchEditText.run {
            setText(item.text)
            onEditorAction(0)
            clearFocus()
        }
    }

    private fun setupSearchView() {
        binding.searchEditText.apply {
            clearFocus()
            addTextChangedListener {
                it?.let { input ->
                    suggestionsAdapter.items = suggestionsAdapter.items.filter { item -> item.text.contains(input, true) }
                }
            }

            setOnEditorActionListener { _, _, _ ->
                text?.toString()?.let {
                    hideKeyboard()
                    keyword = it
                    binding.suggestionRecycler.gone()
                    sharedViewModel.checkFiltersAndSearch(it)
                    sharedViewModel.insertSuggestion(it)
                }
                true
            }

            setOnFocusChangeListener { _, hasFocus ->
                binding.suggestionRecycler.visibility = if (hasFocus) {
                    binding.suggestionRecycler.scheduleLayoutAnimation()
                    View.VISIBLE
                } else {
                    View.GONE
                }
            }
        }
    }

    private fun setContentVisibility() {
        with(binding) {
            artistsResults.visible(sharedViewModel.isArtistChecked)
            artistTitleTextView.visible(sharedViewModel.isArtistChecked)
            albumsResults.visible(sharedViewModel.isAlbumChecked)
            albumsTitleTextView.visible(sharedViewModel.isAlbumChecked)
            tracksResults.visible(sharedViewModel.isTrackChecked)
            tracksTitleTextView.visible(sharedViewModel.isTrackChecked)
        }
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

    private fun hideOrShowKeyboard() {
        val editable = binding.searchEditText.text
        if (editable != null) {
            if (editable.isNotEmpty()) {
                binding.searchEditText.clearFocus()
                hideKeyboard()
            } else {
                binding.searchEditText.requestFocus()
                showKeyboard()
            }
        }
    }
}