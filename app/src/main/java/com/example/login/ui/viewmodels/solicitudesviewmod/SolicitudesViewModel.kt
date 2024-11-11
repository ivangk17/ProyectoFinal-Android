package com.example.login.ui.viewmodels.solicitudesviewmod

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.models.solicitud.aSolicitudSimplificada
import com.example.login.data.network.services.SolicitudesRepositoryImpl
import com.example.login.tokens.Token
import kotlinx.coroutines.launch


class SolicitudesViewModel(private val repository: SolicitudesRepositoryImpl) : ViewModel() {
    private val _uiState = MutableLiveData<SolicitudesUiState>()
    val uiState: LiveData<SolicitudesUiState> = _uiState

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error


    init {
        fetchSolicitudes()
    }


    private fun fetchSolicitudes() {
        viewModelScope.launch {
            _uiState.postValue(SolicitudesUiState.Loading)

            try {
                val response = repository.getSolicitudes()
                if (response.isSuccessful) {

                    val solicitudesList: List<Solicitud> = response.body() ?: emptyList()

                    if (solicitudesList.isEmpty()) {
                        _uiState.postValue(SolicitudesUiState.Empty("No hay solicitudes"))
                    } else {
                        _uiState.postValue(SolicitudesUiState.Success(solicitudesList.map { it.aSolicitudSimplificada(Token.token) }))
                    }
                } else {
                    _uiState.postValue(SolicitudesUiState.Error("Error en la respuesta: ${response.code()}"))
                }
            } catch (e: Exception) {
                _uiState.postValue(SolicitudesUiState.Error(e.message ?: "Error desconocido"))
            }
        }
    }
}