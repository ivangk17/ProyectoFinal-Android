package com.example.login.data.models.fields

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class FormField(
    val label: String,
    val value: MutableState<String> = mutableStateOf(""),
    val error: MutableState<String?> = mutableStateOf(null),
    val tipo: TipoCampo
)

enum class TipoCampo {
    TEXTO,
    NUMERICO,
    DNI,
    CODIGO_POSTAL
}
