package com.example.login.data.models.solicitud

import com.example.login.data.models.personas.Persona

data class Lesiones(
    val lesionado: Persona = Persona(),
    val peatonOCiclista: Boolean? = null,
    val conductorTercero: Boolean? = null,
    val ocupanteTercero: Boolean? = null,
    val asegurado: Boolean? = null,
    val conductorAsegurado: Boolean? = null
)
