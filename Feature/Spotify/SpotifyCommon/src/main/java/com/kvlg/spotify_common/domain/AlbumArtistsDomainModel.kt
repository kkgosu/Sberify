package com.kvlg.spotify_common.domain

import android.os.Parcelable
import com.kvlg.spotify_common.BaseModel
import kotlinx.parcelize.Parcelize

/**
 * @author Konstantin Koval
 * @since 22.12.2020
 */
@Parcelize
data class AlbumArtistsDomainModel(
    val album: AlbumDomainModel,
    val artists: List<ArtistDomainModel>
) : BaseModel(album.baseId), Parcelable
