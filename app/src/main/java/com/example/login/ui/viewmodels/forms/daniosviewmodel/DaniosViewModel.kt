package com.example.login.ui.viewmodels.forms.daniosviewmodel

import androidx.compose.runtime.MutableState
import com.example.login.data.models.solicitud.Solicitud

interface DaniosViewModel {
    val descripcionDanios: MutableState<String?>
    val errorDescription: MutableState<String?>
    var solicitud: Solicitud

    fun onDescripcionChange(valor: String)
    fun crearSolicitud(): Solicitud?
}
