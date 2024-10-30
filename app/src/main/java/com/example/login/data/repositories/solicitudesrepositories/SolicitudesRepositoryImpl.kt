package com.example.login.data.repositories.solicitudesrepositories

import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.network.RetrofitClient
import com.example.login.tokens.Token
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class SolicitudesRepositoryImpl() {

    suspend fun getSolicitudes(): retrofit2.Response<List<Solicitud>> =
        withContext(Dispatchers.IO) {
            RetrofitClient.apiService.getSolicitudes("Bearer ${Token.token}")
        }

}



