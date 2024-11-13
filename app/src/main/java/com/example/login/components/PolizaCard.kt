package com.example.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login.data.models.poliza.Poliza

@Composable
fun PolizaCard(poliza: Poliza, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(11.dp),
        modifier = Modifier
            .padding(start = 12.dp, end =12.dp, top = 7.dp, bottom = 6.dp)
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF009B77), //Card background color
            contentColor = Color.White  //Card content color,e.g.text
        )
    ) {
        Row(
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = getVehicleIcon(poliza.vehiculo.dominio)), // Esto es un ejemplo, ajusta según tu recurso
                contentDescription = "Vehicle Icon",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(48.dp)
                    .padding(end = 16.dp)
            )

            Column {
                Text(
                    text = "${poliza.vehiculo.dominio} - ${poliza.vehiculo.marca} ${poliza.vehiculo.modelo}",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = "Patente: ${poliza.vehiculo.dominio}",
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }
        }
    }
}