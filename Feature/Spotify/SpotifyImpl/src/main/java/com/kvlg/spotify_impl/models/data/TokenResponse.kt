package com.kvlg.spotify_impl.models.data

import com.google.gson.annotations.SerializedName

/**
 * @author Konstantin Koval
 * @since 09.10.2021
 */
data class TokenResponse(
    @SerializedName("access_token")
    val token: String,
    @SerializedName("token_type")
    val tokenType: String,
    @SerializedName("expires_in")
    val expiresIn: Int
)
