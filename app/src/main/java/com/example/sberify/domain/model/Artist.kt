package com.example.sberify.domain.model

import android.os.Parcel
import android.os.Parcelable

data class Artist(val id: String,
        val image: Image?,
        val name: String,
        val genres: List<String>?) : BaseModel(), Parcelable {

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeParcelable(image, Parcelable.PARCELABLE_WRITE_RETURN_VALUE)
        parcel.writeString(name)
        parcel.writeStringList(genres)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Artist> {
        override fun createFromParcel(parcel: Parcel): Artist {
            return Artist(parcel.readString()!!,
                    parcel.readParcelable(((Image::class) as Any).javaClass.classLoader),
                    parcel.readString()!!,
                    parcel.createStringArrayList() as List<String>)
        }

        override fun newArray(size: Int): Array<Artist?> {
            return arrayOfNulls(size)
        }
    }

}
