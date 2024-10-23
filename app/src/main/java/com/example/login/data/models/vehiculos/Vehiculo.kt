package com.example.login.data.models.vehiculos

data class Vehiculo(
    var numeroIdentificador: String = "",
    var marca: String ="",
    var modelo: String ="",
    var tipoVehiculo: TipoVehiculo = TipoVehiculo.DESCONOCIDO,
    var anio: String = "",
    var dominio: String = "",
    var color: String = "",

    var aseguradora: String ="",
    var poliza: String = "",
    var fechaVencimiento: String = ""

)
