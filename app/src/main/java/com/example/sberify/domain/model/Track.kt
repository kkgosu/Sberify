package com.example.sberify.domain.model

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable

data class Track(val id: String, val name: String,
        val artists: List<Artist>,
        val explicit: Boolean = false) : BaseModel(), Parcelable {

    @SuppressLint("NewApi")
    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.let {
            it.writeString(id)
            it.writeParcelableList(artists, Parcelable.CONTENTS_FILE_DESCRIPTOR)
            it.writeString(name)
        }
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Track> {
        override fun createFromParcel(parcel: Parcel): Track {
            return Track(parcel.readString()!!,
                    parcel.readString()!!,
                    parcel.createTypedArrayList(Artist.CREATOR) as List<Artist>)
        }

        override fun newArray(size: Int): Array<Track?> {
            return arrayOfNulls(size)
        }
    }
}