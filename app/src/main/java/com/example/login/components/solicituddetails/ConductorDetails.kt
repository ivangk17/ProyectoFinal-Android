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
    TextSolicitudDetails("Fecha de expedicion del registro:", conductor.fechaRegistroExpedicion)
    TextSolicitudDetails("Fecha de vencimiento del registro:", conductor.fechaRegistroVencimiento)
    TextSolicitudDetails("Relacion con el asegurado:", conductor.relacionAsegurado)
}