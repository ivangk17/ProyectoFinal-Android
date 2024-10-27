package com.example.login.data.models.personas

data class ConductorAsegurado(
    var datosPersona: Persona = Persona(),
    var nroRegistro: String = "",
    var claseRegistro: String = "",
    var relacionAsegurado: String = "",
    var fechaRegistroExpedicion: String = "",
    var fechaRegistroVencimiento: String = "",
)