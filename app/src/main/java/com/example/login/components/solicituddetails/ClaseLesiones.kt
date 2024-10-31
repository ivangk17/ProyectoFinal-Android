package com.example.login.components.solicituddetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun ClaseLesiones(){
    TituloH2Details("Tipo de Lesionado")
    Column(

    ) {
        CamposCheckeablesDetails("Peaton/Ciclista")
        CamposCheckeablesDetails("Conductor vehiculo del tercero")
        CamposCheckeablesDetails("Ocupante vehiculo del tercero")
        CamposCheckeablesDetails("Ocupante vehiculo asegurado")
        CamposCheckeablesDetails("Asegurado")
        CamposCheckeablesDetails("Conductor")
        CamposCheckeablesDetails("Propietario vehiculo asegurado")
        CamposCheckeablesDetails("Relacion con propietario")
    }
}