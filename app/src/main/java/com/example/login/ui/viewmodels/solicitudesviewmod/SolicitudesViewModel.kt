package com.example.login.ui.viewmodels.solicitudesviewmod

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.models.solicitud.SolicitudSimplificada
import com.example.login.data.models.solicitud.aSolicitudSimplificada
import com.example.login.data.repositories.solicitudesrepositories.SolicitudesRepositoryImpl
import kotlinx.coroutines.launch


class SolicitudesViewModel(private val repository: SolicitudesRepositoryImpl) : ViewModel() {
    private val _solicitudes = MutableLiveData<List<SolicitudSimplificada>>()

    val solicitudes: LiveData<List<SolicitudSimplificada>> = _solicitudes


    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    init {
        fetchSolicitudes()
    }


    private fun fetchSolicitudes() {
        viewModelScope.launch {
            try {
                val response = repository.getSolicitudes()
                if (response.isSuccessful) {
                    // Usa una lista vacía como valor predeterminado si response.body() es null
                    val solicitudesList: List<Solicitud> =
                        response.body() ?: emptyList()

                    // Publica la lista (aunque sea vacía) en _solicitudes
                    _solicitudes.postValue( solicitudesList.map { it.aSolicitudSimplificada() })
                } else {
                    // Manejo de errores si la respuesta no es exitosa
                    _error.postValue("Error en la respuesta: ${response.code()}")
                }
            } catch (e: Exception) {
                _error.postValue(e.message)
            }
        }
    }
}