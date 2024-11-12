package com.example.login.components.solicituddetails

import androidx.compose.runtime.Composable
import com.example.login.components.TextSolicitudDetails
import com.example.login.data.models.solicitud.Solicitud

@Composable
fun InformacionAdicionalDetails(solicitud: Solicitud) {
    var daniosMateriales = "NO"
    var daniosPersonales = "NO"
    var huboTestigos = "NO"

    if(solicitud.datosSiniestro.huboDaniosMateriales == true){
        daniosMateriales = "SÍ"
    }

    if(solicitud.datosSiniestro.huboDaniosPersonales == true){
        daniosPersonales = "SÍ"
    }

    if(solicitud.datosSiniestro.huboTestigos == true){
        huboTestigos = "SÍ"
    }

    TextSolicitudDetails("¿Hubo Daños Materiales?:",daniosMateriales)
    TextSolicitudDetails("¿Hubo Daños Personales?:", daniosPersonales)
    TextSolicitudDetails("¿Hubo Testigos?:", huboTestigos)
    TextSolicitudDetails("¿Hubo Denuncia Policial?:", solicitud.datosSiniestro.huboDenuncia.toString())
    TextSolicitudDetails("Vigencia:", solicitud.datosSiniestro.vigencia.toString())
    TextSolicitudDetails("Cobertura:", solicitud.datosSiniestro.cobertura)
    TextSolicitudDetails("Franquicia:", solicitud.datosSiniestro.franquicia)
    TextSolicitudDetails("Cobranza:", solicitud.datosSiniestro.cobranza)
}