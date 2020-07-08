package com.example.sberify.presentation.ui.lyrics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.sberify.base.BaseViewBindingFragment
import com.example.sberify.databinding.FragmentLyricsBinding
import com.example.sberify.presentation.ui.Injectable
import com.example.sberify.presentation.ui.utils.*

class LyricsFragment : BaseViewBindingFragment<FragmentLyricsBinding>(), Injectable {

    private val lyricsViewModel: LyricsViewModel by viewModels { viewModelFactory }
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
        (requireActivity() as AppCompatActivity).apply {
            setSupportActionBar(binding.toolbar)
            supportActionBar?.run {
                setDisplayHomeAsUpEnabled(true)
            }
        }
        binding.playButton.setOnClickListener {
            sharedViewModel.onPlayClick(navArgs.item)
        }
        sharedViewModel.lyrics.applyResultObserver(viewLifecycleOwner,
            success = { track ->
                binding.animation.loadingAnimation.hideAnimation()
                binding.lyrics.apply {
                    text = track.lyrics
                    visibility = View.VISIBLE
                }
                binding.favoriteButton.apply {
                    setFavoriteIcon(track.isFavorite)
                    setOnClickListener {
                        track.isFavorite = !track.isFavorite
                        lyricsViewModel.updateTrack(track)
                        setFavoriteIcon(track.isFavorite)
                        startAnim()
                    }
                }
            },
            loading = {
                binding.animation.loadingAnimation.showAnimation()
                binding.lyrics.visibility = View.GONE
            },
            error = {
                Toast.makeText(requireContext(), "$it", Toast.LENGTH_SHORT).show()
                binding.animation.loadingAnimation.hideAnimation()
                binding.lyrics.visibility = View.GONE
            }
        )
    }
}