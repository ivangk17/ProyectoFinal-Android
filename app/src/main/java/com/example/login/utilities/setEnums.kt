package com.example.login.utilities

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.login.data.models.vehiculos.ColorVehiculo
import com.example.login.data.models.vehiculos.TipoVehiculo

fun setColor(colorString: String): MutableState<ColorVehiculo> {
    val color = mutableStateOf(ColorVehiculo.BLANCO)

    when (colorString) {
        "Rojo" -> color.value = ColorVehiculo.ROJO
        "Azul" -> color.value = ColorVehiculo.AZUL
        "Verde" -> color.value = ColorVehiculo.VERDE
        "Negro" -> color.value = ColorVehiculo.NEGRO
        "Amarillo" -> color.value = ColorVehiculo.AMARILLO
        "Gris" -> color.value = ColorVehiculo.GRIS
        "Naranja" -> color.value = ColorVehiculo.NARANJA
        "Rosa" -> color.value = ColorVehiculo.ROSA
        "Marrón" -> color.value = ColorVehiculo.MARRON
        "Blanco" -> color.value = ColorVehiculo.BLANCO
    }

    return color
}

fun serTipoVehiculo(tipoVehiculoString: String): MutableState<TipoVehiculo>{
    val tipoVehiculo = mutableStateOf(TipoVehiculo.AUTO)

    when(tipoVehiculoString){
        "AUTO" -> TipoVehiculo.AUTO
        "MOTO" -> TipoVehiculo.MOTO
        "CAMION" -> TipoVehiculo.CAMION
    }

    return tipoVehiculo
}