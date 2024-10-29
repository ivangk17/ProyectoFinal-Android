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
fun PersonaDetails(){
    TituloH2Details("Datos Personales")
    TextSolicitudDetails("Nombre:", "Pedro")
    TextSolicitudDetails("Apellido:", "Picapiedra")
    TextSolicitudDetails("Cuit:", "CUIT")
    TextSolicitudDetails("Email:", "Pedropicapiedra@email.com")
    TextSolicitudDetails("Telefono:", "11895236")
    TextSolicitudDetails("Fecha de nacimiento:", "10-10-2000")
    TextSolicitudDetails("Sexo:", "HOMBRE")

    DomicilioDetails()


}