package com.example.sberify.data.api

import com.example.sberify.data.Result
import retrofit2.Response
import java.io.IOException

abstract class BaseResponseHandler {
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
}