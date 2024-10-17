package com.example.login.ui.viewmodels.forms

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.login.data.models.fields.FormField
import com.example.login.data.models.fields.TipoCampo
import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.network.GetServicePolizas
import com.example.login.utilities.ValidacionesCampos.validarCampos

class F4ViewModel (
    getServicePolizas: GetServicePolizas
) : ViewModel() {

    var Solicitud = Solicitud()

    var FechaVencimiento = mutableStateOf<String?>(null)
    var errorFechaVencimiento = mutableStateOf<String?>(null)

    val campos = listOf(
        FormField("Nombre", mutableStateOf(""), tipo = TipoCampo.TEXTO)
    )

    fun onCampoChange(index: Int, newValue: String) {
        campos[index].value.value = newValue
        campos[index].error.value = null
    }


    fun onFechaChange(newValue: String) {
        FechaVencimiento.value = newValue
        errorFechaVencimiento.value = null
    }

    fun crearSolicitudPoliza(): Solicitud? {
        validarCampos(campos)

        if(FechaVencimiento.value.isNullOrEmpty()){
            errorFechaVencimiento.value = "Debes completar la fecha de vencimiento"
        }
        else{
            Solicitud.conductorAsegurado.fechaVencimiento = FechaVencimiento.value!!
        }

        if (campos.all { it.error.value == null } ) {
            Solicitud.conductorAsegurado.nombre = campos[0].value.value
        }else{
        return null
    }

    return Solicitud

    }


    companion object{
        fun provideFactory(getServicePolizas: GetServicePolizas): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return F4ViewModel(getServicePolizas) as T
            }
        }
    }
}