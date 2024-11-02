package com.example.login.data.models.solicitud.datosSiniestros

import com.example.login.data.models.solicitud.datosSiniestros.asistencia.LugarAsistencia

data class DatosSiniestro(
    var lugarAsistencia: LugarAsistencia = LugarAsistencia(),


    var fechaOcurrencia: String? = null,
    var horaOcurrencia: String = "",
    var lugarOcurrencia: String = "",
    var codigoPostal: Int = -1,
    var cantidadAutosParticipantes: Number = -1,
    var hubieronDaniosPersonales: Boolean? = null,
    var hubieronDaniosMateriales: Boolean? = null,
    var hubieronTestigos: Boolean? = null,
    var vigencia: String?= null,
    var cobertura: String= "",
    var franquicia: String= "",
    var cobranza: String= "",
    var asistioGrua: Boolean? = null,
    var asistioAmbulancia: Boolean? = null,
    var asistioBomberos: Boolean? = null,
    var huboDenuncia: HuboDenuncia = HuboDenuncia.DESCONOCIDO,
    var estadoTiempo: EstadoTiempo = EstadoTiempo.DESCONOCIDO,
    var estadoCamino: EstadoCamino = EstadoCamino.DESCONOCIDO,
    var tipoCamino: TipoCamino = TipoCamino.DESCONOCIDO,
    val consecuenciaSiniestro: ConsecuenciaSiniestro = ConsecuenciaSiniestro(),
    var observaciones : String ="",
    var relato: String = ""

)
