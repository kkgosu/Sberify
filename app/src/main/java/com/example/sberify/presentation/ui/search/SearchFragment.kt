package com.example.sberify.presentation.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnNextLayout
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
import kotlinx.android.synthetic.main.fragment_search.*


class SearchFragment : BaseFragment(), AlbumInteraction, TrackInteraction,
    SuggestionsAdapter.Interaction {

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
            suggestionAdapter = SuggestionsAdapter(this@SearchFragment)
            searchAdapter = SearchAdapter(
                this@SearchFragment,
                this@SearchFragment
            )
            sharedVM = sharedViewModel
            suggestionRecyclerView = suggestionRecycler
            radioGroup = searchOptionsRg
        }.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        suggestion_recycler.visibility = View.GONE
        search_results.doOnNextLayout {
            startPostponedEnterTransition()
        }
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
        search_view.setQuery(query, true)
    }

    companion object {
        var CURRENT_SEARCH_TYPE: SearchType = SearchType.ARTIST
    }
}