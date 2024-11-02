package com.example.login.components.solicituddetails

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.login.components.TextSolicitudDetails
import com.example.login.data.models.personas.Persona

@Composable
fun PersonaDetails(datosPersona: Persona){
    TituloH2Details("Datos Personales")
    Row() {
        Row (Modifier.padding(end = 25.dp)){
            TextSolicitudDetails("Nombre:", datosPersona.nombre)
        }
        TextSolicitudDetails("Apellido:", datosPersona.apellido)
    }
    TextSolicitudDetails("Cuit:", datosPersona.cuit.toString())
    TextSolicitudDetails("Email:", datosPersona.email)
    TextSolicitudDetails("Telefono:", datosPersona.telefono)
    TextSolicitudDetails("Fecha de nacimiento:", datosPersona.fechaDeNacimiento)
    TextSolicitudDetails("Sexo:", datosPersona.sexo.toString())

    DomicilioDetails(datosPersona.domicilio)


}