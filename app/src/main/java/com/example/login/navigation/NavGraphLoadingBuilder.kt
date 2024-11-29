package com.example.login.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.login.data.models.poliza.Poliza
import com.example.login.ui.viewmodels.LoadingViewModel
import com.example.login.utilities.obtenerObjetoDeNavegacion

fun  NavGraphBuilder.rutaComposableLoading(
    route: String,
    content: @Composable (Poliza, LoadingViewModel, String) -> Unit
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
            val viewModel: LoadingViewModel = hiltViewModel()
            content(poliza, viewModel, nextRoute)
        }
    }
}
