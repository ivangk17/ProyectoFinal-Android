package com.example.login.ui.viewmodels.solicitudesviewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.login.data.models.poliza.Poliza
import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.network.services.GetServicePolizas
import com.example.login.data.network.services.GetServiceSolicitudes
import kotlinx.coroutines.launch

class SolicitudDetailsViewModel (
    private val getServicePolizas: GetServicePolizas,
    private val getServiceSolicitudes: GetServiceSolicitudes
): ViewModel() {
    val solicitud = mutableStateOf(Solicitud())
    val poliza = mutableStateOf(Poliza())

    fun loadInfoSolicitud(idSolicitud: String) {
        viewModelScope.launch {
            solicitud.value = getServiceSolicitudes.getSolicitud(idSolicitud)
            loadInfoPoliza(solicitud.value.propietarioAsegurado.vehiculo.datosVehiculo.dominio)
            Log.d("s", solicitud. value.propietarioAfectado.datosPersona.domicilio.piso.toString())
        }
    }

    fun loadInfoPoliza(dominio: String){
        viewModelScope.launch {
            poliza.value = getServicePolizas.getPoliza(dominio)
            Log.d("p", poliza.value.asegurador)
        }
    }


    companion object{
        fun provideFactory(getServicePolizas: GetServicePolizas ,getServiceSolicitudes: GetServiceSolicitudes): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return SolicitudDetailsViewModel(getServicePolizas, getServiceSolicitudes) as T
            }
        }
    }
}