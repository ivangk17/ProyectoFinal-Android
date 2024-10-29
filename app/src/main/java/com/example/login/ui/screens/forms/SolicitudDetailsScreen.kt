package com.example.login.ui.screens.forms

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.example.login.components.solicituddetails.DatosSiniestroDetails
import com.example.login.components.solicituddetails.HeaderDetails
import com.example.login.components.solicituddetails.InformacionAdicionalDetails
import com.example.login.components.solicituddetails.PropietarioAseguradoDetails

@Composable
fun SolicitudDetailsScreen() {
    LazyColumn {
        item {
            DatosSiniestroDetails()
            HeaderDetails("Informacion Adicional"){
                InformacionAdicionalDetails()
            }
            HeaderDetails("Datos del propietario del vehiculo asegurado"){
                PropietarioAseguradoDetails()
            }
        }
    }
}

