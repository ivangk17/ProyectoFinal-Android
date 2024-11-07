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

class ConductorVehiculoTerceroViewModel (
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
        FormField("Nombre: ", tipo = TipoCampo.TEXTO),
        FormField("Apellido", tipo = TipoCampo.TEXTO),
        FormField("Calle", tipo = TipoCampo.TEXTO),
        FormField("Numero", tipo = TipoCampo.NUMERICO),
        FormField("Piso", tipo = TipoCampo.NUMERICO),
        FormField("Departamento", tipo = TipoCampo.TEXTO),
        FormField("Codigo Postal", tipo = TipoCampo.TEXTO),
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
//            solicitud.conductorAfectado.datosPersona.nombre = campos[0].value.value
//            solicitud.conductorAfectado.datosPersona.apellido = campos[1].value.value
//            solicitud.conductorAfectado.datosPersona.domicilio.calle = campos[2].value.value
//            solicitud.conductorAfectado.datosPersona.domicilio.numero = campos[3].value.value.toInt()
//            solicitud.conductorAfectado.datosPersona.domicilio.piso = if (campos[4].value.value.isEmpty()) null else campos[4].value.value.toInt()
//            solicitud.conductorAfectado.datosPersona.domicilio.departamento = campos[5].value.value
//            solicitud.conductorAfectado.datosPersona.domicilio.codigoPostal = campos[6].value.value.toInt()
//            solicitud.conductorAfectado.datosPersona.cuit = campos[7].value.value.toInt()
//            solicitud.conductorAfectado.datosPersona.telefono = campos[8].value.value
//            solicitud.conductorAfectado.datosPersona.sexo = sexoSeleccionado.value
//            solicitud.conductorAfectado.datosPersona.email = campos[9].value.value
//            solicitud.conductorAfectado.nroRegistro = campos[10].value.value
//            solicitud.conductorAfectado.claseRegistro = campos[11].value.value
//            solicitud.conductorAfectado.relacionAsegurado = campos[12].value.value
//
//            solicitud.conductorAfectado.datosPersona.fechaDeNacimiento = fechaNacimiento.value!!
//            solicitud.conductorAfectado.fechaRegistroExpedicion = fechaExpedicion.value!!
//            solicitud.conductorAfectado.fechaRegistroVencimiento = fechaDeVencimiento.value!!


            solicitud.conductorAfectado.datosPersona.nombre = "Nombre";
            solicitud.conductorAfectado.datosPersona.apellido = "Apellido";
            solicitud.conductorAfectado.datosPersona.domicilio.calle = "Calle";
            solicitud.conductorAfectado.datosPersona.domicilio.numero = 1020
            solicitud.conductorAfectado.datosPersona.domicilio.piso = null
            solicitud.conductorAfectado.datosPersona.domicilio.departamento = null
            solicitud.conductorAfectado.datosPersona.domicilio.codigoPostal = 7300;
            solicitud.conductorAfectado.datosPersona.cuit = 20987642848;
            solicitud.conductorAfectado.datosPersona.fechaDeNacimiento = "1990-10-10"; // Ejemplo de fecha exacta
            solicitud.conductorAfectado.datosPersona.telefono = "123456789";
            solicitud.conductorAfectado.datosPersona.sexo = Sexo.MUJER;
            solicitud.conductorAfectado.datosPersona.email = "email@example.com";
            solicitud.conductorAfectado.nroRegistro = "NroRegistro";
            solicitud.conductorAfectado.claseRegistro = "ClaseRegistro";
            solicitud.conductorAfectado.fechaRegistroExpedicion = "1990-10-10"; // Ejemplo de fecha exacta
            solicitud.conductorAfectado.fechaRegistroVencimiento = "1990-10-10" // Ejemplo de fecha exacta
            solicitud.conductorAfectado.relacionAsegurado = "RelacionAsegurado";
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
                return ConductorVehiculoTerceroViewModel(getServicePolizas) as T
            }
        }
    }
}