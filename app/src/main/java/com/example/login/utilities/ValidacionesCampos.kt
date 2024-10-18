package com.example.login.utilities

import androidx.compose.runtime.MutableState
import androidx.lifecycle.MutableLiveData
import com.example.login.data.models.fields.FormField
import com.example.login.data.models.fields.TipoCampo

object ValidacionesCampos {

    fun validarCampos(campos : List<FormField>) {
        campos.forEach { campo ->
            campo.error.value = when (campo.tipo) {
                TipoCampo.TEXTO -> validarCampoNoVacio(campo.value.value)
                TipoCampo.NUMERICO -> validarCampoNumerico(campo.value.value)
            }
        }
    }
}

fun validarFecha(fecha: MutableState<String?>, error: MutableState<String?>, mensajeError: String) {
    if (fecha.value.isNullOrEmpty()) {
        error.value = mensajeError
    }
}



private fun validarCampoNoVacio(campo: String): String? {
    return if (campo.isEmpty()) "Este campo no puede estar vacío" else null
}

private fun validarCampoNumerico(valor: String): String? {
    var resultado: String? = null
    if(valor.toDoubleOrNull() == null){
        resultado = "Debe ingresar el campo"
    }
    else if(valor.toDoubleOrNull()!! <= 0){
        resultado = "Debe ingresar un numero mayor a 0"
    }

    return resultado

}