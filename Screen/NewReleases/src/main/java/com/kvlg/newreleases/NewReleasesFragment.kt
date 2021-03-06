package com.kvlg.newreleases

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.kvlg.core_utils.applyResultObserver
import com.kvlg.design.BaseViewBindingFragment
import com.kvlg.design.hideAnimation
import com.kvlg.design.showAnimation
import com.kvlg.newreleases.databinding.FragmentNewReleasesBinding
import com.kvlg.shared.SharedViewModel
import com.kvlg.spotify_common.adapters.AlbumInteraction
import com.kvlg.spotify_common.adapters.AlbumsAdapter
import com.kvlg.spotify_common.presentation.AlbumModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NewReleasesFragment : BaseViewBindingFragment<FragmentNewReleasesBinding>(), AlbumInteraction {

    @Inject
    lateinit var navigation: NewReleasesNavigation

    private val sharedViewModel: SharedViewModel by activityViewModels()
    private lateinit var adapter: AlbumsAdapter

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewReleasesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupViews() {
        subscribeToObservers()
        setupAnimationsForRecyclers(binding.newReleasesRecycler)
        adapter = AlbumsAdapter(this)
        binding.newReleasesRecycler.adapter = adapter
        binding.refreshLayout.setOnRefreshListener { sharedViewModel.refresh() }
    }

    override fun onAlbumSelected(item: AlbumModel, view: View) {
        sharedViewModel.getAlbumInfo(item)
        val extras = FragmentNavigatorExtras(
            view to view.transitionName
        )
        navigation.navigateToAlbumDetails(findNavController(), item, extras)
    }

    private fun subscribeToObservers() {
        sharedViewModel.newReleases.applyResultObserver(
            viewLifecycleOwner,
            success = { album ->
                binding.refreshLayout.isRefreshing = false
                adapter.items = album
                binding.animation.loadingAnimation.hideAnimation()
            },
            loading = { binding.animation.loadingAnimation.showAnimation() },
            error = {
                binding.refreshLayout.isRefreshing = false
                binding.animation.loadingAnimation.hideAnimation()
                shortToast(it ?: "Error occurred while getting new releases :C")
            })
    }
}