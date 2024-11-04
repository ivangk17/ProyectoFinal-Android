package com.example.login.ui.screens.solicitudes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.login.R
import com.example.login.data.models.solicitud.Estado
import com.example.login.data.models.solicitud.SolicitudSimplificada

@Composable
fun SolicitudCard(solicitud: SolicitudSimplificada, onClick: () -> Unit) {

    Card(
        modifier = Modifier
            .padding(8.dp)
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Box(
            modifier = Modifier
                .background(
                    Brush.linearGradient(
                        colors = listOf(
                            Color(0xFFD0CFCF),
                            Color(0xFBCECECE)
                        ),
                        start = Offset(0f, 0f),
                        end = Offset(400f, 400f)
                    )
                )
                .padding(16.dp)
        ) {
            Column(modifier = Modifier.padding(8.dp).fillMaxWidth()) {
                Text(
                    text = stringResource(
                        id = R.string.fecha_siniestro,
                        solicitud.fechaOcurrencia ?: stringResource(id = R.string.dato_no_disponible)
                    )
                )
                Row {
                    Text(
                        text = stringResource(R.string.estado)
                    )
                    var colorEstadoSolicitud = Color.Red.copy(alpha = 0.5f)
                    val solicitudEstado = solicitud.estado
                    if(solicitudEstado == Estado.ACEPTADO){
                        colorEstadoSolicitud = Color.Green.copy(alpha = 0.5f)
                    }
                    else if(solicitudEstado == Estado.PENDIENTE){
                        colorEstadoSolicitud = Color.Blue.copy(alpha = 0.5f)
                    }
                    Text(
                        text = solicitud.estado.name,
                        color = colorEstadoSolicitud
                    )

                }


            }
        }
    }
}