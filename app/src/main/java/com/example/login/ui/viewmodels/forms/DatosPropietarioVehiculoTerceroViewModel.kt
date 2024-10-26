package com.example.login.ui.viewmodels.forms

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.login.data.models.fields.FormField
import com.example.login.data.models.fields.TipoCampo
import com.example.login.data.models.personas.Sexo
import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.models.vehiculos.TipoVehiculo
import com.example.login.data.network.services.GetServicePolizas
import com.example.login.utilities.ValidacionesCampos.validarCampos
import com.example.login.utilities.validarCampoMutable
import com.example.login.utilities.validarMail

class DatosPropietarioVehiculoTerceroViewModel (
    getServicePolizas: GetServicePolizas
) : ViewModel() {

    var solicitud = Solicitud()

    var sexoSeleccionado =  mutableStateOf(Sexo.INDEFINIDO)

    var fechaNacimiento = mutableStateOf<String?>(null)
    var errorFechaNacimiento = mutableStateOf<String?>(null)

    var tipoVehiculo = mutableStateOf(TipoVehiculo.AUTO)

    var fechaDeVencimiento = mutableStateOf<String?>(null)
    var errorFechaVencimiento = mutableStateOf<String?>(null)

    val campos = listOf(
        FormField("Nombre", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Apellido", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Domicilio", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Localidad", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Codigo Postal", mutableStateOf(""), tipo = TipoCampo.NUMERICO),
        FormField("Provincia", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Pais", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("CUIT", mutableStateOf(""), tipo = TipoCampo.NUMERICO),
        FormField("Email", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Telefono", mutableStateOf(""), tipo = TipoCampo.NUMERICO),


        FormField("Marca", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Modelo", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Color de auto", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Año del auto", mutableStateOf(""), tipo = TipoCampo.NUMERICO),
        FormField("Dominio", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Aseguradora", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Poliza", mutableStateOf(""), tipo = TipoCampo.TEXTO),
    )


    fun onCampoChange(index: Int, newValue: String) {
        campos[index].value.value = newValue
        campos[index].error.value = null
    }

    fun setFechaNacimiento(newValue: String) {
        fechaNacimiento.value = newValue
        errorFechaNacimiento.value = null
    }

    fun setFechaDeVencimiento(newValue: String) {
        fechaDeVencimiento.value = newValue
        errorFechaVencimiento.value = null
    }



    fun crearSolicitudPoliza(): Solicitud? {
//        validarCampos(campos)
//        validarMail(campos[8])
//        validarCampoMutable(fechaDeVencimiento, errorFechaVencimiento, "Debes completar la fecha de vencimiento")
//        validarCampoMutable(fechaNacimiento, errorFechaNacimiento, "Debes completar la fecha de vencimiento")

        if(campos.all { it.error.value == null }){
//            solicitud.propietarioAfectado.datosPersona.nombre = campos[0].value.value
//            solicitud.propietarioAfectado.datosPersona.apellido = campos[1].value.value
//            solicitud.propietarioAfectado.datosPersona.domicilio.calle = campos[2].value.value
//            solicitud.propietarioAfectado.datosPersona.domicilio.localidad = campos[3].value.value
//            solicitud.propietarioAfectado.datosPersona.domicilio.codigoPostal = campos[4].value.value.toInt()
//            solicitud.propietarioAfectado.datosPersona.domicilio.provincia = campos[5].value.value
//            solicitud.propietarioAfectado.datosPersona.domicilio.pais = campos[6].value.value
//            solicitud.propietarioAfectado.datosPersona.cuit = campos[7].value.value.toInt()
//            solicitud.propietarioAfectado.datosPersona.email = campos[8].value.value
//            solicitud.propietarioAfectado.datosPersona.telefono = campos[9].value.value
//            solicitud.propietarioAsegurado.datosPersona.sexo = sexoSeleccionado.value
//            solicitud.propietarioAfectado.datosPersona.fechaDeNacimiento = fechaNacimiento.value!!
//            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo.tipoVehiculo = tipoVehiculo.value
//            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo.marca = campos[10].value.value
//            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo.modelo = campos[11].value.value
//            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo.color = campos[12].value.value
//            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo.anio = campos[13].value.value.toInt()
//            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo.dominio = campos[14].value.value
//            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.aseguradora = campos[15].value.value
//            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.poliza = campos[16].value.value
//            solicitud.propietarioAfectado.fechaVencimientoPoliza = fechaDeVencimiento.value!!




            solicitud.propietarioAfectado.datosPersona.nombre = "Nombre";
            solicitud.propietarioAfectado.datosPersona.apellido = "Apellido";
            solicitud.propietarioAfectado.datosPersona.domicilio.calle = "Calle";
            solicitud.propietarioAfectado.datosPersona.domicilio.localidad = "Localidad";
            solicitud.propietarioAfectado.datosPersona.domicilio.codigoPostal = 7300;
            solicitud.propietarioAfectado.datosPersona.domicilio.provincia = "Provincia";
            solicitud.propietarioAfectado.datosPersona.domicilio.pais = "Pais";
            solicitud.propietarioAfectado.datosPersona.cuit = 209876428428;
            solicitud.propietarioAfectado.datosPersona.email = "email@example.com";
            solicitud.propietarioAfectado.datosPersona.telefono = "123456789";
            solicitud.propietarioAfectado.datosPersona.sexo = Sexo.MUJER
            solicitud.propietarioAfectado.datosPersona.fechaDeNacimiento = "1990-10-10"

            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo.tipoVehiculo = TipoVehiculo.CAMION
            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo.marca = "Marca";
            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo.modelo = "Modelo";
            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo.color = "Color";
            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo.anio = 2020; // Ejemplo de año
            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo.dominio = "Dominio";
            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.aseguradora = "Aseguradora";
            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.poliza = "Poliza";

            solicitud.propietarioAfectado.fechaVencimientoPoliza = "1990-10-10"; // Ejemplo de fecha exacta

        }else{
        return null
    }

    return solicitud

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