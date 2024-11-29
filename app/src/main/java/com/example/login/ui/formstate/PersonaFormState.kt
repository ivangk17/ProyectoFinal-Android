package com.example.login.ui.formstate

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.login.data.models.Domicilio
import com.example.login.data.models.fields.FormField
import com.example.login.data.models.fields.TipoCampo
import com.example.login.data.models.personas.Sexo

data class PersonaFormState(
    var nombre: MutableState<String> = mutableStateOf(""),
    var apellido: MutableState<String> = mutableStateOf(""),
    var dni: MutableState<String> = mutableStateOf(""),
    var email: MutableState<String> = mutableStateOf(""),
    var telefono: MutableState<String> = mutableStateOf(""),
    var domicilio: Domicilio = Domicilio(),
    override val campos: List<FormField> = listOf(
        FormField("Nombre", tipo = TipoCampo.TEXTO),
        FormField("Apellido", tipo = TipoCampo.TEXTO),
        FormField("Calle", tipo = TipoCampo.TEXTO),
        FormField("Número", tipo = TipoCampo.NUMERICO),
        FormField("Piso", tipo = TipoCampo.NUMERICO),
        FormField("Departamento", tipo = TipoCampo.TEXTO),
        FormField("Código Postal", tipo = TipoCampo.CODIGO_POSTAL),
        FormField("DNI", tipo = TipoCampo.DNI),
        FormField("Teléfono", tipo = TipoCampo.NUMERICO),
        FormField("Email", tipo = TipoCampo.TEXTO)
    )
) : FormState
