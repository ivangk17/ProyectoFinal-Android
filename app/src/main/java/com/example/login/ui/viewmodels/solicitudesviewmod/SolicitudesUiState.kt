package com.example.login.ui.viewmodels.solicitudesviewmod

import com.example.login.data.models.solicitud.SolicitudSimplificada

sealed class SolicitudesUiState {
    object Loading : SolicitudesUiState()
    data class Success(val solicitudes: List<SolicitudSimplificada>) : SolicitudesUiState()
    data class Empty(val message: String) : SolicitudesUiState()
    data class Error(val message: String) : SolicitudesUiState()
}
