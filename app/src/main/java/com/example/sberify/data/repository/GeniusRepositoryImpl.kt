package com.example.sberify.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sberify.data.GeniusParser
import com.example.sberify.data.api.GeniusApi
import com.example.sberify.data.converters.DbConverter
import com.example.sberify.domain.GeniusRepository
import com.example.sberify.presentation.ui.utils.ResponseHandler.getResult
import com.kvlg.core_utils.Result
import com.kvlg.core_utils.resultLiveData
import com.kvlg.spotify_api.models.domain.RawTrackDomainModel
import com.kvlg.spotify_api.models.domain.TrackDomainModel
import com.kvlg.spotify_impl.data.database.AppDatabase
import timber.log.Timber

class GeniusRepositoryImpl(
    private val geniusParser: GeniusParser,
    private val database: com.kvlg.spotify_impl.data.database.AppDatabase,
    private val dbConverter: DbConverter,
    private val geniusApi: GeniusApi,
) : GeniusRepository {

    override suspend fun getLyrics(track: RawTrackDomainModel): LiveData<Result<TrackDomainModel?>> {
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
        return resultLiveData(
            databaseQuery = {
                database.getTrackDao().getTrackById(track.id).map {
                    it?.let {
                        dbConverter.convertTrackEntityToDomain(it)
                    }
                }
            },
            networkCall = { geniusParser.parseLyrics(url) },
            saveCallResult = {
                database.getTrackDao().updateTrackLyrics(track.id, it)
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
