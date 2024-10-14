package com.example.login.data.models.personas

import com.example.login.data.models.Domicilio
import java.util.Date

open class Persona(
    open val id: Int = -1,
    open val nombre: String = "",
    open val apellido: String = "",
    open val nombreCompleto: String = "${nombre} ${apellido}",
    open val cuit: String = "",
    open val email: String = "",
    open val telefono: Int = -1,
    open val fechaDeNacimiento: Date? = null,
    open val sexo: String = "",
    open val domicilio: Domicilio = Domicilio()
)
