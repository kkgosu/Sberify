package com.example.sberify.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.sberify.data.GeniusParser
import com.example.sberify.data.Result
import com.example.sberify.data.db.AppDatabase
import com.example.sberify.data.db.track.TrackEntity
import com.example.sberify.data.resultLiveData
import com.example.sberify.domain.IGeniusRepository
import com.example.sberify.models.domain.Track
import javax.inject.Inject

class GeniusRepository @Inject constructor(
        private val geniusParser: GeniusParser,
        private val database: AppDatabase) : IGeniusRepository {

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
