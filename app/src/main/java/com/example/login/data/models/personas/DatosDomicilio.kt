package com.example.login.data.models.personas

import androidx.compose.runtime.mutableStateOf
import com.example.login.data.models.fields.FormField
import com.example.login.data.models.fields.TipoCampo

object DatosDomicilio {
    val datos = listOf(
        FormField("Calle", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Numero", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Localidad", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Codigo Postal", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Provincia", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Pais", mutableStateOf(""), tipo = TipoCampo.TEXTO)
    )


}