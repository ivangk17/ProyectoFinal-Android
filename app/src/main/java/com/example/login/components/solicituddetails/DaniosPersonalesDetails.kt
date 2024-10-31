package com.example.login.components.solicituddetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import com.example.login.components.TextSolicitudDetails

@Composable
fun DaniosPersonalesDetails(){
    Row(){
        Column {
            PersonaDetails()
            TituloH2Details("Datos Externos")
            TextSolicitudDetails("Estado civil:", "CASADO")
            TextSolicitudDetails("Telefono alternativo:", "11895236")
        }
        Column {
            ClaseLesiones()
        }
    }


}