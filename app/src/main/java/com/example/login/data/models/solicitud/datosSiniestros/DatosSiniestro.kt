package com.example.login.data.models.solicitud.datosSiniestros

import com.example.login.data.models.solicitud.datosSiniestros.asistencia.LugarAsistencia
import java.util.Date

data class DatosSiniestro(
    val lugarAsistencia: LugarAsistencia,
    val fechaOcurrencia: Date,
    val horaOcurrencia: String,
    val lugaarOcurrencia: String,
    val codigoPostal: Number,
    val localidad: String,
    val provincia: String,
    val pais: String,
    val cantidadAutosParticipantes: Number,
    val interseccion: String,
    val hubieronDaniosPersonales: Boolean,
    val hubieronDaniosMateriales: Boolean,
    val hubieronTestigos: Boolean,
    val vigencia: String,
    val cobertura: String,
    val franquicia: String,
    val cobranza: String,
    val asistioGrua: Boolean,
    val asistioAmbulancia: Boolean,
    val asistioBomberos: Boolean,
    val huboDenuncia: HuboDenuncia,
    val estadoTiempo: EstadoTiempo,
    val estadoCamino: EstadoCamino,
    val tipoCamino: TipoCamino,
    val consecuenciaSiniestro: ConsecuenciaSiniestro

)
