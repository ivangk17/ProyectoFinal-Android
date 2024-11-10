package com.example.login.utilities

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.MutableState
import com.example.login.data.models.fields.FormField
import com.example.login.data.models.fields.TipoCampo
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

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

@RequiresApi(Build.VERSION_CODES.O)
fun validarFechaActual(
    fecha: MutableState<String?>,
    errorFecha: MutableState<String?>
) {
    if (fecha.value.isNullOrEmpty()) {
        errorFecha.value = "La fecha no puede ser nula o vacía."
        Log.d("FECHA", "entro")
    }else{
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val fechaIngresada = LocalDate.parse(fecha.value, formatter)
        val fechaActual = LocalDate.now()

        if (fechaIngresada.isAfter(fechaActual)){
            errorFecha.value = "Fecha inválida."
        }
    }
}



@RequiresApi(Build.VERSION_CODES.O)
fun validarFechaNacimiento(
    fecha: MutableState<String?>,
    errorFecha: MutableState<String?>
) {
    if (fecha.value.isNullOrEmpty()) {
        errorFecha.value = "La fecha no puede ser nula o vacía."
    } else {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val fechaIngresada = LocalDate.parse(fecha.value, formatter)
        val fechaActual = LocalDate.now()
        val edad = ChronoUnit.YEARS.between(fechaIngresada, fechaActual)
        if (edad < 18){
            Log.d("FECHA", "entro " + edad)
            errorFecha.value = "Debe ser mayor de 18 años."
        }
    }
}


fun validarMail(email: FormField) {
    val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$".toRegex()
    if(!emailRegex.matches(email.value.value)){
        email.error.value = "Debe ser un mail valido"
    }
}

private fun validarCampoNoVacio(campo: FormField): String? {
    return if ((campo.label != "Departamento") && campo.value.value.isEmpty()) {
        "El campo ${campo.label} no puede estar vacío"
    } else {
        null
    }
}

private fun validarCampoNumerico(valor: FormField): String? {
    var resultado: String? = null

    if(valor.label != "Piso"){
        if(valor.value.value.toDoubleOrNull() == null){
            resultado = "El campo ${valor.label} no puede estar vacío"
        }
        else if(valor.value.value.toDoubleOrNull()!! <= 0){
            resultado = "El campo ${valor.label} no es valido"
        }
    }
    return resultado
}