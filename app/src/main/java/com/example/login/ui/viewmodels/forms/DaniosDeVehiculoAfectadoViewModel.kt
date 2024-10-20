package com.example.login.ui.viewmodels.forms

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.network.GetServicePolizas
import com.example.login.utilities.validarFecha

class DaniosDeVehiculoAfectadoViewModel(
    getServicePolizas: GetServicePolizas
):ViewModel() {

    var solicitud = Solicitud()
    var descripcionDanios =  mutableStateOf<String?>(null)
    var errorDescription = mutableStateOf<String?>(null)

    fun onDescripcionChange(valor: String){
        descripcionDanios.value = valor
        errorDescription.value = null
    }

    fun crearSolicitud(): Solicitud?{
        validarFecha(descripcionDanios,errorDescription,"Se debe completar el campo")

        if(errorDescription.value == null){
            solicitud.daniosVehiculoAfectado = descripcionDanios.value.toString()
        }else{
            return null
        }

        return solicitud
    }

    companion object{
        fun provideFactory(getServicePolizas: GetServicePolizas): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return DaniosDeVehiculoAfectadoViewModel(getServicePolizas) as T
            }
        }
    }
}