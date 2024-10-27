package com.example.login.utilities

import androidx.compose.runtime.MutableState
import com.example.login.data.models.fields.FormField
import com.example.login.data.models.fields.TipoCampo

object ValidacionesCampos {

    fun validarCampos(campos : List<FormField>) {
        campos.forEach { campo ->
            campo.error.value = when (campo.tipo) {
                TipoCampo.TEXTO -> validarCampoNoVacio(campo)
                TipoCampo.NUMERICO -> validarCampoNumerico(campo)
            }
        }
    }
}

fun validarCampoMutable(campo: MutableState<String?>, error: MutableState<String?>, mensajeError: String) {
    if (campo.value.isNullOrEmpty()) {
        error.value = mensajeError
    }
}

fun validarMail(email: FormField) {
    val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$".toRegex()
    if(!emailRegex.matches(email.value.value)){
        email.error.value = "Debe ser un mail valido"
    }
}

private fun validarCampoNoVacio(campo: FormField): String? {
    return if (campo.value.value.isEmpty()) "El campo ${campo.label} no puede estar vacío" else null
}

private fun validarCampoNumerico(valor: FormField): String? {
    var resultado: String? = null
    if(valor.value.value.toDoubleOrNull() == null){
        resultado = "El campo ${valor.label} no puede estar vacío"
    }
    else if(valor.value.value.toDoubleOrNull()!! <= 0){
        resultado = "El campo ${valor.label} no es valido"
    }

    return resultado

}