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
import com.example.login.data.network.GetServicePolizas
import com.example.login.utilities.ValidacionesCampos.validarCampos

class InformacionAdicionalViewModel(
    getServicePolizas: GetServicePolizas
) : ViewModel() {
    var Solicitud = Solicitud()
    var huboDenunciaSeleccion =  mutableStateOf(HuboDenuncia.NO)


    val camposCheckeables = listOf(
        CheckField("¿Hubieron Daños Personales?"),
        CheckField("¿Hubieron Daños Materiales?"),
        CheckField("¿Hubieron Testigos?"),
        //SwitchCustom(checked = switchState.value, onCheckedChange = {newState -> onSwitchChange(newState) }, "aa")
    )

    val campos = listOf(
        FormField("Vigencia", tipo = TipoCampo.TEXTO),
        FormField("Cobertura", tipo = TipoCampo.TEXTO),
        FormField("Franquicia", tipo = TipoCampo.TEXTO),
        FormField("Cobranza", tipo = TipoCampo.TEXTO)
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
            Solicitud.datosSiniestro.vigencia = campos[0].value.value
            Solicitud.datosSiniestro.cobertura = campos[1].value.value
            Solicitud.datosSiniestro.franquicia = campos[2].value.value
            Solicitud.datosSiniestro.cobranza = campos[3].value.value

            cargarCheckeables()
            Solicitud.datosSiniestro.huboDenuncia = huboDenunciaSeleccion.value
        }else{
            return null
        }


        return Solicitud
    }

    private fun cargarCheckeables() {
        Solicitud.datosSiniestro.hubieronDaniosPersonales = camposCheckeables[0].value.value
        Solicitud.datosSiniestro.hubieronDaniosMateriales = camposCheckeables[1].value.value
        Solicitud.datosSiniestro.hubieronTestigos = camposCheckeables[2].value.value

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