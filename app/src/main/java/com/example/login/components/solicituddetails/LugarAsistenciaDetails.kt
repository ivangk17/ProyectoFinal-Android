package com.example.login.components.solicituddetails

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.login.components.MultipleLineText
import com.example.login.components.TextSolicitudDetails
import com.example.login.data.models.solicitud.datosSiniestros.asistencia.LugarAsistencia

@Composable
fun LugarAsistenciaDetails(lugarAsistencia: LugarAsistencia) {
    TextSolicitudDetails("Nombre del centro:", lugarAsistencia.nombreCentro)
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CamposCheckeablesDetails("¿Queda internado?", lugarAsistencia.quedaInternado)
    }

    TextSolicitudDetails("Estado de lesiones:", "Muy Grave")
    MultipleLineText("Descripcion de lesiones", lugarAsistencia.descripcionLesiones)
}