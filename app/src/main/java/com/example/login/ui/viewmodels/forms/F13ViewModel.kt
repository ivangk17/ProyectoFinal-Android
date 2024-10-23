package com.example.login.ui.viewmodels.forms

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.login.components.SwitchCustom
import com.example.login.data.models.fields.CheckField
import com.example.login.data.models.fields.FormField
import com.example.login.data.models.fields.TipoCampo
import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.models.solicitud.datosSiniestros.HuboDenuncia
import com.example.login.data.models.solicitud.datosSiniestros.asistencia.EstadoLesiones
import com.example.login.data.network.GetServicePolizas
import com.example.login.utilities.ValidacionesCampos.validarCampos

class F13ViewModel(
    getServicePolizas: GetServicePolizas
) : ViewModel() {
    var Solicitud = Solicitud()
    var estadoLesiones = mutableStateOf(EstadoLesiones.LEVE)

    val camposCheckeables = listOf(
        CheckField("¿Queda internado?"),
        // a futuro se pueden agregar mas campos
        //SwitchCustom(checked = switchState.value, onCheckedChange = {newState -> onSwitchChange(newState) }, "aa")
    )

    val campos = listOf(
        FormField("Nombre centro de Asistencia", tipo = TipoCampo.TEXTO),
        // a futuro se pueden agregar mas campos
    )

    fun onCampoChange(index: Int, newValue: String) {
        campos[index].value.value = newValue
        campos[index].error.value = null
    }


    fun onSwitchChange(index: Int, newState: Boolean) {
        Log.d("switch", "CAMBIO")
        camposCheckeables[index].value.value = newState
    }


    fun crearSolicitudPoliza(): Solicitud? {
        validarCampos(campos)
        if (campos.all { it.error.value == null }) {
            Solicitud.datosSiniestro.lugarAsistencia!!.nombreCentro = campos[0].value.value

            cargarCheckeables()

        }else{
            return null
        }


        return Solicitud
    }

    private fun cargarCheckeables(){
        Solicitud.datosSiniestro.lugarAsistencia!!.quedaInternado = camposCheckeables[0].value.value
        Solicitud.datosSiniestro.lugarAsistencia!!.estadoLesiones = estadoLesiones.value
    }

    companion object{
        fun provideFactory(getServicePolizas: GetServicePolizas): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return F13ViewModel(getServicePolizas) as T
            }
        }
    }


}


