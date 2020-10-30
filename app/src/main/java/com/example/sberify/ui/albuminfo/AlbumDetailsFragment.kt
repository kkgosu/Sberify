package com.example.sberify.ui.albuminfo

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
import com.example.sberify.ui.SharedViewModel
import com.example.sberify.ui.lyrics.LyricsViewModel
import com.example.sberify.ui.utils.*
import com.kvlg.model.presentation.Track
import dagger.hilt.android.AndroidEntryPoint


//TODO: check why name and animation disappeared
@AndroidEntryPoint
class AlbumDetailsFragment : BaseViewBindingFragment<FragmentAlbumDetailsBinding>(), TrackInteraction {

    private val lyricsViewModel: LyricsViewModel by activityViewModels()
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
            //TODO: REMOVE PARCEL
/*            binding.detailContainer.transitionName = id
            binding.artistName.text = artist.name
            binding.albumName.text = name
            binding.releaseDate.text = releaseDate
            binding.detailToolbar.title = name*/
        }
        adapter = TrackListedAdapter(this)
        binding.recyclerTracks.adapter = adapter
        binding.fabFavorite.bindAppBarLayoutWithFab(binding.appBarLayout)
    }

    override fun onTrackSelected(item: Track, view: View) {
        lyricsViewModel.getLyrics(item)
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
                binding.albumCover.loadImage(album.imageUrl)
                album.tracks?.let { tracks ->
                    adapter.items = tracks
                    binding.fabFavorite.apply {
                        setFavoriteIcon(!album.isFavorite)
                        setOnClickListener {
                            album.isFavorite = !album.isFavorite
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