package com.example.sberify.presentation.ui.newreleases

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.sberify.R
import com.example.sberify.base.BaseFragment
import com.example.sberify.databinding.FragmentNewReleasesBinding
import com.example.sberify.models.domain.Album
import com.example.sberify.models.domain.BaseModel
import com.example.sberify.presentation.ui.Injectable


class NewReleasesFragment : BaseFragment(), Injectable, NewReleasesAdapter1.Interaction {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentNewReleasesBinding>(
            inflater,
            R.layout.fragment_new_releases,
            container
        ).apply {
            viewModel = sharedViewModel.apply { refresh() }
            anim = loadingAnimation
            lifecycleOwner = this@NewReleasesFragment
            adapter = NewReleasesAdapter1(this@NewReleasesFragment)
            swipeRefresh = refreshLayout.apply {
                setOnRefreshListener { sharedViewModel.refresh() }
            }
        }.root
    }

    override fun onItemSelected(position: Int, item: BaseModel, view: View) {
    }

    override fun onItemSelected(item: Album, view: View) {
        sharedViewModel.getAlbumInfo(item)
        val albumName = view.findViewById<TextView>(R.id.release_name)
        val albumCover = view.findViewById<ImageView>(R.id.release_cover)
        val artistName = view.findViewById<TextView>(R.id.artist_name)
        val extras = FragmentNavigatorExtras(
            albumName to albumName.transitionName,
            albumCover to albumCover.transitionName,
            artistName to artistName.transitionName
        )

        findNavController().navigate(
            R.id.action_newReleasesFragment_to_albumInfoFragment, null,
            null, extras
        )
    }
}