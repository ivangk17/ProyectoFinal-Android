package com.example.login.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.login.R

// Función auxiliar para obtener el ícono correspondiente al vehículo
@Composable
fun getVehicleIcon(dominio: String): Int {
    return if (dominio.contains(stringResource(R.string.camion), ignoreCase = true)) {
        R.drawable.ic_camion2
    } else {
        R.drawable.ic_auto2
    }
}