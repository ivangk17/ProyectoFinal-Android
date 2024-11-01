package com.example.login.ui.viewmodels.solicitudesviewmod

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.login.data.models.poliza.Poliza
import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.network.services.GetServicePolizas
import com.example.login.data.network.services.GetServiceSolicitudes
import com.example.login.ui.viewmodels.PolizaDetailsViewModel
import kotlinx.coroutines.launch

class SolicitudDetailsViewModel (
    private val getServiceSolicitudes: GetServiceSolicitudes
): ViewModel() {
    val solicitud = mutableStateOf(Solicitud())

    fun loadInfoSolicitud(idSolicitud: String) {
        viewModelScope.launch {
            solicitud.value = getServiceSolicitudes.getSolicitud(idSolicitud)
            Log.d("s", solicitud.value.toString())
        }
    }


    companion object{
        fun provideFactory(getServiceSolicitudes: GetServiceSolicitudes): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return SolicitudDetailsViewModel(getServiceSolicitudes) as T
            }
        }
    }
}