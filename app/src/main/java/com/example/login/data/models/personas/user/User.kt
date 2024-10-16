package com.example.login.data.models.personas.user

import com.example.login.data.models.Domicilio
import com.example.login.data.models.personas.Persona
import java.util.Date

data class User(
    val password: String,
    val role: Role,
    override val id: Int,
    override val nombre: String,
    override val apellido: String,
    override val nombreCompleto: String,
    override val cuit: String,
    override val email: String,
    override val telefono: String,
    override val  fechaDeNacimiento: String,
    override val sexo: String,
    override val domicilio: Domicilio
) : Persona(
    id,
    nombre,
    apellido,
    nombreCompleto,
    cuit,
    email,
    telefono,
    fechaDeNacimiento,
    sexo,
    domicilio
)
