package com.example.login.components.solicituddetails

import androidx.compose.runtime.Composable
import com.example.login.components.TextSolicitudDetails
import com.example.login.data.models.solicitud.Solicitud

@Composable
fun InformacionAdicionalDetails(solicitud: Solicitud) {
    var daniosMateriales = "NO"
    var daniosPersonales = "NO"
    var hubieronTestigos = "NO"

    if(solicitud.datosSiniestro.hubieronDaniosMateriales == true){
        daniosMateriales = "SI"
    }

    if(solicitud.datosSiniestro.hubieronDaniosPersonales == true){
        daniosPersonales = "SI"
    }

    if(solicitud.datosSiniestro.hubieronTestigos == true){
        hubieronTestigos = "SI"
    }

    TextSolicitudDetails("¿Hubieron Daños Materiales?:",daniosMateriales)
    TextSolicitudDetails("¿Hubieron Daños Personales?:", daniosPersonales)
    TextSolicitudDetails("¿Hubieron Testigos?:", hubieronTestigos)
    TextSolicitudDetails("¿Hubo Denuncia Policial?:", solicitud.datosSiniestro.huboDenuncia.toString())
}