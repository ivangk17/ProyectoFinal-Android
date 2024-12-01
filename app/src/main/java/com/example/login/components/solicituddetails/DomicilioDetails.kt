package com.example.login.components.solicituddetails

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.login.R
import com.example.login.components.TextSolicitudDetails
import com.example.login.data.models.Domicilio

@Composable
fun DomicilioDetails(domicilio: Domicilio) {
    TituloH2Details(stringResource(R.string.domicilio))
    Row(){
        Row (Modifier.padding(end = 25.dp)){
            TextSolicitudDetails(stringResource(R.string.calle), domicilio.calle)
        }
        TextSolicitudDetails(stringResource(R.string.numero), domicilio.numero.toString())
    }
    Row {
        Row (Modifier.padding(end = 25.dp)){
            TextSolicitudDetails(stringResource(R.string.piso), domicilio.piso?.toString() ?: "")
        }
        TextSolicitudDetails(stringResource(R.string.departamento), domicilio.departamento?.toString() ?: "")
    }
    TextSolicitudDetails(stringResource(R.string.cp), domicilio.codigoPostal.toString())
}