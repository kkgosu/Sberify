package com.kvlg.shared.data

import com.kvlg.model.common.Result
import retrofit2.Response
import java.io.IOException

suspend fun <T> getResult(call: suspend () -> Response<T>): Result<T> {
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


suspend fun <T> getResponse(call: suspend () -> Response<T>): T {
    val response = call()
    if (response.isSuccessful) {
        val body = response.body()
        if (body != null) return body
    }
    throw IOException("Network call has failed for a following reason: ${response.code()} ${response.message()}")
}