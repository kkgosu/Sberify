package com.kvlg.lyrics

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.NavArgs
import com.kvlg.spotify_common.presentation.TrackModel

/**
 * @author Konstantin Koval
 * @since 23.02.2021
 */
data class LyricsArgs(
    val track: TrackModel
) : NavArgs {

    fun toBundle(): Bundle {
        return bundleOf("item" to track)
    }

    companion object {

        @JvmStatic
        fun fromBundle(bundle: Bundle): LyricsArgs {
            bundle.classLoader = LyricsArgs::class.java.classLoader
            val item = bundle["item"] as TrackModel
            return LyricsArgs(item)
        }
    }
}
