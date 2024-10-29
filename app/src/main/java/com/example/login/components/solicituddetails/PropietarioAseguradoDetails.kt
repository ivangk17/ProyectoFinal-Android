package com.example.login.components.solicituddetails

import androidx.compose.runtime.Composable
import com.example.login.components.TextSolicitudDetails

@Composable
fun PropietarioAseguradoDetails(){
    PersonaDetails()
    VehiculosDetails()
    TextSolicitudDetails("Uso del Vehiculo:", "COMERCIAL")
}