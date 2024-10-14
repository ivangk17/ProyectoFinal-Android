package com.example.login.data.models

data class Domicilio(
    val calle: String = "",
    val localidad: String = "",
    val codigoPostal: Int = -1,
    val provincia: String = "",
    val pais: String = ""
)
