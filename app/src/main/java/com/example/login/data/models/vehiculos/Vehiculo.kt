package com.example.login.data.models.vehiculos

open class Vehiculo(
    open val numeroIdentificador: String = "",
    open val marca: String = "",
    open val modelo: String = "",
    open val tipoVehiculo: TipoVehiculo = TipoVehiculo.DESCONOCIDO,
    open val anio: String = "",
    open val dominio: String = "",
    open val idAsegurado: String = "",
    open val color: String = ""
)
