package com.example.login.utilities

import android.util.Log
import com.example.login.data.models.solicitud.Solicitud
import com.example.login.ui.viewmodels.CrearSolicitudViewModel


fun daniosVehiculoAsegurado(crearSolicitudViewModel: CrearSolicitudViewModel, solicitud: Solicitud) {
    Log.d("DANIO VENGO", "vengo")
    crearSolicitudViewModel.daniosVehiculoAsegurado(solicitud)
}

fun daniosVehiculosTercero(crearSolicitudViewModel: CrearSolicitudViewModel, solicitud: Solicitud) {
    Log.d("DANIO VENGO", "vengo")
    crearSolicitudViewModel.daniosVehiculosTercero(solicitud)
}


