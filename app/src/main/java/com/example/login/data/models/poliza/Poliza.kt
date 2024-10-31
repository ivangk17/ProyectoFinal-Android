package com.example.login.data.models.poliza

import com.example.login.data.models.vehiculos.Vehiculo
import com.example.login.data.models.vehiculos.VehiculoPoliza
import com.example.login.data.models.vehiculos.VehiculoPropietarioAsegurado

data class Poliza(
    val asegurado: String = "",
    val asegurador: String = "",
    val dniAsegurado: String = "",
    val tipoCobertura: String = "",
    val dominio: String = "",
    val aseguradora: String = "",
    val primaSegura: String = "",
    val deducible: String = "",
    val vehiculo: VehiculoPoliza = VehiculoPoliza()
    //val vehiculo: VehiculoPropietarioAsegurado = VehiculoPropietarioAsegurado()


)

