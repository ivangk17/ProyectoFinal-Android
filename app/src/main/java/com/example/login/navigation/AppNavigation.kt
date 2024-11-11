package com.example.login.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.login.data.network.RetrofitClient
import com.example.login.data.network.services.GetServicePolizas
import com.example.login.data.network.services.GetServiceSolicitudes
import com.example.login.data.network.services.GetServiceUser
import com.example.login.data.network.services.GetStatus
import com.example.login.data.repositories.SolicitudesRepositoryImpl
import com.example.login.ui.screens.HomeScreen
import com.example.login.ui.screens.LoadingScreen
import com.example.login.ui.screens.LoginScreen
import com.example.login.ui.screens.PolizaDetailsScreen
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
import com.example.login.ui.screens.solicitudes.SolicitudesScreen
import com.example.login.ui.viewmodels.CrearSolicitudViewModel
import com.example.login.ui.viewmodels.HomeViewModel
import com.example.login.ui.viewmodels.LoadingViewModel
import com.example.login.ui.viewmodels.PolizaDetailsViewModel
import com.example.login.ui.viewmodels.forms.ConductorVehiculoAseguradoViewModel
import com.example.login.ui.viewmodels.forms.ConductorVehiculoTerceroViewModel
import com.example.login.ui.viewmodels.forms.ConsecuenciaSiniestroViewModel
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
import com.example.login.ui.viewmodels.solicitudesviewmod.SolicitudDetailsViewModel
import com.example.login.ui.viewmodels.solicitudesviewmod.SolicitudesViewModel
import com.example.login.ui.viewmodels.solicitudesviewmod.SolicitudesViewModelFactory
import com.example.login.utilities.daniosVehiculoAsegurado
import com.example.login.utilities.daniosVehiculosTercero


