package com.example.login.components.solicituddetails

import androidx.compose.runtime.Composable
import com.example.login.components.TextSolicitudDetails
import com.example.login.data.models.personas.Persona
import com.example.login.data.models.solicitud.Solicitud

@Composable
fun PropietarioAseguradoDetails(solicitud: Solicitud) {
    PersonaDetails(solicitud.propietarioAsegurado.datosPersona)
    VehiculosDetails(solicitud.propietarioAsegurado.vehiculo.datosVehiculo)
    TextSolicitudDetails("Uso del Vehiculo:", solicitud.propietarioAsegurado.vehiculo.usoDelVehiculo.toString())
}