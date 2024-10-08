package com.example.login.components

import androidx.compose.runtime.Composable
import com.example.login.R

// Función auxiliar para obtener el ícono correspondiente al vehículo
@Composable
fun getVehicleIcon(dominio: String): Int {
    return if (dominio.contains("Camion", ignoreCase = true)) {
        R.drawable.ic_camion // El ícono del camión
    } else {
        R.drawable.ic_auto // El ícono del auto
    }
}