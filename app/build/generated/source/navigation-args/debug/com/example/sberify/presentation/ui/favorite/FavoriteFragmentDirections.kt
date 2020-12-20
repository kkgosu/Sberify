package com.example.sberify.presentation.ui.favorite

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.example.sberify.R
import com.example.sberify.models.newdomain.AlbumDomainModel
import com.example.sberify.models.newdomain.TrackDomainModel
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

class FavoriteFragmentDirections private constructor() {
  private data class ActionFavoriteFragmentToLyricsFragment(
    val item: TrackDomainModel
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_favoriteFragment_to_lyricsFragment

    @Suppress("CAST_NEVER_SUCCEEDS")
    override fun getArguments(): Bundle {
      val result = Bundle()
      if (Parcelable::class.java.isAssignableFrom(TrackDomainModel::class.java)) {
        result.putParcelable("item", this.item as Parcelable)
      } else if (Serializable::class.java.isAssignableFrom(TrackDomainModel::class.java)) {
        result.putSerializable("item", this.item as Serializable)
      } else {
        throw UnsupportedOperationException(TrackDomainModel::class.java.name +
            " must implement Parcelable or Serializable or must be an Enum.")
      }
      return result
    }
  }

  private data class ActionFavoriteFragmentToAlbumInfoFragment2(
    val item: AlbumDomainModel
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_favoriteFragment_to_albumInfoFragment2

    @Suppress("CAST_NEVER_SUCCEEDS")
    override fun getArguments(): Bundle {
      val result = Bundle()
      if (Parcelable::class.java.isAssignableFrom(AlbumDomainModel::class.java)) {
        result.putParcelable("item", this.item as Parcelable)
      } else if (Serializable::class.java.isAssignableFrom(AlbumDomainModel::class.java)) {
        result.putSerializable("item", this.item as Serializable)
      } else {
        throw UnsupportedOperationException(AlbumDomainModel::class.java.name +
            " must implement Parcelable or Serializable or must be an Enum.")
      }
      return result
    }
  }

  companion object {
    fun actionFavoriteFragmentToLyricsFragment(item: TrackDomainModel): NavDirections =
        ActionFavoriteFragmentToLyricsFragment(item)

    fun actionFavoriteFragmentToAlbumInfoFragment2(item: AlbumDomainModel): NavDirections =
        ActionFavoriteFragmentToAlbumInfoFragment2(item)
  }
}
