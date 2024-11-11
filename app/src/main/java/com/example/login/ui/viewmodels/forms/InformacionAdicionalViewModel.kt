package com.example.login.ui.viewmodels.forms

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.login.components.DatePicker
import com.example.login.data.models.fields.CheckField
import com.example.login.data.models.fields.FormField
import com.example.login.data.models.fields.TipoCampo
import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.models.solicitud.datosSiniestros.HuboDenuncia
import com.example.login.data.network.services.GetServicePolizas
import com.example.login.utilities.ValidacionesCampos.validarCampos
import com.example.login.utilities.validarCampoMutable

class InformacionAdicionalViewModel(
    getServicePolizas: GetServicePolizas
) : ViewModel() {
    var solicitud = Solicitud()
    var huboDenunciaSeleccion =  mutableStateOf(HuboDenuncia.NO)

    var vigenciaHasta = mutableStateOf<String?>(null)
    var errorVigenciaHasta = mutableStateOf<String?>(null)


    val camposCheckeables = listOf(
        CheckField("¿Hubieron Daños Personales?"),
        CheckField("¿Hubieron Daños Materiales?"),
        CheckField("¿Hubieron Testigos?"),
        //SwitchCustom(checked = switchState.value, onCheckedChange = {newState -> onSwitchChange(newState) }, "aa")
    )

    fun onSwitchChange(index: Int, newState: Boolean) {
        Log.d("switch", "CAMBIO")
        camposCheckeables[index].value.value = newState
    }

    fun setVigencia(newValue: String) {
        vigenciaHasta.value = newValue
        errorVigenciaHasta.value = null
    }

    val campos = listOf(
        FormField("Cobertura", tipo = TipoCampo.TEXTO),
        FormField("Franquicia", tipo = TipoCampo.NUMERICO),
        FormField("Cobranza", tipo = TipoCampo.NUMERICO)
    )



    fun onCampoChange(index: Int, newValue: String) {
        campos[index].value.value = newValue
        campos[index].error.value = null
    }


    fun crearSolicitudPoliza(): Solicitud? {
        validarCampoMutable(vigenciaHasta, errorVigenciaHasta,"Se debe seleccionar la vigencia")
//       validarCampos(campos)
        if (campos.all { it.error.value == null } && errorVigenciaHasta.value == null) {
            solicitud.datosSiniestro.vigencia = vigenciaHasta.value!!
//            solicitud.datosSiniestro.cobertura = campos[0].value.value
//            solicitud.datosSiniestro.franquicia = campos[1].value.value
//            solicitud.datosSiniestro.cobranza = campos[2].value.value
//
//            cargarCheckeables()
//            solicitud.datosSiniestro.huboDenuncia = huboDenunciaSeleccion.value

            solicitud.datosSiniestro.hubieronDaniosPersonales = true; // Ejemplo booleano
            solicitud.datosSiniestro.hubieronDaniosMateriales = true; // Ejemplo booleano
            solicitud.datosSiniestro.hubieronTestigos = true; // Ejemplo booleano
            solicitud.datosSiniestro.huboDenuncia = HuboDenuncia.SI;
//            solicitud.datosSiniestro.vigencia = "2025-10-10"
            solicitud.datosSiniestro.cobertura = "Cobertura";
            solicitud.datosSiniestro.franquicia = "Franquicia";
            solicitud.datosSiniestro.cobranza = "Cobranza";



        }else{
            return null
        }


        return solicitud
    }

    private fun cargarCheckeables() {
        solicitud.datosSiniestro.hubieronDaniosPersonales = camposCheckeables[0].value.value
        solicitud.datosSiniestro.hubieronDaniosMateriales = camposCheckeables[1].value.value
        solicitud.datosSiniestro.hubieronTestigos = camposCheckeables[2].value.value

    }


    companion object{
        fun provideFactory(getServicePolizas: GetServicePolizas): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return InformacionAdicionalViewModel(getServicePolizas) as T
            }
        }
    }

}