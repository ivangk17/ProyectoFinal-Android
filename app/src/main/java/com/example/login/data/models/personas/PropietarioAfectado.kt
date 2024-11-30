package com.example.login.data.models.personas

import com.example.login.data.models.vehiculos.VehiculoTercero

data class PropietarioAfectado(
    var datosPersona: Persona = Persona(),
    val vehiculoPropietadoAfectado: VehiculoTercero = VehiculoTercero(),
    var fechaVencimientoPoliza: String = ""

)
