package com.example.login.data.models.vehiculos

import java.util.Date

data class VehiculoTercero(
    override val numeroIdentificador: String = "",
    override val marca: String ="",
    override val modelo: String ="",
    override val tipoVehiculo: TipoVehiculo = TipoVehiculo.DESCONOCIDO,
    override val anio: String = "",
    override val dominio: String = "",
    override val idAsegurado: String = "",
    override val color: String = "",

    val aseguradora: String ="",
    val poliza: String = "",
    val fechaVencimiento: String = ""

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
