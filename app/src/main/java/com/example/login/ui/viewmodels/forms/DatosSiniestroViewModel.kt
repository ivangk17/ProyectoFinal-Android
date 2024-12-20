package com.example.login.ui.viewmodels.forms

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.login.data.models.fields.FormField
import com.example.login.data.models.fields.TipoCampo
import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.network.services.GetServicePolizas
import com.example.login.ui.viewmodels.CrearSolicitudViewModel
import com.example.login.utilities.ValidacionesCampos.validarCampos
import com.example.login.utilities.validarCampoMutable
import com.example.login.utilities.validarFechaActual
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DatosSiniestroViewModel @Inject constructor(
) : ViewModel() {

    val solicitud = Solicitud()

    val campos = listOf(
        FormField("Lugar de Ocurrencia", tipo = TipoCampo.TEXTO),
        FormField("Codigo Postal", tipo = TipoCampo.CODIGO_POSTAL),
        FormField("Cantidad de autos que participaron", mutableStateOf(""), tipo = TipoCampo.NUMERICO),
    )

    var fechaOcurrencia = mutableStateOf<String?>(null)
    var errorFechaOcurrencua = mutableStateOf<String?>(null)

    var horaOcurriencia = mutableStateOf<String?>(null)
    var errorHoraOcurrencua = mutableStateOf<String?>(null)


    fun onCampoChange(index: Int, newValue: String) {
        campos[index].value.value = newValue
        campos[index].error.value = null
    }

    fun setFechaOcurrencia(newValue: String) {
        fechaOcurrencia.value = newValue
        errorFechaOcurrencua.value = null
    }

    fun setHoraOcurrencia(newValue: String) {
        horaOcurriencia.value = newValue
        errorHoraOcurrencua.value = null
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun crearSolicitudPoliza(): Solicitud? {
        validarCampos(campos)
        validarCampoMutable(horaOcurriencia, errorHoraOcurrencua, "Se debe completar la hora de ocurrencia")
        validarFechaActual(fechaOcurrencia, errorFechaOcurrencua)

        if (campos.all { it.error.value == null } && errorFechaOcurrencua.value == null && errorHoraOcurrencua.value == null) {
            solicitud.datosSiniestro.fechaOcurrencia = fechaOcurrencia.value
            solicitud.datosSiniestro.horaOcurrencia = horaOcurriencia.value.toString()
            solicitud.datosSiniestro.lugarOcurrencia = campos[0].value.value
            solicitud.datosSiniestro.codigoPostal = campos[1].value.value.toInt()
            solicitud.datosSiniestro.cantidadAutosParticipantes = campos[2].value.value.toIntOrNull()!!

//            solicitud.datosSiniestro.fechaOcurrencia = "2020-10-10";
//            solicitud.datosSiniestro.horaOcurrencia = "14:30:00"; // Ejemplo de hora exacta
//            solicitud.datosSiniestro.lugarOcurrencia = "Lugar Ocurrencia";
//            solicitud.datosSiniestro.codigoPostal = 7300;
//            solicitud.datosSiniestro.cantidadAutosParticipantes = 2; // Ejemplo de cantidad
        }else{
            return null
        }

        return solicitud
    }

}