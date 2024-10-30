package com.example.login.components.solicituddetails

import androidx.compose.runtime.Composable
import com.example.login.components.TextSolicitudDetails

@Composable
fun PropietarioAfectadoDetails(){
    PersonaDetails()
    VehiculosDetails()
    TituloH2Details("Datos de la Aseguradora")
    TextSolicitudDetails("Aseguradora:", "Aseguradora")
    TextSolicitudDetails("Poliza:", "POLIZA")
}