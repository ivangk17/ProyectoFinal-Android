package com.example.login.ui.viewmodels.forms

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.network.services.GetServicePolizas
import com.example.login.utilities.validarCampoMutable

class RelatoAccidenteViewModel(
    getServicePolizas: GetServicePolizas
): ViewModel() {
    var solicitud = Solicitud()
    var relatoAccidente = mutableStateOf<String?>(null)
    var errorRelatoAccidente = mutableStateOf<String?>(null)


    fun onRelatoChange(valor: String){
        relatoAccidente.value = valor
        errorRelatoAccidente.value = null
    }

    fun crearSolicitud(): Solicitud?{
        validarCampoMutable(relatoAccidente,errorRelatoAccidente,"Se debe completar el relato")

        if(errorRelatoAccidente.value == null){
            solicitud.datosSiniestro.relato = relatoAccidente.value.toString()
            //solicitud.datosSiniestro.relato = "Relato del accidente"
        }else{
            return  null
        }

        return solicitud
    }

    companion object{
        fun provideFactory(getServicePolizas: GetServicePolizas): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return RelatoAccidenteViewModel(getServicePolizas) as T
            }
        }
    }
}