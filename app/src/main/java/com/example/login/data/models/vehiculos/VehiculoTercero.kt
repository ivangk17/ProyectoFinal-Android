package com.example.login.data.models.vehiculos

import java.util.Date

data class VehiculoTercero(
    override val numeroIdentificador: String = "",
    override val marca: String ="",
    override val modelo: String ="",
    override val tipoVehiculo: TipoVehiculo = TipoVehiculo.DESCONOCIDO,
    override val anio: Int = -1,
    override val dominio: String = "",
    override val idAsegurado: Number = -1,
    override val color: String = "",

    val aseguradora: String ="",
    val poliza: String = "",
    val fechaVencimiento: Date? = null

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
