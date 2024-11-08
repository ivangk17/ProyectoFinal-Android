package com.example.login.navigation

import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.navigation.NavController
import com.example.login.R
import com.example.login.ui.theme.TituloDetalle
import com.example.login.ui.theme.TituloFormulario
import com.example.login.ui.theme.TituloListas

class AppNavigationActions(
    navController: NavController
){

    val hideTopBar= listOf(
        Rutas.LoginScreen.ruta,
    )

    @Composable
    fun getColorTopBar(location: String?): Color {
        return when(location){
            //Rutas.HomeScreen.ruta -> Color.White
            //AppDestinations.HOME_ROUTE -> Gray100

            else -> MaterialTheme.colorScheme.background
        }
    }

    @Composable
    fun getTextTopBar(location: String?): String{
        Log.d("LOCATION", location.toString())
        return when(location){
            Rutas.HomeScreen.ruta -> "Listado de polizas"
            "${Rutas.PolizaDetalleScreen.ruta}/{polizaJson}" -> "Poliza"
            "${Rutas.DatosSiniestro.ruta}/{polizaJson}" -> "Datos Del Siniestro"
            "${Rutas.InformacionAdicional.ruta}/{polizaJson}" -> "Informacion Adicional"
            "${Rutas.DatosPropietarioVehiculoAsegurado.ruta}/{polizaJson}" -> "Datos Del Propietario Asegurado"
            Rutas.DatosPropietarioVehiculoTercero .ruta -> "Datos Del Propietario Afectado"
            Rutas.ConductorVehiculoAsegurado.ruta -> "Datos Del Conductor Asegurado"
            Rutas.ConductorVehiculoTercero.ruta -> "Datos Del Conductor Afectado"
            Rutas.DaniosVehiculoAsegurado.ruta -> "Daños Del Vehiculo Asegurado"
            Rutas.DaniosVehiculosTercero.ruta -> "Daños Del Vehiculo Afectado"
            Rutas.DatosAdicionales.ruta -> "Datos Adicionales"
            Rutas.ConsecuenciaSiniestro.ruta -> "Consecuencia Del Siniestro"
            Rutas.RelatoAccidente.ruta -> "Relato Del Accidente"
            Rutas.DaniosPersonales.ruta -> "Daños Personales"
            Rutas.LugarAsistencia.ruta -> "Lugar de Asistencia"

            "${Rutas.LoadingScreen.ruta}/{polizaJson}/{nextRoute}" -> ""
            Rutas.SolicitudesScreen.ruta -> stringResource(R.string.Solicitudes_titulo)
            "${Rutas.SolicitudDetalle.ruta}/{solicitudId}/{solicitudId}" -> "Solicitud"

            else -> ""
        }
    }

    fun getTitleStyleTopBar(location: String?): TextStyle {
        return when(location){
            Rutas.HomeScreen.ruta -> TituloListas
            Rutas.SolicitudesScreen.ruta -> TituloListas
            "${Rutas.PolizaDetalleScreen.ruta}/{polizaJson}" -> TituloDetalle
            "${Rutas.SolicitudDetalle.ruta}/{solicitudId}/{solicitudId}" -> TituloDetalle


            else -> TituloFormulario
        }
    }

    @Composable
    fun getTitleColorTopBar(location: String?): Color{
        return when(location){
            Rutas.HomeScreen.ruta -> colorResource(id = R.color.texto_principal)
            Rutas.SolicitudesScreen.ruta -> colorResource(id = R.color.texto_principal)

            else -> colorResource(id = R.color.black)
        }
    }

    fun hideTopBar(location: String?): Boolean{
        return hideTopBar.contains(location)
    }

    fun getNavigationTopBar(location: String?): Boolean{
        return when(location){
            Rutas.LoginScreen.ruta -> false
            Rutas.HomeScreen.ruta -> false
            Rutas.PolizaDetalleScreen.ruta -> true
            else -> false
        }
    }

}