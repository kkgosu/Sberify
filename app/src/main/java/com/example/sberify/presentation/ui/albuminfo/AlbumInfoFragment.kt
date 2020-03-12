package com.example.sberify.presentation.ui.albuminfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.sberify.R
import com.example.sberify.base.BaseFragment
import com.example.sberify.databinding.FragmentAlbumDetailsBinding
import com.example.sberify.models.domain.BaseModel
import com.example.sberify.models.domain.Track

class AlbumInfoFragment : BaseFragment(), AlbumDetailsAdapter.Interaction {

    private lateinit var tracksRecyclerView: RecyclerView
    private lateinit var albumInfoAdapter: AlbumInfoAdapter<Track>
    private lateinit var favoriteButton: ImageButton

    private var isBack = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println("AlbumInfoFragment.onCreateView")
        return binding<FragmentAlbumDetailsBinding>(
            inflater,
            R.layout.fragment_album_details,
            container
        ).apply {
            adapter = AlbumDetailsAdapter(this@AlbumInfoFragment)
            viewModel = sharedViewModel
            fragment = this@AlbumInfoFragment
            lifecycleOwner = this@AlbumInfoFragment
            setContainer(detailContainer)
            fab = fabFavorite.apply {
                sharedViewModel.album.value?.data?.let { album ->
                    setFavoriteIcon(this, !album.isFavorite)
                    setOnClickListener {
                        album.isFavorite = !album.isFavorite
                        sharedViewModel.updateFavoriteAlbum(album)
                        setFavoriteIcon(this, album.isFavorite)
                        startAnim(this)
                    }
                }
            }
        }.root

/*
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
        return mView*/
    }

    override fun onItemSelected(item: Track, view: View) {
        sharedViewModel.getLyrics(item)
        findNavController().navigate(R.id.action_albumInfoFragment_to_lyricsFragment)
    }

    override fun onItemSelected(position: Int, item: BaseModel, view: View) {

    }
}