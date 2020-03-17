package com.example.sberify.presentation.ui.newreleases

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnNextLayout
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.sberify.R
import com.example.sberify.base.BaseFragment
import com.example.sberify.databinding.FragmentNewReleasesBinding
import com.example.sberify.models.domain.Album
import com.example.sberify.models.domain.BaseModel
import com.example.sberify.presentation.ui.Injectable
import com.google.android.material.transition.Hold
import kotlinx.android.synthetic.main.fragment_new_releases.*


class NewReleasesFragment : BaseFragment(), Injectable, AlbumsAdapter.Interaction {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentNewReleasesBinding>(
            inflater,
            R.layout.fragment_new_releases,
            container
        ).apply {
            lifecycleOwner = this@NewReleasesFragment
            adapter = AlbumsAdapter(this@NewReleasesFragment)
            viewModel = sharedViewModel
            anim = animation.loadingAnimation
            swipeRefresh = refreshLayout.apply {
                setOnRefreshListener { sharedViewModel.refresh() }
            }
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        postponeEnterTransition()
        new_releases_recycler.apply {
            doOnNextLayout {
                startPostponedEnterTransition()
            }
        }

        exitTransition = Hold().apply {
            duration = 450
        }
    }

    override fun onItemSelected(position: Int, item: BaseModel, view: View) {
    }

    override fun onAlbumSelected(item: Album, view: View) {
        sharedViewModel.getAlbumInfo(item)
        val extras = FragmentNavigatorExtras(
            view to view.transitionName
        )
        findNavController().navigate(
            NewReleasesFragmentDirections.actionNewReleasesFragmentToAlbumInfoFragment(
                item
            ), extras
        )
    }
}