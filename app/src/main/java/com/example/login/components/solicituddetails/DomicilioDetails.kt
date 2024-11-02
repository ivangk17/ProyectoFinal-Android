package com.example.login.components.solicituddetails

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.login.components.TextSolicitudDetails
import com.example.login.data.models.Domicilio

@Composable
fun DomicilioDetails(domicilio: Domicilio) {
    TituloH2Details("Datos Domiciliares")
    Row(){
        Row (Modifier.padding(end = 25.dp)){
            TextSolicitudDetails("Calle:", domicilio.calle)
        }
        TextSolicitudDetails("Numero:", domicilio.numero.toString())
    }
    Row {
        Row (Modifier.padding(end = 25.dp)){
            TextSolicitudDetails("Piso:", domicilio.piso.toString())
        }
        TextSolicitudDetails("Departamento:", domicilio.departamento.toString())
    }
    TextSolicitudDetails("CP:", domicilio.codigoPostal.toString())
}