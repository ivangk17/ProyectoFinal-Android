package com.example.login.data.models.personas

import com.example.login.data.models.Domicilio
import java.util.Date

data class ConductorAsegurado(
    override val id: Int,
    override val nombre: String,
    override val apellido: String,
    override val nombreCompleto: String,
    override val cuit: String,
    override val email: String,
    override val telefono: Int,
    override val  fechaDeNacimiento: Date,
    override val sexo: String,
    override val domicilio: Domicilio,

    val nroRegistro: String,
    val claseRegistro: String,
    val relacionAsegurado: String,
    val fechaExpedicion: Date,
    val fechaVencimiento: Date
): Persona(
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
