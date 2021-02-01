package com.kvlg.core

import retrofit2.Response
import timber.log.Timber
import java.io.IOException

object ResponseHandler {
    suspend fun <T> getResult(call: suspend () -> Response<T>): Result<T> {
        try {
            val response = call()
            Timber.d(response.message())
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
        Timber.d(message)
        return Result.error("Network call has failed for a following reason: $message")
    }
}
