package com.example.sberify

import com.example.sberify.models.data.*
import com.example.sberify.models.domain.*

class MockTestUtils {
    companion object {

        fun mockToken() = Token("1", "type", 0.0)

        fun mockImageData() = ImageData("url", 0, 0)

        fun mockArtistData() =
                ArtistData("1",
                        emptyList(),
                        "artistName",
                        emptyList(),
                        0)

        fun mockAlbumData() = AlbumData("1",
                emptyList(),
                emptyList(),
                "albumName",
                mockTrackDataItems(),
                0,
                "01.01.1970")

        fun mockTrackData() = TrackData(
                "1",
                "trackName",
                mockAlbumData(),
                listOf(mockArtistData()),
                0,
                0)

        fun mockTrackDataItems(): TracksData.Items = TracksData.Items(emptyList())

        fun mockTrack() = Track("1", "trackName", mockImage(), emptyList(), null, false)
        fun mockImage() = Image("url", 0, 0)
        fun mockArtist() = Artist("1", mockImage(), "artistName", emptyList())
        fun mockAlbum() = Album("1", mockArtist(), "albumName", emptyList(), "url", "01.01.1970")
    }
}