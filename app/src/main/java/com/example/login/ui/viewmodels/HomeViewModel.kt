package com.example.login.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.login.data.models.Poliza
import com.example.login.data.network.GetServicePolizas
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getPolizasUseCase : GetServicePolizas
) : ViewModel() {

    var Polizas = mutableStateOf<List<Poliza>>(listOf())

    fun loadPolizas() {
        viewModelScope.launch {
            val polizas = getPolizasUseCase.execute()
            if(polizas.isSuccessful) {
                Polizas.value = polizas.body()!!
            }
        }
    }

    companion object {

        fun provideFactory(getPolizasUseCase: GetServicePolizas): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return HomeViewModel(getPolizasUseCase) as T
            }
        }
    }
}