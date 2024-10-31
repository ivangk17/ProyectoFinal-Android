package com.example.login.components.solicituddetails

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.login.components.MultipleLineText
import com.example.login.components.TextSolicitudDetails

@Composable
fun LugarAsistenciaDetails(){
    TextSolicitudDetails("Nombre del centro:", "Hospital Italiano")
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            "¿Queda internado?"
        )
        Checkbox(checked = true, onCheckedChange = { })
    }

    TextSolicitudDetails("Estado de lesiones:", "Muy Grave")
    MultipleLineText("Descripcion de lesiones")
}