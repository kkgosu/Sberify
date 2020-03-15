package com.example.sberify.presentation.ui.lyrics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.sberify.R
import com.example.sberify.base.BaseFragment
import com.example.sberify.databinding.FragmentLyricsBinding
import com.example.sberify.models.domain.BaseModel
import com.example.sberify.presentation.ui.Injectable
import com.google.android.material.transition.MaterialArcMotion
import com.google.android.material.transition.MaterialContainerTransform
import kotlinx.android.synthetic.main.fragment_lyrics.*

class LyricsFragment : BaseFragment(), Injectable {

    private val lyricsViewModel: LyricsViewModel by viewModels { viewModelFactory }
    private val navArgs by navArgs<LyricsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentLyricsBinding>(
            inflater,
            R.layout.fragment_lyrics,
            container
        ).apply {
            lifecycleOwner = this@LyricsFragment
            fragment = this@LyricsFragment
            viewModel = sharedViewModel
            lyricsVM = lyricsViewModel
            anim = animation.loadingAnimation
            favorite = favoriteButton
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lyrics_container.transitionName = navArgs.item.id

        sharedElementEnterTransition = MaterialContainerTransform(requireContext()).apply {
            pathMotion = MaterialArcMotion()
            duration = 450
        }
    }

    override fun onItemSelected(position: Int, item: BaseModel, view: View) {
    }
}