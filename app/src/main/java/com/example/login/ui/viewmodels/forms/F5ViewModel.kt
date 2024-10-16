package com.example.login.ui.viewmodels.forms

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.login.data.models.FormField
import com.example.login.data.models.TipoCampo
import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.network.GetServicePolizas
import com.example.login.utilities.ValidacionesCampos.validarCampos

class F5ViewModel (
    getServicePolizas: GetServicePolizas
) : ViewModel() {

    var Solicitud = Solicitud()
    var FechaNacimiento = mutableStateOf<String?>(null)
    var FechaExpedicion = mutableStateOf<String?>(null)
    var FechaVencimiento = mutableStateOf<String?>(null)

    val campos = listOf(
        FormField("Nombre", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Apellido", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Domicilio", tipo = TipoCampo.TEXTO),
        FormField("Localidad", tipo = TipoCampo.TEXTO),
        FormField("Codigo Postal", tipo = TipoCampo.NUMERICO),
        FormField("Provincia", tipo = TipoCampo.TEXTO),
        FormField("Pais", tipo = TipoCampo.TEXTO),
        FormField("CUIT", tipo = TipoCampo.NUMERICO),
        FormField("Telefono", tipo = TipoCampo.TEXTO),
        FormField("Sexo", tipo = TipoCampo.TEXTO),
        FormField("Email", tipo = TipoCampo.TEXTO),
        FormField("Nro Registro de Conducir", tipo = TipoCampo.TEXTO),
        FormField("Clase del Registro de Conducir", tipo = TipoCampo.TEXTO),
        FormField("Relacion con el asegurado", tipo = TipoCampo.TEXTO),
    )

    fun onCampoChange(index: Int, newValue: String) {
        campos[index].value.value = newValue
        campos[index].error.value = null
    }

    fun crearSolicitudPoliza(): Solicitud? {
        validarCampos(campos)

        if (campos.all { it.error.value == null }) {
            Solicitud.conductorAsegurado.nombre = campos[0].value.value
            Solicitud.conductorAsegurado.apellido = campos[2].value.value
            Solicitud.conductorAsegurado.domicilio.calle = campos[3].value.value
            Solicitud.conductorAsegurado.domicilio.localidad = campos[4].value.value
            Solicitud.conductorAsegurado.domicilio.provincia = campos[5].value.value
            Solicitud.conductorAsegurado.domicilio.pais = campos[6].value.value
            Solicitud.conductorAsegurado.domicilio.codigoPostal = campos[7].value.value
            Solicitud.conductorAsegurado.cuit = campos[8].value.value
            Solicitud.conductorAsegurado.telefono = campos[9].value.value
            Solicitud.conductorAsegurado.sexo = campos[10].value.value
            Solicitud.conductorAsegurado.email = campos[11].value.value
            Solicitud.conductorAsegurado.nroRegistro = campos[12].value.value
            Solicitud.conductorAsegurado.claseRegistro = campos[13].value.value
            Solicitud.conductorAsegurado.relacionAsegurado = campos[14].value.value

        }else{
            return null
        }

        return Solicitud
    }

    companion object{
        fun provideFactory(getServicePolizas: GetServicePolizas): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return F5ViewModel(getServicePolizas) as T
            }
        }
    }
}