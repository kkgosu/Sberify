package com.kvlg.spotify_api.models.domain

import android.os.Parcelable
import com.kvlg.spotify_api.models.BaseModel
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
