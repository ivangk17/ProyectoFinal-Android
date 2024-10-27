package com.example.login.data.models.personas

import androidx.compose.runtime.mutableStateOf
import com.example.login.data.models.fields.FormField
import com.example.login.data.models.fields.TipoCampo

object DatosPropietario {
    val datos = listOf(
        FormField("Marca y Modelo", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Color", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Año", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Dominio", mutableStateOf(""), tipo = TipoCampo.TEXTO)
    )
}