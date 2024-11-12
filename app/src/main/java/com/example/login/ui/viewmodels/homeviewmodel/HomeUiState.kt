package com.example.login.ui.viewmodels.homeviewmodel

import com.example.login.data.models.poliza.Poliza


sealed class HomeUiState {
    object Loading : HomeUiState()
    data class Success(val solicitudes: List<Poliza>) : HomeUiState()
    data class Empty(val message: String) : HomeUiState()
    data class Error(val message: String) : HomeUiState()
}
