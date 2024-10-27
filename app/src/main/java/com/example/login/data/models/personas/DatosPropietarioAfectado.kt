package com.example.login.data.models.personas

import androidx.compose.runtime.mutableStateOf
import com.example.login.data.models.fields.FormField
import com.example.login.data.models.fields.TipoCampo

object DatosPropietarioAfectado {
    val datos = listOf(
        FormField("Aseguradora", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Poliza", mutableStateOf(""), tipo = TipoCampo.TEXTO),
    )
}