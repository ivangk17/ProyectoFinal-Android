package com.example.login.ui.viewmodels.forms

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.login.data.models.fields.CheckField
import com.example.login.data.models.fields.FormField
import com.example.login.data.models.fields.TipoCampo
import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.models.solicitud.datosSiniestros.HuboDenuncia
import com.example.login.data.network.services.GetServicePolizas

class InformacionAdicionalViewModel(
    getServicePolizas: GetServicePolizas
) : ViewModel() {
    var solicitud = Solicitud()
    var huboDenunciaSeleccion =  mutableStateOf(HuboDenuncia.NO)

    val camposCheckeables = listOf(
        CheckField("¿Hubo Daños Personales?"),
        CheckField("¿Hubo Daños Materiales?"),
        CheckField("¿Hubo Testigos?"),
    )

    fun onSwitchChange(index: Int, newState: Boolean) {
        camposCheckeables[index].value.value = newState
    }

    fun crearSolicitudPoliza(): Solicitud {
            cargarCheckeables()
            solicitud.datosSiniestro.huboDenuncia = huboDenunciaSeleccion.value

//            solicitud.datosSiniestro.hubieronDaniosPersonales = true;
//            solicitud.datosSiniestro.hubieronDaniosMateriales = true;
//            solicitud.datosSiniestro.hubieronTestigos = true;
//            solicitud.datosSiniestro.huboDenuncia = HuboDenuncia.SI;

        return solicitud
    }

    private fun cargarCheckeables() {
        solicitud.datosSiniestro.huboDaniosPersonales = camposCheckeables[0].value.value
        solicitud.datosSiniestro.huboDaniosMateriales = camposCheckeables[1].value.value
        solicitud.datosSiniestro.huboTestigos = camposCheckeables[2].value.value

    }


    companion object {
        fun provideFactory(getServicePolizas: GetServicePolizas): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return InformacionAdicionalViewModel(getServicePolizas) as T
                }
            }
    }

}