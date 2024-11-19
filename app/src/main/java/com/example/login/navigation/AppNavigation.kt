package com.example.login.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.login.data.network.RetrofitClient
import com.example.login.data.network.services.GetServicePolizas
import com.example.login.data.network.services.GetServiceSolicitudes
import com.example.login.data.network.services.GetServiceUser
import com.example.login.data.network.services.GetStatus
import com.example.login.data.network.services.SolicitudesRepositoryImpl
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
import com.example.login.ui.viewmodels.LoadingViewModel
import com.example.login.ui.viewmodels.PolizaDetailsViewModel
import com.example.login.ui.viewmodels.ProfileViewModel
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
import com.example.login.ui.viewmodels.homeviewmodel.HomeViewModel
import com.example.login.ui.viewmodels.mainactivityviewmodel.MainActivityViewModel
import com.example.login.ui.viewmodels.solicitudesviewmodel.SolicitudDetailsViewModel
import com.example.login.ui.viewmodels.solicitudesviewmodel.SolicitudesViewModel
import com.example.login.ui.viewmodels.solicitudesviewmodel.SolicitudesViewModelFactory
import com.example.login.utilities.daniosVehiculoAsegurado
import com.example.login.utilities.daniosVehiculosTercero


@SuppressLint("SuspiciousIndentation")
@Composable
fun AppNavigation(
    navController: NavHostController,
    mainActivityViewModel: MainActivityViewModel
) {
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

            HomeScreen(navController, homeViewModel)

        }
        composable(Rutas.LoginScreen.ruta) {
            LoginScreen(modifier = Modifier, navController, mainActivityViewModel)
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

        rutaComposable(
            route = Rutas.DatosPropietarioVehiculoTercero.ruta,
            viewModelFactory = {
                DatosPropietarioVehiculoTerceroViewModel.provideFactory(
                    GetServicePolizas(
                        RetrofitClient.apiService
                    )
                )
                    .create(DatosPropietarioVehiculoTerceroViewModel::class.java)
            }
        ) { viewModel ->
            DatosPropietarioVehiculoTercero(
                navController,
                viewModel,
                crearSolicitudViewModel
            )
        }

        rutaComposable(
            route = Rutas.ConductorVehiculoAsegurado.ruta,
            viewModelFactory = {
                ConductorVehiculoAseguradoViewModel.provideFactory(GetServicePolizas(RetrofitClient.apiService))
                    .create(ConductorVehiculoAseguradoViewModel::class.java)
            }
        ) { viewModel ->
            ConductorVehiculoAsegurado(navController, viewModel, crearSolicitudViewModel)
        }

        rutaComposable(
            route = Rutas.ConductorVehiculoTercero.ruta,
            viewModelFactory = {
                ConductorVehiculoTerceroViewModel.provideFactory(GetServicePolizas(RetrofitClient.apiService))
                    .create(ConductorVehiculoTerceroViewModel::class.java)
            }
        ) { viewModel ->
            ConductorVehiculoTercero(navController, viewModel, crearSolicitudViewModel)
        }

        rutaComposable(
            route = Rutas.DaniosVehiculoAsegurado.ruta,
            viewModelFactory = {
                DaniosVehiculoAseguradoViewModel.provideFactory(GetServicePolizas(RetrofitClient.apiService))
                    .create(DaniosVehiculoAseguradoViewModel::class.java)
            }
        ) { viewModel ->
            DaniosDeVehiculos(
                "Daños del Vehiculo Asegurado",
                navController,
                viewModel,
                crearSolicitudViewModel,
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
        ) { viewModel ->
            DaniosDeVehiculos(
                "Daños del Vehiculo Tercero",
                navController,
                viewModel,
                crearSolicitudViewModel,
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
        ) { viewModel ->
            DatosAdicionales(navController, viewModel, crearSolicitudViewModel)
        }

        rutaComposable(
            route = Rutas.ConsecuenciaSiniestro.ruta,
            viewModelFactory = {
                ConsecuenciaSiniestroViewModel.provideFactory(GetServicePolizas(RetrofitClient.apiService))
                    .create(ConsecuenciaSiniestroViewModel::class.java)
            }
        ) { viewModel ->
            ConsecuenciaSiniestro(navController, viewModel, crearSolicitudViewModel)
        }

        rutaComposable(
            route = Rutas.RelatoAccidente.ruta,
            viewModelFactory = {
                RelatoAccidenteViewModel.provideFactory(GetServicePolizas(RetrofitClient.apiService))
                    .create(RelatoAccidenteViewModel::class.java)
            }
        ) { viewModel ->
            RelatoAccidente(navController, viewModel, crearSolicitudViewModel)
        }

        rutaComposable(
            route = Rutas.LugarAsistencia.ruta,
            viewModelFactory = {
                LugarAsistenciaViewModel.provideFactory(GetServicePolizas(RetrofitClient.apiService))
                    .create(LugarAsistenciaViewModel::class.java)
            }
        ) { viewModel ->
            LugarAsistencia(navController, viewModel, crearSolicitudViewModel)
        }

        composable(Rutas.SolicitudEnviada.ruta) {
            SolicitudEnviadaScreen(navController)
        }

        composable(Rutas.SolicitudesScreen.ruta) {
            val repository = SolicitudesRepositoryImpl()
            val solicitudesViewModel: SolicitudesViewModel = viewModel(
                factory = SolicitudesViewModelFactory(repository)
            )
            SolicitudesScreen(solicitudesViewModel, navController)
        }

        rutaComposableSolicitud(
            route = Rutas.SolicitudDetalle.ruta,
            viewModelFactory = {
                SolicitudDetailsViewModel.provideFactory(
                    GetServicePolizas(RetrofitClient.apiService),
                    GetServiceSolicitudes(RetrofitClient.apiService)
                )
                    .create(SolicitudDetailsViewModel::class.java)
            }
        ) { solicitudId, viewModel ->
            SolicitudDetailsScreen(solicitudId, viewModel, navController)
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

            composable(Rutas.PerfilScreen.ruta) {
                val service = RetrofitClient.apiService
                val profileViewModel: ProfileViewModel = viewModel(
                    factory = ProfileViewModel.provideFactory(GetServiceUser(service))
                )
                ProfileScreen(profileViewModel, navController)
            }

            composable(Rutas.ChangePassword.ruta) { navBackStackEntry ->
                val changePasswordViewModel: ChangePasswordViewModel = viewModel(
                    factory = ChangePasswordViewModel.provideFactory(
                        GetServiceUser(RetrofitClient.apiService)
                    ) {
                        navController.navigate(Rutas.HomeScreen.ruta){
                            popUpTo(0) {inclusive = true}
                        }
                    }
                )
                ChangePasswordScreen(changePasswordViewModel)
            }

            composable(Rutas.DetallesDatosPerfil.ruta) {
                val service = RetrofitClient.apiService
                val detalleDatosPerfilViewModel: DetalleDatosPerfilViewModel = viewModel(
                    factory = DetalleDatosPerfilViewModel.provideFactory(GetServiceUser(service))
                )
                DetalleDatosPerfilScreen(detalleDatosPerfilViewModel, navController)
            }

            composable(Rutas.CambiarDatosPerfil.ruta) {
                val service = RetrofitClient.apiService
                val viewModel: CambiarDatosPerfilViewModel = viewModel(
                    factory = CambiarDatosPerfilViewModel.provideFactory(GetServiceUser(service))
                )
                CambiarDatosPerfilScreen(viewModel, navController)
            }

            composable(Rutas.RecoverPass.ruta){
                val recoverPassViewModel: RecoverPassViewModel = viewModel(
                    factory =  RecoverPassViewModel.provideFactory(GetServiceUser(RetrofitClient.apiService))
                )
                RecoverPassScreen(recoverPassViewModel)
            }

        }
    )
}