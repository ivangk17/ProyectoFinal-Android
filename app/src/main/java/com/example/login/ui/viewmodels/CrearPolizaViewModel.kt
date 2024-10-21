package com.example.login.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.login.data.models.solicitud.Solicitud

class CrearPolizaViewModel: ViewModel()  {


    val Solicitud = Solicitud()

    fun envioF1(solicitud: Solicitud) {

        Solicitud.datosSiniestro.lugaarOcurrencia = solicitud.datosSiniestro.lugaarOcurrencia
        Solicitud.datosSiniestro.codigoPostal = solicitud.datosSiniestro.codigoPostal
        Solicitud.datosSiniestro.localidad = solicitud.datosSiniestro.localidad
        Solicitud.datosSiniestro.provincia = solicitud.datosSiniestro.provincia
        Solicitud.datosSiniestro.pais = solicitud.datosSiniestro.pais
        Solicitud.datosSiniestro.cantidadAutosParticipantes = solicitud.datosSiniestro.cantidadAutosParticipantes
        Solicitud.datosSiniestro.interseccion = solicitud.datosSiniestro.interseccion
        Solicitud.datosSiniestro.fechaOcurrencia = solicitud.datosSiniestro.fechaOcurrencia
    }

    companion object{
        fun provideFactory(): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return CrearPolizaViewModel() as T
            }
        }
    }
}