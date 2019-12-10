package com.example.sberify.data.repository

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.sberify.data.GeniusParser
import com.example.sberify.data.Result
import com.example.sberify.data.api.BaseResponseHandler
import com.example.sberify.data.db.AppDatabase
import com.example.sberify.data.db.track.TrackEntity
import com.example.sberify.data.resultLiveData
import com.example.sberify.domain.IGeniusRepository
import com.example.sberify.models.domain.Track
import com.example.sberify.presentation.ui.utils.normalize
import javax.inject.Inject

class GeniusRepository @Inject constructor(
        private val geniusParser: GeniusParser,
        private val database: AppDatabase) : BaseResponseHandler(), IGeniusRepository {

    override fun getLyrics(track: Track): LiveData<Result<Track>> {
        return resultLiveData(
                databaseQuery = {
                    database.getTrackDao().getTrackById(track.id).map {
                        it?.let {
                            it.toTrack()
                        }
                    }
                },
                networkCall = { parseLyrics(track) },
                saveCallResult = {
                    database.getTrackDao().insertTrack(TrackEntity.from(it))
                })
    }

    private fun parseLyrics(track: Track): Result<Track> {
        var lyrics = ""
        val trackName: String = filterTrackName(track.name)
        var trackUrl: String = filterLyricsUrl(
                "${track.artists[0].name.normalize()} $trackName")

        println(trackUrl)
        lyrics = geniusParser.getLyrics(trackUrl)
        if (lyrics == HTTP_ERROR) {
            if (track.artists.size > 1) {
                val stringBuilder = StringBuilder()
                track.artists.forEachIndexed { index, artist ->
                    stringBuilder.append(artist.name.normalize())
                    if (index != track.artists.size - 1) {
                        stringBuilder.append(" and ")
                    }
                }
                println(trackUrl)
                trackUrl = filterLyricsUrl("$stringBuilder $trackName")
                lyrics = geniusParser.getLyrics(trackUrl)
            }
        }
        track.lyrics = lyrics
        return Result(Result.Status.SUCCESS, track, null)
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