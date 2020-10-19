package com.example.sberify.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import com.example.sberify.data.GeniusParser
import com.example.sberify.data.Result
import com.example.sberify.data.api.IGeniusApi
import com.example.sberify.data.db.AppDatabase
import com.example.sberify.data.db.track.TrackEntity
import com.example.sberify.data.resultLiveData
import com.example.sberify.domain.IGeniusRepository
import com.example.sberify.models.domain.Track
import com.example.sberify.presentation.ui.utils.ResponseHandler.getResult
import javax.inject.Inject

class GeniusRepository @Inject constructor(
    private val geniusParser: GeniusParser,
    private val database: AppDatabase,
    private val geniusApi: IGeniusApi,
) : IGeniusRepository {

    override suspend fun getLyrics(track: Track): LiveData<Result<Track>> {
        val filterTrackName = filterTrackName(track.name)
        val query = filterQuery("${track.artists.firstOrNull()?.name.orEmpty()} $filterTrackName")
        val responseResult = getResult { geniusApi.getPath(query) }
        val url = responseResult.data?.response?.hits?.find {
            it.type == "song" && !it.result.url.contains("annotated", ignoreCase = true) && !it.result.url.contains("spotify", ignoreCase = true)
        }?.result?.url
        println(query)
        println(url)
        if (url == null || url.isEmpty()) {
            return MutableLiveData(Result.error(message = "Didn't find lyrics :C"))
        }
        var isExist = false

        return resultLiveData(
            databaseQuery = {
                database.getTrackDao().getTrackById(track.id).map {
                    it?.let {
                        isExist = true
                        it.toTrack()
                    }
                }
            },
            networkCall = { geniusParser.parseLyrics(track, url) },
            saveCallResult = {
                if (!isExist) {
                    database.getTrackDao().insertTrack(TrackEntity.from(it))
                }
                database.getTrackDao().updateTrackLyrics(it.id, it.lyrics!!)
            })
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
