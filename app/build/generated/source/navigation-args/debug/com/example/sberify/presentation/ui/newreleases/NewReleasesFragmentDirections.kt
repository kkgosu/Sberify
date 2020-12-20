package com.example.sberify.presentation.ui.newreleases

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.example.sberify.R
import com.example.sberify.models.newdomain.AlbumDomainModel
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

class NewReleasesFragmentDirections private constructor() {
  private data class ActionNewReleasesFragmentToAlbumInfoFragment(
    val item: AlbumDomainModel
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_newReleasesFragment_to_albumInfoFragment

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
    fun actionNewReleasesFragmentToAlbumInfoFragment(item: AlbumDomainModel): NavDirections =
        ActionNewReleasesFragmentToAlbumInfoFragment(item)
  }
}
