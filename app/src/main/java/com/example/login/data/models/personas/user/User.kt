package com.example.login.data.models.personas.user

import com.example.login.data.models.Domicilio
import com.example.login.data.models.personas.Persona
import java.util.Date

data class User(
    val password: String,
    val role: Role,
    override val id: Int,
    override var nombre: String,
    override var apellido: String,
    override var nombreCompleto: String,
    override var cuit: String,
    override var email: String,
    override var telefono: String,
    override var  fechaDeNacimiento: String,
    override var sexo: String,
    override var domicilio: Domicilio
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
