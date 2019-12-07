package com.example.sberify.presentation.ui.lyrics

import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.transition.TransitionInflater
import com.airbnb.lottie.LottieAnimationView
import com.example.sberify.R
import com.example.sberify.di.injectViewModel
import com.example.sberify.presentation.ui.SharedViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class LyricsFragment : Fragment(R.layout.fragment_lyrics) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var sharedViewModel: SharedViewModel
    private lateinit var lyricsViewModel: LyricsViewModel
    private lateinit var lottieAnim: LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
        sharedViewModel = ViewModelProvider(requireActivity())
                .get(SharedViewModel::class.java)
        lyricsViewModel = injectViewModel(viewModelFactory)
        sharedElementEnterTransition = TransitionInflater.from(context)
                .inflateTransition(android.R.transition.move)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)!!
        val lyricsTextView = view.findViewById<TextView>(R.id.lyrics)
        val trackName = view.findViewById<TextView>(R.id.track_name)
        val favoriteButton = view.findViewById<ImageButton>(R.id.favorite_text)
        lottieAnim = view.findViewById(R.id.loading_animation)

        sharedViewModel.lyrics.observe(viewLifecycleOwner, Observer {
            trackName.apply {
                transitionName = it.name
                text = it.name
            }
            favoriteButton.apply {
                setFavoriteIcon(this, !it.isFavorite)
                setOnClickListener { _ ->
                    it.isFavorite = !it.isFavorite
                    lyricsViewModel.updateTrack(it)
                    setFavoriteIcon(this, it.isFavorite)
                    startAnim(this)
                }
            }
            lyricsTextView.text = it.lyrics
        })

        sharedViewModel.startLoadingAnim.observe(viewLifecycleOwner, Observer {
            lottieAnim.visibility = View.VISIBLE
            lottieAnim.playAnimation()
        })

        sharedViewModel.cancelLoadingAnim.observe(viewLifecycleOwner, Observer {
            lottieAnim.visibility = View.GONE
            lottieAnim.cancelAnimation()
        })
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        lottieAnim.cancelAnimation()
    }

    private fun setFavoriteIcon(imageButton: ImageButton, isFavorite: Boolean) {
        with(imageButton) {
            setImageDrawable(
                    if (isFavorite) {
                        (requireContext().getDrawable(
                                R.drawable.avd_heart_to_filled))
                    } else {
                        requireContext().getDrawable(
                                R.drawable.avd_filled_heart_break)
                    })
        }
    }

    private fun startAnim(imageButton: ImageButton) {
        with(imageButton) {
            (drawable as AnimatedVectorDrawable).start()
        }
    }
}