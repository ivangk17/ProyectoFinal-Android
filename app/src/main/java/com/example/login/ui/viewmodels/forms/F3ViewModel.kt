package com.example.login.ui.viewmodels.forms

import android.util.Log
import androidx.compose.material3.Text
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
import com.example.login.data.network.GetServicePolizas
import com.example.login.utilities.ValidacionesCampos.validarCampos
import java.lang.IllegalStateException


class F3ViewModel (getServicePolizas: GetServicePolizas
): ViewModel() {
    var Solicitud = Solicitud()
    var huboDenuncia = mutableStateOf(HuboDenuncia.NO)

    val campos = listOf(
        FormField("Nombre: ", tipo = TipoCampo.TEXTO),
        FormField("Apellido", tipo = TipoCampo.TEXTO),
        FormField("Domicilio", tipo = TipoCampo.TEXTO),
        FormField("Localidad", tipo = TipoCampo.TEXTO),
        FormField("C.P.", tipo = TipoCampo.TEXTO),
        FormField("Prov.", tipo = TipoCampo.TEXTO),
        FormField("País", tipo = TipoCampo.TEXTO),
        FormField("CUIT", tipo = TipoCampo.TEXTO),
        FormField("E-mail", tipo = TipoCampo.TEXTO),
        FormField("TEL", tipo = TipoCampo.TEXTO),
        FormField("Marca y modelo", tipo = TipoCampo.TEXTO),
        FormField("Color", tipo = TipoCampo.TEXTO),
        FormField("Año", tipo = TipoCampo.NUMERICO),
        FormField("Dominio", tipo = TipoCampo.TEXTO),
        FormField("Uso del vehículo", tipo = TipoCampo.TEXTO),
        FormField("Particular", tipo = TipoCampo.TEXTO),
        FormField("Comercial", tipo = TipoCampo.TEXTO)
    )
    fun onCampoChange(index: Int, newValue: String){
        campos[index].value.value = newValue
        campos[index].error.value = null
    }


    fun crearSolicitudPoliza(): Solicitud? {
        validarCampos(campos)
        if (campos.all { it.error.value == null }) { //similar a un foreach
            Solicitud.conductorAsegurado.nombre = campos[0].value.value
            Solicitud.conductorAsegurado.apellido = campos[1].value.value
            //con todos los campos

        }else{
            return null
        }
        return Solicitud
    }


    companion object{
        fun provideFactory(getServicePolizas: GetServicePolizas): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return F3ViewModel(getServicePolizas) as T
            }
        }
    }
}