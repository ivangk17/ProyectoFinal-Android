package com.example.login.utilities

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.login.data.models.vehiculos.ColorVehiculo
import com.example.login.data.models.vehiculos.TipoVehiculo

fun setColor(colorString: String): MutableState<ColorVehiculo> {
    val color = mutableStateOf(ColorVehiculo.Blanco)

    when (colorString) {
        "Rojo" -> color.value = ColorVehiculo.Rojo
        "Azul" -> color.value = ColorVehiculo.Azul
        "Verde" -> color.value = ColorVehiculo.Verde
        "Negro" -> color.value = ColorVehiculo.Negro
        "Amarillo" -> color.value = ColorVehiculo.Amarillo
        "Gris" -> color.value = ColorVehiculo.Gris
        "Naranja" -> color.value = ColorVehiculo.Naranja
        "Rosa" -> color.value = ColorVehiculo.Rosa
        "Marrón" -> color.value = ColorVehiculo.Marron
        "Blanco" -> color.value = ColorVehiculo.Blanco
    }

    return color
}

fun setTipoVehiculo(tipoVehiculoString: String): MutableState<TipoVehiculo> {
    val tipoVehiculo = when (tipoVehiculoString) {
        "AUTO" -> mutableStateOf(TipoVehiculo.AUTO)
        "MOTO" -> mutableStateOf(TipoVehiculo.MOTO)
        "CAMION" -> mutableStateOf(TipoVehiculo.CAMION)
        else -> mutableStateOf(TipoVehiculo.AUTO)
    }

    return tipoVehiculo
}


fun setColorToDB(color :MutableState<ColorVehiculo>): String{
    val colorString: String = when (color.value) {
        ColorVehiculo.Rojo -> "Rojo"
        ColorVehiculo.Azul -> "Azul"
        ColorVehiculo.Verde -> "Verde"
        ColorVehiculo.Negro -> "Negro"
        ColorVehiculo.Amarillo -> "Amarillo"
        ColorVehiculo.Gris -> "Gris"
        ColorVehiculo.Naranja -> "Naranja"
        ColorVehiculo.Rosa -> "Rosa"
        ColorVehiculo.Marron -> "Marron"
        ColorVehiculo.Blanco -> "Blanco"
    }

    return colorString
}