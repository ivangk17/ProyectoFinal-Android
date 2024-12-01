package com.example.login.components.solicituddetails

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import com.example.login.R
import com.example.login.components.MultipleLineText
import com.example.login.components.TextSolicitudDetails
import com.example.login.data.models.solicitud.datosSiniestros.asistencia.LugarAsistencia

@Composable
fun LugarAsistenciaDetails(lugarAsistencia: LugarAsistencia) {
    TextSolicitudDetails(stringResource(R.string.nombre_centro), lugarAsistencia.nombreCentro)
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CamposCheckeablesDetails(stringResource(R.string.queda_internado), lugarAsistencia.quedaInternado)
    }

    TextSolicitudDetails(stringResource(R.string.estado_lesiones), stringResource(R.string.muy_grave))
    MultipleLineText(stringResource(R.string.descripcion_lesiones), lugarAsistencia.descripcionLesiones)
}