package com.example.login.components.solicituddetails

import androidx.compose.runtime.Composable
import com.example.login.components.TextSolicitudDetails
import com.example.login.data.models.personas.Persona

@Composable
fun PersonaDetails(datosPersona: Persona){
    TituloH2Details("Datos Personales")
    TextSolicitudDetails("Nombre:", datosPersona.nombre)
    TextSolicitudDetails("Apellido:", datosPersona.apellido)
    TextSolicitudDetails("Cuit:", datosPersona.cuit.toString())
    TextSolicitudDetails("Email:", datosPersona.email)
    TextSolicitudDetails("Telefono:", datosPersona.telefono)
    TextSolicitudDetails("Fecha de nacimiento:", datosPersona.fechaDeNacimiento)
    TextSolicitudDetails("Sexo:", datosPersona.sexo.toString())

    DomicilioDetails(datosPersona.domicilio)


}