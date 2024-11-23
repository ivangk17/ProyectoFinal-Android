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
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SolicitudDetailsViewModel @Inject constructor(
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


}