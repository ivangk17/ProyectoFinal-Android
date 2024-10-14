package com.example.login.data.models.solicitud

import com.example.login.data.models.personas.Persona

data class Lesiones(
    val lesionado: Persona,
    val peatonOCiclista: Boolean,
    val conductorTercero: Boolean,
    val ocupanteTercero: Boolean,
    val asegurado: Boolean,
    val conductorAsegurado: Boolean
)
