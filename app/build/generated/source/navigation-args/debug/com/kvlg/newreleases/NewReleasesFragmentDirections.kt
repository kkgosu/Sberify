package com.kvlg.newreleases

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.example.sberify.R
import com.kvlg.spotify_common.presentation.AlbumModel
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class NewReleasesFragmentDirections private constructor() {
  private data class ActionToAlbumDetailsFragment(
    public val item: AlbumModel
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_to_albumDetailsFragment

    @Suppress("CAST_NEVER_SUCCEEDS")
    public override fun getArguments(): Bundle {
      val result = Bundle()
      if (Parcelable::class.java.isAssignableFrom(AlbumModel::class.java)) {
        result.putParcelable("item", this.item as Parcelable)
      } else if (Serializable::class.java.isAssignableFrom(AlbumModel::class.java)) {
        result.putSerializable("item", this.item as Serializable)
      } else {
        throw UnsupportedOperationException(AlbumModel::class.java.name +
            " must implement Parcelable or Serializable or must be an Enum.")
      }
      return result
    }
  }

  public companion object {
    public fun actionToAlbumDetailsFragment(item: AlbumModel): NavDirections =
        ActionToAlbumDetailsFragment(item)
  }
}
