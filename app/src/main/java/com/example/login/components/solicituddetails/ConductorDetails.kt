package com.example.login.components.solicituddetails

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.login.R
import com.example.login.components.TextSolicitudDetails
import com.example.login.data.models.personas.ConductorAsegurado

@Composable
fun ConductorDetails(conductor: ConductorAsegurado) {
    Column {
        PersonaDetails(conductor.datosPersona)
        TituloH2Details(stringResource(R.string.datos_vehiculares))
        TextSolicitudDetails(stringResource(R.string.nro_registro_conducir), conductor.nroRegistro)
        TextSolicitudDetails(stringResource(R.string.clase_registro), conductor.claseRegistro)
        TituloH2Details(stringResource(R.string.fechas))
        TextSolicitudDetails(stringResource(R.string.expedicion_registro), conductor.fechaRegistroExpedicion)
        TextSolicitudDetails(stringResource(R.string.vencimiento_registro), conductor.fechaRegistroVencimiento)
        TextSolicitudDetails(stringResource(R.string.relacion_asegurado), conductor.relacionAsegurado)
    }
}