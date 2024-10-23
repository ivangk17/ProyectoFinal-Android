package com.example.login.ui.viewmodels.forms

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.login.data.models.fields.FormField
import com.example.login.data.models.fields.TipoCampo
import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.network.services.GetServicePolizas
import com.example.login.ui.viewmodels.CrearSolicitudViewModel
import com.example.login.utilities.ValidacionesCampos.validarCampos
import com.example.login.utilities.validarFecha


class DatosSiniestroViewModel(
    getServicePolizas: GetServicePolizas
) : ViewModel() {
    val crearSolicitudViewModel : CrearSolicitudViewModel = CrearSolicitudViewModel()
    val Solicitud = Solicitud()
    val campos = listOf(
        FormField("Lugar de Ocurrencia", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Codigo Postal", mutableStateOf(""), tipo = TipoCampo.NUMERICO),
        FormField("Localidad", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Provincia", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Pais", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Cantidad de autos que participaron en el siniestro", mutableStateOf(""), tipo = TipoCampo.NUMERICO),
        FormField("Interseccion", mutableStateOf(""), tipo = TipoCampo.TEXTO)
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


    fun crearSolicitudPoliza(): Solicitud? {
        validarCampos(campos)
        validarFecha(fechaOcurrencia, errorFechaOcurrencua, "Se debe completar la fecha de ocurrencia")
        validarFecha(horaOcurriencia, errorHoraOcurrencua, "Se debe completar la hora de ocurrencia")

        if (campos.all { it.error.value == null }) {
            Solicitud.datosSiniestro.lugaarOcurrencia = campos[0].value.value
            Solicitud.datosSiniestro.codigoPostal = campos[1].value.value
            Solicitud.datosSiniestro.localidad = campos[2].value.value
            Solicitud.datosSiniestro.provincia = campos[3].value.value
            Solicitud.datosSiniestro.pais = campos[4].value.value
            Solicitud.datosSiniestro.cantidadAutosParticipantes = campos[5].value.value.toIntOrNull()!!
            Solicitud.datosSiniestro.interseccion = campos[6].value.value

            Solicitud.datosSiniestro.fechaOcurrencia = fechaOcurrencia.value
            Solicitud.datosSiniestro.horaOcurrencia = horaOcurriencia.value.toString()


        }else{
            return null
        }

        return Solicitud
    }

    companion object{
        fun provideFactory(getServicePolizas: GetServicePolizas): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return DatosSiniestroViewModel(getServicePolizas) as T
            }
        }
    }
}