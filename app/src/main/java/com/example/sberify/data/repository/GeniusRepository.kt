package com.example.sberify.data.repository

import android.annotation.SuppressLint
import com.example.sberify.data.GeniusParser
import com.example.sberify.data.db.AppDatabase
import com.example.sberify.data.db.track.TrackEntity
import com.example.sberify.domain.IGeniusRepository
import com.example.sberify.domain.model.Track
import com.example.sberify.presentation.ui.utils.normalize
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GeniusRepository @Inject constructor(
        private val geniusParser: GeniusParser,
        private val database: AppDatabase) : IGeniusRepository {

    override suspend fun getLyrics(track: Track): String {
        var lyrics = ""
        val trackName: String = filterTrackName(track.name)
        var trackUrl: String = filterLyricsUrl(
                "${track.artists[0].name.normalize()} $trackName")

        withContext(Dispatchers.IO) {
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
            database.getTrackDao()
                    .insertTrack(TrackEntity.from(track))
        }
        return lyrics
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