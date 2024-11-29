package com.example.login.data.network.services

import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.network.Api
import com.example.login.tokens.Token
import retrofit2.Response
import javax.inject.Inject

class CrearSolicitudService @Inject constructor(
    private val apiService: Api
) {
    suspend fun enviarSolicitud(solicitud: Solicitud): Response<Unit> {
        return apiService.enviarSolicitud("Bearer ${Token.token}", solicitud)
    }

}
