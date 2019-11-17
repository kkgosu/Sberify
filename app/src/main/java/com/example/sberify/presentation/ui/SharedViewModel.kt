package com.example.sberify.presentation.ui

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
                //search("Kanye West")
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
            var lyrics = ""
            var trackUrl = createLyricsUrl("${(track.artists[0].name)} ${track.name}")
            lyrics = geniusRepository.getLyrics(trackUrl)
            if (lyrics.contains(HTTP_ERROR)) {
                val newTrackName = track.name
                        .substringBefore("feat")
                        .dropLast(2)

                if (track.name.contains("feat")) {
                    trackUrl = createLyricsUrl("${(track.artists[0].name)} $newTrackName")
                    lyrics = geniusRepository.getLyrics(trackUrl)
                }
                if (lyrics.contains(HTTP_ERROR)) {
                    if (track.artists.size > 1) {
                        trackUrl = createLyricsUrl(
                                "${(track.artists[0].name)} and ${(track.artists[1].name)} " +
                                        newTrackName)
                        lyrics = geniusRepository.getLyrics(trackUrl)
                    }
                }
            }
            _lyrics.postValue(lyrics)
        }
    }

    private fun createLyricsUrl(track: String): String {
        val regex = Regex("[^A-Za-z0-9\\-&]")
        return "$track lyrics"
                .replace(" ", "-")
                .replace("&", "and")
                .replace(regex, "")

    }


    private suspend fun search(keyword: String) {
        println(spotifyRepository.search(keyword))
    }

    companion object {
        private const val HTTP_ERROR = "HTTP error fetching URL"
    }
}

