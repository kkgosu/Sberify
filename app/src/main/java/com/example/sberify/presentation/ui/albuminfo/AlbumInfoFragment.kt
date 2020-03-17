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
import com.example.sberify.base.BaseFragment
import com.example.sberify.databinding.FragmentAlbumDetailsBinding
import com.example.sberify.models.domain.Track
import com.google.android.material.transition.Hold
import com.google.android.material.transition.MaterialArcMotion
import com.google.android.material.transition.MaterialContainerTransform
import kotlinx.android.synthetic.main.fragment_album_details.*

class AlbumInfoFragment : BaseFragment(), AlbumDetailsAdapter.Interaction {

    private val navArgs by navArgs<AlbumInfoFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentAlbumDetailsBinding>(
            inflater,
            R.layout.fragment_album_details,
            container
        ).apply {
            lifecycleOwner = this@AlbumInfoFragment
            viewModel = sharedViewModel
            fragment = this@AlbumInfoFragment
            adapter = AlbumDetailsAdapter(this@AlbumInfoFragment)
            fab = fabFavorite
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navArgs.item.run {
            detail_container.transitionName = id
            artist_name.text = artist.name
            album_name.text = name
            release_date.text = releaseDate
        }
        postponeEnterTransition()
        recycler_tracks.apply {
            doOnNextLayout {
                startPostponedEnterTransition()
            }
        }

        sharedElementEnterTransition = MaterialContainerTransform(requireContext()).apply {
            pathMotion = MaterialArcMotion()
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
            AlbumInfoFragmentDirections.navigateToLyricsFragment(item), extras
        )
    }
}