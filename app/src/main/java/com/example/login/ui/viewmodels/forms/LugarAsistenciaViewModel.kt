package com.example.login.ui.viewmodels.forms

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.login.data.models.fields.CheckField
import com.example.login.data.models.fields.FormField
import com.example.login.data.models.fields.TipoCampo
import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.models.solicitud.datosSiniestros.asistencia.EstadoLesiones
import com.example.login.data.network.services.GetServicePolizas
import com.example.login.utilities.ValidacionesCampos.validarCampos
import com.example.login.utilities.validarFecha

class LugarAsistenciaViewModel(
    getServicePolizas: GetServicePolizas
) : ViewModel() {
    var Solicitud = Solicitud()
    var estadoLesiones = mutableStateOf(EstadoLesiones.LEVE)

    var descripcionLesiones = mutableStateOf<String?>(null)
    var errorDescripcionLesiones= mutableStateOf<String?>(null)

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

    fun onDescripcionChange(valor: String){
        descripcionLesiones.value = valor
        errorDescripcionLesiones.value = null
    }


    fun crearSolicitudPoliza(): Solicitud? {
        validarCampos(campos)
        validarFecha(descripcionLesiones,errorDescripcionLesiones,"Faltan la descripcion de las lesiones")
        if (campos.all { it.error.value == null }) {
            Solicitud.datosSiniestro.lugarAsistencia.nombreCentro = campos[0].value.value

            cargarCheckeables()
            Solicitud.datosSiniestro.lugarAsistencia.descripcionLesiones = descripcionLesiones.value.toString()

        }else{
            return null
        }


        return Solicitud
    }

    private fun cargarCheckeables(){
        Solicitud.datosSiniestro.lugarAsistencia.quedaInternado = camposCheckeables[0].value.value
        Solicitud.datosSiniestro.lugarAsistencia.estadoLesiones = estadoLesiones.value
    }

    companion object{
        fun provideFactory(getServicePolizas: GetServicePolizas): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return LugarAsistenciaViewModel(getServicePolizas) as T
            }
        }
    }


}


