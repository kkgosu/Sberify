package com.example.sberify.presentation.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.core.view.doOnPreDraw
import androidx.lifecycle.observe
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.sberify.R
import com.example.sberify.base.BaseFragment
import com.example.sberify.data.Result
import com.example.sberify.databinding.FragmentSearchBinding
import com.example.sberify.models.domain.Album
import com.example.sberify.models.domain.Artist
import com.example.sberify.models.domain.Suggestion
import com.example.sberify.models.domain.Track


class SearchFragment : BaseFragment(), SearchAdapter.Interaction, SuggestionsAdapter.Interaction {

    private var searchType = SearchType.ARTIST

    private lateinit var searchAdapter: SearchAdapter
    private lateinit var suggestionsAdapter: SuggestionsAdapter
    private lateinit var resultsRecyclerView: RecyclerView
    private lateinit var suggestionsRecycler: RecyclerView
    private var suggestions = emptyList<Suggestion>()

    private lateinit var searchView: SearchView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initBinding<FragmentSearchBinding>(R.layout.fragment_search, container)
        resultsRecyclerView = mView.findViewById(R.id.search_results)
        suggestionsRecycler = mView.findViewById(R.id.suggestion_recycler)

        searchAdapter = SearchAdapter(this)
        suggestionsAdapter = SuggestionsAdapter(this)

        resultsRecyclerView.adapter = searchAdapter
        suggestionsRecycler.apply {
            adapter = suggestionsAdapter
        }
        searchView = mView.findViewById(R.id.search_view)
        configureSearchView(searchView)
        setupArtistObserver()
        sharedViewModel.suggestions.observe(viewLifecycleOwner) {
            suggestions = it
            suggestionsAdapter.submitList(suggestions)
        }

        return mView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        resultsRecyclerView.doOnPreDraw {
            startPostponedEnterTransition()
        }
    }

    override fun onArtistSelected(position: Int, item: Artist, view: View) {

    }

    override fun onAlbumSelected(item: Album, view: View) {
        sharedViewModel.getAlbumInfo(item)
        val extras = FragmentNavigatorExtras(
            view.findViewById<TextView>(R.id.release_name) to "${item.name}album",
            view.findViewById<ImageView>(R.id.release_cover) to "${item.imageUrl}album",
            view.findViewById<TextView>(R.id.artist_name) to "${item.artist.name}album"
        )
        findNavController().navigate(
            R.id.action_searchFragment_to_albumInfoFragment, null, null,
            extras
        )
    }

    override fun onTrackSelected(position: Int, item: Track, view: View) {
        sharedViewModel.getLyrics(item)
        val extras = FragmentNavigatorExtras(
            view.findViewById<TextView>(R.id.name) to item.name
        )
        findNavController().navigate(
            R.id.action_searchFragment_to_lyricsFragment, null, null,
            extras
        )
    }

    override fun onSuggestionSelected(position: Int, item: Suggestion) {
        val query = item.text
        searchView.setQuery(query, true)
    }

    override fun onResume() {
        super.onResume()
        suggestionsRecycler.visibility = View.GONE
    }


    private fun setupArtistObserver() {
        sharedViewModel.tracks.removeObservers(viewLifecycleOwner)
        sharedViewModel.albums.removeObservers(viewLifecycleOwner)
        sharedViewModel.artist.observe(viewLifecycleOwner) {
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
        sharedViewModel.artist.removeObservers(viewLifecycleOwner)
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
        sharedViewModel.artist.removeObservers(viewLifecycleOwner)
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
    }
}