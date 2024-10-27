package com.example.login.tokens
import com.auth0.android.jwt.JWT
import com.example.login.data.models.User

class Utility {
//
    fun decodeJWT(token: String) : User {
        var user = User("","")
        try {
            val jwt = JWT(token)
            val email = jwt.getClaim("email").asString()
            val role = jwt.getClaim("role").asString()
             user = email?.let { User(it,"") }!!
        } catch (e: Exception) {
            e.printStackTrace()

        }
        return user
    }


}