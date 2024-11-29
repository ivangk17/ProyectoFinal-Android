package com.example.login.ui.formstate

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class FechaVencFormState(
    var fechaDeVencimiento: MutableState<String?> = mutableStateOf(null),
    var errorFechaVencimiento: MutableState<String?> = mutableStateOf(null),
)

