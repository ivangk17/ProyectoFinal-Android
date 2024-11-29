package com.example.login.components.solicituddetails

import androidx.compose.runtime.Composable
import com.example.login.components.TextSolicitudDetails
import com.example.login.data.models.vehiculos.Vehiculo

@Composable
fun VehiculosDetails(vehiculo: Vehiculo){
    TituloH2Details("Datos del Vehiculo")
    TextSolicitudDetails("Marca:", vehiculo.marca)
    TextSolicitudDetails("Modelo:", vehiculo.modelo)
    TextSolicitudDetails("Tipo del Vehiculo:", vehiculo.tipoVehiculo.displayName)
    TextSolicitudDetails("Color:", vehiculo.color.displayName)
    TextSolicitudDetails("Año:", vehiculo.anio.toString())
    TextSolicitudDetails("Dominio:", vehiculo.dominio)
}