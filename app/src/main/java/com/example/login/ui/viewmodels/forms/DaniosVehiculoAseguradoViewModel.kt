package com.example.login.ui.viewmodels.forms

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.network.services.GetServicePolizas
import com.example.login.utilities.validarFecha

class DaniosVehiculoAseguradoViewModel(
    getServicePolizas: GetServicePolizas
) : ViewModel(), DaniosViewModel {

    override var solicitud = Solicitud()
    override var descripcionDanios = mutableStateOf<String?>(null)
    override var errorDescription = mutableStateOf<String?>(null)

    override fun onDescripcionChange(valor: String) {
        descripcionDanios.value = valor
        errorDescription.value = null
    }

    override fun crearSolicitud(): Solicitud? {
        validarFecha(descripcionDanios, errorDescription, "Se debe completar el campo")

        if (errorDescription.value == null) {
            solicitud.daniosVehiculoAsegurado = descripcionDanios.value.toString()
            solicitud.daniosVehiculoAsegurado = "Daños vehiculos asegurado"
        } else {
            return null
        }

        return solicitud
    }

    companion object {
        fun provideFactory(getServicePolizas: GetServicePolizas): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return DaniosVehiculoAseguradoViewModel(getServicePolizas) as T
            }
        }
    }
}