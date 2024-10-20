package com.example.login.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.login.data.models.poliza.Poliza
import com.example.login.data.network.GetServicePolizas
import com.example.login.data.network.RetrofitClient
import com.example.login.ui.screens.HomeScreen
import com.example.login.ui.screens.LoginScreen
import com.example.login.ui.screens.PolizaDetailsScreen
import com.example.login.ui.screens.forms.F3
import com.example.login.ui.viewmodels.HomeViewModel
import com.example.login.ui.viewmodels.PolizaDetailsViewModel
import com.example.login.ui.viewmodels.forms.F3ViewModel
import com.example.login.utilities.obtenerObjetoDeNavegacion

fun <T : ViewModel> NavGraphBuilder.polizaComposable(
    route: String,
    viewModelFactory: () -> T,
    content: @Composable (Poliza, T) -> Unit
) {
    composable(
        route = "$route/{polizaJson}",
        arguments = listOf(navArgument("polizaJson") { type = NavType.StringType })
    ) { backStackEntry ->
        val poliza = obtenerObjetoDeNavegacion<Poliza>(backStackEntry, "polizaJson")
        if (poliza != null) {
            val viewModel = viewModelFactory()
            content(poliza, viewModel)
        }
    }
}



@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Rutas.HomeScreen.ruta, builder = {
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

        polizaComposable(
            route = Rutas.PolizaDetalleScreen.ruta,
            viewModelFactory = {
                PolizaDetailsViewModel.provideFactory(GetServicePolizas(RetrofitClient.apiService))
                    .create(PolizaDetailsViewModel::class.java)
            }
        ) { poliza, viewModel ->
            PolizaDetailsScreen(poliza, viewModel, navController)
        }

        polizaComposable(
            route = Rutas.SolicitudPolizaScreen.ruta,
            viewModelFactory = {
                F3ViewModel.provideFactory(GetServicePolizas(RetrofitClient.apiService))
                    .create(F3ViewModel::class.java)
            }
        ) { poliza, viewModel ->
            F3(navController, viewModel, poliza)

        }
        }
    )
}