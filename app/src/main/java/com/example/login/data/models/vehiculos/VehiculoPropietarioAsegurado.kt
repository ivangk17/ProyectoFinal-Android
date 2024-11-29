package com.example.login.data.models.vehiculos

data class VehiculoPropietarioAsegurado(
    var datosVehiculo: Vehiculo = Vehiculo(),
    var usoDelVehiculo: UsoDelVehiculo = UsoDelVehiculo.PARTICULAR
)
