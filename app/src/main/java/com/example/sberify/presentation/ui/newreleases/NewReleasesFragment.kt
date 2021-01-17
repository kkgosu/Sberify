package com.example.sberify.presentation.ui.newreleases

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.sberify.adapters.AlbumInteraction
import com.example.sberify.adapters.AlbumsAdapter
import com.example.sberify.base.BaseViewBindingFragment
import com.example.sberify.databinding.FragmentNewReleasesBinding
import com.example.sberify.presentation.ui.SharedViewModel
import com.example.sberify.presentation.ui.utils.applyResultObserver
import com.example.sberify.presentation.ui.utils.hideAnimation
import com.example.sberify.presentation.ui.utils.showAnimation
import com.kvlg.spotify.models.presentation.AlbumModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewReleasesFragment : BaseViewBindingFragment<FragmentNewReleasesBinding>(), AlbumInteraction {

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
        findNavController().navigate(
            NewReleasesFragmentDirections.actionNewReleasesFragmentToAlbumInfoFragment(
                item
            ), extras
        )
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
                Toast.makeText(requireContext(), it ?: "Error occurred while getting new releases :C", Toast.LENGTH_SHORT).show()
            })
    }
}