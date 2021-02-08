package com.kvlg.genius_impl.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import com.kvlg.core.ResponseHandler
import com.kvlg.core.Result
import com.kvlg.core.database.AppDatabase
import com.kvlg.core.models.RawTrackModel
import com.kvlg.core.resultLiveData
import com.kvlg.core_db.database.DbConverter
import com.kvlg.genius_impl.data.network.GeniusApiMapper
import com.kvlg.spotify_models.domain.TrackDomainModel
import timber.log.Timber

/**
 * @author Konstantin Koval
 * @since 18.01.2021
 */
class GeniusRepositoryImpl(
    private val geniusParser: GeniusParser,
    private val database: AppDatabase,
    private val dbConverter: DbConverter,
    private val geniusApi: GeniusApiMapper,
) : GeniusRepository {

    override suspend fun getLyrics(track: RawTrackModel): LiveData<Result<TrackDomainModel?>> {
        val filterTrackName = filterTrackName(track.name)
        val query = filterQuery("${track.artistNames} $filterTrackName")
        val responseResult = ResponseHandler.getResult { geniusApi.getPath(query) }
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