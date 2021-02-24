package com.kvlg.albumdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.kvlg.albumdetails.databinding.FragmentAlbumDetailsBinding
import com.kvlg.core_utils.applyResultObserver
import com.kvlg.design.BaseViewBindingFragment
import com.kvlg.design.bindAppBarLayoutWithFab
import com.kvlg.design.loadImage
import com.kvlg.design.onClick
import com.kvlg.design.setFavoriteIcon
import com.kvlg.design.startAnim
import com.kvlg.shared.SharedViewModel
import com.kvlg.spotify_common.adapters.TrackInteraction
import com.kvlg.spotify_common.adapters.TrackListedAdapter
import com.kvlg.spotify_common.presentation.TrackModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AlbumDetailsFragment : BaseViewBindingFragment<FragmentAlbumDetailsBinding>(), TrackInteraction {

    @Inject
    lateinit var navigation: AlbumDetailsNavigation

    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val navArgs by navArgs<AlbumDetailsArgs>()

    private lateinit var adapter: TrackListedAdapter

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAlbumDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupViews() {
        setupAnimationsForRecyclers(binding.recyclerTracks)
        subscribeToObservers()
        (requireActivity() as AppCompatActivity).apply {
            setSupportActionBar(binding.detailToolbar)
            supportActionBar?.run {
                setDisplayHomeAsUpEnabled(true)
            }
        }
        navArgs.item.run {
            binding.detailContainer.transitionName = id
            binding.albumName.text = name
            binding.releaseDate.text = releaseDate
            binding.detailToolbar.title = name
            binding.artistName.text = artistNames
        }
        adapter = TrackListedAdapter(this)
        binding.recyclerTracks.adapter = adapter
        binding.fabFavorite.bindAppBarLayoutWithFab(binding.appBarLayout)
    }

    override fun onTrackSelected(item: TrackModel, view: View) {
        sharedViewModel.getLyrics(item)
        val extras = FragmentNavigatorExtras(
            view to view.transitionName,
        )
        navigation.navigateToLyrics(findNavController(), item, extras)
    }

    private fun subscribeToObservers() {
        sharedViewModel.album.applyResultObserver(
            viewLifecycleOwner,
            success = { album ->
                binding.releaseDate.text = album.releaseDate
                binding.albumCover.loadImage(album.imageUrl)
                adapter.items = album.tracks
                binding.fabFavorite.apply {
                    setFavoriteIcon(!album.isFavorite)
                    onClick {
                        sharedViewModel.updateFavoriteAlbum(album)
                        setFavoriteIcon(album.isFavorite)
                        startAnim()
                    }
                }
            },
            loading = { },
            error = {
                Toast.makeText(
                    requireContext(),
                    it ?: "Error occurred while getting album's data :C",
                    Toast.LENGTH_SHORT
                ).show()
            }
        )
    }
}