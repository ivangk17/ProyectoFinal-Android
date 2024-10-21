package com.example.login.data.network

import com.example.login.data.network.models.UserInfoResponse
import com.example.login.data.models.LoginResponse
import com.example.login.data.models.TokenForJson
import com.example.login.data.models.poliza.Poliza
import com.example.login.data.models.UserLogin
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
interface Api {

    // Login endpoint, which returns a token
    @POST("/api/users/login")
     suspend fun login(@Body user: UserLogin): LoginResponse

     @GET("api/polizas/list")
     suspend fun getPolizas(@Header("Authorization") token: String): Response<List<Poliza>>

     @GET("api/test/getStatus")
     suspend fun getStatus(): Response<Boolean>

     @POST("api/users/getInfoByToken")
     suspend fun getInfoUser(@Body token: TokenForJson) : UserInfoResponse

}