package com.example.login.data.models.solicitud

import com.example.login.data.models.personas.ConductorAsegurado
import com.example.login.data.models.personas.PropietarioAfectado
import com.example.login.data.models.personas.PropietarioAsegurado
import com.example.login.data.models.solicitud.datosSiniestros.DatosSiniestro
import com.example.login.tokens.Token
import com.example.login.tokens.Utility

data class Solicitud(
    val _id: String = "",
    val estado: Estado = Estado.PENDIENTE,
    var daniosVehiculoAsegurado: String = "aaa",
    var daniosVehiculoAfectado: String = "aaa",
    var idPropietarioAsegurado: String = "ID del propietario asegurado",
    val conductorAsegurado: ConductorAsegurado = ConductorAsegurado(),
    val propietarioAfectado: PropietarioAfectado = PropietarioAfectado(),
    val conductorAfectado: ConductorAsegurado = ConductorAsegurado(),
    val propietarioAsegurado: PropietarioAsegurado = PropietarioAsegurado(),
    val lesiones: Lesiones = Lesiones(),
    val datosSiniestro: DatosSiniestro = DatosSiniestro()
)

fun getId(token: String): String {
    val user = Utility().decodeJWT(Token.token)
    val id = user.email
    return id
}