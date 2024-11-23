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
import com.example.login.data.models.vehiculos.TipoVehiculo
import com.example.login.data.network.Api
import com.example.login.data.network.services.GetServicePolizas
import com.example.login.utilities.ValidacionesCampos.validarCampos
import com.example.login.utilities.validarCampoMutable
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LugarAsistenciaViewModel @Inject constructor(
    private val apiService: Api,
    getServicePolizas: GetServicePolizas
) : ViewModel() {
    var solicitud = Solicitud()
    var estadoLesiones = mutableStateOf(EstadoLesiones.LEVE)

    var descripcionLesiones = mutableStateOf<String?>(null)
    var errorDescripcionLesiones= mutableStateOf<String?>(null)

    val camposCheckeables = listOf(
        CheckField("¿Queda internado?"),
    )

    val campos = listOf(
        FormField("Nombre centro de Asistencia", tipo = TipoCampo.TEXTO),
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
        validarCampoMutable(descripcionLesiones,errorDescripcionLesiones,"Faltan la descripcion de las lesiones")
        if (campos.all { it.error.value == null }) {
            solicitud.datosSiniestro.lugarAsistencia!!.nombreCentro = campos[0].value.value
            cargarCheckeables()
            solicitud.datosSiniestro.lugarAsistencia!!.descripcionLesiones = descripcionLesiones.value.toString()

            solicitud.datosSiniestro.lugarAsistencia!!.estadoLesiones = estadoLesiones.value

//            solicitud.datosSiniestro.lugarAsistencia!!.nombreCentro = "Nombre del Centro";
//            solicitud.datosSiniestro.lugarAsistencia!!.quedaInternado = true; // Ejemplo booleano
//            solicitud.datosSiniestro.lugarAsistencia!!.estadoLesiones = EstadoLesiones.MUERTE
//            solicitud.datosSiniestro.lugarAsistencia!!.descripcionLesiones = "Descripción de las Lesiones";

        }else{
            return null
        }


        return solicitud
    }

    private fun cargarCheckeables(){
        solicitud.datosSiniestro.lugarAsistencia!!.quedaInternado = camposCheckeables[0].value.value

    }


}


