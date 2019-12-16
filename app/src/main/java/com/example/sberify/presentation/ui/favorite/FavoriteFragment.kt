package com.example.sberify.presentation.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.sberify.R
import com.example.sberify.databinding.FragmentFavoriteBinding
import com.example.sberify.di.injectViewModel
import com.example.sberify.models.domain.BaseModel
import com.example.sberify.models.domain.Track
import com.example.sberify.presentation.ui.BaseFragment
import com.example.sberify.presentation.ui.Injectable
import com.example.sberify.presentation.ui.Interaction
import com.example.sberify.presentation.ui.albuminfo.AlbumInfoAdapter
import com.example.sberify.presentation.ui.utils.setDivider

class FavoriteFragment : BaseFragment(), Interaction, Injectable {
    
    private lateinit var favoriteViewModel: FavoriteViewModel
    private lateinit var albumInfoAdapter: AlbumInfoAdapter<Track>
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        initBinding<FragmentFavoriteBinding>(R.layout.fragment_favorite, container)
        favoriteViewModel = injectViewModel(viewModelFactory)
        albumInfoAdapter = AlbumInfoAdapter(this)
        val recyclerView: RecyclerView = mView.findViewById(R.id.favorite_recycler)
        recyclerView.apply {
            adapter = albumInfoAdapter
            setDivider(R.drawable.divider)
        }
        favoriteViewModel.favorite.observe(viewLifecycleOwner, Observer {
            albumInfoAdapter.submitList(it)
            startPostponedEnterTransition()
        })
        favoriteViewModel.loadFavorite()
        return mView
    }

    override fun onItemSelected(position: Int, item: BaseModel, view: View) {
        if (item is Track) {
            sharedViewModel.getLyrics(item)
            val extras = FragmentNavigatorExtras(
                    view.findViewById<TextView>(R.id.track_name) to item.name)
            findNavController().navigate(R.id.action_favoriteFragment_to_lyricsFragment, null, null,
                    extras)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupAnimations()
    }
}