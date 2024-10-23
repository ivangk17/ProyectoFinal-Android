package com.example.login.data.models.vehiculos

open class Vehiculo(
    open val numeroIdentificador: String = "",
    open var marca: String = "",
    open var modelo: String = "",
    open val tipoVehiculo: TipoVehiculo = TipoVehiculo.DESCONOCIDO,
    open var anio: String = "",
    open var dominio: String = "",
    open val idAsegurado: String = "",
    open val color: String = "",
    open var usoDelVehiculo : UsoDelVehiculo = UsoDelVehiculo.PARTICULAR,
)
