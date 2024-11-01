package com.example.login.components.solicituddetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login.components.TextSolicitudDetails
import com.example.login.data.models.poliza.Poliza
import com.example.login.data.models.solicitud.Solicitud


@Composable
fun DatosSiniestroDetails(solicitud: Solicitud, poliza: Poliza) {
    Column {
            Surface(
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(horizontal = 1.dp, vertical = 4.dp)
                    .fillMaxWidth(1.0F)
            ) {
                Row(modifier = Modifier.padding(24.dp)) {
                    Column(modifier = Modifier
                        .weight(1f)
                        .padding(bottom = 10.dp)) {
                        Text(
                            text = "DATOS DEL SINIESTRO",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 15.dp)
                        )
                        TextSolicitudDetails("Aseguradora:", poliza.aseguradora)
                        Row{
                            TextSolicitudDetails("Fecha Ocurrencia:", solicitud.datosSiniestro.fechaOcurrencia.toString())
                            TextSolicitudDetails("Hora Ocurrencia:", solicitud.datosSiniestro.horaOcurrencia)
                        }
                        Row{
                            TextSolicitudDetails("Lugar de Ocurrencia:", solicitud.datosSiniestro.lugarOcurrencia)
                            TextSolicitudDetails("CP:", solicitud.datosSiniestro.codigoPostal.toString())
                        }
                        TextSolicitudDetails("Cantidad de autos que participaron:", solicitud.datosSiniestro.cantidadAutosParticipantes.toString())
                        TextSolicitudDetails("Interseccion:", solicitud.datosSiniestro.interseccion)
                    }
                }
            }
    }
}

