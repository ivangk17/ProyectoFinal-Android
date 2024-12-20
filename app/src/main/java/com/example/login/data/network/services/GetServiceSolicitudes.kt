package com.example.login.data.network.services

import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.network.Api
import com.example.login.tokens.Token
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetServiceSolicitudes @Inject constructor(
    private val api: Api
) {
    suspend fun getSolicitud(idSolicitud: String): Solicitud = withContext(Dispatchers.IO) {
        api.getSolicitud("Bearer ${Token.token}", idSolicitud)
    }
}