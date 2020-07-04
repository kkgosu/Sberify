package com.example.sberify.presentation.ui.search

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResultListener
import com.example.sberify.R
import com.example.sberify.databinding.FilterBottomSheetLayoutBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * @author Konstantin Koval
 * @since 30.06.2020
 */
class FilterBottomSheetFragment : BottomSheetDialogFragment() {

    private var _binding: FilterBottomSheetLayoutBinding? = null
    private val binding get() = _binding!!

    override fun getTheme(): Int {
        return R.style.BaseBottomSheetDialog
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FilterBottomSheetLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCancel(dialog: DialogInterface) {
        val bundle = bundleOf(
            ARTIST_SWITCH_CHECKED_KEY to binding.artistSwitch.isChecked,
            ALBUM_SWITCH_CHECKED_KEY to binding.albumSwitch.isChecked,
            TRACK_SWITCH_CHECKED_KEY to binding.trackSwitch.isChecked
        )
        parentFragmentManager.setFragmentResult("requestKey", bundle)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        parentFragmentManager.setFragmentResultListener("showFilter", this) { _, result ->
            binding.artistSwitch.isChecked = result.getBoolean(ARTIST_SWITCH_CHECKED_KEY, false)
            binding.albumSwitch.isChecked = result.getBoolean(ALBUM_SWITCH_CHECKED_KEY, false)
            binding.trackSwitch.isChecked = result.getBoolean(TRACK_SWITCH_CHECKED_KEY, false)
        }
    }

    companion object {
        const val TAG = "FilterBottomSheetFragment"
        const val ARTIST_SWITCH_CHECKED_KEY = "ArtistSwitchChecked"
        const val ALBUM_SWITCH_CHECKED_KEY = "AlbumSwitchChecked"
        const val TRACK_SWITCH_CHECKED_KEY = "TrackSwitchChecked"
    }
}