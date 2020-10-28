package com.kvlg.shared.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.kvlg.model.common.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay

fun <T, A> resultLiveData(
    databaseQuery: () -> LiveData<T>,
    networkCall: suspend () -> Result<A>,
    saveCallResult: suspend (A) -> Unit
): LiveData<Result<T>> =
    liveData(Dispatchers.IO) {
        emit(Result.loading())
        val source = databaseQuery().map { Result.success(it) }
        emitSource(source)

        val responseStatus = networkCall()
        if (responseStatus.status == Result.Status.SUCCESS) {
            saveCallResult(responseStatus.data!!)
            val newSource = databaseQuery().map { Result.success(it) }
            emitSource(newSource)
        } else if (responseStatus.status == Result.Status.ERROR) {
            emit(Result.error(responseStatus.message!!))
            delay(100)
            emitSource(source)
        }
    }

fun <T, A> resultData(
    databaseQuery: suspend () -> T,
    networkCall: suspend () -> Result<A>,
    saveCallResult: suspend (A) -> Unit
): LiveData<T> =
    liveData(Dispatchers.IO) {
        val source = databaseQuery()
        emit(source)
        val responseStatus = networkCall()
        if (responseStatus.status == Result.Status.SUCCESS) {
            saveCallResult.invoke(responseStatus.data!!)
            val newSource = databaseQuery()
            emit(newSource)
        } else if (responseStatus.status == Result.Status.ERROR) {
            delay(100)
            emit(source)
        }
    }