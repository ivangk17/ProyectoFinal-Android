package com.example.login.ui.screens.forms

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.login.components.MultipleLineText
import com.example.login.components.solicituddetails.ConductorDetails
import com.example.login.components.solicituddetails.ConsecuenciaSiniestroDetails
import com.example.login.components.solicituddetails.DatosAdicionalesDetails
import com.example.login.components.solicituddetails.DatosSiniestroDetails
import com.example.login.components.solicituddetails.HeaderDetails
import com.example.login.components.solicituddetails.InformacionAdicionalDetails
import com.example.login.components.solicituddetails.PropietarioAfectadoDetails
import com.example.login.components.solicituddetails.PropietarioAseguradoDetails

@Composable
fun SolicitudDetailsScreen() {
    LazyColumn {
        item {
            DatosSiniestroDetails()
            HeaderDetails("INFORMACION ADICIONA"){
                InformacionAdicionalDetails()
            }
            HeaderDetails("DATOS DEL PROPIETARIOS DEL VEHICULO ASEGURADO"){
                PropietarioAseguradoDetails()
            }
            HeaderDetails("DATOS DEL PROPIETARIOS DEL VEHICULO AFECTADO"){
                PropietarioAfectadoDetails()
            }
            HeaderDetails("CONDUCTOR DEL VEHICULO ASEGURADO"){
                ConductorDetails()
            }
            HeaderDetails("CONDUCTOR DEL VEHICULO     AFECTADO"){
                ConductorDetails()
            }
            MultipleLineText("DAÑOS DEL VEHICULO ASEGURADO")

            MultipleLineText("DAÑOS DEL VEHICULO AFECTADO")

            HeaderDetails("Datos Adicionales"){
                DatosAdicionalesDetails()
            }
            HeaderDetails("Datos Adicionales"){
                ConsecuenciaSiniestroDetails()
            }
        }
    }
}