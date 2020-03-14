package com.example.sberify.models.domain

import android.os.Parcel
import android.os.Parcelable

data class Album(
    val id: String,
    val artist: Artist,
    val name: String,
    val tracks: List<Track>? = null,
    val imageUrl: String,
    val releaseDate: String,
    var isFavorite: Boolean = false
) : BaseModel(id), Parcelable {


    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.let {
            it.writeString(id)
            it.writeParcelable(artist, Parcelable.PARCELABLE_WRITE_RETURN_VALUE)
            it.writeString(name)
            it.writeString(imageUrl)
            it.writeString(releaseDate)
        }
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Album> {
        override fun createFromParcel(parcel: Parcel): Album {
            return Album(
                parcel.readString()!!,
                parcel.readParcelable(
                    ((Artist::class) as Any).javaClass.classLoader
                )!!,
                parcel.readString()!!,
                parcel.createTypedArrayList(Track) as List<Track>,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readByte() != 0.toByte()
            )
        }

        override fun newArray(size: Int): Array<Album?> {
            return arrayOfNulls(size)
        }
    }


}