package com.example.login.ui.viewmodels.navdrawerviewmodel


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.lifecycle.ViewModel
import com.example.login.navigation.Rutas
import com.example.login.ui.navigationdrawer.DrawerItems

class DrawerViewModel: ViewModel() {
    val drawerItems = listOf(
        DrawerItems(
            userIcon = Icons.Default.Face,
            text = "Login",
            route = Rutas.LoginScreen.ruta
        ),
        DrawerItems(
            userIcon = Icons.Default.Home,
            text = "Home",
            route = Rutas.HomeScreen.ruta
        ),
        DrawerItems(
            userIcon = Icons.Default.Info,
            text = "Detalles de póliza",
            route = Rutas.PolizaDetalleScreen.ruta
        ),
        DrawerItems(
            userIcon = Icons.Filled.DateRange,
            text = "Solicitude de póliza",
            route = Rutas.SolicitudPolizaScreen.ruta
        )
    )
}