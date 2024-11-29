package com.example.login.ui.formstate

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.login.data.models.fields.FormField
import com.example.login.data.models.fields.TipoCampo
import com.example.login.data.models.vehiculos.ColorVehiculo
import com.example.login.data.models.vehiculos.TipoVehiculo

data class VehiculoFormState(
    var marca: MutableState<String> = mutableStateOf(""),
    var modelo: MutableState<String> = mutableStateOf(""),
    var anio: MutableState<String> = mutableStateOf(""),
    var dominio: MutableState<String> = mutableStateOf(""),
    var aseguradora: MutableState<String> = mutableStateOf(""),
    var poliza: MutableState<String> = mutableStateOf(""),
    var tipoVehiculo: MutableState<TipoVehiculo> = mutableStateOf(TipoVehiculo.AUTO),
    var colorDelVehiculo: MutableState<ColorVehiculo> = mutableStateOf(ColorVehiculo.Blanco)
)
