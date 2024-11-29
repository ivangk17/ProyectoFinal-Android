package com.example.login.ui.formstate

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.login.data.models.fields.FormField
import com.example.login.data.models.fields.TipoCampo
import com.example.login.data.models.personas.Sexo

data class ConductorFormState(
    var sexoSeleccionado: MutableState<Sexo> = mutableStateOf(Sexo.HOMBRE),
    var fechaNacimiento: MutableState<String?> = mutableStateOf(null),
    var errorFechaNacimiento: MutableState<String?> = mutableStateOf(null),
    var fechaExpedicion: MutableState<String?> = mutableStateOf(null),
    var errorFechaExpedicion: MutableState<String?> = mutableStateOf(null),
    var fechaDeVencimiento: MutableState<String?> = mutableStateOf(null),
    var errorFechaVencimiento: MutableState<String?> = mutableStateOf(null),
    val campos: List<FormField> = listOf(
        FormField("Nombre", tipo = TipoCampo.TEXTO),
        FormField("Apellido", tipo = TipoCampo.TEXTO),
        FormField("Calle", tipo = TipoCampo.TEXTO),
        FormField("Número", tipo = TipoCampo.NUMERICO),
        FormField("Piso", tipo = TipoCampo.NUMERICO),
        FormField("Departamento", tipo = TipoCampo.TEXTO),
        FormField("Código Postal", tipo = TipoCampo.CODIGO_POSTAL),
        FormField("DNI", tipo = TipoCampo.DNI),
        FormField("Teléfono", tipo = TipoCampo.NUMERICO),
        FormField("Email", tipo = TipoCampo.TEXTO),
        FormField("Nro Registro de Conducir", tipo = TipoCampo.TEXTO),
        FormField("Clase del Registro de Conducir", tipo = TipoCampo.TEXTO),
        FormField("Relación con el asegurado", tipo = TipoCampo.TEXTO),
    )
)

