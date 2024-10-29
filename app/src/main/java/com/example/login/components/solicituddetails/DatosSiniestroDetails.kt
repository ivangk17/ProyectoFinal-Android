package com.example.login.components.solicituddetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login.components.TextSolicitudDetails
import com.example.login.ui.screens.forms.SolicitudDetailsScreen


@Composable
fun DatosSiniestroDetails() {
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
                        TextSolicitudDetails("N° de Póiliza:", "NUMERO DE POLIZA")
                        TextSolicitudDetails("Aseguradora:", "Seguros ORT")
                        Row{
                            TextSolicitudDetails("Fecha Ocurrencia:", "10-10-2002")
                            TextSolicitudDetails("Hora Ocurrencia:", "10:00")
                        }
                        Row{
                            TextSolicitudDetails("Lugar de Ocurrencia:", "Av. Libertador 1574")
                            TextSolicitudDetails("CP:", "7300")
                        }
                        Row {
                            TextSolicitudDetails("Localidad:", "Venado Tuerto")
                            TextSolicitudDetails("Provincia:", "Buenos Aires")
                        }
                        TextSolicitudDetails("Pais:", "Argentina")
                        TextSolicitudDetails("Cantidad de autos que participaron:", "100")
                        TextSolicitudDetails("Interseccion:", "Cordoba y Av. Comandante Franco")
                    }
                }
            }
    }
}

