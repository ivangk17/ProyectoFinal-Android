package com.example.login.data.models.fields

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class CheckField(
    val label: String,
    val value: MutableState<Boolean> = mutableStateOf(false)
)
