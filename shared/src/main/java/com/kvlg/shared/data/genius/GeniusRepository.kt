package com.kvlg.shared.data.genius

import com.kvlg.model.presentation.Image
import com.kvlg.model.presentation.Track
import com.kvlg.network.ResponseHandler.getResult
import com.kvlg.network.genius.GeniusApi
import com.kvlg.network.genius.GeniusParser
import com.kvlg.shared.data.db.AppDatabase
import com.kvlg.shared.data.db.track.TrackEntity
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository for working with genius' data
 *
 * @author Konstantin Koval
 * @since 25.10.2020
 */
interface GeniusRepository {
    fun getLyricsFromDb(track: Track): Track?
    suspend fun parseLyrics(track: Track): Track
    fun saveLyricsIntoDb(track: Track)
}

@Singleton
class GeniusRepositoryImpl @Inject constructor(
    private val database: AppDatabase,
    private val geniusParser: GeniusParser,
    private val geniusApi: GeniusApi
) : GeniusRepository {

    override fun getLyricsFromDb(track: Track): Track? {
        val trackEntity = database.getTrackDao().getTrackById(track.id)
        return trackEntity?.let {
            Track(
                id = it.spotifyId,
                name = it.name,
                image = Image(it.image_url ?: "", 0, 0),
                artists = it.artists,
                lyrics = it.lyrics,
                isFavorite = it.isFavorite
            )
        }
    }

    override suspend fun parseLyrics(track: Track): Track {
        val filterTrackName = filterTrackName(track.name)
        val query = filterQuery("${track.artists.firstOrNull()?.name.orEmpty()} $filterTrackName")
        val responseResult = getResult { geniusApi.getPath(query) }
        val url = responseResult.data?.response?.hits?.find {
            it.type == "song" && !it.result.url.contains("annotated", ignoreCase = true) && !it.result.url.contains("spotify", ignoreCase = true)
        }?.result?.url
        println(query)
        println(url)
        if (url == null || url.isEmpty()) {
            throw LyricsNotFoundException()
        }
        return geniusParser.parseLyrics(track, url)
    }

    override fun saveLyricsIntoDb(track: Track) {
        database.getTrackDao().insertTrack(
            TrackEntity(
                spotifyId = track.id,
                name = track.name,
                albumId = "",
                lyrics = track.lyrics,
                artists = track.artists,
                isFavorite = track.isFavorite,
                image_url = track.image?.url
            )
        )
    }

    private fun filterTrackName(name: String): String {
        if (name[0] == '(' || name[0] == '[')
            return name
        return name.takeWhile { it != '(' && it != '[' }
    }

    private fun filterQuery(query: String): String = query.replace(notAllowedChars, "")

    companion object {
        private val notAllowedChars = "[^0-9a-zA-Zа-яА-Я .,$-]*".toRegex()
    }
}

class LyricsNotFoundException : Exception()