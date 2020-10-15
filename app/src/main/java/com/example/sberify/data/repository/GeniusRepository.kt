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
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class GeniusRepository @Inject constructor(
    private val geniusParser: GeniusParser,
    private val database: AppDatabase,
    private val geniusApi: IGeniusApi,
) : IGeniusRepository {

    override suspend fun getKendrikLamar(): String {
        return getResult { geniusApi.getToken() }.data.toString()
    }

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Result<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Result.success(body)
            }
            return error(" ${response.code()} ${response.message()}")
        } catch (e: IOException) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Result<T> {
        println(message)
        return Result.error("Network call has failed for a following reason: $message")
    }

    override fun getLyrics(track: Track): LiveData<Result<Track>> {
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
            networkCall = { geniusParser.parseLyrics(track) },
            saveCallResult = {
                if (!isExist) {
                    database.getTrackDao().insertTrack(TrackEntity.from(it))
                }
                database.getTrackDao().updateTrackLyrics(it.id, it.lyrics!!)
            })
    }
}
