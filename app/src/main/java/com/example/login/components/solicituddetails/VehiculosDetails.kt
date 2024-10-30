package com.example.login.components.solicituddetails

import androidx.compose.runtime.Composable
import com.example.login.components.TextSolicitudDetails

@Composable
fun VehiculosDetails(){
    TituloH2Details("Datos del Vehiculo")
    TextSolicitudDetails("Marca:", "Marca")
    TextSolicitudDetails("Modelo:", "Modelo")
    TextSolicitudDetails("Tipo del Vehiculo:", "Tipo del Vehiculo")
    TextSolicitudDetails("Color:", "Color")
    TextSolicitudDetails("Año:", "Año")
    TextSolicitudDetails("Dominio:", "Dominio")
}