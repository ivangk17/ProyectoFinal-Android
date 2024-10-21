package com.example.login.data.network.services

import android.util.Log
import com.example.login.data.network.models.UserInfoResponse
import com.example.login.data.models.TokenForJson
import com.example.login.data.network.Api
import com.example.login.tokens.Token
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetServiceUser(
    private val api: Api
) {
    suspend fun execute(): UserInfoResponse = withContext(Dispatchers.IO) {
        val token = TokenForJson(Token.token)
        Log.d("JSON", Gson().toJson(token))  // Esto imprimirá {"token":"tu_token_aqui"}
        api.getInfoUser(token)
    }
}