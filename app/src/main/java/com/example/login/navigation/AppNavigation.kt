package com.example.login.navigation

import com.example.login.ui.screens.HomeScreen
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.login.ui.viewmodels.HomeViewModel
import com.example.login.data.network.GetServicePolizas
import com.example.login.data.network.RetrofitClient
import com.example.login.ui.screens.LoginScreen


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Rutas.LoginScreen.ruta, builder = {
        composable(Rutas.HomeScreen.ruta) {
            val homeViewModel: HomeViewModel = viewModel(
                factory = HomeViewModel.provideFactory(
                    GetServicePolizas(RetrofitClient.apiService)
                )
            )

            HomeScreen(navController, homeViewModel)

        }
        composable(Rutas.LoginScreen.ruta) {
            LoginScreen(navController)
        }
        }
    )
}