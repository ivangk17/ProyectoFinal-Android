package com.example.login.data.models.solicitud

import com.google.gson.annotations.SerializedName


data class SolicitudSimplificada(

    val _id: String?="",
    val estado: Estado = Estado.PENDIENTE,
    val idAsegurado: String? = "",
    val nombreAsegurado: String,
    val fechaOcurrencia: String? = null
)

fun Solicitud.aSolicitudSimplificada(token: String): SolicitudSimplificada {
    return SolicitudSimplificada(
        _id = _id,
        estado = estado,
        idAsegurado = idAsegurado,
        nombreAsegurado = conductorAsegurado.datosPersona.nombreCompleto ?: "Nombre no disponible",
        fechaOcurrencia = datosSiniestro.fechaOcurrencia
    )
}
