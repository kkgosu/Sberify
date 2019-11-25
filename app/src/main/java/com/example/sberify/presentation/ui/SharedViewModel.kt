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
import com.example.sberify.domain.model.Artist
import com.example.sberify.domain.model.Token
import com.example.sberify.domain.model.Track
import com.example.sberify.presentation.ui.utils.normalize
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
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

    private val _albums = MutableLiveData<List<Album>>()
    val albums: LiveData<List<Album>> = _albums

    private val _artist = MutableLiveData<List<Artist>>()
    val artist: LiveData<List<Artist>> = _artist

    private val _track = MutableLiveData<List<Track>>()
    val track: LiveData<List<Track>> = _track

    fun getData() {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                getToken()
                loadReleases()
            }
        }
    }

    private suspend fun loadReleases() {
        _newReleases.postValue(spotifyRepository.getNewReleases())
    }

    private suspend fun getToken() {
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
                    "${track.artists[0].name.normalize()} $trackName")

            lyrics = geniusRepository.getLyrics(trackUrl)
            println(trackUrl)

            if (lyrics == HTTP_ERROR) {
                if (track.artists.size > 1) {
                    val stringBuilder = StringBuilder()
                    track.artists.forEachIndexed { index, artist ->
                        stringBuilder.append(artist.name.normalize())
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

    fun searchArtist(keyword: String) {
        viewModelScope.launch {
            val searchArtist = spotifyRepository.searchArtist(keyword)
            println(searchArtist)
            _artist.postValue(searchArtist)
        }
    }

    fun searchAlbum(keyword: String) {
        viewModelScope.launch {
            val searchAlbum = spotifyRepository.searchAlbum(keyword)
            println(searchAlbum)
            _albums.postValue(searchAlbum)
        }
    }

    fun searchTrack(keyword: String) {
        viewModelScope.launch {
            val searchTrack = spotifyRepository.searchTrack(keyword)
            println(searchTrack)
            _track.postValue(searchTrack)
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

    companion object {
        private const val HTTP_ERROR = "HTTP error fetching URL"
        private const val TRANSLITERATE_VALUE = "Latin-Russian/BGN"
    }
}

