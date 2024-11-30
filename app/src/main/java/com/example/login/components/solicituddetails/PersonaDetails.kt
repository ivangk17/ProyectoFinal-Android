package com.example.login.components.solicituddetails

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.login.R
import com.example.login.components.TextSolicitudDetails
import com.example.login.data.models.personas.Persona

@Composable
fun PersonaDetails(datosPersona: Persona){
    TituloH2Details(stringResource(R.string.datos_personales))
    TextSolicitudDetails(stringResource(R.string.nombre) , datosPersona.nombre)
    TextSolicitudDetails(stringResource(R.string.apellido), datosPersona.apellido)
    TextSolicitudDetails(stringResource(R.string.dni), datosPersona.dni.toString())
    TextSolicitudDetails(stringResource(R.string.email), datosPersona.email)
    TextSolicitudDetails(stringResource(R.string.telefono), datosPersona.telefono)
    TextSolicitudDetails(stringResource(R.string.fecha_nac), datosPersona.fechaDeNacimiento)
    TextSolicitudDetails(stringResource(R.string.sexo), datosPersona.sexo.toString())

    DomicilioDetails(datosPersona.domicilio)


}