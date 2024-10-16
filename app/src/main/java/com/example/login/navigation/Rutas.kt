package com.example.login.navigation

sealed class Rutas(val ruta: String) {
    object LoginScreen : Rutas("loginScreen")
    object HomeScreen : Rutas("homeScreen")


    //object Rutas {
        //const val LOGIN_SCREEN = "loginScreen"
//const val HOME_SCREEN = "homeScreen"
        //const val  POLIZA_DETALLE_SCREEN = "polizaDetalleScreen"
        //const val  SOLICITUD_POLIZA_SCREEN = "solicitudPolizaScreen"
   // }
}