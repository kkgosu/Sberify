package com.example.sberify.presentation.ui.albuminfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.TransitionInflater
import com.example.sberify.R
import com.example.sberify.domain.model.Track
import com.example.sberify.presentation.ui.SharedViewModel
import com.example.sberify.presentation.ui.utils.loadImage

class AlbumInfoFragment : Fragment(
        R.layout.fragment_album_info_start), AlbumInfoAdapter.Interaction {

    private lateinit var mTracksRecyclerView: RecyclerView
    private lateinit var mAdapter: AlbumInfoAdapter
    private lateinit var mSharedViewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mAdapter = AlbumInfoAdapter(this)
        mSharedViewModel = ViewModelProvider(requireActivity()).get(
                SharedViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)!!
        val albumCover = view.findViewById<ImageView>(R.id.album_cover)
        val albumName = view.findViewById<TextView>(R.id.album_name)
        val artistName = view.findViewById<TextView>(R.id.artist_name)
        val releaseDate = view.findViewById<TextView>(R.id.release_date)
        mTracksRecyclerView = view.findViewById(R.id.recycler_tracks)
        mTracksRecyclerView.adapter = mAdapter

        mSharedViewModel.album.observe(viewLifecycleOwner, Observer {
            albumCover.apply {
                transitionName = it.id
                loadImage(it.imageUrl)
            }
            albumName.apply {
                transitionName = it.name
                text = it.name
            }
            artistName.apply {
                transitionName = it.artist.name
                text = it.artist.name
            }
            releaseDate.text = it.releaseDate
            it.tracks?.let { tracks ->
                mAdapter.submitList(tracks)
            }
        })
        sharedElementReturnTransition = TransitionInflater.from(context)
                .inflateTransition(android.R.transition.move)
        sharedElementEnterTransition = TransitionInflater.from(context)
                .inflateTransition(android.R.transition.move)
        postponeEnterTransition()

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        postponeEnterTransition()
        mTracksRecyclerView.viewTreeObserver.addOnPreDrawListener {
            startPostponedEnterTransition()
            true
        }
    }

    override fun onItemSelected(position: Int, item: Track, view: View) {
        mSharedViewModel.getLyrics(item)
        val extras = FragmentNavigatorExtras(
                view.findViewById<TextView>(R.id.track_name) to item.name)
        findNavController().navigate(R.id.action_albumInfoFragment_to_lyricsFragment, null,
                null, extras)
    }
}