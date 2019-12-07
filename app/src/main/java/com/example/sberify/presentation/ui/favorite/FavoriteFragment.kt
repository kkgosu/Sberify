package com.example.sberify.presentation.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.sberify.R
import com.example.sberify.databinding.FragmentFavoriteBinding
import com.example.sberify.di.injectViewModel
import com.example.sberify.models.domain.BaseModel
import com.example.sberify.models.domain.Track
import com.example.sberify.presentation.ui.Interaction1
import com.example.sberify.presentation.ui.SharedViewModel
import com.example.sberify.presentation.ui.albuminfo.AlbumInfoAdapter
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class FavoriteFragment : Fragment(), Interaction1 {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var sharedViewModel: SharedViewModel
    private lateinit var favoriteViewModel: FavoriteViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var albumInfoAdapter: AlbumInfoAdapter<Track>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
        sharedViewModel = ViewModelProvider(requireActivity())
                .get(SharedViewModel::class.java)
        favoriteViewModel = injectViewModel(viewModelFactory)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        val binding: FragmentFavoriteBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_favorite, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        val view = binding.root
        // albumInfoAdapter = AlbumInfoAdapter(this)
        recyclerView = view.findViewById(R.id.favorite_recycler)
        recyclerView.adapter = albumInfoAdapter

        favoriteViewModel.favorite.observe(viewLifecycleOwner, Observer {
            albumInfoAdapter.submitList(it)
        })
        favoriteViewModel.loadFavorite()
        return view
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
}