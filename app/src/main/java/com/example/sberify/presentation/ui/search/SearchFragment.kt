package com.example.sberify.presentation.ui.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.core.view.doOnNextLayout
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.observe
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearSnapHelper
import com.example.sberify.R
import com.example.sberify.adapters.*
import com.example.sberify.base.BaseFragment
import com.example.sberify.databinding.FragmentSearchBinding
import com.example.sberify.models.domain.Album
import com.example.sberify.models.domain.Suggestion
import com.example.sberify.models.domain.Track
import com.example.sberify.presentation.ui.search.FilterBottomSheetFragment.Companion.ALBUM_SWITCH_CHECKED_KEY
import com.example.sberify.presentation.ui.search.FilterBottomSheetFragment.Companion.ARTIST_SWITCH_CHECKED_KEY
import com.example.sberify.presentation.ui.search.FilterBottomSheetFragment.Companion.TRACK_SWITCH_CHECKED_KEY
import com.example.sberify.presentation.ui.utils.applyResultObserver
import com.example.sberify.presentation.ui.utils.visible
import com.google.android.material.transition.Hold
import com.google.android.material.transition.MaterialArcMotion
import com.google.android.material.transition.MaterialContainerTransform


class SearchFragment : BaseFragment(),
    AlbumInteraction, TrackInteraction,
    SuggestionInteraction {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private val suggestionsAdapter = SuggestionAdapter(this)
    private val artistsAdapter = AlbumsAdapter(this)
    private val albumsAdapter = AlbumsHorizontalAdapter(this)
    private val tracksListedAdapter = TrackListedAdapter(this)

    private var keyword: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        postponeEnterTransition()
        sharedElementEnterTransition = MaterialContainerTransform().apply {
            setPathMotion(MaterialArcMotion())
            duration = 450
        }
        exitTransition = Hold().apply {
            duration = 450
        }
        binding.suggestionRecycler.adapter = suggestionsAdapter
        binding.artistsResults.apply {
            doOnNextLayout {
                startPostponedEnterTransition()
            }
        }
        binding.albumsResults.apply {
            doOnNextLayout {
                startPostponedEnterTransition()
            }
            adapter = albumsAdapter
            LinearSnapHelper().attachToRecyclerView(this)
        }
        binding.tracksResults.apply {
            doOnNextLayout {
                startPostponedEnterTransition()
            }
            adapter = tracksListedAdapter
        }
        (binding.searchView.findViewById<View>(R.id.search_src_text) as EditText).apply {
            setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.white
                )
            )
            setHintTextColor(ContextCompat.getColor(requireContext(), R.color.gray_400))
        }
        binding.searchView.findViewById<ImageView>(androidx.appcompat.R.id.search_close_btn)
            .setColorFilter(ContextCompat.getColor(requireContext(), R.color.white_100))

        binding.filterButton.setOnClickListener {
            showFilterBottomSheet()
            hideKeyboard()
        }

        binding.searchView.apply {
            clearFocus()
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
                        binding.suggestionRecycler.visibility = View.GONE
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
        }

        if (artistsAdapter.itemCount == 0 && albumsAdapter.itemCount == 0 && tracksListedAdapter.itemCount == 0) {
            binding.searchView.requestFocus()
            binding.suggestionRecycler.visibility = View.VISIBLE
        } else {
            binding.searchView.clearFocus()
            binding.suggestionRecycler.visibility = View.GONE
        }

        sharedViewModel.artistsSearchResult.applyResultObserver(viewLifecycleOwner,
            success = {
                sharedViewModel.refreshContentVisibility()
                artistsAdapter.items = it
            },
            loading = { binding.artistTitleTextView.visibility = View.GONE },
            error = { Toast.makeText(requireContext(), "$it", Toast.LENGTH_SHORT).show() }
        )

        sharedViewModel.albumsSearchResult.applyResultObserver(viewLifecycleOwner,
            success = {
                sharedViewModel.refreshContentVisibility()
                albumsAdapter.items = it
            },
            loading = { binding.albumsTitleTextView.visibility = View.GONE },
            error = { Toast.makeText(requireContext(), "$it", Toast.LENGTH_SHORT).show() }
        )

        sharedViewModel.tracksSearchResult.applyResultObserver(viewLifecycleOwner,
            success = {
                sharedViewModel.refreshContentVisibility()
                tracksListedAdapter.items = it
            },
            loading = { binding.tracksTitleTextView.visibility = View.GONE },
            error = { Toast.makeText(requireContext(), "$it", Toast.LENGTH_SHORT).show() }
        )

        sharedViewModel.suggestions.observe(viewLifecycleOwner) { suggestionsAdapter.items = it }
        sharedViewModel.showFiltersFragment.observe(viewLifecycleOwner) { showFilterBottomSheet() }
        sharedViewModel.refreshContentVisibility.observe(viewLifecycleOwner) { setContentVisibility() }

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

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onAlbumSelected(item: Album, view: View) {
        sharedViewModel.getAlbumInfo(item)
        val extras = FragmentNavigatorExtras(
            view to view.transitionName
        )
        findNavController().navigate(
            SearchFragmentDirections.actionSearchFragmentToAlbumInfoFragment(item),
            extras
        )
    }

    override fun onTrackSelected(item: Track, view: View) {
        sharedViewModel.getLyrics(item)
        val extras = FragmentNavigatorExtras(
            view to view.transitionName
        )
        findNavController().navigate(
            SearchFragmentDirections.actionSearchFragmentToLyricsFragment(item),
            extras
        )
    }

    override fun onSuggestionSelected(position: Int, item: Suggestion) {
        binding.searchView.setQuery(item.text, true)
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

    private fun showKeyboard() {
        val imm: InputMethodManager = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    }

    private fun hideKeyboard() {
        val imm: InputMethodManager = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(requireActivity().currentFocus?.windowToken, 0)
    }
}