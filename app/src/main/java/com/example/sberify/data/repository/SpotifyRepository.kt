package com.example.sberify.data.repository

import com.example.sberify.data.model.AlbumsResponse
import com.example.sberify.data.api.ISpotifyApi
import com.example.sberify.data.api.SearchTypes
import com.example.sberify.domain.ISpotifyRepository
import com.example.sberify.domain.PrefUtil
import com.example.sberify.domain.model.Token
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SpotifyRepository : ISpotifyRepository {

    private val mSpotifyApi by lazy {
        Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ISpotifyApi::class.java)
    }

    override suspend fun getToken(): Token {
        return mSpotifyApi.getToken()
    }

    override suspend fun getNewReleases(): AlbumsResponse.Items =
            mSpotifyApi.getNewReleases(PrefUtil.getStringDefaultBlank("oauthtoken")!!).albums

    override suspend fun search(keyword: String): AlbumsResponse.Artist {
        val encodedKeyword = keyword.replace(" ", "%20")
        return mSpotifyApi.search(PrefUtil.getStringDefaultBlank("oauthtoken")!!,
                encodedKeyword,
                SearchTypes.ARTIST)
    }


    companion object {
        private const val TOKEN_URL = "https://accounts.spotify.com/"
        private const val API_URL = "https://api.spotify.com/v1/"
    }
}