package com.example.login.components.solicituddetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import com.example.login.R
import com.example.login.data.models.solicitud.datosSiniestros.ConsecuenciaSiniestro

@Composable
fun ConsecuenciaSiniestroDetails(consecuenciaSiniestro: ConsecuenciaSiniestro) {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CamposCheckeablesDetails(stringResource(R.string.danio_parcial), consecuenciaSiniestro.danioParcial)
            CamposCheckeablesDetails(stringResource(R.string.robo_rueda), consecuenciaSiniestro.roboRueda)
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CamposCheckeablesDetails(stringResource(R.string.robo_parcial), consecuenciaSiniestro.roboParcial)
            CamposCheckeablesDetails(stringResource(R.string.danio_terceros), consecuenciaSiniestro.danioTerceros)
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CamposCheckeablesDetails(stringResource(R.string.incendio_total), consecuenciaSiniestro.incendioTotal)
            CamposCheckeablesDetails(stringResource(R.string.otros), consecuenciaSiniestro.otros)
        }

    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CamposCheckeablesDetails(stringResource(R.string.destruccion_total), consecuenciaSiniestro.destruccionTotal)
        CamposCheckeablesDetails(stringResource(R.string.robo_total), consecuenciaSiniestro.roboTotal)
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CamposCheckeablesDetails(stringResource(R.string.rotura_cristal), consecuenciaSiniestro.roturaCristales)
        CamposCheckeablesDetails(stringResource(R.string.incendio_parcial), consecuenciaSiniestro.incendioParcial)
    }
}