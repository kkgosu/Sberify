package com.example.sberify.presentation.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.sberify.R
import com.example.sberify.base.BaseFragment
import com.example.sberify.databinding.FragmentSearchBinding
import com.example.sberify.models.domain.Album
import com.example.sberify.models.domain.Artist
import com.example.sberify.models.domain.Suggestion
import com.example.sberify.models.domain.Track
import kotlinx.android.synthetic.main.fragment_search.*


class SearchFragment : BaseFragment(), SearchAdapter.Interaction, SuggestionsAdapter.Interaction {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentSearchBinding>(
            inflater,
            R.layout.fragment_search,
            container
        ).apply {
            lifecycleOwner = this@SearchFragment
            fragment = this@SearchFragment
            suggestionAdapter = SuggestionsAdapter(this@SearchFragment)
            searchAdapter = SearchAdapter(this@SearchFragment)
            sharedVM = sharedViewModel
            suggestionRecyclerView = suggestionRecycler
            radioGroup = searchOptionsRg
        }.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        search_results.doOnPreDraw {
            startPostponedEnterTransition()
        }
    }

    override fun onArtistSelected(position: Int, item: Artist, view: View) {

    }

    override fun onAlbumSelected(item: Album, view: View) {
        sharedViewModel.getAlbumInfo(item)
        val extras = FragmentNavigatorExtras(
            view to view.transitionName
        )
        findNavController().navigate(
            R.id.action_searchFragment_to_albumInfoFragment, null, null,
            extras
        )
    }

    override fun onTrackSelected(position: Int, item: Track, view: View) {
        sharedViewModel.getLyrics(item)
        val extras = FragmentNavigatorExtras(
            view to view.transitionName
        )
        findNavController().navigate(
            R.id.action_searchFragment_to_lyricsFragment, null, null,
            extras
        )
    }

    override fun onSuggestionSelected(position: Int, item: Suggestion) {
        val query = item.text
        search_view.setQuery(query, true)
    }

    override fun onResume() {
        super.onResume()
        suggestion_recycler.visibility = View.GONE
    }


/*    private fun setupArtistObserver() {
        sharedViewModel.tracks.removeObservers(viewLifecycleOwner)
        sharedViewModel.albums.removeObservers(viewLifecycleOwner)
        sharedViewModel.artists.observe(viewLifecycleOwner) {
            when (it.status) {
                Result.Status.SUCCESS -> {
                    if (searchType == SearchType.ARTIST) {
                        SearchAdapter.currentSearchType = searchType
                        searchAdapter.submitList(it.data!!)
                    }
                }
            }
        }
    }

    private fun setupAlbumObserver() {
        sharedViewModel.tracks.removeObservers(viewLifecycleOwner)
        sharedViewModel.artists.removeObservers(viewLifecycleOwner)
        sharedViewModel.albums.observe(viewLifecycleOwner) {
            when (it.status) {
                Result.Status.SUCCESS -> {
                    if (searchType == SearchType.ALBUM) {
                        SearchAdapter.currentSearchType = searchType
                        searchAdapter.submitList(it.data!!)
                    }
                }
            }
        }
    }

    private fun setupTrackObserver() {
        sharedViewModel.artists.removeObservers(viewLifecycleOwner)
        sharedViewModel.albums.removeObservers(viewLifecycleOwner)
        sharedViewModel.tracks.observe(viewLifecycleOwner) {
            when (it.status) {
                Result.Status.SUCCESS -> {
                    if (searchType == SearchType.TRACK) {
                        SearchAdapter.currentSearchType = searchType
                        searchAdapter.submitList(it.data!!)
                    }
                }
            }
        }
    }

    private fun configureSearchView(sView: SearchView?) {
        sView?.setOnQueryTextFocusChangeListener { _, hasFocus ->
            suggestionsRecycler.visibility = if (hasFocus) {
                sharedViewModel.getAllSuggestions()
                suggestionsRecycler.scheduleLayoutAnimation()
                View.VISIBLE
            } else {
                View.GONE
            }
        }
        sView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { query ->
                    suggestionsAdapter.submitList(
                        suggestions.filter { it.text.contains(query, true) })
                }
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                sharedViewModel.insertSuggestion(query!!)
                sharedViewModel.search(query, searchType)
                sView.clearFocus()
                suggestionsRecycler.visibility = View.GONE
                return true
            }
        })
        mView.findViewById<RadioGroup>(R.id.search_options_rg)
            .setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    R.id.artist_rb -> {
                        searchType = SearchType.ARTIST
                        setupArtistObserver()
                    }
                    R.id.album_rb -> {
                        searchType = SearchType.ALBUM
                        setupAlbumObserver()
                    }
                    R.id.track_rb -> {
                        searchType = SearchType.TRACK
                        setupTrackObserver()
                    }
                }
            }
    }*/
}