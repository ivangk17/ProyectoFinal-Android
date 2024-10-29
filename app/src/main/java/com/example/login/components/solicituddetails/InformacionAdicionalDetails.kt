package com.example.login.components.solicituddetails

import androidx.compose.runtime.Composable
import com.example.login.components.TextSolicitudDetails
import com.example.login.navigation.Rutas

@Composable
fun InformacionAdicionalDetails(){
    TextSolicitudDetails("¿Hubieron Daños Materiales?:", "SI")
    TextSolicitudDetails("¿Hubieron Daños Personales?:", "SI")
    TextSolicitudDetails("¿Hubieron Testigos?:", "SI")
    TextSolicitudDetails("¿Hubo Denuncia Policial?:", "COMISARIA")
    TextSolicitudDetails("Vigencia:", "10-10-200")
    TextSolicitudDetails("Cobertura:", "Contra Terceros")
    TextSolicitudDetails("Franquicia:", "$50000")
    TextSolicitudDetails("Cobranza:", "$7000")
}