package com.example.sberify.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.sberify.R
import com.example.sberify.domain.model.Album

class AlbumInfoFragment : Fragment(R.layout.fragment_album_info) {

    private lateinit var mTracksRecyclerView: RecyclerView
    private lateinit var mAdapter: AlbumInfoAdapter
    private lateinit var mSharedViewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        mAdapter = AlbumInfoAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        mTracksRecyclerView = view!!.findViewById(R.id.recycler_tracks)
        mTracksRecyclerView.adapter = mAdapter
        mSharedViewModel.album.observe(viewLifecycleOwner, Observer {
            view.findViewById<ImageView>(R.id.album_cover)
                    .loadImage(it.imageUrl)
            view.findViewById<TextView>(R.id.album_name)
                    .setText(it.name)
            view.findViewById<TextView>(R.id.artist_name)
                    .setText(it.artist.name)
            it.tracks?.let { tracks ->
                mAdapter.submitList(tracks)
            }
        })
        return view
    }

    companion object {
        fun newInstance(): AlbumInfoFragment {
            val args = Bundle()
            val fragment = AlbumInfoFragment()
            fragment.arguments = args
            return fragment
        }
    }
}