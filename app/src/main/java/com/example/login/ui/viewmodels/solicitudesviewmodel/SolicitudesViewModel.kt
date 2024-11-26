package com.example.login.ui.viewmodels.solicitudesviewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.models.solicitud.aSolicitudSimplificada
import com.example.login.data.network.services.SolicitudesRepository
import com.example.login.tokens.Token
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SolicitudesViewModel @Inject constructor(
    private val solicitudesRepository: SolicitudesRepository) : ViewModel() {
    private val _uiState = mutableStateOf<SolicitudesUiState>(SolicitudesUiState.Loading)
    val uiState: State<SolicitudesUiState> = _uiState

    private val _error = mutableStateOf<String?>(null)
    val error: State<String?> = _error


    init {
        fetchSolicitudes()
    }


    private fun fetchSolicitudes() {
        viewModelScope.launch {
            _uiState.value = SolicitudesUiState.Loading

            try {
                val response = solicitudesRepository.getSolicitudes()
                if (response.isSuccessful) {

                    val solicitudesList: List<Solicitud> = response.body() ?: emptyList()

                    _uiState.value = if (solicitudesList.isEmpty()) {
                        SolicitudesUiState.Empty("No hay solicitudes")
                    } else {
                        SolicitudesUiState.Success(solicitudesList.map {
                            it.aSolicitudSimplificada(
                                Token.token
                            )
                        })
                    }
                } else {
                    _uiState.value =
                        SolicitudesUiState.Error("Error en la respuesta: ${response.code()}")
                }
            } catch (e: Exception) {
                _uiState.value = SolicitudesUiState.Error(e.message ?: "Error desconocido")
            }
        }
    }
}