package com.example.login.navigation

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.login.ui.screens.HomeScreen
import com.example.login.ui.screens.LoadingScreen
import com.example.login.ui.screens.LoginScreen
import com.example.login.ui.screens.PolizaDetailsScreen
import com.example.login.ui.screens.ProfileScreen
import com.example.login.ui.screens.changepassword.ChangePasswordScreen
import com.example.login.ui.screens.changepassword.ChangePasswordViewModel
import com.example.login.ui.screens.datosperfil.CambiarDatosPerfilScreen
import com.example.login.ui.screens.datosperfil.DetalleDatosPerfilScreen
import com.example.login.ui.screens.forms.ConductorVehiculoAsegurado
import com.example.login.ui.screens.forms.ConductorVehiculoTercero
import com.example.login.ui.screens.forms.ConsecuenciaSiniestro
import com.example.login.ui.screens.forms.DaniosDeVehiculos
import com.example.login.ui.screens.forms.DatosAdicionales
import com.example.login.ui.screens.forms.DatosPropietarioVehiculoAsegurado
import com.example.login.ui.screens.forms.DatosPropietarioVehiculoTercero
import com.example.login.ui.screens.forms.DatosSiniestro
import com.example.login.ui.screens.forms.InformacionAdicional
import com.example.login.ui.screens.forms.LugarAsistencia
import com.example.login.ui.screens.forms.RelatoAccidente
import com.example.login.ui.screens.forms.SolicitudDetailsScreen
import com.example.login.ui.screens.forms.SolicitudEnviadaScreen
import com.example.login.ui.screens.recoverpass.RecoverPassScreen
import com.example.login.ui.screens.recoverpass.RecoverPassViewModel
import com.example.login.ui.screens.solicitudes.SolicitudesScreen
import com.example.login.ui.viewmodels.CambiarDatosPerfilViewModel
import com.example.login.ui.viewmodels.CrearSolicitudViewModel
import com.example.login.ui.viewmodels.DetalleDatosPerfilViewModel
import com.example.login.ui.viewmodels.ProfileViewModel
import com.example.login.ui.viewmodels.homeviewmodel.HomeViewModel
import com.example.login.ui.viewmodels.mainactivityviewmodel.MainActivityViewModel
import com.example.login.ui.viewmodels.solicitudesviewmodel.SolicitudesViewModel
import com.example.login.utilities.daniosVehiculoAsegurado
import com.example.login.utilities.daniosVehiculosTercero


