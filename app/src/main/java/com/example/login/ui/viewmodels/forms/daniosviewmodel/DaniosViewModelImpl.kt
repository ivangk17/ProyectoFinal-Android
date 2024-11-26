package com.example.login.ui.viewmodels.forms.daniosviewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.network.Api
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DaniosViewModelImpl @Inject constructor(
    private val apiService: Api
) : ViewModel(), DaniosViewModel {
    override val descripcionDanios = mutableStateOf<String?>(null)
    override val errorDescription = mutableStateOf<String?>(null)
    override var solicitud = Solicitud()

    override fun onDescripcionChange(valor: String) {
        descripcionDanios.value = valor
        errorDescription.value = null
    }

    override fun crearSolicitud(): Solicitud? {
        return solicitud
    }
}
