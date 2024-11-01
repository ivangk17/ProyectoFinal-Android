package com.example.login.components.solicituddetails

import androidx.compose.runtime.Composable
import com.example.login.components.TextSolicitudDetails
import com.example.login.data.models.Domicilio

@Composable
fun DomicilioDetails(domicilio: Domicilio) {
    TituloH2Details("Datos Domiciliares")
    TextSolicitudDetails("Calle:", domicilio.calle)
    TextSolicitudDetails("Numero:", domicilio.numero.toString())
    TextSolicitudDetails("Piso:", domicilio.piso.toString())
    TextSolicitudDetails("Departamento:", domicilio.departamento.toString())
    TextSolicitudDetails("CP:", domicilio.codigoPostal.toString())
}