package com.example.sberius

import retrofit2.Call
import retrofit2.http.*

interface RequestApi {
    @FormUrlEncoded
    @Headers("Authorization: Basic NDllMTEwY2RhNWI2NGQ2ZDg5NDc2ZjQwNjg3NzI1YzQ6OWQ3NmVmMGRjZjBjNDhiZWJlYmUxNTM3ZDhiMTE0Y2Y=")
    @POST(".")
    fun getToken(@Field("grant_type") grandType: String = "client_credentials"): Call<Any>
}