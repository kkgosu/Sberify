package com.example.sberify

import com.kvlg.model.data.spotify.*

class MockTestUtils {
    companion object {

        fun mockImageData() = ImageData("url", 0, 0)

        fun mockArtistData() =
                ArtistData("1",
                        listOf(mockImageData()),
                        "artistName",
                        emptyList(),
                        0)

        fun mockAlbumsData() = AlbumsData(AlbumsData.Items(listOf(mockAlbumData())))

        fun mockAlbumData() = AlbumData("1",
                listOf(mockArtistData()),
                listOf(mockImageData()),
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

        fun mockTrack() = Track("1", "trackName", mockImage(), listOf(mockArtist()), null, false)
        fun mockTrackDB() = Track("1", "trackName", Image(null),
                listOf(mockArtistDB()), null, false)

        fun mockImage() = Image("url", 0, 0)
        fun mockArtist() = Artist("1", mockImage(), "artistName", emptyList())
        fun mockArtistDB() = Artist("1", null, "artistName", emptyList())
        fun mockAlbum() = Album("1", mockArtist(), "albumName", emptyList(), "url", "01.01.1970")
    }
}