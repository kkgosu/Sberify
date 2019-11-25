package com.example.sberify.presentation.ui.search

import android.graphics.drawable.Animatable
import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.appcompat.widget.SearchView
import androidx.core.view.forEach
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.example.sberify.R
import com.example.sberify.domain.model.Album
import com.example.sberify.domain.model.Artist
import com.example.sberify.domain.model.Track
import com.example.sberify.presentation.ui.MainActivity
import com.example.sberify.presentation.ui.SharedViewModel
import kotlinx.android.synthetic.main.bottom_app_bar.*


class SearchFragment : Fragment(R.layout.fragment_search), SearchAdapter.Interaction {

    private var searchType = SearchType.ARTIST

    private lateinit var resultsRecyclerView: RecyclerView
    private lateinit var mSearchAdapter: SearchAdapter
    private lateinit var mSuggestionsRecycler: RecyclerView
    private lateinit var mSuggestionsAdapter: SuggestionsAdapter
    private val list = listOf("Lorem", "Ipsum", "simply", "dummy", "text")

    private lateinit var mSharedViewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSharedViewModel = ViewModelProvider(requireActivity()).get(
                SharedViewModel::class.java)
        mSearchAdapter = SearchAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        resultsRecyclerView = view?.findViewById(R.id.search_results)!!
        mSuggestionsRecycler = view.findViewById(R.id.suggestion_recycler)!!
        val searchView = view.findViewById<SearchView>(R.id.search_view)
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

        mSuggestionsAdapter = SuggestionsAdapter()
        mSuggestionsRecycler.apply {
            adapter = mSuggestionsAdapter
            mSuggestionsAdapter.submitList(list)
        }

        resultsRecyclerView.adapter = mSearchAdapter

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
        configureSearchView(searchView)
        return view
    }

    override fun onResume() {
        super.onResume()
        (requireActivity() as MainActivity).apply {
            fab.setImageDrawable(getDrawable(R.drawable.avd_search_to_close))
            if (fab.drawable is AnimatedVectorDrawable) {
                ((fab.drawable) as AnimatedVectorDrawable).start()
            }
            bottomAppBar.replaceMenu(R.menu.another_bottom_menu)
            bottomAppBar.menu.forEach { (it.icon as? Animatable)?.start() }
        }
    }

    override fun onPause() {
        super.onPause()
        (requireActivity() as MainActivity).apply {
            bottomAppBar.menu[0].icon = AnimatedVectorDrawableCompat.create(this,
                    R.drawable.delete_scale_down)
            bottomAppBar.menu[1].icon = AnimatedVectorDrawableCompat.create(this,
                    R.drawable.delete_scale_down)
            bottomAppBar.menu.forEach { (it.icon as? Animatable)?.start() }
        }
    }

    override fun onArtistSelected(position: Int, item: Artist) {
        
    }

    override fun onTrackSelected(position: Int, item: Track) {
        
    }

    override fun onAlbumSelected(position: Int, item: Album) {
        
    }

    private fun configureSearchView(searchView: SearchView?) {
        searchView?.setOnQueryTextFocusChangeListener { _, hasFocus ->
            mSuggestionsRecycler.visibility = if (hasFocus) {
                mSuggestionsRecycler.scheduleLayoutAnimation()
                View.VISIBLE
            } else {
                View.GONE
            }
        }
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { query ->
                    mSuggestionsAdapter.submitList(list.filter { it.contains(query, true) })
                }
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()
                mSuggestionsRecycler.visibility = View.GONE
                when (searchType) {
                    SearchType.ARTIST -> mSharedViewModel.searchArtist(query!!)
                    SearchType.ALBUM -> mSharedViewModel.searchAlbum(query!!)
                    SearchType.TRACK -> mSharedViewModel.searchTrack(query!!)
                }
                return true
            }
        })
    }

    companion object {
        fun newInstance(): SearchFragment {
            val args = Bundle()
            val fragment = SearchFragment()
            fragment.arguments = args
            return fragment
        }
    }
}