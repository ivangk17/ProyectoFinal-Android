package com.example.login.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.login.data.network.services.GetServicePolizas

class PolizaDetailsViewModel(
    private val getServicePolizas: GetServicePolizas
): ViewModel() {

companion object{
    fun provideFactory(getServicePolizas: GetServicePolizas): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return PolizaDetailsViewModel(getServicePolizas) as T
        }
    }
}
}