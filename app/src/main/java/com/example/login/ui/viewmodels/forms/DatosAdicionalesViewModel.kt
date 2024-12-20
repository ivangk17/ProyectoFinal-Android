package com.example.login.ui.viewmodels.forms

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.login.data.models.fields.CheckField
import com.example.login.data.models.fields.TipoCampo
import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.models.solicitud.datosSiniestros.EstadoCamino
import com.example.login.data.models.solicitud.datosSiniestros.EstadoTiempo
import com.example.login.data.models.solicitud.datosSiniestros.TipoCamino
import com.example.login.data.network.services.GetServicePolizas
import com.example.login.utilities.validarCampoMutable
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DatosAdicionalesViewModel @Inject constructor(
): ViewModel() {

    var solicitud = Solicitud()

    var tipoCamino =  mutableStateOf(TipoCamino.ASFALTO)
    var estadoCamino = mutableStateOf(EstadoCamino.REGULAR)
    var estadoTiempo =mutableStateOf(EstadoTiempo.SECO)

    var observaciones = mutableStateOf<String?>(null)
    var errorObservaciones = mutableStateOf<String?>(null)

    val camposCheckeables = listOf(
        CheckField("¿Asistio la grua?"),
        CheckField("¿Asistio la ambulancia?"),
        CheckField("¿Asistio bomberos?"),
    )

    fun onSwitchChange(index: Int, newState: Boolean) {
        Log.d("switch", "CAMBIO")
        camposCheckeables[index].value.value = newState
    }

    fun onObservacionChange(valor: String){
        observaciones.value = valor
        errorObservaciones.value = null
    }

    fun crearSolicitud(): Solicitud?{
        validarCampoMutable( observaciones,errorObservaciones,"Se debe completar el campo")

        if(errorObservaciones.value == null){
            solicitud.datosSiniestro.tipoCamino = tipoCamino.value
            solicitud.datosSiniestro.estadoCamino = estadoCamino.value
            solicitud.datosSiniestro.estadoTiempo = estadoTiempo.value
            solicitud.datosSiniestro.asistioGrua = camposCheckeables[0].value.value
            solicitud.datosSiniestro.asistioAmbulancia = camposCheckeables[1].value.value
            solicitud.datosSiniestro.asistioBomberos = camposCheckeables[2].value.value
            solicitud.datosSiniestro.observaciones = observaciones.value.toString()

//            solicitud.datosSiniestro.tipoCamino = TipoCamino.RIPIO
//            solicitud.datosSiniestro.estadoCamino = EstadoCamino.MALO
//            solicitud.datosSiniestro.estadoTiempo = EstadoTiempo.NIEVE
//            solicitud.datosSiniestro.asistioGrua = true
//            solicitud.datosSiniestro.asistioAmbulancia = true
//            solicitud.datosSiniestro.asistioBomberos = true
//            solicitud.datosSiniestro.observaciones = "Observaciones datos sieniestros"
        }else{
            return null
        }

        return solicitud
    }

}