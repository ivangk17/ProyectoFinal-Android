package com.example.login.data.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.login.navigation.Rutas

data class DrawerItems(
    var userIcon: ImageVector,
    var text: String,
    var route: String
){
    companion object {
        val defaultItems = listOf(
            DrawerItems(Icons.Default.Home, "Home", Rutas.HomeScreen.ruta),
            DrawerItems(Icons.Default.Info, "Solicitudes", Rutas.SolicitudesScreen.ruta)
        )
    }
}
