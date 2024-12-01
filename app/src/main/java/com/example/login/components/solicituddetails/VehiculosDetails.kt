package com.example.login.components.solicituddetails

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.login.R
import com.example.login.components.TextSolicitudDetails
import com.example.login.data.models.vehiculos.Vehiculo

@Composable
fun VehiculosDetails(vehiculo: Vehiculo){
    TituloH2Details(stringResource(R.string.datos_vehiculares))
    TextSolicitudDetails(stringResource(R.string.marca), vehiculo.marca)
    TextSolicitudDetails(stringResource(R.string.modelo), vehiculo.modelo)
    TextSolicitudDetails(stringResource(R.string.tipo_vehiculo), vehiculo.tipoVehiculo.displayName)
    TextSolicitudDetails(stringResource(R.string.color), vehiculo.color.displayName)
    TextSolicitudDetails(stringResource(R.string.anio), vehiculo.anio.toString())
    TextSolicitudDetails(stringResource(R.string.dominio), vehiculo.dominio)
}