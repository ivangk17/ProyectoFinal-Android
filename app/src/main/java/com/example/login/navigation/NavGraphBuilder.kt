package com.example.login.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.login.data.models.poliza.Poliza
import com.example.login.ui.viewmodels.forms.ConsecuenciaSiniestroViewModel
import com.example.login.ui.viewmodels.forms.DaniosVehiculoAseguradoViewModel
import com.example.login.ui.viewmodels.forms.DaniosVehiculoTerceroViewModel
import com.example.login.ui.viewmodels.forms.DatosAdicionalesViewModel
import com.example.login.ui.viewmodels.forms.DatosPropietarioVehiculoAseguradoViewModel
import com.example.login.ui.viewmodels.forms.DatosSiniestroViewModel
import com.example.login.ui.viewmodels.forms.InformacionAdicionalViewModel
import com.example.login.ui.viewmodels.forms.LugarAsistenciaViewModel
import com.example.login.ui.viewmodels.forms.RelatoAccidenteViewModel
import com.example.login.ui.viewmodels.solicitudesviewmodel.SolicitudDetailsViewModel
import com.example.login.utilities.obtenerObjetoDeNavegacion


fun NavGraphBuilder.rutaComposablePropietarioVehiculoTercero(
    route: String,
    content: @Composable () -> Unit
) {
    composable(
        route = route,
    ) { backStackEntry ->
        content()
    }
}

fun NavGraphBuilder.rutaComposableConductorVehiculoAsegurado(
    route: String,
    content: @Composable () -> Unit
) {
    composable(
        route = route,
    ) { backStackEntry ->
        content()
    }
}

fun NavGraphBuilder.rutaComposableConductorVehiculoTercero(
    route: String,
    content: @Composable () -> Unit
) {
    composable(
        route = route,
    ) { backStackEntry ->
        content()
    }
}

fun NavGraphBuilder.rutaComposableDaniosVehiculoAsegurado(
    route: String,
    content: @Composable (DaniosVehiculoAseguradoViewModel) -> Unit
) {
    composable(
        route = route,
    ) { backStackEntry ->
        val viewModel: DaniosVehiculoAseguradoViewModel = hiltViewModel()
        content(viewModel)
    }
}

fun NavGraphBuilder.rutaComposableDaniosVehiculoTercero(
    route: String,
    content: @Composable (DaniosVehiculoTerceroViewModel) -> Unit
) {
    composable(
        route = route,
    ) { backStackEntry ->
        val viewModel: DaniosVehiculoTerceroViewModel = hiltViewModel()
        content(viewModel)
    }
}

fun NavGraphBuilder.rutaComposableDatosAdicionales(
    route: String,
    content: @Composable (DatosAdicionalesViewModel) -> Unit
) {
    composable(
        route = route,
    ) { backStackEntry ->
        val viewModel: DatosAdicionalesViewModel = hiltViewModel()
        content(viewModel)
    }
}

fun NavGraphBuilder.rutaComposableConsecuenciaSiniestro(
    route: String,
    content: @Composable (ConsecuenciaSiniestroViewModel) -> Unit
) {
    composable(
        route = route,
    ) { backStackEntry ->
        val viewModel: ConsecuenciaSiniestroViewModel = hiltViewModel()
        content(viewModel)
    }
}


fun NavGraphBuilder.rutaComposableRelatoAccidente(
    route: String,
    content: @Composable (RelatoAccidenteViewModel) -> Unit
) {
    composable(
        route = route,
    ) { backStackEntry ->
        val viewModel: RelatoAccidenteViewModel = hiltViewModel()
        content(viewModel)
    }
}

fun NavGraphBuilder.rutaComposableLugarAsistencia(
    route: String,
    content: @Composable (LugarAsistenciaViewModel) -> Unit
) {
    composable(
        route = route,
    ) { backStackEntry ->
        val viewModel: LugarAsistenciaViewModel = hiltViewModel()
        content(viewModel)
    }
}


fun NavGraphBuilder.rutaComposablePolizaDetails(
    route: String,
    content: @Composable (Poliza) -> Unit
) {
    composable(
        route = "$route/{polizaJson}",
        arguments = listOf(navArgument("polizaJson") { type = NavType.StringType })
    ) { backStackEntry ->
        val poliza = obtenerObjetoDeNavegacion<Poliza>(backStackEntry, "polizaJson")
        if (poliza != null) {
            content(poliza)
        }
    }
}

fun NavGraphBuilder.rutaComposableDatosSiniestro(
    route: String,
    content: @Composable (Poliza, DatosSiniestroViewModel) -> Unit
) {
    composable(
        route = "$route/{polizaJson}",
        arguments = listOf(navArgument("polizaJson") { type = NavType.StringType })
    ) { backStackEntry ->
        val poliza = obtenerObjetoDeNavegacion<Poliza>(backStackEntry, "polizaJson")
        if (poliza != null) {
            val viewModel: DatosSiniestroViewModel = hiltViewModel()
            content(poliza, viewModel)
        }
    }
}

fun NavGraphBuilder.rutaComposableInfoAdicional(
    route: String,
    content: @Composable (Poliza, InformacionAdicionalViewModel) -> Unit
) {
    composable(
        route = "$route/{polizaJson}",
        arguments = listOf(navArgument("polizaJson") { type = NavType.StringType })
    ) { backStackEntry ->
        val poliza = obtenerObjetoDeNavegacion<Poliza>(backStackEntry, "polizaJson")
        if (poliza != null) {
            val viewModel: InformacionAdicionalViewModel = hiltViewModel()
            content(poliza, viewModel)
        }
    }
}

fun NavGraphBuilder.rutaComposablePropietarioVehiculoAsegurado(
    route: String,
    content: @Composable (Poliza, DatosPropietarioVehiculoAseguradoViewModel) -> Unit
) {
    composable(
        route = "$route/{polizaJson}",
        arguments = listOf(navArgument("polizaJson") { type = NavType.StringType })
    ) { backStackEntry ->
        val poliza = obtenerObjetoDeNavegacion<Poliza>(backStackEntry, "polizaJson")
        if (poliza != null) {
            val viewModel: DatosPropietarioVehiculoAseguradoViewModel = hiltViewModel()
            content(poliza, viewModel)
        }
    }
}


fun NavGraphBuilder.rutaComposableSolicitudDetalle(
    route: String,
    content: @Composable (String, SolicitudDetailsViewModel) -> Unit
) {
    composable(
        route = "$route/{solicitudId}",
        arguments = listOf(navArgument("solicitudId") { type = NavType.StringType })
    ) { backStackEntry ->
        val solicitudId = backStackEntry.arguments?.getString("solicitudId")
        if (solicitudId != null) {
            val viewModel: SolicitudDetailsViewModel = hiltViewModel()
            content(solicitudId, viewModel)
        }
    }
}