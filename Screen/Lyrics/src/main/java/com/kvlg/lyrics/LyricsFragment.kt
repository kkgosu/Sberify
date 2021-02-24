package com.kvlg.lyrics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.kvlg.core_utils.applyResultObserver
import com.kvlg.design.BaseViewBindingFragment
import com.kvlg.design.gone
import com.kvlg.design.hideAnimation
import com.kvlg.design.onClick
import com.kvlg.design.setFavoriteIcon
import com.kvlg.design.showAnimation
import com.kvlg.design.startAnim
import com.kvlg.design.visible
import com.kvlg.lyrics.databinding.FragmentLyricsBinding
import com.kvlg.shared.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LyricsFragment : BaseViewBindingFragment<FragmentLyricsBinding>() {

    private val lyricsViewModel: LyricsViewModel by activityViewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()

    private val navArgs by navArgs<LyricsArgs>()

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
        binding.lyricsContainer.transitionName = navArgs.track.id
        binding.title.text = navArgs.track.name
        binding.animation.loadingAnimation.showAnimation()
        (requireActivity() as AppCompatActivity).apply {
            setSupportActionBar(binding.toolbar)
            supportActionBar?.run { setDisplayHomeAsUpEnabled(true) }
        }
        binding.playButton.onClick {
            sharedViewModel.onPlayClick(navArgs.track)
        }
        sharedViewModel.lyrics.applyResultObserver(viewLifecycleOwner,
            success = {
                it?.let { track ->
                    binding.lyrics.apply {
                        text = it.lyrics
                        visible()
                    }
                    binding.favoriteButton.apply {
                        setFavoriteIcon(!track.isFavorite)
                        onClick {
                            track.isFavorite = !track.isFavorite
                            lyricsViewModel.updateTrack(track)
                            setFavoriteIcon(track.isFavorite)
                            startAnim()
                        }
                    }
                }
            },
            loading = { binding.lyrics.gone() },
            error = {
                Toast.makeText(requireContext(), "$it", Toast.LENGTH_SHORT).show()
                binding.lyrics.gone()
            }
        )
    }

    override fun onDestroy() {
        binding.animation.loadingAnimation.hideAnimation()
        super.onDestroy()
    }
}