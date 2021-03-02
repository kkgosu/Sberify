package com.kvlg.albumdetails

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import com.kvlg.spotify_common.presentation.AlbumModel
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class AlbumDetailsFragmentArgs(
  public val item: AlbumModel
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
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

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): AlbumDetailsFragmentArgs {
      bundle.setClassLoader(AlbumDetailsFragmentArgs::class.java.classLoader)
      val __item : AlbumModel?
      if (bundle.containsKey("item")) {
        if (Parcelable::class.java.isAssignableFrom(AlbumModel::class.java) ||
            Serializable::class.java.isAssignableFrom(AlbumModel::class.java)) {
          __item = bundle.get("item") as AlbumModel?
        } else {
          throw UnsupportedOperationException(AlbumModel::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__item == null) {
          throw IllegalArgumentException("Argument \"item\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"item\" is missing and does not have an android:defaultValue")
      }
      return AlbumDetailsFragmentArgs(__item)
    }
  }
}
