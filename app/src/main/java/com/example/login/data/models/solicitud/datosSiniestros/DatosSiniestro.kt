package com.example.login.data.models.solicitud.datosSiniestros

import com.example.login.data.models.solicitud.datosSiniestros.asistencia.EstadoLesiones
import com.example.login.data.models.solicitud.datosSiniestros.asistencia.LugarAsistencia
import java.util.Date

data class DatosSiniestro(
    val lugarAsistencia: LugarAsistencia? = null,
    val fechaOcurrencia: Date? = null,
    val horaOcurrencia: String = "",
    var lugaarOcurrencia: String = "",
    val codigoPostal: Number = -1,
    val localidad: String = "",
    val provincia: String= "",
    val pais: String = "",
    val cantidadAutosParticipantes: Number = -1,
    val interseccion: String = "",
    val hubieronDaniosPersonales: Boolean? = null,
    val hubieronDaniosMateriales: Boolean? = null,
    val hubieronTestigos: Boolean? = null,
    val vigencia: String = "",
    val cobertura: String= "",
    val franquicia: String= "",
    val cobranza: String= "",
    val asistioGrua: Boolean? = null,
    val asistioAmbulancia: Boolean? = null,
    val asistioBomberos: Boolean? = null,
    val huboDenuncia: HuboDenuncia = HuboDenuncia.DESCONOCIDO,
    val estadoTiempo: EstadoTiempo = EstadoTiempo.DESCONOCIDO,
    val estadoCamino: EstadoCamino = EstadoCamino.DESCONOCIDO,
    val tipoCamino: TipoCamino = TipoCamino.DESCONOCIDO,
    val consecuenciaSiniestro: ConsecuenciaSiniestro = ConsecuenciaSiniestro.DESCONOCIDO

)
