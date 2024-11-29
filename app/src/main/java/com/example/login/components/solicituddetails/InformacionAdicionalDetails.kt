package com.example.login.components.solicituddetails

import androidx.compose.runtime.Composable
import com.example.login.components.TextSolicitudDetails
import com.example.login.data.models.solicitud.Solicitud

@Composable
fun InformacionAdicionalDetails(solicitud: Solicitud) {
    var daniosMateriales = "NO"
    var daniosPersonales = "NO"
    var huboTestigos = "NO"

    if(solicitud.datosSiniestro.hubieronDaniosMateriales == true){
        daniosMateriales = "SÍ"
    }

    if(solicitud.datosSiniestro.hubieronDaniosPersonales == true){
        daniosPersonales = "SÍ"
    }

    if(solicitud.datosSiniestro.hubieronTestigos == true){
        huboTestigos = "SÍ"
    }

    TextSolicitudDetails("¿Hubo Daños Materiales?:",daniosMateriales)
    TextSolicitudDetails("¿Hubo Daños Personales?:", daniosPersonales)
    TextSolicitudDetails("¿Hubo Testigos?:", huboTestigos)
    TextSolicitudDetails("¿Hubo Denuncia Policial?:", solicitud.datosSiniestro.huboDenuncia.toString())
}