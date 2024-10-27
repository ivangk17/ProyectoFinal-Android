package com.example.login.data.models.personas

import com.example.login.data.models.Domicilio
import com.example.login.data.models.vehiculos.Vehiculo

open class Propietario(
    val id: Int = -1,
    var nombre: String = "",
    var apellido: String = "",
    var nombreCompleto: String = "${nombre} ${apellido}",
    var cuit: String = "",
    var email: String = "",
    var telefono: String = "",
    var fechaDeNacimiento: String = "",
    var sexo: String = "",
    var domicilio: Domicilio = Domicilio(),

     val vehiculo: Vehiculo = Vehiculo()

)