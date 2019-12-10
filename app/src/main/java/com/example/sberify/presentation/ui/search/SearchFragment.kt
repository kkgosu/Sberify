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
import androidx.lifecycle.Observer
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.TransitionInflater
import com.example.sberify.R
import com.example.sberify.data.Result
import com.example.sberify.databinding.FragmentSearchBinding
import com.example.sberify.models.domain.*
import com.example.sberify.presentation.ui.BaseFragment


class SearchFragment : BaseFragment(), SearchAdapter.Interaction, SuggestionsAdapter.Interaction {

    private var searchType = SearchType.ARTIST

    private var isBack = false

    private lateinit var searchAdapter: SearchAdapter
    private lateinit var suggestionsAdapter: SuggestionsAdapter
    private lateinit var resultsRecyclerView: RecyclerView
    private lateinit var suggestionsRecycler: RecyclerView
    private var suggestions = emptyList<Suggestion>()

    private lateinit var searchView: SearchView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
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

        sharedViewModel.artist.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Result.Status.SUCCESS -> {
                    searchAdapter.submitList(it.data!!)
                    isBack = false
                }
                else -> {
                }
            }
        })
        sharedViewModel.albums.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Result.Status.SUCCESS -> {
                    searchAdapter.submitList(it.data!!)
                    isBack = false
                }
                else -> {
                }
            }
        })
        sharedViewModel.tracks.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Result.Status.SUCCESS -> {
                    searchAdapter.submitList(it.data!!)
                    isBack = false
                }
                else -> {
                }
            }
        })
        sharedViewModel.suggestions.observe(viewLifecycleOwner, Observer {
            suggestions = it
            suggestionsAdapter.submitList(suggestions)

        })
        return mView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        postponeEnterTransition()
        sharedElementReturnTransition = TransitionInflater.from(context)
                .inflateTransition(android.R.transition.move)
        resultsRecyclerView.doOnPreDraw {
            startPostponedEnterTransition()
        }
    }

    override fun onPause() {
        super.onPause()
        isBack = true
    }

    override fun onArtistSelected(position: Int, item: Artist, view: View) {

    }

    override fun onTrackSelected(position: Int, item: Track, view: View) {
        sharedViewModel.getLyrics(item)
        val extras = FragmentNavigatorExtras(
                view.findViewById<TextView>(R.id.name) to item.name)
        findNavController().navigate(R.id.action_searchFragment_to_lyricsFragment, null, null,
                extras)
    }

    override fun onAlbumSelected(item: Album, view: View) {
        sharedViewModel.getAlbumInfo(item)
        val extras = FragmentNavigatorExtras(
                view.findViewById<TextView>(R.id.release_name) to "${item.name}album",
                view.findViewById<ImageView>(R.id.release_cover) to "${item.imageUrl}album",
                view.findViewById<TextView>(R.id.artist_name) to "${item.artist.name}album")
        findNavController().navigate(R.id.action_searchFragment_to_albumInfoFragment, null, null,
                extras)
    }

    override fun onSuggestionSelected(position: Int, item: Suggestion) {
        val query = item.text
        searchView.setQuery(query, true)
    }

    override fun onResume() {
        super.onResume()
        suggestionsRecycler.visibility = View.GONE
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
                isBack = false
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
                        }
                        R.id.album_rb -> {
                            searchType = SearchType.ALBUM
                        }
                        R.id.track_rb -> {
                            searchType = SearchType.TRACK
                        }
                    }
                    searchAdapter.currentSearchType = searchType
                    if (!isBack) {
                        searchView.setQuery(searchView.query, true)
                    }
                }
    }

    override fun onItemSelected(position: Int, item: BaseModel, view: View) {
    }
}