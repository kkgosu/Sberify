package com.example.sberify.presentation.ui.albuminfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sberify.R
import com.example.sberify.base.BaseFragment
import com.example.sberify.databinding.FragmentAlbumDetailsBinding
import com.example.sberify.models.domain.BaseModel
import com.example.sberify.models.domain.Track
import com.google.android.material.transition.Hold
import kotlinx.android.synthetic.main.fragment_album_details.*

class AlbumInfoFragment : BaseFragment(), AlbumDetailsAdapter.Interaction {

    private lateinit var bind: FragmentAlbumDetailsBinding
    private lateinit var manager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = binding<FragmentAlbumDetailsBinding>(
            inflater,
            R.layout.fragment_album_details,
            container
        ).apply {
            lifecycleOwner = this@AlbumInfoFragment
            viewModel = sharedViewModel
            fragment = this@AlbumInfoFragment
            adapter = AlbumDetailsAdapter(this@AlbumInfoFragment)
            setContainer(detailContainer)
            fab = fabFavorite
        }
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        postponeEnterTransition()
        recycler_tracks.apply {
            doOnPreDraw {
                startPostponedEnterTransition()
            }
        }
        exitTransition = Hold().apply {
            duration = 450
        }
    }

    override fun onItemSelected(item: Track, view: View) {
        sharedViewModel.getLyrics(item)
        val extras = FragmentNavigatorExtras(
            view to view.transitionName
        )
        findNavController().navigate(
            AlbumInfoFragmentDirections.navigateToLyricsFragment(item), extras
        )
    }

    override fun onItemSelected(position: Int, item: BaseModel, view: View) {

    }
}