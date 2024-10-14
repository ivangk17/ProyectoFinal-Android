package com.example.login.data.models.solicitud

import com.example.login.data.models.personas.ConductorAsegurado
import com.example.login.data.models.personas.Persona
import com.example.login.data.models.personas.PropietarioAfectado
import com.example.login.data.models.solicitud.datosSiniestros.DatosSiniestro

data class Solicitud(
    val estado: Estado,
    val daniosVehiculoAsegurado: String,
    val daniosVehiculoAfectado: String,
    val idPropietarioAsegurado: String,
    val conductorAsegurado: ConductorAsegurado,
    val propietarioAfectado: PropietarioAfectado,
    val conductorAfectado: Persona,
    val lesiones: Lesiones,
    val datosSiniestro: DatosSiniestro
)
