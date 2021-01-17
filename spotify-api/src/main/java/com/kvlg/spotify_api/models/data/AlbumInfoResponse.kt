package com.kvlg.spotify_api.models.data

import com.google.gson.annotations.SerializedName

data class AlbumInfoResponse(
    @SerializedName("album_type")
    val albumType: String?,
    @SerializedName("artists")
    val artists: List<ArtistResponse>?,
    @SerializedName("available_markets")
    val availableMarkets: List<String>?,
    @SerializedName("copyrights")
    val copyrights: List<CopyrightResponse>?,
    @SerializedName("external_urls")
    val externalUrls: ExternalUrlResponse,
    @SerializedName("genres")
    val genres: List<Any>?,
    @SerializedName("href")
    val href: String?,
    @SerializedName("id")
    val id: String,
    @SerializedName("images")
    val images: List<ImageResponse>?,
    @SerializedName("label")
    val label: String?,
    @SerializedName("name")
    val name: String,
    @SerializedName("popularity")
    val popularity: Int?,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("release_date_precision")
    val releaseDatePrecision: String?,
    @SerializedName("total_tracks")
    val totalTracks: Int?,
    @SerializedName("tracks")
    val tracks: TracksResponse?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("uri")
    val uri: String?
)