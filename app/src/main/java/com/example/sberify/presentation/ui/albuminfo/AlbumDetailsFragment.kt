package com.example.sberify.presentation.ui.albuminfo

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
import com.example.sberify.adapters.TrackInteraction
import com.example.sberify.adapters.TrackListedAdapter
import com.example.sberify.base.BaseViewBindingFragment
import com.example.sberify.databinding.FragmentAlbumDetailsBinding
import com.example.sberify.models.newdomain.TrackDomainModel
import com.example.sberify.presentation.ui.SharedViewModel
import com.example.sberify.presentation.ui.utils.applyResultObserver
import com.example.sberify.presentation.ui.utils.bindAppBarLayoutWithFab
import com.example.sberify.presentation.ui.utils.loadImage
import com.example.sberify.presentation.ui.utils.setFavoriteIcon
import com.example.sberify.presentation.ui.utils.startAnim
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumDetailsFragment : BaseViewBindingFragment<FragmentAlbumDetailsBinding>(), TrackInteraction {

    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val navArgs by navArgs<AlbumDetailsFragmentArgs>()

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
            binding.releaseDate.text = releaseDate.uiValue
            binding.detailToolbar.title = name
        }
        adapter = TrackListedAdapter(this)
        binding.recyclerTracks.adapter = adapter
        binding.fabFavorite.bindAppBarLayoutWithFab(binding.appBarLayout)
    }

    override fun onTrackSelected(item: TrackDomainModel, view: View) {
        sharedViewModel.getLyrics(item)
        val extras = FragmentNavigatorExtras(
            view to view.transitionName,
        )
        findNavController().navigate(
            AlbumDetailsFragmentDirections.navigateToLyricsFragment(item), extras
        )
    }

    private fun subscribeToObservers() {
        sharedViewModel.album.applyResultObserver(
            viewLifecycleOwner,
            success = { album ->
                binding.releaseDate.text = album.releaseDate.uiValue
                binding.albumCover.loadImage(album.images.firstOrNull()?.url)
                album.tracks?.let { tracks ->
                    adapter.items = tracks
                    binding.fabFavorite.apply {
                        setFavoriteIcon(!album.isFavorite)
                        setOnClickListener {
                            sharedViewModel.updateFavoriteAlbum(album)
                            setFavoriteIcon(album.isFavorite)
                            startAnim()
                        }
                    }
                }
            },
            loading = { },
            error = { Toast.makeText(requireContext(), it ?: "Error occurred while getting album's data :C", Toast.LENGTH_SHORT).show() }
        )
    }
}