@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("SuspiciousIndentation")
@Composable
fun AppNavigation(
    navController: NavHostController,
    mainActivityViewModel: MainActivityViewModel
) {
    val crearSolicitudViewModel: CrearSolicitudViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = Rutas.LoginScreen.ruta, builder = {
        composable(Rutas.HomeScreen.ruta) {
            val homeViewModel: HomeViewModel = hiltViewModel()
            HomeScreen(navController, homeViewModel)
        }
        composable(Rutas.LoginScreen.ruta) {
            LoginScreen(modifier = Modifier, navController, mainActivityViewModel)
        }

        rutaComposableLoading(
            route = Rutas.LoadingScreen.ruta
        ) {
            poliza, viewModel, nextRoute ->
            LoadingScreen(
                poliza = poliza,
                viewModel = viewModel,
                navController = navController,
                nextRoute = nextRoute
            )
        }

        rutaComposablePolizaDetails(
            route = Rutas.PolizaDetalleScreen.ruta
        ) { poliza, viewModel ->

            PolizaDetailsScreen(
                poliza = poliza,
                polizaDetailsViewModel = viewModel,
                navController = navController,
                crearSolicitudViewModel
            )
        }


        rutaComposableDatosSiniestro(
            route = Rutas.DatosSiniestro.ruta
        ) { poliza, viewModel ->
            DatosSiniestro(
                navController = navController,
                viewModel = viewModel,
                poliza = poliza,
                crearSolicitudViewModel
            )
        }

        rutaComposableInfoAdicional(
            route = Rutas.InformacionAdicional.ruta
        ) { poliza, viewModel ->
            InformacionAdicional(
                navController = navController,
                viewModel = viewModel,
                poliza = poliza,
                crearSolicitudViewModel
            )
        }

        rutaComposablePropietarioVehiculoAsegurado(
            route = Rutas.DatosPropietarioVehiculoAsegurado.ruta
        ) { poliza, viewModel ->
            DatosPropietarioVehiculoAsegurado(
                navController = navController,
                viewModel = viewModel,
                polizaParametro = poliza,
                crearSolicitudViewModel
            )
        }

        rutaComposablePropietarioVehiculoTercero(
            route = Rutas.DatosPropietarioVehiculoTercero.ruta,

        ) { viewModel ->
            DatosPropietarioVehiculoTercero(
                navController,
                viewModel,
                crearSolicitudViewModel
            )
        }

        rutaComposableConductorVehiculoAsegurado(
            route = Rutas.ConductorVehiculoAsegurado.ruta
        ) { viewModel ->
            ConductorVehiculoAsegurado(navController, viewModel,crearSolicitudViewModel)
        }

        rutaComposableConductorVehiculoTercero(
            route = Rutas.ConductorVehiculoTercero.ruta
        ) { viewModel ->
            ConductorVehiculoTercero(navController, viewModel, crearSolicitudViewModel)
        }

        rutaComposableDaniosVehiculoAsegurado(
            route = Rutas.DaniosVehiculoAsegurado.ruta
        ) { viewModel ->
            DaniosDeVehiculos(
                "Daños del Vehiculo Asegurado",
                navController,
                viewModel,
                crearSolicitudViewModel = crearSolicitudViewModel,
                Rutas.DaniosVehiculosTercero,
                onEnviar = ::daniosVehiculoAsegurado
            )
        }

        rutaComposableDaniosVehiculoTercero(
            route = Rutas.DaniosVehiculosTercero.ruta
        ) { viewModel ->
            DaniosDeVehiculos(
                "Daños del Vehiculo Tercero",
                navController,
                viewModel,
                crearSolicitudViewModel = crearSolicitudViewModel,
                Rutas.DatosAdicionales,
                onEnviar = ::daniosVehiculosTercero
            )
        }

        rutaComposableDatosAdicionales(
            route = Rutas.DatosAdicionales.ruta
        ) { viewModel ->
            DatosAdicionales(navController, viewModel, crearSolicitudViewModel)
        }

        rutaComposableConsecuenciaSiniestro(
            route = Rutas.ConsecuenciaSiniestro.ruta
        ) { viewModel ->
            ConsecuenciaSiniestro(navController, viewModel, crearSolicitudViewModel)
        }

        rutaComposableRelatoAccidente(
            route = Rutas.RelatoAccidente.ruta
        ) { viewModel ->
            RelatoAccidente(navController, viewModel, crearSolicitudViewModel)
        }

        rutaComposableLugarAsistencia(
            route = Rutas.LugarAsistencia.ruta,
        ) {
            viewModel ->
            LugarAsistencia(navController, viewModel, crearSolicitudViewModel)
        }



        composable(Rutas.SolicitudEnviada.ruta) {
            SolicitudEnviadaScreen(navController)
        }

        composable(Rutas.SolicitudesScreen.ruta) {
            val solicitudesViewModel: SolicitudesViewModel = hiltViewModel()
            SolicitudesScreen(solicitudesViewModel, navController)
        }

        rutaComposableSolicitudDetalle(
            route = Rutas.SolicitudDetalle.ruta
        ) { solicitudId, viewModel ->
            SolicitudDetailsScreen(solicitudId, viewModel, navController)
        }



        composable(Rutas.PerfilScreen.ruta) {
            val profileViewModel: ProfileViewModel =  hiltViewModel()

            ProfileScreen(profileViewModel, navController)
        }
///CORREGIR
        composable(Rutas.ChangePassword.ruta) {
            val changePasswordViewModel: ChangePasswordViewModel = hiltViewModel()
            ChangePasswordScreen(
                changePasswordViewModel= changePasswordViewModel,
                navController = navController)
        }



        composable(Rutas.DetallesDatosPerfil.ruta) {
            val detalleDatosPerfilViewModel: DetalleDatosPerfilViewModel = hiltViewModel()

            DetalleDatosPerfilScreen(detalleDatosPerfilViewModel, navController)
        }

        composable(Rutas.CambiarDatosPerfil.ruta) {
            val viewModel: CambiarDatosPerfilViewModel = hiltViewModel()
            CambiarDatosPerfilScreen(viewModel, navController)
        }

        composable(Rutas.RecoverPass.ruta) {
            val recoverPassViewModel: RecoverPassViewModel = hiltViewModel()
            RecoverPassScreen(recoverPassViewModel)
        }

    }
    )
}
