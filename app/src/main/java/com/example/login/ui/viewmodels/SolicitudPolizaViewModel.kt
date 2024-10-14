package com.example.login.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.login.data.models.FormField
import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.network.GetServicePolizas
import com.example.login.ui.screens.forms.validarCampoNoVacio

class SolicitudPolizaViewModel(
    getServicePolizas: GetServicePolizas
) : ViewModel() {
    val campos = listOf(
        FormField("daniosVehiculoAsegurado", mutableStateOf("")),

    )

    fun validarCampos() {
        campos.forEach { campo ->
            campo.error.value = validarCampoNoVacio(campo)
        }
    }

    fun onCampoChange(index: Int, newValue: String) {
        campos[index].value.value = newValue
        campos[index].error.value = null
    }


    fun crearSolicitudPoliza(): Solicitud? {
        validarCampos()
        return if (campos.all { it.error.value == null }) {
            Solicitud(
                daniosVehiculoAsegurado = campos[0].value.value,
            )
        } else {
            null
        }
    }

    companion object{
        fun provideFactory(getServicePolizas: GetServicePolizas): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return SolicitudPolizaViewModel(getServicePolizas) as T
            }
        }
    }
}