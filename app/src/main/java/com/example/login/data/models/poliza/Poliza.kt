package com.example.login.data.models.poliza

import com.example.login.data.models.vehiculos.VehiculoPoliza

data class Poliza(
    val _id: String = "",
    val asegurado: String = "",
    val asegurador: String = "",
    val dniAsegurado: String = "",
    val tipoCobertura: String = "",
    val dominio: String = "",
    val aseguradora: String = "",
    val primaSegura: String = "",
    val deducible: String = "",
    val vehiculo: VehiculoPoliza = VehiculoPoliza()


)

