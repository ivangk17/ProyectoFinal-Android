package com.example.login.data.network.services

import com.example.login.data.models.ErrorResponse
import com.example.login.data.models.UserLogin
import com.example.login.data.network.Api
import com.example.login.data.network.RetrofitClient
import com.example.login.tokens.Token
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import retrofit2.HttpException
import javax.inject.Inject

class LoginService @Inject constructor(
    private val apiService: Api
) {

    suspend fun login(user: UserLogin): String {
        return try {
            val response = apiService.login(user)
            Token.token = response.token
            response.token
        } catch (e: Exception) {
            val errorMessage = when (e) {
                is HttpException -> {
                    val errorBody = e.response()?.errorBody()?.string()
                    val errorResponse = try {
                        Gson().fromJson(errorBody, ErrorResponse::class.java)
                    } catch (jsonException: JsonSyntaxException) {
                        ErrorResponse(errorBody ?: "Error desconocido contactar con el asegurador")
                    }
                    errorResponse?.error ?: "Error desconocido contactar con el asegurador"
                }

                else -> e.message ?: "Error desconocido contactar con el asegurador"
            }
            throw Exception(errorMessage)
        }
    }
}
