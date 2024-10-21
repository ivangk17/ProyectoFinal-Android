package com.example.login.data.models.poliza

import com.example.login.data.models.vehiculos.Vehiculo

data class Poliza(
    val dniAsegurado: String = "",
    val tipoCobertura: String = "",
    val dominio: String = "",
    val aseguradora: String = "",
    val primaSegura: String = "",
    val deducible: String = "",
    val vehiculo: Vehiculo = Vehiculo(),


)

