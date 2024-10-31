package com.example.login.ui.screens.forms

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
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

@Composable
fun SolicitudDetailsScreen() {
    LazyColumn {
        item {
            DatosSiniestroDetails()
            HeaderDetails("Informacion Adicional"){
                InformacionAdicionalDetails()
            }
            HeaderDetails("Datos del Propietario del Vehiculo Asegurado"){
                PropietarioAseguradoDetails()
            }
            HeaderDetails("Datos del Propietario del Vehiculo Afectado"){
                PropietarioAfectadoDetails()
            }
            HeaderDetails("Conductor del Vehiculo Asegurado"){
                ConductorDetails()
            }
            HeaderDetails("Conductor del Vehiculo Afectado"){
                ConductorDetails()
            }
            MultipleLineText("Daños del  Vechiculo Asegurado")

            MultipleLineText("Daños del  Vechiculo Afectado")

            HeaderDetails("Datos Adicionales"){
                DatosAdicionalesDetails()
            }
            HeaderDetails("Consecuencia del Siniestro"){
                ConsecuenciaSiniestroDetails()
            }

            MultipleLineText("Relato del Accidente")

            HeaderDetails("Daños Personales"){
                DaniosPersonalesDetails()
            }
            HeaderDetails("Lugar de Asistencia"){
                LugarAsistenciaDetails()
            }
        }
    }
}