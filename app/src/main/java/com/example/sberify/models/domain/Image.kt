package com.example.sberify.models.domain

import android.os.Parcel
import android.os.Parcelable

data class Image(val url: String?, val height: Int = 0, val width: Int = 0) : BaseModel(), Parcelable {

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
            return Image(parcel.readString()!!, parcel.readInt(),
                    parcel.readInt())
        }

        override fun newArray(size: Int): Array<Image?> {
            return arrayOfNulls(size)
        }
    }
}