package com.example.login.navigation

import android.util.Log
import com.example.login.ui.screens.HomeScreen
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.login.ui.viewmodels.HomeViewModel
import com.example.login.data.network.RetrofitClient
import com.example.login.data.network.services.GetServicePolizas
import com.example.login.data.network.services.GetServiceUser
import com.example.login.data.network.services.GetStatus
import com.example.login.ui.screens.LoadingScreen
import com.example.login.ui.screens.LoginScreen
import com.example.login.ui.screens.PolizaDetailsScreen
import com.example.login.ui.screens.forms.ConductorVehiculoAsegurado
import com.example.login.ui.screens.forms.ConductorVehiculoTercero
import com.example.login.ui.screens.forms.ConsecuenciaSiniestro
import com.example.login.ui.screens.forms.DaniosDeVehiculos
import com.example.login.ui.screens.forms.DaniosPersonales
import com.example.login.ui.screens.forms.DatosAdicionales
import com.example.login.ui.screens.forms.DatosPropietarioVehiculoAsegurado
import com.example.login.ui.screens.forms.DatosPropietarioVehiculoTercero
import com.example.login.ui.screens.forms.DatosSiniestro
import com.example.login.ui.screens.forms.InformacionAdicional
import com.example.login.ui.screens.forms.LugarAsistencia
import com.example.login.ui.screens.forms.RelatoAccidente
import com.example.login.ui.screens.forms.SolicitudEnviadaScreen
import com.example.login.ui.viewmodels.CrearSolicitudViewModel
import com.example.login.ui.viewmodels.LoadingViewModel
import com.example.login.ui.viewmodels.PolizaDetailsViewModel
import com.example.login.ui.viewmodels.forms.ConductorVehiculoAseguradoViewModel
import com.example.login.ui.viewmodels.forms.ConductorVehiculoTerceroViewModel
import com.example.login.ui.viewmodels.forms.ConsecuenciaSiniestroViewModel
import com.example.login.ui.viewmodels.forms.DaniosPersonalesViewModel
import com.example.login.ui.viewmodels.forms.DaniosVehiculoAseguradoViewModel
import com.example.login.ui.viewmodels.forms.DaniosVehiculoTerceroViewModel
import com.example.login.ui.viewmodels.forms.DatosAdicionalesViewModel
import com.example.login.ui.viewmodels.forms.DatosPropietarioVehiculoAseguradoViewModel
import com.example.login.ui.viewmodels.forms.DatosPropietarioVehiculoTerceroViewModel
import com.example.login.ui.viewmodels.forms.DatosSiniestroViewModel
import com.example.login.ui.viewmodels.forms.InformacionAdicionalViewModel
import com.example.login.ui.viewmodels.forms.LugarAsistenciaViewModel
import com.example.login.ui.viewmodels.forms.RelatoAccidenteViewModel
import com.example.login.ui.viewmodels.navdrawerviewmodel.DrawerViewModel
import com.example.login.utilities.daniosVehiculoAsegurado
import com.example.login.utilities.daniosVehiculosTercero


