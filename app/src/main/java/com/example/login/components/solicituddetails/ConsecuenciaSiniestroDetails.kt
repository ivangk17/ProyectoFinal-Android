package com.example.login.components.solicituddetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.login.data.models.solicitud.datosSiniestros.ConsecuenciaSiniestro

@Composable
fun ConsecuenciaSiniestroDetails(consecuenciaSiniestro: ConsecuenciaSiniestro) {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CamposCheckeablesDetails("Daño parcial", consecuenciaSiniestro.danioParcial)
            CamposCheckeablesDetails("Robo de rueda", consecuenciaSiniestro.roboRueda)
            CamposCheckeablesDetails("Robo parcial", consecuenciaSiniestro.roboParcial)
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
        )  {
            CamposCheckeablesDetails("Daño a terceros", consecuenciaSiniestro.danioTerceros)
            CamposCheckeablesDetails("Incendio total", consecuenciaSiniestro.incendioTotal)
            CamposCheckeablesDetails("Otros", consecuenciaSiniestro.otros)
        }

    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CamposCheckeablesDetails("Destruccion total", consecuenciaSiniestro.destruccionTotal)
        CamposCheckeablesDetails("Robo/Hurto total", consecuenciaSiniestro.roboTotal)
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CamposCheckeablesDetails("Rotura de cristales", consecuenciaSiniestro.roturaCristales)
        CamposCheckeablesDetails("Incendio parcial", consecuenciaSiniestro.incendioParcial)
    }
}