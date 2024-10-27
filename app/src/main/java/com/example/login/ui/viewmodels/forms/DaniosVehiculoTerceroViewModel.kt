package com.example.login.ui.viewmodels.forms

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.network.services.GetServicePolizas
import com.example.login.utilities.validarCampoMutable

class DaniosVehiculoTerceroViewModel(
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
//        validarCampoMutable(descripcionDanios, errorDescription, "Se debe completar el campo")

        if (errorDescription.value == null) {
//            solicitud.daniosVehiculoAfectado = descripcionDanios.value.toString()
            solicitud.daniosVehiculoAfectado = "Daños vehiculos afectado"
        } else {
            return null
        }

        return solicitud
    }

    companion object {
        fun provideFactory(getServicePolizas: GetServicePolizas): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return DaniosVehiculoTerceroViewModel(getServicePolizas) as T
            }
        }
    }
}