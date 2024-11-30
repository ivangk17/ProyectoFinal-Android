package com.example.login.navigation

sealed class Rutas(val ruta: String) {
    object LoginScreen : Rutas("loginScreen")
    object HomeScreen : Rutas("homeScreen")
    object PolizaDetalleScreen : Rutas("polizaDetalleScreen")
    object LoadingScreen : Rutas("loadingScreen")
    object DatosSiniestro : Rutas("DatosSiniestroScreen")
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
    object LugarAsistencia : Rutas("lugarAsistenciaScreen")
    object SolicitudEnviada : Rutas("solicitudEnviada")
    object SolicitudesScreen : Rutas("solicitudesScreen")
    object PerfilScreen : Rutas("perfilScreen")
    object ChangePassword : Rutas("changePassword")
    object DetallesDatosPerfil : Rutas("detalleDatosPerfil")
    object CambiarDatosPerfil : Rutas("cambiarDatosPerfil")
    object RecoverPass : Rutas("recoverPass")


    object SolicitudDetalle : Rutas("solicitudDetalle/{solicitudId}") {
        fun rutaConId(solicitudId: String) = "solicitudDetalle/$solicitudId"
    }
}