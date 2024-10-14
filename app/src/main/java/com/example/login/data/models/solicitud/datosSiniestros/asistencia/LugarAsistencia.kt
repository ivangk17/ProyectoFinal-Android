package com.example.login.data.models.solicitud.datosSiniestros.asistencia

data class LugarAsistencia(
    val nombreCentro: String = "",
    val quedaInternado: Boolean? = null,
    val descripcionLesiones: String = "",
    val estadoLesiones: EstadoLesiones = EstadoLesiones.DESCONOCIDO
)
