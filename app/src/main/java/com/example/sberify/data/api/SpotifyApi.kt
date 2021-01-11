package com.example.sberify.data.api

import com.example.sberify.models.data.spotify.AlbumInfoResponse
import com.example.sberify.models.data.spotify.AlbumSearchResponse
import com.example.sberify.models.data.spotify.ArtistSearchResponse
import com.example.sberify.models.data.spotify.NewReleasesResponse
import com.example.sberify.models.data.spotify.TrackSearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SpotifyApi {

    @GET("browse/new-releases")
    suspend fun getNewReleases(
        @Query("limit") limit: Int = 50
    ): Response<NewReleasesResponse>

    @GET("albums/{id}")
    suspend fun getAlbumInfo(
        @Path("id") id: String
    ): Response<AlbumInfoResponse>

    @GET("search")
    suspend fun searchArtist(
        @Query("q") keyword: String,
        @Query("type") type: String = "artist"
    ): Response<ArtistSearchResponse>

    @GET("search")
    suspend fun searchAlbum(
        @Query("q") keyword: String,
        @Query("type") type: String = "album"
    ): Response<AlbumSearchResponse>

    @GET("search")
    suspend fun searchTrack(
        @Query("q") keyword: String,
        @Query("type") type: String = "track"
    ): Response<TrackSearchResponse>

    companion object {
        const val API_URL = "https://api.spotify.com/v1/"
    }
}
