package com.example.login.components.solicituddetails

import androidx.compose.runtime.Composable
import com.example.login.components.TextSolicitudDetails
import com.example.login.data.models.solicitud.Solicitud

@Composable
fun PropietarioAfectadoDetails(solicitud: Solicitud){
    PersonaDetails(solicitud.propietarioAfectado.datosPersona)
    VehiculosDetails(solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo)

    TituloH2Details("Datos de la Aseguradora")
    TextSolicitudDetails("Aseguradora:", solicitud.propietarioAfectado.vehiculoPropietadoAfectado.aseguradora)
    TextSolicitudDetails("Poliza:", solicitud.propietarioAfectado.vehiculoPropietadoAfectado.poliza)
}