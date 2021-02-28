package com.kvlg.lyrics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
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

    private val lyricsViewModel: LyricsViewModel by viewModels()
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
        with(requireView()) {
            transitionName = navArgs.track.id
            doOnPreDraw {
                startPostponedEnterTransition()
            }
        }
        setupToolbar(binding.toolbar) {
            setDisplayHomeAsUpEnabled(true)
        }
        lyricsViewModel.getLyrics(navArgs.track)
        binding.title.text = navArgs.track.name
        binding.playButton.onClick {
            sharedViewModel.onPlayClick(navArgs.track)
        }
        lyricsViewModel.lyrics.applyResultObserver(viewLifecycleOwner,
            success = { model ->
                model?.let { track ->
                    track.lyrics?.let {
                        hideLoadingAnim()
                        binding.lyrics.apply {
                            text = it
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
                }
            },
            loading = {
                showLoadingAnim()
                binding.lyrics.gone()
            },
            error = {
                shortToast(it.toString())
                hideLoadingAnim()
                binding.lyrics.gone()
            }
        )
    }

    override fun onDestroy() {
        hideLoadingAnim()
        super.onDestroy()
    }

    private fun showLoadingAnim() {
        binding.animation.loadingAnimation.showAnimation()
    }

    private fun hideLoadingAnim() {
        binding.animation.loadingAnimation.hideAnimation()
    }
}