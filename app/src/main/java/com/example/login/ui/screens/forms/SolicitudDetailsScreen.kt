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
import com.example.login.components.solicituddetails.LugarAsistenciaDetails
import com.example.login.components.solicituddetails.PropietarioAfectadoDetails
import com.example.login.components.solicituddetails.PropietarioAseguradoDetails
import com.example.login.ui.viewmodels.solicitudesviewmodel.SolicitudDetailsViewModel

@Composable
fun SolicitudDetailsScreen(
    solicitudId: String,
    viewModel: SolicitudDetailsViewModel,
    navController: NavHostController
) {
    val solicitudCarga = viewModel.loadInfoSolicitud(solicitudId)
    val solicitud =viewModel.solicitud.value
    val poliza =viewModel.poliza.value

    LazyColumn(
    ) {
        item {
            DatosSiniestroDetails(solicitud, poliza)
            HeaderDetails("Información Adicional"){
                InformacionAdicionalDetails(solicitud)
            }
            HeaderDetails("Datos del Propietario del Vehículo Asegurado"){
                PropietarioAseguradoDetails(solicitud)
            }
            HeaderDetails("Datos del Propietario del Vehículo Afectado"){
                PropietarioAfectadoDetails(solicitud)
            }
            HeaderDetails("Conductor del Vehículo Asegurado"){
                ConductorDetails(solicitud.conductorAsegurado)
            }
            HeaderDetails("Conductor del Vehículo Afectado"){
                ConductorDetails(solicitud.conductorAfectado)
            }
            MultipleLineText("Daños del  Vechículo Asegurado", solicitud.daniosVehiculoAsegurado)

            MultipleLineText("Daños del  Vechículo Afectado", solicitud.daniosVehiculoAfectado)

            HeaderDetails("Datos Adicionales"){
                DatosAdicionalesDetails(solicitud.datosSiniestro)
            }
            HeaderDetails("Consecuencia del Siniestro"){
                ConsecuenciaSiniestroDetails(solicitud.datosSiniestro.consecuenciaSiniestro)
            }

            MultipleLineText("Relato del Accidente", solicitud.datosSiniestro.relato)

            HeaderDetails("Lugar de Asistencia"){
                if(solicitud.datosSiniestro.lugarAsistencia == null){
                    Text("No se ha registrado lugar de asistencia")
                }else{
                    LugarAsistenciaDetails(solicitud.datosSiniestro.lugarAsistencia!!)
                }
            }
        }
    }
}