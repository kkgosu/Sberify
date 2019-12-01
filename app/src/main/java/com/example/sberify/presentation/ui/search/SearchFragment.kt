package com.example.sberify.presentation.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.TransitionInflater
import com.example.sberify.R
import com.example.sberify.domain.model.Album
import com.example.sberify.domain.model.Artist
import com.example.sberify.domain.model.Suggestion
import com.example.sberify.domain.model.Track
import com.example.sberify.presentation.ui.SharedViewModel
import com.example.sberify.presentation.ui.albuminfo.AlbumInfoFragment
import com.example.sberify.presentation.ui.lyrics.LyricsFragment


class SearchFragment : Fragment(
        R.layout.fragment_search), SearchAdapter.Interaction, SuggestionsAdapter.Interaction {
    private var searchType = SearchType.ARTIST

    private lateinit var resultsRecyclerView: RecyclerView
    private lateinit var mSearchAdapter: SearchAdapter
    private lateinit var mSuggestionsRecycler: RecyclerView
    private lateinit var mSuggestionsAdapter: SuggestionsAdapter
    private var list = emptyList<Suggestion>()

    private lateinit var mSharedViewModel: SharedViewModel

    private lateinit var mSearchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSharedViewModel = ViewModelProvider(requireActivity()).get(
                SharedViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        resultsRecyclerView = view?.findViewById(R.id.search_results)!!
        mSuggestionsRecycler = view.findViewById(R.id.suggestion_recycler)!!

        mSearchAdapter = SearchAdapter(this)
        mSuggestionsAdapter = SuggestionsAdapter(this)

        resultsRecyclerView.adapter = mSearchAdapter
        mSuggestionsRecycler.apply {
            adapter = mSuggestionsAdapter
        }
        mSearchView = view.findViewById(R.id.search_view)
        view.findViewById<RadioGroup>(R.id.search_options_rg)
                .setOnCheckedChangeListener { _, checkedId ->
                    when (checkedId) {
                        R.id.artist_rb -> {
                            searchType = SearchType.ARTIST
                        }
                        R.id.album_rb -> {
                            searchType = SearchType.ALBUM
                        }
                        R.id.track_rb -> {
                            searchType = SearchType.TRACK
                        }
                    }
                }

        mSharedViewModel.artist.observe(viewLifecycleOwner, Observer {
            mSearchAdapter.currentSearchType = SearchType.ARTIST
            mSearchAdapter.submitList(it)
        })
        mSharedViewModel.albums.observe(viewLifecycleOwner, Observer {
            mSearchAdapter.currentSearchType = SearchType.ALBUM
            mSearchAdapter.submitList(it)
        })
        mSharedViewModel.track.observe(viewLifecycleOwner, Observer {
            mSearchAdapter.currentSearchType = SearchType.TRACK
            mSearchAdapter.submitList(it)
        })
        mSharedViewModel.suggestions.observe(viewLifecycleOwner, Observer {
            list = it
            mSuggestionsAdapter.submitList(list)

        })
        configureSearchView(mSearchView)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        sharedElementReturnTransition = TransitionInflater.from(context)
                .inflateTransition(android.R.transition.move)
        postponeEnterTransition()
        resultsRecyclerView.viewTreeObserver.addOnPreDrawListener {
            startPostponedEnterTransition()
            true
        }
    }

    override fun onArtistSelected(position: Int, item: Artist) {

    }

    override fun onTrackSelected(position: Int, item: Track) {
        mSharedViewModel.getLyrics(item)
        findNavController().navigate(R.id.action_searchFragment_to_lyricsFragment2)
    }

    override fun onAlbumSelected(item: Album, view: View) {
        mSharedViewModel.getAlbumInfo(item)
        val extras = FragmentNavigatorExtras(
                view.findViewById<TextView>(R.id.release_name) to item.name,
                view.findViewById<ImageView>(R.id.release_cover) to item.id,
                view.findViewById<TextView>(R.id.artist_name) to item.artist.name)
        findNavController().navigate(R.id.action_searchFragment_to_albumInfoFragment, null, null,
                extras)
    }

    override fun onSuggestionSelected(position: Int, item: Suggestion) {
        val query = item.text
        mSearchView.setQuery(query, true)
    }

    private fun configureSearchView(searchView: SearchView?) {
        searchView?.setOnQueryTextFocusChangeListener { _, hasFocus ->
            mSuggestionsRecycler.visibility = if (hasFocus) {
                mSharedViewModel.getAllSuggestions()
                mSuggestionsRecycler.scheduleLayoutAnimation()
                View.VISIBLE
            } else {
                View.GONE
            }
        }
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { query ->
                    mSuggestionsAdapter.submitList(list.filter { it.text.contains(query, true) })
                }
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                mSharedViewModel.insertSuggestion(query!!)
                searchView.clearFocus()
                mSuggestionsRecycler.visibility = View.GONE
                when (searchType) {
                    SearchType.ARTIST -> mSharedViewModel.searchArtist(query)
                    SearchType.ALBUM -> mSharedViewModel.searchAlbum(query)
                    SearchType.TRACK -> mSharedViewModel.searchTrack(query)
                }
                return true
            }
        })
    }
}