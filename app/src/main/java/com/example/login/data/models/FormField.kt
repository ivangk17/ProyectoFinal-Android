package com.example.login.data.models

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class FormField(
    val label: String,
    val value: MutableState<String>,
    val error: MutableState<String?> = mutableStateOf(null)
)
