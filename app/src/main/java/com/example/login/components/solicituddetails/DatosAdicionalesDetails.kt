package com.example.login.components.solicituddetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.login.components.TextSolicitudDetails

@Composable
fun DatosAdicionalesDetails(){
    Column {
            TextSolicitudDetails("Tipo de camino:", "ASFALTO")
        Row(){
            TextSolicitudDetails("Estado:", "Bueno")
            TextSolicitudDetails("Estado del tiempo:", "Bueno")
        }
            TextSolicitudDetails("¿Asistio grua?:", "Bueno")
            TextSolicitudDetails("¿Asistio ambulancia?:", "Bueno")
            TextSolicitudDetails("¿Asistio bomberos?:", "Bueno")
    }
}
