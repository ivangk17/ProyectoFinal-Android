package com.example.login.data.models.vehiculos

data class VehiculoTercero(
    override val numeroIdentificador: String,
    override val marca: String,
    override val modelo: String,
    override val tipoVehiculo: TipoVehiculo,
    override val anio: Int,
    override val dominio: String,
    override val idAsegurado: Number,
    override val color: String
):
    Vehiculo(
        numeroIdentificador,
        marca,
        modelo,
        tipoVehiculo,
        anio,
        dominio,
        idAsegurado,
        color
    )
