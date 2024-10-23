package com.example.login.data.models.personas

import com.example.login.data.models.Domicilio
import com.example.login.data.models.vehiculos.Vehiculo

data class PropietarioAsegurado(
    override val id: Int = -1,
    override var nombre: String = "",
    override var apellido: String = "",
    override var nombreCompleto: String = "${nombre} ${apellido}",
    override var cuit: String = "",
    override var email: String = "",
    override var telefono: String = "",
    override var fechaDeNacimiento: String = "",
    override var sexo: String = "",
    override var domicilio: Domicilio = Domicilio(),
    override val vehiculo: Vehiculo = Vehiculo(),

) : Propietario(
    id,
    nombre,
    apellido,
    nombreCompleto,
    cuit,
    email,
    telefono,
    fechaDeNacimiento,
    sexo,
    domicilio,
    vehiculo
)

