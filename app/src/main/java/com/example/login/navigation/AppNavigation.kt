package com.example.login.navigation

import com.example.login.ui.screens.HomeScreen
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.login.data.models.Poliza
import com.example.login.ui.viewmodels.HomeViewModel
import com.example.login.data.network.GetServicePolizas
import com.example.login.data.network.RetrofitClient
import com.example.login.ui.screens.LoginScreen
import com.example.login.ui.screens.PolizaDetailsScreen
import com.example.login.ui.viewmodels.PolizaDetailsViewModel
import com.google.gson.Gson


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Rutas.LOGIN_SCREEN, builder = {
        composable(Rutas.HOME_SCREEN) {
            val homeViewModel: HomeViewModel = viewModel(
                factory = HomeViewModel.provideFactory(
                    GetServicePolizas(RetrofitClient.apiService)
                )
            )

            HomeScreen(navController, homeViewModel)

        }
        composable(Rutas.LOGIN_SCREEN) {
            LoginScreen(navController)
        }
        composable(
            route= "${Rutas.POLIZA_DETALLE_SCREEN}/{polizaJson}",
            arguments = listOf(navArgument("polizaJson") { type = NavType.StringType })
        ) {
                backStackEntry ->
            val gson = Gson()
            val polizaJson = backStackEntry.arguments?.getString("polizaJson") ?: ""
            val poliza = gson.fromJson(polizaJson, Poliza::class.java)

            val polizaDetailsViewModel : PolizaDetailsViewModel = viewModel(
                factory = PolizaDetailsViewModel.provideFactory(
                    GetServicePolizas(RetrofitClient.apiService)
                )
            )

            PolizaDetailsScreen(poliza, polizaDetailsViewModel)
        }
        }
    )
}