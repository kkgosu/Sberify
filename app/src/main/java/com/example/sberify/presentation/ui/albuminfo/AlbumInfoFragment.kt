package com.example.sberify.presentation.ui.albuminfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.sberify.R
import com.example.sberify.base.BaseFragment
import com.example.sberify.databinding.FragmentAlbumDetailsBinding
import com.example.sberify.models.domain.BaseModel
import com.example.sberify.models.domain.Track

class AlbumInfoFragment : BaseFragment(), AlbumDetailsAdapter.Interaction {

    private lateinit var bind: FragmentAlbumDetailsBinding

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

    override fun onResume() {
        super.onResume()
        bind.invalidateAll() //fix for recyclerView
    }

    override fun onItemSelected(item: Track, view: View) {
        sharedViewModel.getLyrics(item)
        findNavController().navigate(R.id.action_albumInfoFragment_to_lyricsFragment)
    }

    override fun onItemSelected(position: Int, item: BaseModel, view: View) {

    }
}