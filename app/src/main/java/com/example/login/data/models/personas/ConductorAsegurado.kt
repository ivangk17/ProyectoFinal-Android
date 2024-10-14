package com.example.login.data.models.personas

import com.example.login.data.models.Domicilio
import java.util.Date

data class ConductorAsegurado(
    override val id: Int = -1,
    override val nombre: String = "",
    override val apellido: String = "",
    override val nombreCompleto: String = "${nombre} ${apellido}",
    override val cuit: String = "",
    override val email: String = "",
    override val telefono: Int = -1,
    override val fechaDeNacimiento: Date? = null,
    override val sexo: String = "",
    override val domicilio: Domicilio = Domicilio(),

    val nroRegistro: String = "",
    val claseRegistro: String = "",
    val relacionAsegurado: String = "",
    val fechaExpedicion: Date? = null,
    val fechaVencimiento: Date? = null
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
