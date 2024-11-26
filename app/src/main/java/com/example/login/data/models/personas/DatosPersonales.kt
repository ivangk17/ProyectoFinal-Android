package com.example.login.data.models.personas

import androidx.compose.runtime.mutableStateOf
import com.example.login.data.models.fields.FormField
import com.example.login.data.models.fields.TipoCampo

data class DatosPersonales(
    var Nombre: String = "",
    var Apellido: String = "",
    var CUIT: String = "",
    var Email: String = "",
    var Telefono: String = ""
)
