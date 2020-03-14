package com.example.sberify.presentation.ui.lyrics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.lifecycle.observe
import androidx.navigation.fragment.navArgs
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.airbnb.lottie.LottieAnimationView
import com.example.sberify.R
import com.example.sberify.base.BaseFragment
import com.example.sberify.data.Result
import com.example.sberify.databinding.FragmentLyricsBinding
import com.example.sberify.di.injectViewModel
import com.example.sberify.models.domain.BaseModel
import com.example.sberify.presentation.ui.Injectable
import com.google.android.material.transition.MaterialArcMotion
import com.google.android.material.transition.MaterialContainerTransform
import kotlinx.android.synthetic.main.fragment_lyrics.*

class LyricsFragment : BaseFragment(), Injectable {

    private lateinit var lyricsViewModel: LyricsViewModel
    private lateinit var lottieAnim: LottieAnimationView
    private lateinit var favoriteButton: ImageButton
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    private val navArgs by navArgs<LyricsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        lyricsViewModel = injectViewModel(viewModelFactory)
        initBinding<FragmentLyricsBinding>(R.layout.fragment_lyrics, container)
            .viewModel = sharedViewModel
        setupToolbar()
        favoriteButton = mView.findViewById(R.id.favorite_button)
        swipeRefreshLayout = mView.findViewById(R.id.refresh_layout)
        swipeRefreshLayout.setOnRefreshListener {
            sharedViewModel.refreshLyrics()
        }
        lottieAnim = mView.findViewById(R.id.loading_animation)
        sharedViewModel.lyrics.observe(viewLifecycleOwner) {
            when (it.status) {
                Result.Status.SUCCESS -> {
                    invalidateBindings<FragmentLyricsBinding>()
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
                }
                Result.Status.ERROR -> {
                    showLottie()
                    Toast.makeText(
                        requireContext(),
                        "Error while getting lyrics. Please try again later", Toast.LENGTH_LONG
                    )
                        .show()
                }
            }
        }
        return mView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lyrics_container.transitionName = navArgs.item.id
        title.text = navArgs.item.name
        binding.executePendingBindings()

        sharedElementEnterTransition = MaterialContainerTransform(requireContext()).apply {
            pathMotion = MaterialArcMotion()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        hideLottie()
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

    override fun onItemSelected(position: Int, item: BaseModel, view: View) {
    }
}