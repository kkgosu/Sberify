package com.example.sberify.domain.model

import android.os.Parcel
import android.os.Parcelable

data class Image(val url: String, val height: Int, val width: Int) : BaseModel(), Parcelable {

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(url)
        parcel.writeInt(height)
        parcel.writeInt(width)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Image> {
        override fun createFromParcel(parcel: Parcel): Image {
            return Image(parcel.readString()!!, parcel.readInt(), parcel.readInt())
        }

        override fun newArray(size: Int): Array<Image?> {
            return arrayOfNulls(size)
        }
    }
}