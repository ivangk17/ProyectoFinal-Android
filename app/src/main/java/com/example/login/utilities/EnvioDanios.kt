package com.example.login.utilities

import com.example.login.data.models.solicitud.Solicitud
import com.example.login.ui.viewmodels.CrearSolicitudViewModel


fun daniosVehiculoAsegurado(crearSolicitudViewModel: CrearSolicitudViewModel, solicitud: Solicitud) {
    crearSolicitudViewModel.daniosVehiculoAsegurado(solicitud)
}

fun daniosVehiculosTercero(crearSolicitudViewModel: CrearSolicitudViewModel, solicitud: Solicitud) {
    crearSolicitudViewModel.daniosVehiculosTercero(solicitud)
}


