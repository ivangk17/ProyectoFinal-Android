package com.example.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login.R
import com.example.login.data.models.solicitud.Estado
import com.example.login.data.models.solicitud.SolicitudSimplificada

@Composable
fun SolicitudCard(solicitud: SolicitudSimplificada, onClick: () -> Unit) {

    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .padding(vertical = 6.dp, horizontal = 15.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF009B77),
            contentColor = Color.White
        )
    ) {
        Box(
            modifier = Modifier
                .padding(start = 17.dp, end = 6.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            ) {

                Image(
                    painter = painterResource(id = R.drawable.detail_item),
                    contentDescription = stringResource(R.string.solicitud_image_detail),
                    modifier = Modifier.size(50.dp)
                )

                Text(
                    text = stringResource(
                        id = R.string.fecha_siniestro,
                        solicitud.fechaOcurrencia
                            ?: stringResource(id = R.string.dato_no_disponible)
                    ),
                    fontSize = 22.sp
                )
                Row {


                    Text(
                        text = stringResource(R.string.estado)
                    )
                    var colorEstadoSolicitud = Color.Red.copy(alpha = 0.5f)
                    val solicitudEstado = solicitud.estado
                    if (solicitudEstado == Estado.ACEPTADO) {
                        colorEstadoSolicitud = Color.Green.copy(alpha = 0.5f)
                    } else if (solicitudEstado == Estado.PENDIENTE) {
                        colorEstadoSolicitud = Color.Blue.copy(alpha = 0.5f)
                    }
                    Text(
                        text = solicitud.estado.name,
                        color = colorEstadoSolicitud,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 13.dp)
                    )
                }
            }
        }
    }
}