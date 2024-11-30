package com.example.login.ui.viewmodels.forms

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.network.services.GetServicePolizas
import com.example.login.ui.viewmodels.forms.daniosviewmodel.DaniosViewModel
import com.example.login.utilities.validarCampoMutable
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DaniosVehiculoAseguradoViewModel @Inject constructor(
) : ViewModel(), DaniosViewModel {

    override var solicitud = Solicitud()
    override var descripcionDanios = mutableStateOf<String?>(null)
    override var errorDescription = mutableStateOf<String?>(null)

    override fun onDescripcionChange(valor: String) {
        descripcionDanios.value = valor
        errorDescription.value = null
    }

    override fun crearSolicitud(): Solicitud? {
        validarCampoMutable(descripcionDanios,errorDescription,"Se debe completar el campo")
        if (errorDescription.value == null) {
            solicitud.daniosVehiculoAsegurado = descripcionDanios.value.toString()
//            solicitud.daniosVehiculoAsegurado = "Daños vehiculos asegurado"
        } else {
            return null
        }

        return solicitud
    }


}