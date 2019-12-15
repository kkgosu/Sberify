package com.example.sberify

import retrofit2.Response

object ApiUtil {
    fun <T> getCall(data: T) = Response.success(data)

}