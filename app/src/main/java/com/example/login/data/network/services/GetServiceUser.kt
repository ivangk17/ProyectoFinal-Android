package com.example.login.data.network.services

import com.example.login.data.models.ChangePasswordRequest
import com.example.login.data.network.models.UserInfoResponse
import com.example.login.data.models.TokenForJson
import com.example.login.data.models.UserInfoChange
import com.example.login.data.network.Api
import com.example.login.tokens.Token
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class GetServiceUser @Inject constructor(
    private val api: Api
) {
    suspend fun execute(): UserInfoResponse = withContext(Dispatchers.IO) {
        val token = TokenForJson(Token.token)
        api.getInfoUser(token)
    }

    suspend fun changePassword(oldPass: String, newPass: String, confirmPassword: String): Response<Unit> = withContext(Dispatchers.IO) {
        val token = "Bearer " + Token.token
        val changePasswordRequest = ChangePasswordRequest(oldPass, newPass, confirmPassword)
        api.changePassword(token, changePasswordRequest)
    }

    suspend fun editarPerfil(phone: String, address: String, zip_code: String, number: String, apartment: String, floor: String?) : Response<Unit> = withContext(Dispatchers.IO){
        val token = "Bearer " + Token.token
        val userInfo = UserInfoChange(phone, address, zip_code, number, apartment, floor.toString())
        api.editarPerfil(token, userInfo)
    }

    suspend fun recoverPassword(email: String): Response<Unit> = withContext(Dispatchers.IO){
        api.recoverPassword(email)
    }


}