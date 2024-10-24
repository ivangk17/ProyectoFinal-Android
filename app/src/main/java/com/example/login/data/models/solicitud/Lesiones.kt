package com.example.login.data.models.solicitud

import com.example.login.data.models.personas.Lesionado
import com.example.login.data.models.personas.Persona

data class Lesiones(
    var lesionado: Lesionado = Lesionado(),
    var peatonOCiclista: Boolean = false,
    var conductorTercero: Boolean = false,
    var ocupanteTercero: Boolean = false,
    var conductorAsegurado: Boolean = false,
    var asegurado: Boolean = false,
    var conductor: Boolean = false,
    var propietarioVehiculoAsegurado: Boolean = false,
    var relacionConPropietario: Boolean = false
)
