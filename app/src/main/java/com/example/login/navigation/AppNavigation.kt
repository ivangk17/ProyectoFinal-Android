package com.example.login.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.login.screen.HomeScreen
import com.example.login.screen.LoginScreen


@Composable

fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Rutas.loginScreen, builder = {
        composable(Rutas.homeScreen) {
            HomeScreen(navController)

        }
        composable(Rutas.loginScreen) {
            LoginScreen(navController)
        }
        }
    )
}