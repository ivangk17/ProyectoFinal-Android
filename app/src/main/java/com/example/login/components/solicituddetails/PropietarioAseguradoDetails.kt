package com.example.login.components.solicituddetails

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.login.R
import com.example.login.components.TextSolicitudDetails
import com.example.login.data.models.solicitud.Solicitud

@Composable
fun PropietarioAseguradoDetails(solicitud: Solicitud) {
    PersonaDetails(solicitud.propietarioAsegurado.datosPersona)
    VehiculosDetails(solicitud.propietarioAsegurado.vehiculo.datosVehiculo)
    TextSolicitudDetails(
        stringResource(R.string.uso_vehiculo),
        solicitud.propietarioAsegurado.vehiculo.usoDelVehiculo.toString()
    )
}