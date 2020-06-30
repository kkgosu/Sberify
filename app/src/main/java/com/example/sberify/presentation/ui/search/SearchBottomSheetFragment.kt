package com.example.sberify.presentation.ui.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sberify.databinding.SearchBottomSheetLayoutBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * @author Konstantin Koval
 * @since 30.06.2020
 */
class SearchBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var listener: OnSwitchChangeListener
    private var _binding: SearchBottomSheetLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SearchBottomSheetLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.albumSwitch.setOnCheckedChangeListener { _, isChecked ->
            listener.onAlbumCheck(isChecked)
        }
        binding.artistSwitch.setOnCheckedChangeListener { _, isChecked ->
            listener.onArtistCheck(isChecked)
        }
        binding.trackSwitch.setOnCheckedChangeListener { _, isChecked ->
            listener.onTrackCheck(isChecked)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is OnSwitchChangeListener) {
            context
        } else {
            throw RuntimeException("You should implement OnSwitchChangeListener")
        }
    }

    interface OnSwitchChangeListener {
        fun onArtistCheck(checked: Boolean)
        fun onAlbumCheck(checked: Boolean)
        fun onTrackCheck(checked: Boolean)
    }

    companion object {

        const val ALBUM_SWITCH_CHECKED_KEY = "AlbumSwitchChecked"
        const val ARTIST_SWITCH_CHECKED_KEY = "ArtistSwitchChecked"
        const val TRACK_SWITCH_CHECKED_KEY = "TrackSwitchChecked"

        fun newInstance(
            albumChecked: Boolean,
            artistChecked: Boolean,
            trackChecked: Boolean
        ): SearchBottomSheetFragment {
            return SearchBottomSheetFragment().apply {
                arguments = Bundle().apply {
                    ALBUM_SWITCH_CHECKED_KEY to albumChecked
                    ARTIST_SWITCH_CHECKED_KEY to artistChecked
                    TRACK_SWITCH_CHECKED_KEY to trackChecked
                }
            }
        }
    }
}