package com.example.login.ui.formstate

import androidx.compose.runtime.MutableState
import com.example.login.data.models.fields.FormField
import com.example.login.data.models.personas.Sexo

interface FormState {
    val campos: List<FormField>
}