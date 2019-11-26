package com.example.sberify.data.api

import com.example.sberify.BuildConfig
import com.example.sberify.data.model.AlbumData
import com.example.sberify.data.model.AlbumsData
import com.example.sberify.data.model.ArtistsData
import com.example.sberify.data.model.TracksData
import com.example.sberify.domain.model.Album
import com.example.sberify.domain.model.Token
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
import retrofit2.http.Headers

interface ISpotifyApi {

    @FormUrlEncoded
    @Headers(BuildConfig.BASIC)
    @POST("https://accounts.spotify.com/api/token/")
    suspend fun getToken(
            @Field("grant_type") grandType: String = "client_credentials"): Token

    @GET("browse/new-releases")
    suspend fun getNewReleases(
            @Query("limit") limit: Int = 50): AlbumsData

    @GET("albums/{id}")
    suspend fun getAlbumInfo(
            @Path("id") id: String): AlbumData

    @GET("search")
    suspend fun searchArtist(
            @Query("q") keyword: String,
            @Query("type") type: String): ArtistsData

    @GET("search")
    suspend fun searchAlbum(
            @Query("q") keyword: String,
            @Query("type") type: String): AlbumsData


    @GET("search")
    suspend fun searchTrack(
            @Query("q") keyword: String,
            @Query("type") type: String): TracksData
}