package com.example.sberify.presentation.ui

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sberify.domain.IGeniusRepository
import com.example.sberify.domain.ISpotifyRepository
import com.example.sberify.domain.PrefUtil
import com.example.sberify.domain.model.Album
import com.example.sberify.domain.model.Token
import com.example.sberify.domain.model.Track
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.Normalizer

class SharedViewModel(private val spotifyRepository: ISpotifyRepository,
        private val geniusRepository: IGeniusRepository) : ViewModel() {

    private val _token = MutableLiveData<Token>()
    val token: LiveData<Token> = _token

    private val _album = MutableLiveData<Album>()
    val album: LiveData<Album> = _album

    private val _newReleases = MutableLiveData<List<Album>>()
    val newReleases: LiveData<List<Album>> = _newReleases

    private val _lyrics = MutableLiveData<String>()
    val lyrics: LiveData<String> = _lyrics

    fun getData() {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                getToken()
                loadReleases()
                //searchArtist("Kanye West")
            }
        }
    }

    private suspend fun loadReleases() {
        _newReleases.postValue(spotifyRepository.getNewReleases())
    }

    private suspend fun getToken() {
        //delay(5000)
        val token = spotifyRepository.getToken()
        _token.postValue(token)
        PrefUtil.setString("oauthtoken", "Bearer ${token.access_token}")
    }

    fun getAlbumInfo(album: Album) {
        viewModelScope.launch {
            _album.value = album
            val albumInfo = spotifyRepository.getAlbumInfo(album.id)
            if (albumInfo.isNotEmpty()) {
                _album.postValue(albumInfo[0])
            }
        }
    }

    fun getLyrics(track: Track) {
        viewModelScope.launch {
            _lyrics.value = ""

            var lyrics: String
            val trackName: String = filterTrackName(track.name)
            var trackUrl: String = filterLyricsUrl(
                    "${(track.artists[0].name).normalize()} $trackName")

            lyrics = geniusRepository.getLyrics(trackUrl)
            println(trackUrl)

            if (lyrics == HTTP_ERROR) {
                if (track.artists.size > 1) {
                    val stringBuilder = StringBuilder()
                    track.artists.forEachIndexed { index, artist ->
                        stringBuilder.append((artist.name).normalize())
                        if (index != track.artists.size - 1) {
                            stringBuilder.append(" and ")
                        }
                    }
                    trackUrl = filterLyricsUrl("$stringBuilder $trackName")
                    println(trackUrl)
                    lyrics = geniusRepository.getLyrics(trackUrl)
                }
            }
            _lyrics.postValue(lyrics)
        }
    }
    
    @SuppressLint("DefaultLocale")
    private fun filterTrackName(trackName: String): String {
        //val toLatin = Transliterator.getInstance(TRANSLITERATE_VALUE)
        var result: String = trackName.normalize()
        val regexFeat = Regex(".*(feat).*")
        val regexWith = Regex(".*[(\\[]with.*")
        result = when {
            result.toLowerCase().matches(regexFeat) -> result.substringBefore("feat")
                    .dropLast(2)
            result.toLowerCase().matches(regexWith) -> result.substringBefore("with")
                    .dropLast(2)
            else -> result
        }
        return result
    }

    private fun filterLyricsUrl(track: String): String {
        val regex = Regex("[^A-Za-z0-9\\-&]")
        return "$track lyrics"
                .replace(" ", "-")
                .replace("&", "and")
                .replace(regex, "")
    }


    private fun search(keyword: String) {
        viewModelScope.launch {
            println(spotifyRepository.search(keyword))
        }
    }

    companion object {
        private const val HTTP_ERROR = "HTTP error fetching URL"
        private const val TRANSLITERATE_VALUE = "Latin-Russian/BGN"
    }
}

