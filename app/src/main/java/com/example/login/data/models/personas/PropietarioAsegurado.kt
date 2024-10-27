package com.example.login.data.models.personas

import com.example.login.data.models.Domicilio
import com.example.login.data.models.vehiculos.Vehiculo
import com.example.login.data.models.vehiculos.VehiculoPropietarioAsegurado

data class PropietarioAsegurado(
    var datosPersona: Persona = Persona(),
    var vehiculo: VehiculoPropietarioAsegurado = VehiculoPropietarioAsegurado()
)
