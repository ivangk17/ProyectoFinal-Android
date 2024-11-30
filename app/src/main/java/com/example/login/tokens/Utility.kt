package com.example.login.tokens

import com.auth0.android.jwt.JWT
import com.example.login.data.models.UserLogin

class Utility {

    fun decodeJWT(token: String): UserLogin {
        var user = UserLogin("", "")
        try {
            val jwt = JWT(token)
            val email = jwt.getClaim("email").asString()
            val role = jwt.getClaim("role").asString()
            user = email?.let { UserLogin(it, "") }!!
        } catch (e: Exception) {
            e.printStackTrace()

        }
        return user
    }


}