package com.example.login.ui.viewmodels.homeviewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.login.data.models.poliza.Poliza
import com.example.login.data.network.services.GetServicePolizas
import com.example.login.ui.viewmodels.solicitudesviewmodel.SolicitudesUiState
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getPolizasUseCase : GetServicePolizas
) : ViewModel() {

    private val _uiState = mutableStateOf<HomeUiState>(HomeUiState.Loading)
    val uiState: State<HomeUiState> = _uiState

    var Polizas = mutableStateOf<List<Poliza>>(listOf())

    init {
        loadPolizas()
    }

    private fun loadPolizas() {
        viewModelScope.launch {
            _uiState.value = HomeUiState.Loading
            try {
                val response = getPolizasUseCase.getPolizas()
                if (response.isSuccessful) {
                    // Supongamos que la respuesta es un List<List<Poliza>>
                    val polizasList = response.body() ?: emptyList()
                    _uiState.value = if (polizasList.isNotEmpty()) {
                        HomeUiState.Success(polizasList)
                    } else {
                        HomeUiState.Empty("No hay pólizas disponibles")
                    }
                } else {
                    _uiState.value = HomeUiState.Error("Error en la respuesta: ${response.code()}")
                }
            } catch (e: Exception) {
                _uiState.value = HomeUiState.Error(e.message ?: "Error desconocido")
            }
        }
    }

// var Polizas = mutableStateOf<List<Poliza>>(listOf())

    companion object {

        fun provideFactory(getPolizasUseCase: GetServicePolizas): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return HomeViewModel(getPolizasUseCase) as T
            }
        }
    }

}

