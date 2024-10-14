package com.example.login.navigation

sealed class Rutas(val ruta: String) {
    object LoginScreen : Rutas("loginScreen")
    object HomeScreen : Rutas("homeScreen")

}