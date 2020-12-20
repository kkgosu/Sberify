package com.example.sberify.presentation.ui.albuminfo

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import com.example.sberify.models.newdomain.AlbumDomainModel
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

data class AlbumDetailsFragmentArgs(
  val item: AlbumDomainModel
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  fun toBundle(): Bundle {
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

  companion object {
    @JvmStatic
    fun fromBundle(bundle: Bundle): AlbumDetailsFragmentArgs {
      bundle.setClassLoader(AlbumDetailsFragmentArgs::class.java.classLoader)
      val __item : AlbumDomainModel?
      if (bundle.containsKey("item")) {
        if (Parcelable::class.java.isAssignableFrom(AlbumDomainModel::class.java) ||
            Serializable::class.java.isAssignableFrom(AlbumDomainModel::class.java)) {
          __item = bundle.get("item") as AlbumDomainModel?
        } else {
          throw UnsupportedOperationException(AlbumDomainModel::class.java.name +
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
