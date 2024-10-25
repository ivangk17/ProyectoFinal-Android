package com.example.login.data.models.vehiculos

data class Vehiculo(
    var marca: String ="",
    var modelo: String ="",
    var tipoVehiculo: TipoVehiculo = TipoVehiculo.AUTO,
    var color: String = "",
    var anio: Number = -1,
    var dominio: String = "",
)
