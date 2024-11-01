package com.example.login.ui.screens.forms

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.login.components.MultipleLineText
import com.example.login.components.solicituddetails.ConductorDetails
import com.example.login.components.solicituddetails.ConsecuenciaSiniestroDetails
import com.example.login.components.solicituddetails.DatosAdicionalesDetails
import com.example.login.components.solicituddetails.DatosSiniestroDetails
import com.example.login.components.solicituddetails.HeaderDetails
import com.example.login.components.solicituddetails.InformacionAdicionalDetails
import com.example.login.components.solicituddetails.DaniosPersonalesDetails
import com.example.login.components.solicituddetails.LugarAsistenciaDetails
import com.example.login.components.solicituddetails.PropietarioAfectadoDetails
import com.example.login.components.solicituddetails.PropietarioAseguradoDetails
import com.example.login.ui.viewmodels.solicitudesviewmod.SolicitudDetailsViewModel

@Composable
fun SolicitudDetailsScreen(
    solicitudId: String,
    viewModel: SolicitudDetailsViewModel,
    navController: NavHostController
) {
    val solicitudCarga = viewModel.loadInfoSolicitud(solicitudId)
    val solicitud =viewModel.solicitud.value
    val poliza =viewModel.poliza.value


        Text(viewModel.solicitud.value.daniosVehiculoAfectado)

    LazyColumn {
        item {
            DatosSiniestroDetails(solicitud, poliza)
            HeaderDetails("Informacion Adicional"){
                InformacionAdicionalDetails(solicitud)
            }
            HeaderDetails("Datos del Propietario del Vehiculo Asegurado"){
                PropietarioAseguradoDetails(solicitud)
            }
            HeaderDetails("Datos del Propietario del Vehiculo Afectado"){
                PropietarioAfectadoDetails(solicitud)
            }
            HeaderDetails("Conductor del Vehiculo Asegurado"){
                ConductorDetails(solicitud.conductorAsegurado)
            }
            HeaderDetails("Conductor del Vehiculo Afectado"){
                ConductorDetails(solicitud.conductorAfectado)
            }
            MultipleLineText("Daños del  Vechiculo Asegurado", solicitud.daniosVehiculoAsegurado)

            MultipleLineText("Daños del  Vechiculo Afectado", solicitud.daniosVehiculoAfectado)

            HeaderDetails("Datos Adicionales"){
                DatosAdicionalesDetails(solicitud.datosSiniestro)
            }
            HeaderDetails("Consecuencia del Siniestro"){
                ConsecuenciaSiniestroDetails(solicitud.datosSiniestro.consecuenciaSiniestro)
            }

            MultipleLineText("Relato del Accidente", solicitud.datosSiniestro.relato)

            HeaderDetails("Daños Personales"){
                DaniosPersonalesDetails(solicitud)
            }
            HeaderDetails("Lugar de Asistencia"){
                LugarAsistenciaDetails(solicitud.datosSiniestro.lugarAsistencia)
            }
        }
    }
}