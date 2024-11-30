package com.example.login.data.network.services

import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.network.Api
import com.example.login.tokens.Token
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class SolicitudesRepository @Inject constructor(
    private val apiService: Api
    ) {

    suspend fun getSolicitudes(): retrofit2.Response<List<Solicitud>> =
        withContext(Dispatchers.IO) {
            apiService.getSolicitudes("Bearer ${Token.token}")
        }

}

//Por la migración a Hilt, para gestionar las dependencias, ahora necesitamos inyectar la instancia de ApiService en SolicitudesRepository, en vez de acceder
//desde RetrofitClient (que, además  ya no está disponible como antes acá).

