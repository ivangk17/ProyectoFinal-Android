package com.example.login.ui.viewmodels.forms

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.login.data.models.fields.FormField
import com.example.login.data.models.fields.TipoCampo
import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.network.GetServicePolizas
import com.example.login.utilities.ValidacionesCampos.validarCampos
import com.example.login.utilities.validarFecha

class ConductorVehiculoAseguradoViewModel (
    getServicePolizas: GetServicePolizas
) : ViewModel() {

    var solicitud = Solicitud()
    var fechaNacimiento = mutableStateOf<String?>(null)
    var errorFechaNacimiento = mutableStateOf<String?>(null)

    var fechaExpedicion = mutableStateOf<String?>(null)
    var errorFechaExpedicion = mutableStateOf<String?>(null)

    var fechaDeVencimiento = mutableStateOf<String?>(null)
    var errorFechaVencimiento = mutableStateOf<String?>(null)



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

    fun setFechaNacimiento(newValue: String) {
        fechaNacimiento.value = newValue
        errorFechaNacimiento.value = null
    }

    fun setFechaExpedicion(newValue: String) {
        fechaExpedicion.value = newValue
        errorFechaExpedicion.value = null
    }

    fun setFechaDeVencimiento(newValue: String) {
        fechaDeVencimiento.value = newValue
        errorFechaVencimiento.value = null
    }




    fun crearSolicitudPoliza(): Solicitud? {
        validarCampos(campos)

        validarFecha(fechaNacimiento, errorFechaNacimiento, "Debes completar la fecha de nacimiento")
        validarFecha(fechaExpedicion, errorFechaExpedicion, "Debes completar la fecha de expedicion")
        validarFecha(fechaDeVencimiento, errorFechaVencimiento, "Debes completar la fecha de vencimiento")

        if (campos.all { it.error.value == null }) {
            solicitud.conductorAsegurado.nombre = campos[0].value.value
            solicitud.conductorAsegurado.apellido = campos[1].value.value
            solicitud.conductorAsegurado.domicilio.calle = campos[2].value.value
            solicitud.conductorAsegurado.domicilio.localidad = campos[3].value.value
            solicitud.conductorAsegurado.domicilio.codigoPostal = campos[6].value.value
            solicitud.conductorAsegurado.domicilio.provincia = campos[4].value.value
            solicitud.conductorAsegurado.domicilio.pais = campos[5].value.value
            solicitud.conductorAsegurado.cuit = campos[7].value.value
            solicitud.conductorAsegurado.telefono = campos[8].value.value
            solicitud.conductorAsegurado.sexo = campos[9].value.value
            solicitud.conductorAsegurado.email = campos[10].value.value
            solicitud.conductorAsegurado.nroRegistro = campos[11].value.value
            solicitud.conductorAsegurado.claseRegistro = campos[12].value.value
            solicitud.conductorAsegurado.relacionAsegurado = campos[13].value.value

            solicitud.conductorAsegurado.fechaDeNacimiento = fechaNacimiento.value!!
            solicitud.conductorAsegurado.fechaVencimiento = fechaDeVencimiento.value!!
            solicitud.conductorAsegurado.fechaExpedicion = fechaExpedicion.value!!


        }
        else{
            return null
        }

        return solicitud
    }

    companion object{
        fun provideFactory(getServicePolizas: GetServicePolizas): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ConductorVehiculoAseguradoViewModel(getServicePolizas) as T
            }
        }
    }
}