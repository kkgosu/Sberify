package com.example.sberify.presentation.ui.lyrics

import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.sberify.R
import com.example.sberify.presentation.ui.SharedViewModel
import com.example.sberify.presentation.ui.ViewModelFactory

class LyricsFragment : Fragment(R.layout.fragment_lyrics) {

    private lateinit var mSharedViewModel: SharedViewModel
    private lateinit var mLyricsViewModel: LyricsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSharedViewModel = ViewModelProvider(requireActivity())
                .get(SharedViewModel::class.java)
        mLyricsViewModel = ViewModelProvider(this, ViewModelFactory())
                .get(LyricsViewModel::class.java)
        postponeEnterTransition()
        sharedElementEnterTransition = TransitionInflater.from(requireContext())
                .inflateTransition(android.R.transition.move)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        val lyricsTextView = view!!.findViewById<TextView>(R.id.lyrics)

        mSharedViewModel.lyrics.observe(viewLifecycleOwner, Observer {
            view.findViewById<TextView>(R.id.track_name)
                    .apply {
                        transitionName = it.name
                        text = it.name
                    }
            view.findViewById<ImageButton>(R.id.favorite_text)
                    .apply {
                        setFavoriteIcon(this, !it.isFavorite)
                        setOnClickListener { _ ->
                            it.isFavorite = !it.isFavorite
                            mLyricsViewModel.updateTrack(it)
                            setFavoriteIcon(this, it.isFavorite)
                            startAnim(this)
                        }
                    }
            lyricsTextView.text = it.lyrics
        })
        return view
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

    companion object {
        fun newInstance(): LyricsFragment {
            val args = Bundle()
            val fragment = LyricsFragment()
            fragment.arguments = args
            return fragment
        }
    }
}