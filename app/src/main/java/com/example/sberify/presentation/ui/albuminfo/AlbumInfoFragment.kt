package com.example.sberify.presentation.ui.albuminfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.doOnPreDraw
import androidx.databinding.OnRebindCallback
import androidx.lifecycle.Observer
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.sberify.R
import com.example.sberify.data.Result
import com.example.sberify.databinding.FragmentAlbumInfoStartBinding
import com.example.sberify.models.domain.BaseModel
import com.example.sberify.models.domain.Track
import com.example.sberify.presentation.ui.BaseFragment
import com.example.sberify.presentation.ui.Interaction

class AlbumInfoFragment : BaseFragment(), Interaction {

    private lateinit var tracksRecyclerView: RecyclerView
    private lateinit var albumInfoAdapter: AlbumInfoAdapter<Track>

    private var isBack = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        initBinding<FragmentAlbumInfoStartBinding>(R.layout.fragment_album_info_start, container)
                .viewModel = sharedViewModel
        val toolbar = mView.findViewById<Toolbar>(R.id.collapsed_toolbar)
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        albumInfoAdapter = AlbumInfoAdapter(this)
        tracksRecyclerView = mView.findViewById(R.id.recycler_tracks)
        tracksRecyclerView.adapter = albumInfoAdapter

        sharedViewModel.album.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Result.Status.SUCCESS -> {
                    binding.invalidateAll()
                    binding.addOnRebindCallback(object : OnRebindCallback<FragmentAlbumInfoStartBinding>() {
                        override fun onBound(binding: FragmentAlbumInfoStartBinding?) {
                            startPostponedEnterTransition(isBack)
                        }
                    })
                    it.data?.let { album ->
                        album.tracks?.let { tracks ->
                            albumInfoAdapter.submitList(tracks)
                        }
                    }
                }
                else -> {
                }
            }

        })
        return mView
    }

    private fun startPostponedEnterTransition(flag: Boolean) {
        if (flag) {
            tracksRecyclerView.doOnPreDraw {
                startPostponedEnterTransition()
                isBack = !flag
            }
        } else {
            startPostponedEnterTransition()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupAnimations()
    }

    override fun onItemSelected(position: Int, item: BaseModel, view: View) {
        if (item is Track) {
            isBack = true
            sharedViewModel.getLyrics(item)
            val extras = FragmentNavigatorExtras(
                    view.findViewById<TextView>(R.id.track_name) to item.name,
                    mView.findViewById<ImageView>(R.id.album_cover) to "${item.image?.url}")
            findNavController().navigate(R.id.action_albumInfoFragment_to_lyricsFragment, null,
                    null, extras)
        }
    }
}