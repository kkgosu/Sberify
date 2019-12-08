package com.example.sberify.presentation.ui.lyrics

import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.transition.TransitionInflater
import com.airbnb.lottie.LottieAnimationView
import com.example.sberify.R
import com.example.sberify.databinding.FragmentLyricsBinding
import com.example.sberify.di.injectViewModel
import com.example.sberify.models.domain.BaseModel
import com.example.sberify.presentation.ui.BaseFragment
import com.example.sberify.presentation.ui.Injectable
import javax.inject.Inject

class LyricsFragment : BaseFragment(), Injectable {
    
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var lyricsViewModel: LyricsViewModel
    private lateinit var lottieAnim: LottieAnimationView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {

        initBinding<FragmentLyricsBinding>(R.layout.fragment_lyrics, container)
                .viewModel = sharedViewModel

        val favoriteButton = mView.findViewById<ImageButton>(R.id.favorite_text)
        lyricsViewModel = injectViewModel(viewModelFactory)

        sharedElementEnterTransition = TransitionInflater.from(context)
                .inflateTransition(android.R.transition.move)

        lottieAnim = mView.findViewById(R.id.loading_animation)
        sharedViewModel.lyrics.observe(viewLifecycleOwner, Observer {
            favoriteButton.apply {
                setFavoriteIcon(this, !it.isFavorite)
                setOnClickListener { _ ->
                    it.isFavorite = !it.isFavorite
                    lyricsViewModel.updateTrack(it)
                    setFavoriteIcon(this, it.isFavorite)
                    startAnim(this)
                }
            }
        })

        sharedViewModel.startLoadingAnim.observe(viewLifecycleOwner, Observer {
            showLottie()
        })

        sharedViewModel.cancelLoadingAnim.observe(viewLifecycleOwner, Observer {
            hideLottie()
        })
        return mView
    }

    override fun onDestroy() {
        super.onDestroy()
        hideLottie()
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

    private fun showLottie() {
        lottieAnim.visibility = View.VISIBLE
        lottieAnim.playAnimation()
    }

    private fun hideLottie() {
        lottieAnim.visibility = View.GONE
        lottieAnim.cancelAnimation()
    }

    private fun startAnim(imageButton: ImageButton) {
        with(imageButton) {
            (drawable as AnimatedVectorDrawable).start()
        }
    }

    override fun onItemSelected(position: Int, item: BaseModel, view: View) {
    }
}