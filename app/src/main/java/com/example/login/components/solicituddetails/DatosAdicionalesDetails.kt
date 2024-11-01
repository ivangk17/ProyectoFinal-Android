package com.example.login.components.solicituddetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import com.example.login.components.TextSolicitudDetails
import com.example.login.data.models.solicitud.datosSiniestros.DatosSiniestro

@Composable
fun DatosAdicionalesDetails(datosSiniestro: DatosSiniestro) {
    var asistioGrua = "NO"
    var asistioAmbulancia = "NO"
    var asistioBomberos= "NO"

    if(datosSiniestro.asistioGrua == true){
        asistioGrua = "SI"
    }
    if(datosSiniestro.asistioAmbulancia == true){
        asistioAmbulancia = "SI"
    }
    if(datosSiniestro.asistioBomberos == true){
        asistioBomberos = "SI"
    }

    Column {
            TextSolicitudDetails("Tipo de camino:", datosSiniestro.tipoCamino.toString())
        Row(){
            TextSolicitudDetails("Estado:", datosSiniestro.estadoCamino.toString())
            TextSolicitudDetails("Estado del tiempo:", datosSiniestro.estadoTiempo.toString())
        }
            TextSolicitudDetails("¿Asistio grua?:", asistioGrua)
            TextSolicitudDetails("¿Asistio ambulancia?:", asistioAmbulancia)
            TextSolicitudDetails("¿Asistio bomberos?:", asistioBomberos)
    }
}
