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

    fun validarCampos(campos: List<FormField>) {
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

fun validarCampoMutable(
    campo: MutableState<String?>,
    error: MutableState<String?>,
    mensajeError: String,
) {
    val soloLetrasNumeros = Regex("^[a-zA-Z0-9 ,.ñÑ:-]*$")

    if (campo.value.isNullOrEmpty()) {
        error.value = mensajeError
    }else if(!soloLetrasNumeros.matches(campo.value!!) || campo.value!!.length < 3) {
        error.value = "No es valido."
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
    } else {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val fechaIngresada = LocalDate.parse(fecha.value, formatter)
        val fechaActual = LocalDate.now()

        if (fechaIngresada.isAfter(fechaActual)) {
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
        if (edad < 18) {
            Log.d("FECHA", "entro " + edad)
            errorFecha.value = "Debe ser mayor de 18 años."
        }
    }
}



@RequiresApi(Build.VERSION_CODES.O)
private fun validarCampoNoVacio(campo: FormField): String? {
    val soloLetras = Regex("^[a-zA-Z ñÑáéíóúÁÉÍÓÚäëïöüÄËÏÖÜ]*$")
    val soloLetrasNumeros = Regex("^[a-zA-Z0-9 ñÑáéíóúÁÉÍÓÚäëïöüÄËÏÖÜ]*$")
    val textoLargo = Regex("^[a-zA-Z0-9 ,.ñÑáéíóúÁÉÍÓÚäëïöüÄËÏÖÜ:]*$")
    val largo = campo.value.value.length < 3
    var resultado: String? = null

    if (campo.label == "Departamento") {
        resultado = validarDepartamento(campo.value.value)
    }

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
        //Validar texto largo
        else if (campo.label == "Lugar de Ocurrencia" || campo.label == "Calle" || campo.label == "Aseguradora" || campo.label == "Nombre centro de Asistencia") {
            if (!textoLargo.matches(campo.value.value) || campo.value.value.length < 3) {
                return "Revisa ${campo.label}."
            }
        }
        // Validar solo letras para Nombre y Apellido
        else if (campo.label == "Nombre" || campo.label == "Apellido") {
            if (!soloLetras.matches(campo.value.value) || campo.value.value.length < 3) {
                return "Revisa el campo ${campo.label}."
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

        //Validar Poliza
        else if (campo.label == "Poliza") {
            val polizaError = validarNumeroPoliza(campo.value.value)
            if (polizaError != null) return polizaError
        }


        else if (campo.label == "Clase del Registro de Conducir") {
            val claseRegistroError = validarClaseRegistro(campo)
            if (claseRegistroError != null) return claseRegistroError
        }

        // Validar solo letras y números para otros campos
        else {
            if (!soloLetrasNumeros.matches(campo.value.value) || largo) {
                return "Revisa ${campo.label}."
            }
        }
    }

    return resultado
}


private fun validarClaseRegistro(campo: FormField): String? {
    val clasesValidas = setOf("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z")
    return if (!clasesValidas.contains(campo.value.value.toUpperCase())) {
        "La clase de registro no es válida."
    } else {
        null
    }
}

fun validarNumeroPoliza(numeroPoliza: String?): String? {
    // Verificar si el número de póliza es nulo o vacío
    if (numeroPoliza.isNullOrEmpty()) {
        return "El número de póliza no puede estar vacío"
    }

    // Verificar si el número de póliza contiene solo letras y dígitos
    if (!numeroPoliza.all { it.isLetterOrDigit() }) {
        return "El número de póliza solo puede contener letras y números"
    }

    // Verificar la longitud del número de póliza (ejemplo: entre 8 y 12 caracteres)
    if (numeroPoliza.length !in 8..12) {
        return "El número de póliza debe tener entre 8 y 12 caracteres"
    }

    // Si todas las validaciones pasan, devolver null (sin errores)
    return null
}

fun validarDepartamento(value: String?): String? {
    return when {
        value.isNullOrEmpty() -> null // El campo puede estar vacío
        !value.all { it.isLetterOrDigit() } -> "El departamento solo puede contener números y letras"
        else -> null
    }
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
    val regex = Regex("^\\d+$")

    // Validar Año
    if (valor.label == "Año" || valor.label == "Año del auto") {
        val anioError = validarAnio(valor)
        if (anioError != null) return anioError
    }

    if (valor.label == "Telefono" || valor.label == "Telefono Alternativo") {
        resultado = validarTelefono(valor.value.value)
    } else if (valor.label == "Piso") {
        resultado = validarPiso(valor.value.value)
    } else if (valor.value.value.toDoubleOrNull() == null) {
        resultado = "El campo ${valor.label} no puede estar vacío"
    } else if (!regex.matches(valor.value.value)) {
        resultado = "El campo ${valor.label} debe contener solo números"
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
    val dominioRegex =
        "^[A-Z]{3}\\d{3}$|^[A-Z]{2}\\d{3}[A-Z]{2}$|^[A-Z]{3} \\d{3}$|^[A-Z]{2} \\d{3} [A-Z]{2}$".toRegex(
            RegexOption.IGNORE_CASE
        )
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

private fun validarPiso(valor: String?): String? {
    return when {
        valor.isNullOrEmpty() -> null
        !valor.all { it.isDigit() } -> "El piso solo puede contener números"
        valor.toLongOrNull() ?: 0 > 200 -> "El piso no puede ser mayor que 200"
        valor.toLongOrNull() ?: 0 <= 0 -> "El piso debe ser mayor que 0"
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



fun validatePassword(campos: List<FormField>, currentPassword: FormField) {
    val pass1 = campos[0].value.value
    val pass2 = campos[1].value.value

    campos.forEach { campo ->
        val pass = campo.value.value
        when {
            pass1 != pass2 -> {
                campo.error.value = "Las contraseñas no coinciden."
            }
            pass.isNullOrEmpty() -> {
                campo.error.value = "La contraseña no puede estar vacía."
            }
            pass.length < 8 -> {
                campo.error.value = "La contraseña debe tener al menos 8 caracteres."
            }
            !pass.any { it.isUpperCase() } -> {
                campo.error.value = "La contraseña debe contener al menos una letra mayúscula."
            }
            !pass.any { !it.isLetterOrDigit() } -> {
                campo.error.value = "La contraseña debe contener al menos un signo."
            }
            currentPassword.value.value.isNullOrEmpty() ->{
                currentPassword.error.value = "La contraseña no puede estar vacía."
            }
            else -> {
                campo.error.value = null
            }
        }
    }
}
