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
import com.example.login.data.models.Poliza

@Composable
fun PolizaCard(poliza: Poliza, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Aquí debes colocar el ícono del vehículo, según corresponda
            Image(
                painter = painterResource(id = getVehicleIcon(poliza.dominio)), // Esto es un ejemplo, ajusta según tu recurso
                contentDescription = "Vehicle Icon",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(48.dp)
                    .padding(end = 16.dp)
            )

            Column {
                Text(
                    text = "${poliza.dominio} - ${"poliza.marca"} ${"poliza.modelo"}",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = "Patente: ${poliza.dominio}",
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }
        }
    }
}