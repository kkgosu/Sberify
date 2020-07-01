package com.example.sberify.presentation.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.core.view.doOnNextLayout
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.sberify.R
import com.example.sberify.adapters.AlbumInteraction
import com.example.sberify.adapters.SearchAdapter
import com.example.sberify.adapters.TrackInteraction
import com.example.sberify.base.BaseFragment
import com.example.sberify.databinding.FragmentSearchBinding
import com.example.sberify.models.domain.Album
import com.example.sberify.models.domain.Suggestion
import com.example.sberify.models.domain.Track
import com.example.sberify.presentation.ui.SharedViewModel


class SearchFragment : BaseFragment(),
    AlbumInteraction, TrackInteraction,
    SuggestionsAdapter.Interaction {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private lateinit var searchAdapter: SearchAdapter
    private lateinit var suggestionsAdapter: SuggestionsAdapter

    private val viewModel by activityViewModels<SharedViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        searchAdapter = SearchAdapter(this, this)
        suggestionsAdapter = SuggestionsAdapter(this)
        viewModel.suggestions.observe(this, suggestionsAdapter::submitList)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.suggestionRecycler.visibility = View.GONE
        binding.searchResults.doOnNextLayout {
            startPostponedEnterTransition()
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
        if (searchAdapter.itemCount == 0) {
            binding.searchView.requestFocus()
        } else {
            binding.searchView.clearFocus()
        }

        binding.filterButton.setOnClickListener {
            showFilterBottomSheet()
        }

        binding.searchView.apply {
            setOnQueryTextFocusChangeListener { _, hasFocus ->
                binding.suggestionRecycler.visibility = if (hasFocus) {
                    viewModel.getAllSuggestions()
                    binding.suggestionRecycler.scheduleLayoutAnimation()
                    View.VISIBLE
                } else {
                    View.GONE
                }
            }

            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    query?.let {
                        viewModel.insertSuggestion(it)
                        viewModel.search(it)
                        clearFocus()
                        binding.suggestionRecycler.visibility = View.GONE
                    }

                    if (!viewModel.isAlbumChecked && !viewModel.isArtistChecked && !viewModel.isTrackChecked) {
                        showFilterBottomSheet()
                    }
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    newText?.let { query ->
                        this@SearchFragment.suggestionsAdapter.submitList(
                            this@SearchFragment.suggestionsAdapter.getList().filter { it.text.contains(query, true) }
                        )
                    }
                    return true
                }
            })
        }
    }

    private fun showFilterBottomSheet() {
        FilterBottomSheetFragment
            .newInstance(viewModel.isAlbumChecked, viewModel.isArtistChecked, viewModel.isTrackChecked)
            .show(requireActivity().supportFragmentManager, FilterBottomSheetFragment.TAG)
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
        val query = item.text
        binding.searchView.setQuery(query, true)
    }
}