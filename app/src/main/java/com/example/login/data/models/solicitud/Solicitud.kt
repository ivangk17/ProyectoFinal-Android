package com.example.login.data.models.solicitud

import com.example.login.data.models.personas.ConductorAsegurado
import com.example.login.data.models.personas.Propietario
import com.example.login.data.models.personas.PropietarioAfectado
import com.example.login.data.models.personas.PropietarioAsegurado
import com.example.login.data.models.solicitud.datosSiniestros.DatosSiniestro
import com.example.login.data.network.models.UserInfoResponse
import com.example.login.tokens.Token
import com.example.login.tokens.Utility

data class Solicitud(
    val estado: Estado = Estado.PENDIENTE,
    var daniosVehiculoAsegurado: String = "",
    var daniosVehiculoAfectado: String = "",
    val propietarioAsegurado: PropietarioAsegurado = PropietarioAsegurado(),
    val conductorAsegurado: ConductorAsegurado = ConductorAsegurado(),
    val propietarioAfectado: PropietarioAfectado = PropietarioAfectado(),
    val conductorAfectado: ConductorAsegurado = ConductorAsegurado(),
    val lesiones: Lesiones = Lesiones(),
    val datosSiniestro: DatosSiniestro = DatosSiniestro()
)

fun getId(token: String): String {
    val user = Utility().decodeJWT(Token.token)
    val id = user.email
    return id
}
