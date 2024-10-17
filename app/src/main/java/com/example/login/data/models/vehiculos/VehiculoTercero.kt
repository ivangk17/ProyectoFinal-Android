package com.example.login.data.models.vehiculos

import java.util.Date

data class VehiculoTercero(
    override var numeroIdentificador: String = "",
    override var marca: String ="",
    override var modelo: String ="",
    override var tipoVehiculo: TipoVehiculo = TipoVehiculo.DESCONOCIDO,
    override var anio: String = "",
    override var dominio: String = "",
    override var idAsegurado: String = "",
    override var color: String = "",

    var aseguradora: String ="",
    var poliza: String = "",
    var fechaVencimiento: String = ""

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