@SuppressLint("SuspiciousIndentation")
@Composable
fun AppNavigation(drawerViewModel: DrawerViewModel) {
    val navController = rememberNavController()
    val crearSolicitudViewModel: CrearSolicitudViewModel = viewModel(
        factory = CrearSolicitudViewModel.provideFactory()
    )
        NavHost(navController = navController, startDestination = Rutas.HomeScreen.ruta, builder = {
        composable(Rutas.HomeScreen.ruta) {
            val homeViewModel: HomeViewModel = viewModel(
                factory = HomeViewModel.provideFactory(
                    GetServicePolizas(RetrofitClient.apiService)
                )
            )

            HomeScreen(navController, homeViewModel, drawerViewModel)

        }
        composable(Rutas.LoginScreen.ruta) {
            LoginScreen(navController)
        }

        rutaComposableLoading(
            route = Rutas.LoadingScreen.ruta,
            viewModelFactory = {
                LoadingViewModel.provideFactory(
                    GetStatus(RetrofitClient.apiService),
                    GetServicePolizas(RetrofitClient.apiService)
                )
                    .create(LoadingViewModel::class.java)
            }
        ) { poliza, viewModel, nextRoute ->
            LoadingScreen(
                poliza, viewModel, navController, nextRoute
            )
        }

        rutaComposablePoliza(
            route = Rutas.PolizaDetalleScreen.ruta,
            viewModelFactory = {
                PolizaDetailsViewModel.provideFactory(GetServicePolizas(RetrofitClient.apiService))
                    .create(PolizaDetailsViewModel::class.java)
            }
        ) { poliza, viewModel ->
            PolizaDetailsScreen(poliza, viewModel, navController)
        }

        rutaComposablePoliza(
            route = Rutas.DatosSiniestro.ruta,
            viewModelFactory = {
                DatosSiniestroViewModel.provideFactory(GetServicePolizas(RetrofitClient.apiService))
                    .create(DatosSiniestroViewModel::class.java)
            }
        ) { poliza, viewModel ->
            DatosSiniestro(navController, viewModel, poliza, crearSolicitudViewModel)
        }

        rutaComposablePoliza(
            route = Rutas.InformacionAdicional.ruta,
            viewModelFactory = {
                InformacionAdicionalViewModel.provideFactory(GetServicePolizas(RetrofitClient.apiService))
                    .create(InformacionAdicionalViewModel::class.java)
            }
        ) { poliza, viewModel ->
            InformacionAdicional(navController, viewModel, poliza, crearSolicitudViewModel)
        }

        rutaComposablePoliza(
            route = Rutas.DatosPropietarioVehiculoAsegurado.ruta,
            viewModelFactory = {
                val service = RetrofitClient.apiService
                DatosPropietarioVehiculoAseguradoViewModel.provideFactory(
                    GetServicePolizas(service),
                    GetServiceUser(service)
                )
                    .create(DatosPropietarioVehiculoAseguradoViewModel::class.java)
            }
        ) { poliza, viewModel ->
            DatosPropietarioVehiculoAsegurado(
                navController,
                viewModel,
                poliza,
                crearSolicitudViewModel
            )
        }

        rutaComposablePoliza(
            route = Rutas.DatosPropietarioVehiculoTercero.ruta,
            viewModelFactory = {
                DatosPropietarioVehiculoTerceroViewModel.provideFactory(
                    GetServicePolizas(
                        RetrofitClient.apiService
                    )
                )
                    .create(DatosPropietarioVehiculoTerceroViewModel::class.java)
            }
        ) { poliza, viewModel ->
            DatosPropietarioVehiculoTercero(
                navController,
                viewModel,
                poliza,
                crearSolicitudViewModel
            )
        }

        rutaComposablePoliza(
            route = Rutas.ConductorVehiculoAsegurado.ruta,
            viewModelFactory = {
                ConductorVehiculoAseguradoViewModel.provideFactory(GetServicePolizas(RetrofitClient.apiService))
                    .create(ConductorVehiculoAseguradoViewModel::class.java)
            }
        ) { poliza, viewModel ->
            ConductorVehiculoAsegurado(navController, viewModel, poliza, crearSolicitudViewModel)
        }

        rutaComposablePoliza(
            route = Rutas.ConductorVehiculoTercero.ruta,
            viewModelFactory = {
                ConductorVehiculoTerceroViewModel.provideFactory(GetServicePolizas(RetrofitClient.apiService))
                    .create(ConductorVehiculoTerceroViewModel::class.java)
            }
        ) { poliza, viewModel ->
            ConductorVehiculoTercero(navController, viewModel, poliza, crearSolicitudViewModel)
        }

        rutaComposablePoliza(
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

        rutaComposablePoliza(
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

        rutaComposablePoliza(
            route = Rutas.DatosAdicionales.ruta,
            viewModelFactory = {
                DatosAdicionalesViewModel.provideFactory(GetServicePolizas(RetrofitClient.apiService))
                    .create(DatosAdicionalesViewModel::class.java)
            }
        ) { poliza, viewModel ->
            DatosAdicionales(navController, viewModel, poliza, crearSolicitudViewModel)
        }

        rutaComposablePoliza(
            route = Rutas.ConsecuenciaSiniestro.ruta,
            viewModelFactory = {
                ConsecuenciaSiniestroViewModel.provideFactory(GetServicePolizas(RetrofitClient.apiService))
                    .create(ConsecuenciaSiniestroViewModel::class.java)
            }
        ) { poliza, viewModel ->
            ConsecuenciaSiniestro(navController, viewModel, poliza, crearSolicitudViewModel)
        }

        rutaComposablePoliza(
            route = Rutas.RelatoAccidente.ruta,
            viewModelFactory = {
                RelatoAccidenteViewModel.provideFactory(GetServicePolizas(RetrofitClient.apiService))
                    .create(RelatoAccidenteViewModel::class.java)
            }
        ) { poliza, viewModel ->
            RelatoAccidente(navController, viewModel, poliza, crearSolicitudViewModel)
        }

        rutaComposablePoliza(
            route = Rutas.LugarAsistencia.ruta,
            viewModelFactory = {
                LugarAsistenciaViewModel.provideFactory(GetServicePolizas(RetrofitClient.apiService))
                    .create(LugarAsistenciaViewModel::class.java)
            }
        ) { poliza, viewModel ->
            LugarAsistencia(navController, viewModel, poliza, crearSolicitudViewModel)
        }

        composable(Rutas.SolicitudEnviada.ruta) {
            SolicitudEnviadaScreen(navController)
        }

        composable(Rutas.SolicitudesScreen.ruta) {
            val repository = SolicitudesRepositoryImpl()
            val solicitudesViewModel: SolicitudesViewModel = viewModel(
                factory = SolicitudesViewModelFactory(repository)
            )
            SolicitudesScreen(solicitudesViewModel, navController,drawerViewModel)
        }

            rutaComposableSolicitud(
                route = Rutas.SolicitudDetalle.ruta,
                viewModelFactory = {
                    SolicitudDetailsViewModel.provideFactory(GetServicePolizas(RetrofitClient.apiService),GetServiceSolicitudes(RetrofitClient.apiService))
                        .create(SolicitudDetailsViewModel::class.java)
                }
            ) { solicitudId, viewModel ->
                SolicitudDetailsScreen(solicitudId, viewModel, navController)
            }
    }
    )
}