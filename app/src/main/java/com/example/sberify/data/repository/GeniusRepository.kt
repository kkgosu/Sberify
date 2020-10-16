package com.example.sberify.data.repository

import androidx.lifecycle.LiveData
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
        val query = "${track.artists.firstOrNull()?.name.orEmpty()} ${track.name}"
        val responseResult = getResult { geniusApi.getPath(query) }
        val url = responseResult.data?.response?.hits?.firstOrNull { !it.result.url.contains("annotated") && it.type == "song" }?.let {
            it.result.url
        } ?: run {
            throw IllegalStateException("Didn't find lyrics :C")
        }
        println(query)
        println(url)
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
}
