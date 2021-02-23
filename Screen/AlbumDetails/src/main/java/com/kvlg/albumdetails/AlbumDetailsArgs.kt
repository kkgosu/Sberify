package com.kvlg.albumdetails

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.NavArgs
import com.kvlg.spotify_common.presentation.AlbumModel

/**
 * @author Konstantin Koval
 * @since 23.02.2021
 */
data class AlbumDetailsArgs(
    val item: AlbumModel
) : NavArgs {

    fun toBundle(): Bundle {
        return bundleOf("item" to item)
    }

    companion object {

        @JvmStatic
        fun fromBundle(bundle: Bundle): AlbumDetailsArgs {
            bundle.classLoader = AlbumDetailsArgs::class.java.classLoader
            val item = bundle["item"] as AlbumModel
            return AlbumDetailsArgs(item)
        }
    }
}