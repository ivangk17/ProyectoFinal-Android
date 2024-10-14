package com.example.login.data.models

data class Domicilio(
    val calle: String,
    val localidad: String,
    val codigoPostal: Int,
    val provincia: String,
    val pais: String 
)
