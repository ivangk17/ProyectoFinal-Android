package com.example.login.ui.formstate

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.login.data.models.personas.Sexo

data class CommonFormFields(
    var fechaNacimiento: MutableState<String?> = mutableStateOf(null),
    var errorFechaNacimiento: MutableState<String?> = mutableStateOf(null),
    var sexoSeleccionado: MutableState<Sexo> = mutableStateOf(Sexo.HOMBRE)
)
