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
    TextSolicitudDetails("Calle:", "Av. Libertador")
    TextSolicitudDetails("Numero:", "2035")
    TextSolicitudDetails("Piso:", "")
    TextSolicitudDetails("Departamento:", "")
    TextSolicitudDetails("CP:", "1424")
}