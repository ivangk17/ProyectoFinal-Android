package com.example.login.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.login.data.models.poliza.Poliza
import com.example.login.utilities.obtenerObjetoDeNavegacion

fun <T : ViewModel> NavGraphBuilder.rutaComposableLoading(
    route: String,
    viewModelFactory: () -> T,
    content: @Composable (Poliza, T, String) -> Unit
) {
    composable(
        route = "$route/{polizaJson}/{nextRoute}",
        arguments = listOf(
            navArgument("polizaJson") { type = NavType.StringType },
            navArgument("nextRoute") { type = NavType.StringType }
        )
    ) { backStackEntry ->
        val poliza = obtenerObjetoDeNavegacion<Poliza>(backStackEntry, "polizaJson")
        val nextRoute = backStackEntry.arguments?.getString("nextRoute")

        if (poliza != null && nextRoute != null) {
            val viewModel = viewModelFactory()
            content(poliza, viewModel, nextRoute)
        }
    }
}