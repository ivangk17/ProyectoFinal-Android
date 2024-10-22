package com.example.login.navigation

sealed class Rutas(val ruta: String) {
    object LoginScreen : Rutas("loginScreen")
    object HomeScreen : Rutas("homeScreen")
    object PolizaDetalleScreen : Rutas("polizaDetalleScreen")
    object SolicitudPolizaScreen : Rutas("solicitudPolizaScreen")
    object DatosSiniestro: Rutas("DatosSiniestroScreen")
    object InformacionAdicional : Rutas("informacionAdicionalScreen")
    object DatosPropietarioVehiculoAsegurado : Rutas("datosPropietarioVehiculoAseguradoScreen")
    object DatosPropietarioVehiculoTercero : Rutas("datosPropietarioVehiculoTerceroScreen")
    object ConductorVehiculoAsegurado : Rutas("conductorVehiculoAseguradoScreen")
    object ConductorVehiculoTercero : Rutas("conductorVehiculoTerceroScreen")
    object DaniosVehiculoAsegurado : Rutas("daniosVehiculoAseguradoScreen")
    object DaniosVehiculosTercero : Rutas("daniosVehiculosTerceroScreen")
    object DatosAdicionales : Rutas("datosAdicionalesScreen")
    object ConsecuenciaSiniestro : Rutas("consecuenciaSiniestroScreen")
    object RelatoAccidente : Rutas("relatoAccidenteScreen")
    object DaniosPersonales : Rutas("daniosPersonalesScreen")
    object LugarAsistencia : Rutas("lugarAsistenciaScreen")

}