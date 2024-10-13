package com.example.login.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.login.data.network.GetServicePolizas

class SolicitudPolizaViewModel(
    getServicePolizas: GetServicePolizas
) : ViewModel() {

    companion object{
        fun provideFactory(getServicePolizas: GetServicePolizas): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return SolicitudPolizaViewModel(getServicePolizas) as T
            }
        }
    }
}