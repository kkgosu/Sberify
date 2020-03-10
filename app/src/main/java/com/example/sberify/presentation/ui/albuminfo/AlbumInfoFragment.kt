package com.example.sberify.presentation.ui.albuminfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.doOnPreDraw
import androidx.databinding.OnRebindCallback
import androidx.lifecycle.observe
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.sberify.R
import com.example.sberify.base.BaseFragment
import com.example.sberify.base.Interaction
import com.example.sberify.data.Result
import com.example.sberify.databinding.FragmentAlbumDetailsBinding
import com.example.sberify.models.domain.BaseModel
import com.example.sberify.models.domain.Track
import com.example.sberify.presentation.ui.utils.setDivider

class AlbumInfoFragment : BaseFragment(), Interaction {

    private lateinit var tracksRecyclerView: RecyclerView
    private lateinit var albumInfoAdapter: AlbumInfoAdapter<Track>
    private lateinit var favoriteButton: ImageButton

    private var isBack = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initBinding<FragmentAlbumDetailsBinding>(R.layout.fragment_album_details, container).apply {
            viewModel = sharedViewModel
            fragment = this@AlbumInfoFragment
            setContainer(detailContainer)
            fab = fabFavorite
        }
        setupToolbar()
        albumInfoAdapter = AlbumInfoAdapter(this)
        tracksRecyclerView = mView.findViewById(R.id.recycler_tracks)
        tracksRecyclerView.apply {
            adapter = albumInfoAdapter
            setDivider(R.drawable.divider)
        }

        favoriteButton = mView.findViewById(R.id.fab_favorite)

        sharedViewModel.album.observe(viewLifecycleOwner) {
            when (it.status) {
                Result.Status.SUCCESS -> {
                    binding.invalidateAll()
                    binding.addOnRebindCallback(object :
                        OnRebindCallback<FragmentAlbumDetailsBinding>() {
                        override fun onBound(binding: FragmentAlbumDetailsBinding?) {
                            startPostponedEnterTransition(isBack)
                        }
                    })
                    it.data?.let { album ->
                        album.tracks?.let { tracks ->
                            albumInfoAdapter.submitList(tracks)
                            favoriteButton.apply {
                                setFavoriteIcon(this, !album.isFavorite)
                                setOnClickListener {
                                    album.isFavorite = !album.isFavorite
                                    sharedViewModel.updateFavoriteAlbum(album)
                                    setFavoriteIcon(this, album.isFavorite)
                                    startAnim(this)
                                }
                            }
                        }
                    }
                }
            }

        }
        return mView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupAnimations()
    }

    override fun onItemSelected(position: Int, item: BaseModel, view: View) {
        if (item is Track) {
            isBack = true
            sharedViewModel.getLyrics(item)
            val trackName = view.findViewById<TextView>(R.id.track_name)
            val albumCover = mView.findViewById<ImageView>(R.id.album_cover)
            val extras = FragmentNavigatorExtras(
                trackName to (sharedViewModel.lyrics.value?.data?.name ?: item.name),
                albumCover to albumCover.transitionName
            )
            findNavController().navigate(
                R.id.action_albumInfoFragment_to_lyricsFragment, null,
                null, extras
            )
        }
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
}