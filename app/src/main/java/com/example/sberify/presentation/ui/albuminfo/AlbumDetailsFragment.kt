package com.example.sberify.presentation.ui.albuminfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnNextLayout
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.sberify.R
import com.example.sberify.adapters.TrackInteraction
import com.example.sberify.adapters.TrackListedAdapter
import com.example.sberify.base.BaseFragment
import com.example.sberify.databinding.FragmentAlbumDetailsBinding
import com.example.sberify.models.domain.Track
import com.google.android.material.transition.Hold
import com.google.android.material.transition.MaterialArcMotion
import com.google.android.material.transition.MaterialContainerTransform
import kotlinx.android.synthetic.main.fragment_album_details.*

class AlbumDetailsFragment : BaseFragment(),
    TrackInteraction {

    private val navArgs by navArgs<AlbumDetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentAlbumDetailsBinding>(
            inflater,
            R.layout.fragment_album_details,
            container
        ).apply {
            lifecycleOwner = this@AlbumDetailsFragment
            viewModel = sharedViewModel
            fragment = this@AlbumDetailsFragment
            adapter =
                TrackListedAdapter(this@AlbumDetailsFragment)
            fab = fabFavorite
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navArgs.item.run {
            detail_container.transitionName = id
            artist_name.text = artist.name
            album_name.text = name
            release_date.text = releaseDate
            detail_toolbar.title = name
        }
        postponeEnterTransition()
        recycler_tracks.doOnNextLayout {
            startPostponedEnterTransition()
        }

        sharedElementEnterTransition = MaterialContainerTransform().apply {
            setPathMotion(MaterialArcMotion())
            duration = 450
        }

        exitTransition = Hold().apply {
            duration = 450
        }
    }

    override fun onTrackSelected(item: Track, view: View) {
        sharedViewModel.getLyrics(item)
        val extras = FragmentNavigatorExtras(
            view to view.transitionName
        )
        findNavController().navigate(
            AlbumDetailsFragmentDirections.navigateToLyricsFragment(item), extras
        )
    }
}