package com.example.login.data.models.solicitud.datosSiniestros.asistencia

data class LugarAsistencia(
    var nombreCentro: String = "",
    var quedaInternado: Boolean = false,
    var descripcionLesiones: String = "",
    var estadoLesiones: EstadoLesiones = EstadoLesiones.DESCONOCIDO
)
