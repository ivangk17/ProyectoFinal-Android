package com.example.login.components.solicituddetails

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.login.R
import com.example.login.components.TextSolicitudDetails
import com.example.login.data.models.solicitud.Solicitud

@Composable
fun InformacionAdicionalDetails(solicitud: Solicitud) {
    val negativo = stringResource(R.string.negativo)
    val afirmativo = stringResource(R.string.afirmativo)

    var daniosMateriales = negativo
    var daniosPersonales = negativo
    var huboTestigos = negativo

    if(solicitud.datosSiniestro.hubieronDaniosMateriales == true){
        daniosMateriales = afirmativo
    }

    if(solicitud.datosSiniestro.hubieronDaniosPersonales == true){
        daniosPersonales = afirmativo
    }

    if(solicitud.datosSiniestro.hubieronTestigos == true){
        huboTestigos = afirmativo
    }

    TextSolicitudDetails(stringResource(R.string.hubo_danios_materiales),daniosMateriales)
    TextSolicitudDetails(stringResource(R.string.hubo_danios_personales), daniosPersonales)
    TextSolicitudDetails(stringResource(R.string.hubo_testigos), huboTestigos)
    TextSolicitudDetails(stringResource(R.string.hubo_denuncia), solicitud.datosSiniestro.huboDenuncia.toString())
}