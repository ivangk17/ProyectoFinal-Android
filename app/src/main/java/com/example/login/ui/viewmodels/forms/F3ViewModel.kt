package com.example.login.ui.viewmodels.forms

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.login.data.models.fields.FormField
import com.example.login.data.models.fields.TipoCampo
import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.models.solicitud.datosSiniestros.HuboDenuncia
import com.example.login.data.network.services.GetServicePolizas
import com.example.login.utilities.ValidacionesCampos.validarCampos


class F3ViewModel (getServicePolizas: GetServicePolizas
): ViewModel() {
    var Solicitud = Solicitud()
    var huboDenuncia = mutableStateOf(HuboDenuncia.NO)

    val campos = listOf(
        FormField("Nombre: ", tipo = TipoCampo.TEXTO),
        FormField("Apellido", tipo = TipoCampo.TEXTO),
        FormField("Domicilio", tipo = TipoCampo.TEXTO),
        FormField("Localidad", tipo = TipoCampo.TEXTO),
        FormField("Codigo Postal", tipo = TipoCampo.TEXTO),
        FormField("Provincia.", tipo = TipoCampo.TEXTO),
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
            //Solicitud.conductorAsegurado.domicilio = campos[2].value.value
            //Solicitud.conductorAsegurado.localidad = campos[3].value.value
            //Solicitud.conductorAsegurado.codigoPostal = campos[4].value.value
            //Solicitud.conductorAsegurado.provincia = campos[5].value.value
            //Solicitud.conductorAsegurado.pais = campos[6].value.value
            Solicitud.conductorAsegurado.cuit = campos[7].value.value
            Solicitud.conductorAsegurado.email = campos[8].value.value
            Solicitud.conductorAsegurado.telefono = campos[9].value.value
            //Solicitud.conductorAsegurado.marcaymodelo = campos[10].value.value
            //Solicitud.conductorAsegurado.color = campos[11].value.value
            //Solicitud.conductorAsegurado.anio = campos[12].value.value
            //Solicitud.conductorAsegurado.dominio = campos[13].value.value
            //Solicitud.conductorAsegurado.usodelvehiculo = campos[14].value.value
            //Solicitud.conductorAsegurado.particular = campos[15].value.value
           // Solicitud.conductorAsegurado.comercial = campos[16].value.value


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