package com.example.sberify.presentation.ui.lyrics

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import com.kvlg.spotify_models.presentation.TrackModel
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class LyricsFragmentArgs(
  public val item: TrackModel
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
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

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): LyricsFragmentArgs {
      bundle.setClassLoader(LyricsFragmentArgs::class.java.classLoader)
      val __item : TrackModel?
      if (bundle.containsKey("item")) {
        if (Parcelable::class.java.isAssignableFrom(TrackModel::class.java) ||
            Serializable::class.java.isAssignableFrom(TrackModel::class.java)) {
          __item = bundle.get("item") as TrackModel?
        } else {
          throw UnsupportedOperationException(TrackModel::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__item == null) {
          throw IllegalArgumentException("Argument \"item\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"item\" is missing and does not have an android:defaultValue")
      }
      return LyricsFragmentArgs(__item)
    }
  }
}
