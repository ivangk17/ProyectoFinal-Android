package com.example.login.data.models.personas.user

import com.example.login.data.models.Domicilio
import com.example.login.data.models.personas.Persona
import java.util.Date

data class User(
    val password: String,
    val role: Role,
)
