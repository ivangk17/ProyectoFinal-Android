package com.example.login.ui.viewmodels.forms

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.login.data.models.fields.CheckField
import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.models.solicitud.datosSiniestros.HuboDenuncia
import com.example.login.data.network.services.GetServicePolizas
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InformacionAdicionalViewModel @Inject constructor(
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
        solicitud.datosSiniestro.hubieronDaniosPersonales = camposCheckeables[0].value.value
        solicitud.datosSiniestro.hubieronDaniosMateriales = camposCheckeables[1].value.value
        solicitud.datosSiniestro.hubieronTestigos = camposCheckeables[2].value.value

    }



}