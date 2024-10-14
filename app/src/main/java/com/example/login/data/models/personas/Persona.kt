package com.example.login.data.models.personas

import com.example.login.data.models.Domicilio
import java.util.Date

open class Persona(
    open val id: Int,
    open val nombre: String,
    open val apellido: String,
    open val nombreCompleto: String,
    open val cuit: String,
    open val email: String,
    open val telefono: Int,
    open val fechaDeNacimiento: Date,
    open val sexo: String,
    open val domicilio: Domicilio
)
