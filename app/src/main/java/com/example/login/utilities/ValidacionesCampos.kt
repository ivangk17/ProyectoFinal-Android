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
                TipoCampo.DNI -> validarDni(campo)
                TipoCampo.CODIGO_POSTAL -> validarCodigoPostal(campo)
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


@RequiresApi(Build.VERSION_CODES.O)
private fun validarCampoNoVacio(campo: FormField): String? {
    val soloLetras = Regex("^[a-zA-Z]*$")
    val soloLetrasNumeros = Regex("^[a-zA-Z0-9]*$")
    var resultado: String? = null

    if (campo.label != "Departamento") {
        // Validar que el campo no esté vacío
        if (campo.value.value.isEmpty()) {
            return "El campo ${campo.label} no puede estar vacío."
        }

        // Validar que el valor no sea negativo
        val valorNumerico = campo.value.value.toDoubleOrNull()
        if (valorNumerico != null && valorNumerico < 0) {
            return "El campo ${campo.label} no puede ser negativo."
        }

        // Validar email
        if (campo.label == "Email") {
            val emailError = validarMail(campo)
            if (emailError != null) return emailError
        }
        // Validar solo letras para Nombre y Apellido
        else if (campo.label == "Nombre" || campo.label == "Apellido") {
            if (!soloLetras.matches(campo.value.value)) {
                return "El campo ${campo.label} solo puede contener letras."
            }
        }
        // Validar Nro Registro de Conducir
        else if (campo.label == "Nro Registro de Conducir") {
            val registroError = validarRegistroConducir(campo)
            if (registroError != null) return registroError
        }
        // Validar Dominio
        else if (campo.label == "Dominio") {
            val dominioError = validarDominio(campo)
            if (dominioError != null) return dominioError
        }
        // Validar Año
        else if (campo.label == "Año" || campo.label == "Año del auto") {
            val anioError = validarAnio(campo)
            if (anioError != null) return anioError
        }
        // Validar solo letras y números para otros campos
        else {
            if (!soloLetrasNumeros.matches(campo.value.value)) {
                return "El campo ${campo.label} solo puede contener números y letras."
            }
        }
    }

    return resultado
}


private fun validarMail(email: FormField): String? {
    val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$".toRegex()
    return if (!emailRegex.matches(email.value.value)) {
        "Debe ser un mail válido"
    } else {
        null
    }
}

private fun validarCampoNumerico(valor: FormField): String? {
    var resultado: String? = null

    if (valor.label != "Piso") {
        if (valor.label == "Telefono" || valor.label == "Telefono Alternativo") {
            resultado = validarTelefono(valor.value.value)
        } else {
            if (valor.value.value.toDoubleOrNull() == null) {
                resultado = "El campo ${valor.label} no puede estar vacío"
            } else if (valor.value.value.toDoubleOrNull()!! <= 0) {
                resultado = "El campo ${valor.label} no es válido"
            }
        }
    }
    return resultado
}


private fun validarDni(valor: FormField): String? {
    val numerico = valor.value.value.toDoubleOrNull() != null
    val largo = valor.value.value.length in 7..8
    return if (!numerico || !largo) {
        "El DNI no es válido."
    } else {
        null
    }
}

private fun validarCodigoPostal(valor: FormField): String? {
    val numerico = valor.value.value.toDoubleOrNull() != null
    val largo = valor.value.value.length == 4
    return if (!numerico || !largo) {
        "No es un código postal válido"
    } else {
        null
    }
}

private fun validarRegistroConducir(campo: FormField): String? {
    val registroRegex = "^[A-Z]{1,3}[0-9]{6,8}$".toRegex()
    return if (!registroRegex.matches(campo.value.value)) {
        "El Nro Registro de Conducir no es válido."
    } else {
        null
    }
}

private fun validarDominio(campo: FormField): String? {
    val dominioRegex = "^[A-Z]{3}\\d{3}$|^[A-Z]{2}\\d{3}[A-Z]{2}$|^[A-Z]{3} \\d{3}$|^[A-Z]{2} \\d{3} [A-Z]{2}$".toRegex(RegexOption.IGNORE_CASE)
    return if (!dominioRegex.matches(campo.value.value)) {
        "El Dominio no es válido."
    } else {
        null
    }
}

private fun validarTelefono(valor: String): String? {
    return when {
        !valor.all { it.isDigit() } -> "El teléfono solo puede contener números"
        valor.length < 7 || valor.length > 12 -> "El teléfono debe tener entre 7 y 12 dígitos"
        valor.toLongOrNull() ?: 0 <= 0 -> "El teléfono debe ser mayor que 0"
        else -> null
    }
}

@RequiresApi(Build.VERSION_CODES.O)
private fun validarAnio(campo: FormField): String? {
    val anio = campo.value.value.toIntOrNull()
    val anioActual = LocalDate.now().year
    return if (anio == null || anio <= 1950 || anio > anioActual) {
        "El año debe ser mayor a 1950 y menor o igual al año actual."
    } else {
        null
    }
}

