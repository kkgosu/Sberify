package com.example.sberify.ui.lyrics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.example.sberify.base.BaseViewBindingFragment
import com.example.sberify.databinding.FragmentLyricsBinding
import com.example.sberify.ui.SharedViewModel
import com.example.sberify.ui.utils.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LyricsFragment : BaseViewBindingFragment<FragmentLyricsBinding>() {

    private val lyricsViewModel: LyricsViewModel by activityViewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()

    private val navArgs by navArgs<LyricsFragmentArgs>()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLyricsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupViews() {
        startPostponedEnterTransition()
        binding.lyricsContainer.transitionName = navArgs.item.id
        binding.title.text = navArgs.item.name
        binding.animation.loadingAnimation.showAnimation()
        (requireActivity() as AppCompatActivity).apply {
            setSupportActionBar(binding.toolbar)
            supportActionBar?.run { setDisplayHomeAsUpEnabled(true) }
        }
        binding.playButton.setOnClickListener {
            sharedViewModel.onPlayClick(navArgs.item)
        }
        lyricsViewModel.lyrics.applyResultObserver(viewLifecycleOwner,
            success = {
                it?.let {track ->
                    binding.lyrics.apply {
                        binding.animation.loadingAnimation.hideAnimation()
                        text = track.lyrics
                        visibility = View.VISIBLE
                    }
                    binding.favoriteButton.apply {
                        setFavoriteIcon(!track.isFavorite)
                        setOnClickListener {
                            track.isFavorite = !track.isFavorite
                            lyricsViewModel.updateTrack(track)
                            setFavoriteIcon(track.isFavorite)
                            startAnim()
                        }
                    }
                }
            },
            loading = { binding.lyrics.visibility = View.GONE },
            error = {
                Toast.makeText(requireContext(), "$it", Toast.LENGTH_SHORT).show()
                binding.lyrics.visibility = View.GONE
            }
        )
    }

    override fun onDestroy() {
        binding.animation.loadingAnimation.hideAnimation()
        super.onDestroy()
    }
}