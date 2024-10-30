package com.example.login.components.solicituddetails

import androidx.compose.runtime.Composable
import com.example.login.components.TextSolicitudDetails

@Composable
fun ConductorDetails(){
    PersonaDetails()
    TituloH2Details("Datos Vehiculares")
    TextSolicitudDetails("N° Registro de conducir:", "893248511")
    TextSolicitudDetails("Clase de registro:", "A3")
    TextSolicitudDetails("Fecha de expedicion del registro:", "02-04-2019")
    TextSolicitudDetails("Fecha de vencimiento del registro:", "02-04-2019")
    TextSolicitudDetails("Relacion con el asegurado:", "Primo")
}