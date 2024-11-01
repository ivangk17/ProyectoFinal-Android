package com.example.login.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.login.data.models.poliza.Poliza
import com.example.login.utilities.obtenerObjetoDeNavegacion

fun <T : ViewModel> NavGraphBuilder.rutaComposablePoliza(
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
fun <T : ViewModel> NavGraphBuilder.rutaComposableSolicitud(
    route: String,
    viewModelFactory: () -> T,
    content: @Composable (String, T) -> Unit
) {
    composable(
        route = "$route/{solicitudId}",
        arguments = listOf(navArgument("solicitudId") { type = NavType.StringType })
    ) { backStackEntry ->
        val solicitudId = backStackEntry.arguments?.getString("solicitudId")
        if (solicitudId != null) {
            val viewModel = viewModelFactory()
            content(solicitudId, viewModel)
        }
    }
}
