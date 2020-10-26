package com.kvlg.network.spotify

import com.kvlg.model.data.spotify.AlbumData
import com.kvlg.model.data.spotify.AlbumsData
import com.kvlg.model.data.spotify.ArtistsData
import com.kvlg.model.data.spotify.TracksData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SpotifyApi {

    companion object {
        const val API_URL = "https://api.spotify.com/v1/"
    }

    @GET("browse/new-releases")
    suspend fun getNewReleases(
            @Query("limit") limit: Int = 50): Response<AlbumsData>

    @GET("albums/{id}")
    suspend fun getAlbumInfo(
            @Path("id") id: String): Response<AlbumData>

    @GET("search")
    suspend fun searchArtist(
            @Query("q") keyword: String,
            @Query("type") type: String): Response<ArtistsData>

    @GET("search")
    suspend fun searchAlbum(
            @Query("q") keyword: String,
            @Query("type") type: String): Response<AlbumsData>


    @GET("search")
    suspend fun searchTrack(
            @Query("q") keyword: String,
            @Query("type") type: String): Response<TracksData>
}