@Composable
fun AppNavigation(drawerViewModel: DrawerViewModel) {
    val navController = rememberNavController()
    val crearSolicitudViewModel: CrearSolicitudViewModel = viewModel(
        factory = CrearSolicitudViewModel.provideFactory()
    )
    NavHost(navController = navController, startDestination = Rutas.LoginScreen.ruta, builder = {
        composable(Rutas.HomeScreen.ruta) {
            val homeViewModel: HomeViewModel = viewModel(
                factory = HomeViewModel.provideFactory(
                    GetServicePolizas(RetrofitClient.apiService)
                )
            )

            HomeScreen(navController, homeViewModel,drawerViewModel)

        }
        composable(Rutas.LoginScreen.ruta) {
            LoginScreen(navController)
        }

        rutaComposableLoading(
            route = Rutas.LoadingScreen.ruta,
            viewModelFactory = {
                LoadingViewModel.provideFactory(GetStatus(RetrofitClient.apiService),GetServicePolizas(RetrofitClient.apiService))
                    .create(LoadingViewModel::class.java)
            }
        ) { poliza, viewModel, nextRoute ->
            LoadingScreen(
                poliza, viewModel, navController, nextRoute
            )
        }

        rutaComposable(
            route = Rutas.PolizaDetalleScreen.ruta,
            viewModelFactory = {
                PolizaDetailsViewModel.provideFactory(GetServicePolizas(RetrofitClient.apiService))
                    .create(PolizaDetailsViewModel::class.java)
            }
        ) { poliza, viewModel ->
            PolizaDetailsScreen(poliza, viewModel, navController)
        }

        rutaComposable(
            route = Rutas.DatosSiniestro.ruta,
            viewModelFactory = {
                DatosSiniestroViewModel.provideFactory(GetServicePolizas(RetrofitClient.apiService))
                    .create(DatosSiniestroViewModel::class.java)
            }
        ) { poliza, viewModel ->
            DatosSiniestro(navController, viewModel, poliza, crearSolicitudViewModel)
        }

        rutaComposable(
            route = Rutas.InformacionAdicional.ruta,
            viewModelFactory = {
                InformacionAdicionalViewModel.provideFactory(GetServicePolizas(RetrofitClient.apiService))
                    .create(InformacionAdicionalViewModel::class.java)
            }
        ) { poliza, viewModel ->
            InformacionAdicional(navController, viewModel, poliza,crearSolicitudViewModel)
        }

        rutaComposable(
            route = Rutas.DatosPropietarioVehiculoAsegurado.ruta,
            viewModelFactory = {
                val service = RetrofitClient.apiService
                DatosPropietarioVehiculoAseguradoViewModel.provideFactory(GetServicePolizas(service), GetServiceUser(service))
                    .create(DatosPropietarioVehiculoAseguradoViewModel::class.java)
            }
        ) { poliza, viewModel ->
            DatosPropietarioVehiculoAsegurado(navController, viewModel, poliza, crearSolicitudViewModel)
        }

        rutaComposable(
            route = Rutas.DatosPropietarioVehiculoTercero.ruta,
            viewModelFactory = {
                DatosPropietarioVehiculoTerceroViewModel.provideFactory(GetServicePolizas(RetrofitClient.apiService))
                    .create(DatosPropietarioVehiculoTerceroViewModel::class.java)
            }
        ) { poliza, viewModel ->
            DatosPropietarioVehiculoTercero(navController, viewModel, poliza, crearSolicitudViewModel)
        }

        rutaComposable(
            route = Rutas.ConductorVehiculoAsegurado.ruta,
            viewModelFactory = {
                ConductorVehiculoAseguradoViewModel.provideFactory(GetServicePolizas(RetrofitClient.apiService))
                    .create(ConductorVehiculoAseguradoViewModel::class.java)
            }
        ) { poliza, viewModel ->
            ConductorVehiculoAsegurado(navController, viewModel, poliza, crearSolicitudViewModel)
        }

        rutaComposable(
            route = Rutas.ConductorVehiculoTercero.ruta,
            viewModelFactory = {
                ConductorVehiculoTerceroViewModel.provideFactory(GetServicePolizas(RetrofitClient.apiService))
                    .create(ConductorVehiculoTerceroViewModel::class.java)
            }
        ) { poliza, viewModel ->
            ConductorVehiculoTercero(navController, viewModel, poliza, crearSolicitudViewModel)
        }

        rutaComposable(
            route = Rutas.DaniosVehiculoAsegurado.ruta,
            viewModelFactory = {
                DaniosVehiculoAseguradoViewModel.provideFactory(GetServicePolizas(RetrofitClient.apiService))
                    .create(DaniosVehiculoAseguradoViewModel::class.java)
            }
        ) { poliza, viewModel ->
            DaniosDeVehiculos(
                "Daños del Vehiculo Asegurado",
                navController,
                viewModel,
                crearSolicitudViewModel,
                poliza,
                Rutas.DaniosVehiculosTercero,
                onEnviar = ::daniosVehiculoAsegurado
            )
        }

        rutaComposable(
            route = Rutas.DaniosVehiculosTercero.ruta,
            viewModelFactory = {
                DaniosVehiculoTerceroViewModel.provideFactory(GetServicePolizas(RetrofitClient.apiService))
                    .create(DaniosVehiculoTerceroViewModel::class.java)
            }
        ) { poliza, viewModel ->
            DaniosDeVehiculos(
                "Daños del Vehiculo Tercero",
                navController,
                viewModel,
                crearSolicitudViewModel,
                poliza,
                Rutas.DatosAdicionales,
                onEnviar = ::daniosVehiculosTercero
            )
        }

        rutaComposable(
            route = Rutas.DatosAdicionales.ruta,
            viewModelFactory = {
                DatosAdicionalesViewModel.provideFactory(GetServicePolizas(RetrofitClient.apiService))
                    .create(DatosAdicionalesViewModel::class.java)
            }
        ) { poliza, viewModel ->
            DatosAdicionales(navController, viewModel, poliza, crearSolicitudViewModel)
        }

        rutaComposable(
            route = Rutas.ConsecuenciaSiniestro.ruta,
            viewModelFactory = {
                ConsecuenciaSiniestroViewModel.provideFactory(GetServicePolizas(RetrofitClient.apiService))
                    .create(ConsecuenciaSiniestroViewModel::class.java)
            }
        ) { poliza, viewModel ->
            ConsecuenciaSiniestro(navController, viewModel, poliza, crearSolicitudViewModel)
        }

        rutaComposable(
            route = Rutas.RelatoAccidente.ruta,
            viewModelFactory = {
                RelatoAccidenteViewModel.provideFactory(GetServicePolizas(RetrofitClient.apiService))
                    .create(RelatoAccidenteViewModel::class.java)
            }
        ) { poliza, viewModel ->
            RelatoAccidente(navController, viewModel, poliza, crearSolicitudViewModel)
        }

        rutaComposable(
            route = Rutas.DaniosPersonales.ruta,
            viewModelFactory = {
                DaniosPersonalesViewModel.provideFactory(GetServicePolizas(RetrofitClient.apiService))
                    .create(DaniosPersonalesViewModel::class.java)
            }
        ) { poliza, viewModel ->
            DaniosPersonales(navController, viewModel, poliza, crearSolicitudViewModel)
        }

        rutaComposable(
            route = Rutas.LugarAsistencia.ruta,
            viewModelFactory = {
                LugarAsistenciaViewModel.provideFactory(GetServicePolizas(RetrofitClient.apiService))
                    .create(LugarAsistenciaViewModel::class.java)
            }
        ) { poliza, viewModel ->
            LugarAsistencia(navController, viewModel, poliza,crearSolicitudViewModel)
        }

        composable(Rutas.SolicitudEnviada.ruta) {
            SolicitudEnviadaScreen(navController)
        }

    }
    )
}