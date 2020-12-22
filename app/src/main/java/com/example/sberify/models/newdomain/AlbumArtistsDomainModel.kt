package com.example.sberify.models.newdomain

import android.os.Parcelable
import com.example.sberify.models.domain.BaseModel
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
