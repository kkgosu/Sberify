package com.example.sberify.ui.newreleases

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
import com.example.sberify.ui.SharedViewModel
import com.example.sberify.ui.utils.applyResultObserver
import com.kvlg.model.presentation.Album
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