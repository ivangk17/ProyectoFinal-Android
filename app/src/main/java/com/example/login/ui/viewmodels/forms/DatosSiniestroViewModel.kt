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
import com.example.login.utilities.validarCampoMutable


class DatosSiniestroViewModel(
    getServicePolizas: GetServicePolizas
) : ViewModel() {
    val crearSolicitudViewModel : CrearSolicitudViewModel = CrearSolicitudViewModel()
    val solicitud = Solicitud()

    val campos = listOf(
        FormField("Lugar de Ocurrencia", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Codigo Postal", mutableStateOf(""), tipo = TipoCampo.NUMERICO),
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
//        validarCampos(campos)
//        validarCampoMutable(fechaOcurrencia, errorFechaOcurrencua, "Se debe completar la fecha de ocurrencia")
//        validarCampoMutable(horaOcurriencia, errorHoraOcurrencua, "Se debe completar la hora de ocurrencia")

        if (campos.all { it.error.value == null }) {
//            solicitud.datosSiniestro.fechaOcurrencia = fechaOcurrencia.value
//            solicitud.datosSiniestro.horaOcurrencia = horaOcurriencia.value.toString()
//            solicitud.datosSiniestro.lugarOcurrencia = campos[0].value.value
//            solicitud.datosSiniestro.codigoPostal = campos[1].value.value.toInt()
//            solicitud.datosSiniestro.localidad = campos[2].value.value
//            solicitud.datosSiniestro.provincia = campos[3].value.value
//            solicitud.datosSiniestro.pais = campos[4].value.value
//            solicitud.datosSiniestro.cantidadAutosParticipantes = campos[5].value.value.toIntOrNull()!!
//            solicitud.datosSiniestro.interseccion = campos[6].value.value




            solicitud.datosSiniestro.fechaOcurrencia = "2020-10-10";
            solicitud.datosSiniestro.horaOcurrencia = "14:30:00"; // Ejemplo de hora exacta
            solicitud.datosSiniestro.lugarOcurrencia = "Lugar Ocurrencia";
            solicitud.datosSiniestro.codigoPostal = 7300;
            solicitud.datosSiniestro.cantidadAutosParticipantes = 2; // Ejemplo de cantidad
        }else{
            return null
        }

        return solicitud
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