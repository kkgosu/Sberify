package com.example.sberify.presentation.ui.lyrics

import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.airbnb.lottie.LottieAnimationView
import com.example.sberify.R
import com.example.sberify.data.Result
import com.example.sberify.databinding.FragmentLyricsBinding
import com.example.sberify.di.injectViewModel
import com.example.sberify.models.domain.BaseModel
import com.example.sberify.presentation.ui.BaseFragment
import com.example.sberify.presentation.ui.Injectable

class LyricsFragment : BaseFragment(), Injectable {

    private lateinit var lyricsViewModel: LyricsViewModel
    private lateinit var lottieAnim: LottieAnimationView
    private lateinit var favoriteButton: ImageButton
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        initBinding<FragmentLyricsBinding>(R.layout.fragment_lyrics, container)
                .viewModel = sharedViewModel
        lyricsViewModel = injectViewModel(viewModelFactory)
        val toolbar = mView.findViewById<Toolbar>(R.id.collapsed_toolbar)
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (requireActivity() as AppCompatActivity).supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        favoriteButton = mView.findViewById(R.id.favorite_text)
        swipeRefreshLayout = mView.findViewById(R.id.refresh_layout)
        swipeRefreshLayout.setOnRefreshListener {
            sharedViewModel.refreshLyrics()
        }
        lottieAnim = mView.findViewById(R.id.loading_animation)
        sharedViewModel.lyrics.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Result.Status.SUCCESS -> {
                    startPostponedEnterTransition()
                    it.data?.let { track ->
                        swipeRefreshLayout.isRefreshing = false
                        track.lyrics?.let {
                            hideLottie()
                            favoriteButton.apply {
                                setFavoriteIcon(this, !track.isFavorite)
                                setOnClickListener {
                                    track.isFavorite = !track.isFavorite
                                    lyricsViewModel.updateTrack(track)
                                    setFavoriteIcon(this, track.isFavorite)
                                    startAnim(this)
                                }
                            }
                        }
                    }
                }
                Result.Status.LOADING -> {
                    showLottie()
                    it.data?.let {
                        startPostponedEnterTransition()
                    }
                }
                Result.Status.ERROR -> {
                    showLottie()
                    Toast.makeText(requireContext(),
                            "Error while getting lyrics. Please try again later", Toast.LENGTH_LONG)
                            .show()
                }
            }
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
        favoriteButton.visibility = View.GONE
    }

    private fun hideLottie() {
        lottieAnim.visibility = View.GONE
        lottieAnim.cancelAnimation()
        favoriteButton.visibility = View.VISIBLE
    }

    private fun startAnim(imageButton: ImageButton) {
        with(imageButton) {
            (drawable as AnimatedVectorDrawable).start()
        }
    }

    override fun onItemSelected(position: Int, item: BaseModel, view: View) {
    }
}