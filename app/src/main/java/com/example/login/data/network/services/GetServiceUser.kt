package com.example.login.data.network.services

import android.util.Log
import androidx.compose.runtime.MutableState
import com.example.login.data.models.ChangePasswordRequest
import com.example.login.data.network.models.UserInfoResponse
import com.example.login.data.models.TokenForJson
import com.example.login.data.network.Api
import com.example.login.tokens.Token
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class GetServiceUser(
    private val api: Api
) {
    suspend fun execute(): UserInfoResponse = withContext(Dispatchers.IO) {
        val token = TokenForJson(Token.token)
        api.getInfoUser(token)
    }

    suspend fun changePassword(userId: String, oldPass: String, newPass: String, confirmPassword: String): Response<Unit> = withContext(Dispatchers.IO) {
        val token = "Bearer " + Token.token
        val changePasswordRequest = ChangePasswordRequest(oldPass, newPass, confirmPassword)
        api.changePassword(userId, token, changePasswordRequest)
    }

}