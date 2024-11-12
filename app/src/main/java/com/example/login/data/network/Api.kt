package com.example.login.data.network

import com.example.login.data.models.ChangePasswordRequest
import com.example.login.data.network.models.UserInfoResponse
import com.example.login.data.models.LoginResponse
import com.example.login.data.models.TokenForJson
import com.example.login.data.models.UserInfoChange
import com.example.login.data.models.poliza.Poliza
import com.example.login.data.models.UserLogin
import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.models.solicitud.SolicitudSimplificada
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

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

    @POST("api/solicitudes/send")
    suspend fun enviarSolicitud(@Body solicitud: Solicitud?): Response<Unit>

    //Para obtener las solicitudes simplificadas
    @GET("/api/solicitudes/list")
    suspend fun getSolicitudes(@Header("Authorization") token: String): Response <List<Solicitud>>

    @GET("/api/solicitudes/buscarSolicitud")
    suspend fun  getSolicitud(@Header("Authorization") token: String, @Query("idSolicitud") idSolicitud: String): Solicitud

    @GET("api/polizas/buscarPolizaPorDominio")
    suspend fun getPoliza(@Header("Authorization") token: String, @Query("dominio") dominio: String): Poliza

    @POST("/api/users/changePassword/{id}")
    suspend fun changePassword(
        @Path("id") id: String,
        @Header("Authorization") token: String,
        @Body changePasswordRequest: ChangePasswordRequest
    ): Response<Unit>

    @PUT("api/users/editarPerfil")
    suspend fun editarPerfil(
        @Header("Authorization") token: String,
        @Body userInfoChange: UserInfoChange
    ): Response<Unit>

}