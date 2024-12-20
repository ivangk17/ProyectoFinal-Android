package com.example.login.data.models.solicitud

import com.example.login.data.models.personas.ConductorAsegurado
import com.example.login.data.models.personas.PropietarioAfectado
import com.example.login.data.models.personas.PropietarioAsegurado
import com.example.login.data.models.solicitud.datosSiniestros.DatosSiniestro
import com.example.login.tokens.Token
import com.example.login.tokens.Utility

data class Solicitud(
    val estado: Estado = Estado.PENDIENTE,
    var daniosVehiculoAsegurado: String = "",
    var daniosVehiculoAfectado: String = "",
    var idAsegurado: String? = "",
    var idAsegurador: String= "",
    val conductorAsegurado: ConductorAsegurado = ConductorAsegurado(),
    val propietarioAfectado: PropietarioAfectado = PropietarioAfectado(),
    val conductorAfectado: ConductorAsegurado = ConductorAsegurado(),
    val propietarioAsegurado: PropietarioAsegurado = PropietarioAsegurado(),
    val datosSiniestro: DatosSiniestro = DatosSiniestro(),
    val _id: String? ="")

