package com.example.login.data.models.solicitud

import com.google.gson.annotations.SerializedName



data class SolicitudSimplificada(
    @SerializedName("id")
    val estado: Estado = Estado.PENDIENTE,
    val idAsegurado: String? = "",
    val nombreAsegurado: String,
    val fechaOcurrencia: String? = null
)

fun Solicitud.aSolicitudSimplificada(): SolicitudSimplificada {
    return SolicitudSimplificada(
        estado = estado,
        idAsegurado = idAsegurado,
        nombreAsegurado = conductorAsegurado.datosPersona.nombreCompleto ?: "Nombre no disponible",
        fechaOcurrencia = datosSiniestro.fechaOcurrencia
    )
}
