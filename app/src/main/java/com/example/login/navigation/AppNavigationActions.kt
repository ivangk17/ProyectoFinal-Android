package com.example.login.navigation

import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.login.R
import com.example.login.ui.theme.TituloFormulario
import com.example.login.ui.theme.TitleBold

class AppNavigationActions(
    private val navController: NavController
) {

    companion object {
        val routesWithDrawer = listOf(
            Rutas.HomeScreen.ruta,
            Rutas.SolicitudesScreen.ruta
        )
    }
    fun navigateToRoute(route: String): Unit {
        navController.navigate(route)
    }


    fun navigateToLogin() {
        navController.navigate(Rutas.LoginScreen.ruta)
    }

    val hideTopBar = listOf(
        Rutas.LoginScreen.ruta,
    )

    @Composable
    fun getColorTopBar(location: String?): Color {
        return when (location) {
            //Rutas.HomeScreen.ruta -> Color.White
            //AppDestinations.HOME_ROUTE -> Gray100

            else -> MaterialTheme.colorScheme.background
        }
    }


    @Composable
    fun getTextTopBar(location: String?): String {
        Log.d("LOCATION", location.toString())
        Log.d("LOCATION", "${Rutas.SolicitudDetalle.ruta}/{solicitudId}/{solicitudId}")
        return when(location){
            Rutas.HomeScreen.ruta -> "Mis Pólizas"
            "${Rutas.PolizaDetalleScreen.ruta}/{polizaJson}" -> "Mi Poliza"
            "${Rutas.DatosSiniestro.ruta}/{polizaJson}" -> "Datos Del Siniestro"
            "${Rutas.InformacionAdicional.ruta}/{polizaJson}" -> "Información Adicional"
            "${Rutas.DatosPropietarioVehiculoAsegurado.ruta}/{polizaJson}" -> "Propietario Asegurado"
            Rutas.DatosPropietarioVehiculoTercero .ruta -> "Propietario Afectado"
            Rutas.ConductorVehiculoAsegurado.ruta -> "Conductor Asegurado"
            Rutas.ConductorVehiculoTercero.ruta -> "Conductor Afectado"
            Rutas.DaniosVehiculoAsegurado.ruta -> "Daños"
            Rutas.DaniosVehiculosTercero.ruta -> "Daños"
            Rutas.DatosAdicionales.ruta -> "Datos Adicionales"
            Rutas.ConsecuenciaSiniestro.ruta -> "Consecuencia Del Siniestro"
            Rutas.RelatoAccidente.ruta -> "Relato Del Accidente"
            Rutas.DaniosPersonales.ruta -> "Daños Personales"
            Rutas.LugarAsistencia.ruta -> "Lugar de Asistencia"

            "${Rutas.LoadingScreen.ruta}/{polizaJson}/{nextRoute}" -> ""
            Rutas.SolicitudesScreen.ruta -> stringResource(R.string.Solicitudes_titulo)
            "${Rutas.SolicitudDetalle.ruta}/{solicitudId}" -> "Mi Solicitud"

            else -> ""
        }
    }

    fun getTitleStyleTopBar(location: String?): TextStyle {
        return when(location){
            Rutas.HomeScreen.ruta -> TitleBold
            Rutas.SolicitudesScreen.ruta -> TitleBold
            "${Rutas.PolizaDetalleScreen.ruta}/{polizaJson}" -> TitleBold
            "${Rutas.SolicitudDetalle.ruta}/{solicitudId}" -> TitleBold

            else -> TituloFormulario
        }
    }

    @Composable
    fun getTitleColorTopBar(location: String?): Color {
        return when (location) {
            Rutas.HomeScreen.ruta -> colorResource(id = R.color.texto_principal)
            Rutas.SolicitudesScreen.ruta -> colorResource(id = R.color.texto_principal)

            else -> colorResource(id = R.color.texto_principal)
        }
    }

    fun hideTopBar(location: String?): Boolean {
        return hideTopBar.contains(location)
    }

    fun getNavigationTopBar(location: String?): Boolean{
        return when(location){
            Rutas.LoginScreen.ruta -> false
            Rutas.HomeScreen.ruta -> false
            Rutas.SolicitudEnviada.ruta -> false
            else -> true
        }
    }

    fun quitScreen(location: String?, navController: NavHostController): Boolean{
        return when(location){
            "${Rutas.DatosSiniestro.ruta}/{polizaJson}" -> true

            "${Rutas.DatosSiniestro.ruta}/{polizaJson}" -> true
            "${Rutas.InformacionAdicional.ruta}/{polizaJson}" -> true
            "${Rutas.DatosPropietarioVehiculoAsegurado.ruta}/{polizaJson}" -> true
            Rutas.DatosPropietarioVehiculoTercero .ruta -> true
            Rutas.ConductorVehiculoAsegurado.ruta -> true
            Rutas.ConductorVehiculoTercero.ruta -> true
            Rutas.DaniosVehiculoAsegurado.ruta -> true
            Rutas.DaniosVehiculosTercero.ruta -> true
            Rutas.DatosAdicionales.ruta -> true
            Rutas.ConsecuenciaSiniestro.ruta -> true
            Rutas.RelatoAccidente.ruta -> true
            Rutas.DaniosPersonales.ruta -> true
            Rutas.LugarAsistencia.ruta -> true

            else -> false
        }

        //navController.navigate(lastScreen.toString())
    }

    fun moveText(location: String?): Boolean{
        return when(location){
            "${Rutas.PolizaDetalleScreen.ruta}/{polizaJson}" -> true
            "${Rutas.SolicitudDetalle.ruta}/{solicitudId}" -> true


            else -> false
        }
    }


}