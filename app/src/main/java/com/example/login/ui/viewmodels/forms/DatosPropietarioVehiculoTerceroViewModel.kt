package com.example.login.ui.viewmodels.forms

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.login.data.models.fields.FormField
import com.example.login.data.models.fields.TipoCampo
import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.network.services.GetServicePolizas
import com.example.login.utilities.ValidacionesCampos.validarCampos
import com.example.login.utilities.validarFecha

class DatosPropietarioVehiculoTerceroViewModel (
    getServicePolizas: GetServicePolizas
) : ViewModel() {

    var Solicitud = Solicitud()

    var fechaDeVencimiento = mutableStateOf<String?>(null)
    var errorFechaVencimiento = mutableStateOf<String?>(null)

    val campos = listOf(
        FormField("Nombre", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Apellido", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Domicilio", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Localidad", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Codigo Postal", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Provincia", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Pais", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("CUIT", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Email", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Telefono", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Marca", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Modelo", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Color de auto", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Año del auto", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Dominio", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Aseguradora", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Poliza", mutableStateOf(""), tipo = TipoCampo.TEXTO),
    )


    fun onCampoChange(index: Int, newValue: String) {
        campos[index].value.value = newValue
        campos[index].error.value = null
    }


    fun setFechaDeVencimiento(newValue: String) {
        fechaDeVencimiento.value = newValue
        errorFechaVencimiento.value = null
    }

    fun crearSolicitudPoliza(): Solicitud? {
        validarCampos(campos)
        validarFecha(fechaDeVencimiento, errorFechaVencimiento, "Debes completar la fecha de vencimiento")

        if(campos.all { it.error.value == null }){
            Solicitud.propietarioAfectado.nombre = campos[0].value.value
            Solicitud.propietarioAfectado.apellido = campos[1].value.value
            Solicitud.propietarioAfectado.domicilio.calle = campos[2].value.value
            Solicitud.propietarioAfectado.domicilio.localidad = campos[3].value.value
            Solicitud.propietarioAfectado.domicilio.codigoPostal = campos[4].value.value
            Solicitud.propietarioAfectado.domicilio.provincia = campos[5].value.value
            Solicitud.propietarioAfectado.domicilio.pais = campos[6].value.value
            Solicitud.propietarioAfectado.cuit = campos[7].value.value
            Solicitud.propietarioAfectado.email = campos[8].value.value
            Solicitud.propietarioAfectado.telefono = campos[9].value.value
            Solicitud.propietarioAfectado.vehiculo.marca = campos[10].value.value
            Solicitud.propietarioAfectado.vehiculo.modelo = campos[11].value.value
            Solicitud.propietarioAfectado.vehiculo.color = campos[12].value.value
            Solicitud.propietarioAfectado.vehiculo.anio = campos[13].value.value
            Solicitud.propietarioAfectado.vehiculo.dominio = campos[14].value.value
            Solicitud.propietarioAfectado.vehiculo.aseguradora = campos[15].value.value
            Solicitud.propietarioAfectado.vehiculo.poliza = campos[16].value.value

            Solicitud.propietarioAfectado.vehiculo.fechaVencimiento = fechaDeVencimiento.value!!
        }else{
        return null
    }

    return Solicitud

    }


    companion object{
        fun provideFactory(getServicePolizas: GetServicePolizas): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return DatosPropietarioVehiculoTerceroViewModel(getServicePolizas) as T
            }
        }
    }
}