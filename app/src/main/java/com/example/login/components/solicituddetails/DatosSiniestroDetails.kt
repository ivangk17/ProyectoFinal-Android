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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login.R
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
                            text = stringResource(R.string.datos_siniestro),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 15.dp)
                        )
                        TextSolicitudDetails(stringResource(R.string.aseguradora), poliza.aseguradora)
                        TextSolicitudDetails(stringResource(R.string.fecha_ocurrencia), solicitud.datosSiniestro.fechaOcurrencia.toString())
                        TextSolicitudDetails(stringResource(R.string.hora_ocurrencia), solicitud.datosSiniestro.horaOcurrencia)

                        TextSolicitudDetails(stringResource(R.string.lugar_ocurrencia), solicitud.datosSiniestro.lugarOcurrencia)
                        TextSolicitudDetails(stringResource(R.string.cp), solicitud.datosSiniestro.codigoPostal.toString())

                        TextSolicitudDetails(stringResource(R.string.cantidad_autos_participantes), solicitud.datosSiniestro.cantidadAutosParticipantes.toString())
                    }
                }
            }
    }
}

