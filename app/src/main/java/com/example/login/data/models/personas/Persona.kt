package com.example.login.data.models.personas

import com.example.login.data.models.Domicilio
import java.util.Date

data class Persona(
    var nombre: String = "",
    var apellido: String = "",
    var nombreCompleto: String = "${nombre} ${apellido}",
    var dni: Number = -1,
    var email: String = "",
    var telefono: String = "",
    var fechaDeNacimiento: String= "",
    var sexo: Sexo = Sexo.HOMBRE,
    var domicilio: Domicilio = Domicilio()
)
