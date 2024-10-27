package com.example.login.ui.viewmodels.forms

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.login.data.models.fields.FormField
import com.example.login.data.models.fields.TipoCampo
import com.example.login.data.models.personas.Sexo
import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.network.services.GetServicePolizas
import com.example.login.utilities.ValidacionesCampos.validarCampos
import com.example.login.utilities.validarCampoMutable
import com.example.login.utilities.validarMail

class ConductorVehiculoAseguradoViewModel (
    getServicePolizas: GetServicePolizas
) : ViewModel() {

    var solicitud = Solicitud()

    var sexoSeleccionado =  mutableStateOf(Sexo.INDEFINIDO)

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
        FormField("Telefono", tipo = TipoCampo.NUMERICO),
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
//        validarCampos(campos)
//        validarMail(campos[9])
//        validarCampoMutable(fechaNacimiento, errorFechaNacimiento, "Debes completar la fecha de nacimiento")
//        validarCampoMutable(fechaExpedicion, errorFechaExpedicion, "Debes completar la fecha de expedicion")
//        validarCampoMutable(fechaDeVencimiento, errorFechaVencimiento, "Debes completar la fecha de vencimiento")

        if (campos.all { it.error.value == null }) {
//            solicitud.conductorAsegurado.datosPersona.nombre = campos[0].value.value
//            solicitud.conductorAsegurado.datosPersona.apellido = campos[1].value.value
//            solicitud.conductorAsegurado.datosPersona.domicilio.calle = campos[2].value.value
//            solicitud.conductorAsegurado.datosPersona.domicilio.localidad = campos[3].value.value
//            solicitud.conductorAsegurado.datosPersona.domicilio.codigoPostal = campos[4].value.value.toInt()
//            solicitud.conductorAsegurado.datosPersona.domicilio.provincia = campos[5].value.value
//            solicitud.conductorAsegurado.datosPersona.domicilio.pais = campos[6].value.value
//            solicitud.conductorAsegurado.datosPersona.cuit = campos[7].value.value.toInt()
//            solicitud.conductorAsegurado.datosPersona.telefono = campos[8].value.value
//            solicitud.conductorAsegurado.datosPersona.sexo = sexoSeleccionado.value
//            solicitud.conductorAsegurado.datosPersona.email = campos[9].value.value
//            solicitud.conductorAsegurado.nroRegistro = campos[10].value.value
//            solicitud.conductorAsegurado.claseRegistro = campos[11].value.value
//            solicitud.conductorAsegurado.relacionAsegurado = campos[12].value.value
//
//            solicitud.conductorAsegurado.datosPersona.fechaDeNacimiento = fechaNacimiento.value!!
//            solicitud.conductorAsegurado.fechaRegistroVencimiento = fechaDeVencimiento.value!!
//            solicitud.conductorAsegurado.fechaRegistroExpedicion = fechaExpedicion.value!!



            solicitud.conductorAsegurado.datosPersona.nombre = "Nombre";
            solicitud.conductorAsegurado.datosPersona.apellido = "Apellido";
            solicitud.conductorAsegurado.datosPersona.domicilio.calle = "Calle";
            solicitud.conductorAsegurado.datosPersona.domicilio.localidad = "Localidad";
            solicitud.conductorAsegurado.datosPersona.domicilio.codigoPostal = 7300;
            solicitud.conductorAsegurado.datosPersona.domicilio.provincia = "Provincia";
            solicitud.conductorAsegurado.datosPersona.domicilio.pais = "Pais";
            solicitud.conductorAsegurado.datosPersona.cuit = 209876428428;
            solicitud.conductorAsegurado.datosPersona.fechaDeNacimiento = "1990-10-10"; // Ejemplo de fecha exacta

            solicitud.conductorAsegurado.datosPersona.telefono = "123456789";
            solicitud.conductorAsegurado.datosPersona.sexo = Sexo.MUJER;
            solicitud.conductorAsegurado.datosPersona.email = "email@example.com";
            solicitud.conductorAsegurado.nroRegistro = "NroRegistro";
            solicitud.conductorAsegurado.claseRegistro = "ClaseRegistro";
            solicitud.conductorAsegurado.fechaRegistroExpedicion = "2020-10-10"; // Ejemplo de fecha exacta
            solicitud.conductorAsegurado.fechaRegistroVencimiento = "2025-10-10"; // Ejemplo de fecha exacta
            solicitud.conductorAsegurado.relacionAsegurado = "RelacionAsegurado";
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