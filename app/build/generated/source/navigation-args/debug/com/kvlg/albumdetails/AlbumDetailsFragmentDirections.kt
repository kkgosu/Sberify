package com.kvlg.albumdetails

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.example.sberify.R
import com.kvlg.spotify_common.presentation.TrackModel
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class AlbumDetailsFragmentDirections private constructor() {
  private data class ActionToLyricsFragment(
    public val item: TrackModel
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_to_lyricsFragment

    @Suppress("CAST_NEVER_SUCCEEDS")
    public override fun getArguments(): Bundle {
      val result = Bundle()
      if (Parcelable::class.java.isAssignableFrom(TrackModel::class.java)) {
        result.putParcelable("item", this.item as Parcelable)
      } else if (Serializable::class.java.isAssignableFrom(TrackModel::class.java)) {
        result.putSerializable("item", this.item as Serializable)
      } else {
        throw UnsupportedOperationException(TrackModel::class.java.name +
            " must implement Parcelable or Serializable or must be an Enum.")
      }
      return result
    }
  }

  public companion object {
    public fun actionToLyricsFragment(item: TrackModel): NavDirections =
        ActionToLyricsFragment(item)
  }
}
