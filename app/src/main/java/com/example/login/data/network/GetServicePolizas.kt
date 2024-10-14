package com.example.login.data.network

import com.example.login.data.models.poliza.Poliza
import com.example.login.tokens.Token
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class GetServicePolizas(
    private val api: Api
) {
    suspend fun execute(): Response<List<Poliza>> = withContext(Dispatchers.IO){
        api.getPolizas("Bearer ${Token.token}")
    }
}