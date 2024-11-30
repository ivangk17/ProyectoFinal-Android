package com.example.login.components.solicituddetails

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.login.R
import com.example.login.components.TextSolicitudDetails
import com.example.login.data.models.solicitud.datosSiniestros.DatosSiniestro

@Composable
fun DatosAdicionalesDetails(datosSiniestro: DatosSiniestro) {
    val negativo = stringResource(R.string.negativo)
    val afirmativo = stringResource(R.string.afirmativo)

    var asistioGrua = negativo
    var asistioAmbulancia = negativo
    var asistioBomberos = negativo

    if (datosSiniestro.asistioGrua == true) {
        asistioGrua = afirmativo
    }
    if (datosSiniestro.asistioAmbulancia == true) {
        asistioAmbulancia = afirmativo
    }
    if (datosSiniestro.asistioBomberos == true) {
        asistioBomberos = afirmativo
    }

    Column {
        TextSolicitudDetails(stringResource(R.string.tipo_camino), datosSiniestro.tipoCamino.toString())
        TextSolicitudDetails(stringResource(R.string.estado), datosSiniestro.estadoCamino.toString())
        TextSolicitudDetails(stringResource(R.string.estado_tiempo), datosSiniestro.estadoTiempo.toString())
        TextSolicitudDetails(stringResource(R.string.asisto_grua), asistioGrua)
        TextSolicitudDetails(stringResource(R.string.asisto_ambulancia), asistioAmbulancia)
        TextSolicitudDetails(stringResource(R.string.asistio_bomberos), asistioBomberos)
    }
}
