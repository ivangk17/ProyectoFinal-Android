package com.example.login.ui.viewmodels.forms

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.login.data.models.fields.CheckField
import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.network.services.GetServicePolizas
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ConsecuenciaSiniestroViewModel @Inject constructor(
): ViewModel() {

    var solicitud = Solicitud()

    val camposCheckeables = listOf(
        CheckField("Daño parcial"),
        CheckField("Robo de rueda"),
        CheckField("Robo parcial"),
        CheckField("Daño a terceros"),
        CheckField("Incendio total"),
        CheckField("Otros"),
        CheckField("Destrucción total"),
        CheckField("Robo/hurto total"),
        CheckField("Rotura de Cristales"),
        CheckField("Incendio parcial"),
    )

    fun onSwitchChange(index: Int, newState: Boolean) {
        camposCheckeables[index].value.value = newState
    }

    fun crearSolicitudPoliza(): Solicitud{

        solicitud.datosSiniestro.consecuenciaSiniestro.danioParcial = camposCheckeables[0].value.value
        solicitud.datosSiniestro.consecuenciaSiniestro.roboRueda = camposCheckeables[1].value.value
        solicitud.datosSiniestro.consecuenciaSiniestro.roboParcial = camposCheckeables[2].value.value
        solicitud.datosSiniestro.consecuenciaSiniestro.danioTerceros = camposCheckeables[3].value.value
        solicitud.datosSiniestro.consecuenciaSiniestro.incendioTotal = camposCheckeables[4].value.value
        solicitud.datosSiniestro.consecuenciaSiniestro.otros = camposCheckeables[5].value.value
        solicitud.datosSiniestro.consecuenciaSiniestro.destruccionTotal = camposCheckeables[6].value.value
        solicitud.datosSiniestro.consecuenciaSiniestro.roboTotal = camposCheckeables[7].value.value
        solicitud.datosSiniestro.consecuenciaSiniestro.roturaCristales = camposCheckeables[8].value.value
        solicitud.datosSiniestro.consecuenciaSiniestro.incendioParcial = camposCheckeables[9].value.value

//            solicitud.datosSiniestro.consecuenciaSiniestro.danioParcial = true
//            solicitud.datosSiniestro.consecuenciaSiniestro.roboRueda = true
//            solicitud.datosSiniestro.consecuenciaSiniestro.roboParcial = true
//            solicitud.datosSiniestro.consecuenciaSiniestro.danioTerceros = true
//            solicitud.datosSiniestro.consecuenciaSiniestro.incendioTotal = true
//            solicitud.datosSiniestro.consecuenciaSiniestro.otros = true
//            solicitud.datosSiniestro.consecuenciaSiniestro.destruccionTotal = true
//            solicitud.datosSiniestro.consecuenciaSiniestro.roboTotal = true
//            solicitud.datosSiniestro.consecuenciaSiniestro.roturaCristales = true
//            solicitud.datosSiniestro.consecuenciaSiniestro.incendioParcial = true


        return solicitud
    }



}