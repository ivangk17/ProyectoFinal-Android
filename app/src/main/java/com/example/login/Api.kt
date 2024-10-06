package com.example.login

import android.telecom.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
interface Api {

    // Login endpoint, which returns a token
    @POST("/api/users/login")
     suspend fun login(@Body user: User): LoginResponse


}