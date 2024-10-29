package com.example.login.components.solicituddetails

import androidx.compose.runtime.Composable
import com.example.login.components.TextSolicitudDetails

@Composable
fun VehiculosDetails(){
    TituloH2Details("Datos del Vehiculo")
    TextSolicitudDetails("Marca:", "Pedro")
    TextSolicitudDetails("Modelo:", "Pedro")
    TextSolicitudDetails("Tipo del Vehiculo:", "Pedro")
    TextSolicitudDetails("Color:", "Pedro")
    TextSolicitudDetails("Año:", "Pedro")
    TextSolicitudDetails("Dominio:", "Pedro")
}