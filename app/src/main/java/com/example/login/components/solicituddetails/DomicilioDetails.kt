package com.example.login.components.solicituddetails

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login.components.TextSolicitudDetails

@Composable
fun DomicilioDetails(){
    TituloH2Details("Datos Domiciliares")
    TextSolicitudDetails("Direccion:", "Av. Libertador 2035")
    TextSolicitudDetails("Localidad:", "Belgrano")
    TextSolicitudDetails("CP:", "1424")
    TextSolicitudDetails("Provincia:", "Buenos Aires")
    TextSolicitudDetails("Ciudad:", "Capital Federal")
}