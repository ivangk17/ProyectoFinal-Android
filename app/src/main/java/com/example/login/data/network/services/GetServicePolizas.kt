package com.example.login.data.network.services

import com.example.login.data.models.poliza.Poliza
import com.example.login.data.network.Api
import com.example.login.tokens.Token
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class GetServicePolizas @Inject constructor(
    private val api: Api
) {
    suspend fun getPolizas(): Response<List<Poliza>> = withContext(Dispatchers.IO){
        api.getPolizas("Bearer ${Token.token}")
    }

    suspend fun getPoliza(dominio: String): Poliza = withContext(Dispatchers.IO){
        api.getPoliza("Bearer ${Token.token}", dominio)
    }
}