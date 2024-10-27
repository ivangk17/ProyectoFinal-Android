package com.example.login.data.models.personas

import com.example.login.data.models.Domicilio

data class Lesionado(
    var datosPersona: Persona = Persona(),
    var estadoCivil: String = "",
    var telefonoAlternativo: String = ""
)