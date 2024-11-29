package com.example.login.ui.formstate

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class DomicilioFormState(
    var calle: MutableState<String> = mutableStateOf(""),
    var numero: MutableState<Int> = mutableStateOf(-1),
    var piso: MutableState<String?> = mutableStateOf(null),
    var departamento: MutableState<String> = mutableStateOf(""),
    var codigoPostal: MutableState<Int> = mutableStateOf(-1)
)
