package com.example.login.ui.screens.forms

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.login.R
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
    viewModel: SolicitudDetailsViewModel
) {
    val solicitudCarga = viewModel.loadInfoSolicitud(solicitudId)
    val solicitud =viewModel.solicitud.value
    val poliza =viewModel.poliza.value

    LazyColumn(
    ) {
        item {
            DatosSiniestroDetails(solicitud, poliza)
            HeaderDetails(stringResource(R.string.informacion_adicional)){
                InformacionAdicionalDetails(solicitud)
            }
            HeaderDetails(stringResource(R.string.datos_propietario_asegurado)){
                PropietarioAseguradoDetails(solicitud)
            }
            HeaderDetails(stringResource(R.string.datos_propietario_afectado)){
                PropietarioAfectadoDetails(solicitud)
            }
            HeaderDetails(stringResource(R.string.conductor_asegurado)){
                ConductorDetails(solicitud.conductorAsegurado)
            }
            HeaderDetails(stringResource(R.string.conductor_afectado)){
                ConductorDetails(solicitud.conductorAfectado)
            }
            MultipleLineText(stringResource(R.string.danios_vehiculo_asegurado), solicitud.daniosVehiculoAsegurado)

            MultipleLineText(stringResource(R.string.danios_vehiculo_afectado), solicitud.daniosVehiculoAfectado)

            HeaderDetails(stringResource(R.string.datos_adicionales)){
                DatosAdicionalesDetails(solicitud.datosSiniestro)
            }
            HeaderDetails(stringResource(R.string.consecuencia_siniestro)){
                ConsecuenciaSiniestroDetails(solicitud.datosSiniestro.consecuenciaSiniestro)
            }

            MultipleLineText(stringResource(R.string.relato_accidente), solicitud.datosSiniestro.relato)

            HeaderDetails(stringResource(R.string.lugar_asistencia)){
                if(solicitud.datosSiniestro.lugarAsistencia == null){
                    Text(stringResource(R.string.sin_registro_de_asistencia))
                }else{
                    LugarAsistenciaDetails(solicitud.datosSiniestro.lugarAsistencia!!)
                }
            }
        }
    }
}