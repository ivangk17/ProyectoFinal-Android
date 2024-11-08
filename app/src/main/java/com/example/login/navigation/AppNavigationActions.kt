package com.example.login.navigation

import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.login.ui.theme.TituloTopBar

class AppNavigationActions(
    navController: NavController
){

    val hideTopBar= listOf(
        Rutas.LoginScreen.ruta,
    )

    @Composable
    fun getColorTopBar(location: String?): Color {
        return when(location){
            //Rutas.HomeScreen.ruta -> Color.White
            //AppDestinations.HOME_ROUTE -> Gray100

            else -> MaterialTheme.colorScheme.background
        }
    }

    fun getTextTopBar(location: String?): String{
        Log.d("LOCATION", location.toString())
        return when(location){
            Rutas.HomeScreen.ruta -> "Listado de polizas"
            "${Rutas.PolizaDetalleScreen}/{polizaJson}" -> "Poliza"

            else -> "POLIZAS"
        }
    }

    fun getTitleStyleTopBar(location: String?): TextStyle {
        return when(location){
            //Rutas.HomeScreen.ruta -> TituloTopBar


            else -> TituloTopBar
        }
    }

    fun getTitleColorTopBar(location: String?): Color{
        return when(location){
            Rutas.HomeScreen.ruta -> Color(0xFFD70000)

            else -> Color(0xFFFDF008)
        }
    }

    fun hideTopBar(location: String?): Boolean{
        return hideTopBar.contains(location)
    }

    fun getNavigationTopBar(location: String?): Boolean{
        return when(location){
            Rutas.LoginScreen.ruta -> false
            Rutas.HomeScreen.ruta -> false
            Rutas.PolizaDetalleScreen.ruta -> true
            else -> false
        }
    }

}