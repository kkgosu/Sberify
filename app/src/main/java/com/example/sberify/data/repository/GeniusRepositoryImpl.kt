package com.example.sberify.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import com.example.sberify.data.DbConverter
import com.example.sberify.data.GeniusParser
import com.example.sberify.data.ResponseConverter
import com.example.sberify.data.Result
import com.example.sberify.data.api.GeniusApi
import com.example.sberify.data.db.AppDatabase
import com.example.sberify.data.resultLiveData
import com.example.sberify.domain.GeniusRepository
import com.example.sberify.models.domain.TrackDomainModel
import com.example.sberify.presentation.ui.utils.ResponseHandler.getResult
import timber.log.Timber
import javax.inject.Inject

class GeniusRepositoryImpl @Inject constructor(
    private val geniusParser: GeniusParser,
    private val database: AppDatabase,
    private val dbConverter: DbConverter,
    private val geniusApi: GeniusApi,
    private val responseConverter: ResponseConverter
) : GeniusRepository {

    override suspend fun getLyrics(track: TrackDomainModel): LiveData<Result<TrackDomainModel?>> {
        val filterTrackName = filterTrackName(track.name)
        val query = filterQuery("${track.artistNames} $filterTrackName")
        val responseResult = getResult { geniusApi.getPath(query) }
        val url = responseResult.data?.response?.hits?.find {
            it.type == "song" && !it.result.url.contains(
                "annotated",
                ignoreCase = true
            ) && !it.result.url.contains("spotify", ignoreCase = true)
        }?.result?.url
        Timber.d(query)
        Timber.d(url)
        if (url == null || url.isEmpty()) {
            return MutableLiveData(Result.error(message = "Didn't find lyrics :C"))
        }
        var isExist = false

        return resultLiveData(
            databaseQuery = {
                database.getTrackDao().getTrackById(track.id).map {
                    it?.let {
                        isExist = true
                        dbConverter.convertTrackEntityToDomain(it)
                    }
                }
            },
            networkCall = { geniusParser.parseLyrics(track, url) },
            saveCallResult = {
                database.getTrackDao().updateTrackLyrics(it.id, it.lyrics)
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
