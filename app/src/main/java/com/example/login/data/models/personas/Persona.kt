package com.example.login.data.models.personas

import com.example.login.data.models.Domicilio
import java.util.Date

open class Persona(
    open val id: Int = -1,
    open var nombre: String = "",
    open var apellido: String = "",
    open var nombreCompleto: String = "${nombre} ${apellido}",
    open var cuit: String = "",
    open var email: String = "",
    open var telefono: String = "",
    open var fechaDeNacimiento: String= "",
    open var sexo: String = "",
    open var domicilio: Domicilio = Domicilio()
)
