package com.example.sberify.data.api

import com.example.sberify.models.newdata.AlbumInfoResponse
import com.example.sberify.models.newdata.AlbumsResponse
import com.example.sberify.models.newdata.ArtistsResponse
import com.example.sberify.models.newdata.NewReleasesResponse
import com.example.sberify.models.newdata.TracksResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ISpotifyApi {

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
        @Query("type") type: String
    ): Response<ArtistsResponse>

    @GET("search")
    suspend fun searchAlbum(
        @Query("q") keyword: String,
        @Query("type") type: String
    ): Response<AlbumsResponse>

    @GET("search")
    suspend fun searchTrack(
        @Query("q") keyword: String,
        @Query("type") type: String
    ): Response<TracksResponse>

    companion object {
        const val API_URL = "https://api.spotify.com/v1/"
    }
}
