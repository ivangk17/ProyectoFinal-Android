package com.example.login.components.solicituddetails

import androidx.compose.runtime.Composable
import com.example.login.components.TextSolicitudDetails
import com.example.login.data.models.personas.ConductorAsegurado

@Composable
    fun ConductorDetails(conductor: ConductorAsegurado) {
    PersonaDetails(conductor.datosPersona)
    TituloH2Details("Datos Vehiculares")
    TextSolicitudDetails("N° Registro de conducir:", conductor.nroRegistro)
    TextSolicitudDetails("Clase de registro:", conductor.claseRegistro)
    TituloH2Details("Fechas")
    TextSolicitudDetails("Expedición del registro:", conductor.fechaRegistroExpedicion)
    TextSolicitudDetails("Vencimiento del registro:", conductor.fechaRegistroVencimiento)
    TextSolicitudDetails("Relación con el asegurado:", conductor.relacionAsegurado)
}