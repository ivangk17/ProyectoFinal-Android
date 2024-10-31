package com.example.login.components.solicituddetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

@Composable
fun ConsecuenciaSiniestroDetails(){
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CamposCheckeablesDetails("Daño parcial")
            CamposCheckeablesDetails("Robo de rueda")
            CamposCheckeablesDetails("Robo parcial")
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
        )  {
            CamposCheckeablesDetails("Daño a terceros")
            CamposCheckeablesDetails("Incendio total")
            CamposCheckeablesDetails("Otros")
        }

    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CamposCheckeablesDetails("Destruccion total")
        CamposCheckeablesDetails("Robo/Hurto total")
        CamposCheckeablesDetails("Rotura de cristales")
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CamposCheckeablesDetails("Incendio parcial")
    }
}