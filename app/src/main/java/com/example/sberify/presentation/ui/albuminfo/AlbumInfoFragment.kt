package com.example.sberify.presentation.ui.albuminfo

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
import androidx.transition.TransitionInflater
import com.example.sberify.R
import com.example.sberify.databinding.FragmentAlbumInfoStartBinding
import com.example.sberify.models.domain.Track
import com.example.sberify.presentation.ui.SharedViewModel

class AlbumInfoFragment : Fragment(), AlbumInfoAdapter.Interaction {

    private lateinit var tracksRecyclerView: RecyclerView
    private lateinit var albumInfoAdapter: AlbumInfoAdapter
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        albumInfoAdapter = AlbumInfoAdapter(this)
        sharedViewModel = ViewModelProvider(requireActivity()).get(
                SharedViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        val binding: FragmentAlbumInfoStartBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_album_info_start, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = sharedViewModel
        val view = binding.root
        tracksRecyclerView = view.findViewById(R.id.recycler_tracks)
        tracksRecyclerView.adapter = albumInfoAdapter

        sharedViewModel.album.observe(viewLifecycleOwner, Observer {
            it.tracks?.let { tracks ->
                albumInfoAdapter.submitList(tracks)
            }
        })
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        sharedElementReturnTransition = TransitionInflater.from(context)
                .inflateTransition(android.R.transition.move)
        sharedElementEnterTransition = TransitionInflater.from(context)
                .inflateTransition(android.R.transition.move)
        postponeEnterTransition()
        tracksRecyclerView.viewTreeObserver.addOnPreDrawListener {
            startPostponedEnterTransition()
            true
        }
    }

    override fun onItemSelected(position: Int, item: Track, view: View) {
        sharedViewModel.getLyrics(item)
        val extras = FragmentNavigatorExtras(
                view.findViewById<TextView>(R.id.track_name) to item.name)
        findNavController().navigate(R.id.action_albumInfoFragment_to_lyricsFragment, null,
                null, extras)
    }
}