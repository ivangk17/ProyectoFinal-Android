package com.example.login.components.solicituddetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import com.example.login.components.TextSolicitudDetails
import com.example.login.data.models.solicitud.Solicitud

@Composable
fun DaniosPersonalesDetails(solicitud: Solicitud) {
    Row(){
        Column {
            PersonaDetails(solicitud.lesiones.lesionado.datosPersona)
            TituloH2Details("Datos Externos")
            TextSolicitudDetails("Estado civil:", "CASADO")
            TextSolicitudDetails("Telefono alternativo:", "11895236")
            ClaseLesiones(solicitud.lesiones)
        }
    }


}