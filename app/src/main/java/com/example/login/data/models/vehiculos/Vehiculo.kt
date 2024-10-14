package com.example.login.data.models.vehiculos

open class Vehiculo(
    open val numeroIdentificador: String,
    open val marca: String,
    open val modelo: String,
    open val tipoVehiculo: TipoVehiculo,
    open val anio: Int,
    open val dominio: String,
    open val idAsegurado: Number,
    open val color: String
)
