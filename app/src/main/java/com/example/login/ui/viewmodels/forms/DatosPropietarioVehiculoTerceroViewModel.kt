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
        FormField("Nombre: ", tipo = TipoCampo.TEXTO),
        FormField("Apellido", tipo = TipoCampo.TEXTO),
        FormField("Calle", tipo = TipoCampo.TEXTO),
        FormField("Numero", tipo = TipoCampo.NUMERICO),
        FormField("Piso", tipo = TipoCampo.NUMERICO),
        FormField("Departamento", tipo = TipoCampo.TEXTO),
        FormField("Codigo Postal", tipo = TipoCampo.TEXTO),
        FormField("CUIT", tipo = TipoCampo.NUMERICO),
        FormField("Email", tipo = TipoCampo.TEXTO),
        FormField("Telefono", tipo = TipoCampo.NUMERICO),


        FormField("Marca", tipo = TipoCampo.TEXTO),
        FormField("Modelo", tipo = TipoCampo.TEXTO),
        FormField("Color de auto", tipo = TipoCampo.TEXTO),
        FormField("Año del auto", tipo = TipoCampo.NUMERICO),
        FormField("Dominio", tipo = TipoCampo.TEXTO),
        FormField("Aseguradora", tipo = TipoCampo.TEXTO),
        FormField("Poliza", tipo = TipoCampo.TEXTO),
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
//            solicitud.propietarioAfectado.datosPersona.domicilio.numero = campos[3].value.value.toInt()
//            solicitud.propietarioAfectado.datosPersona.domicilio.piso = campos[4].value.value.toInt()
//            solicitud.propietarioAfectado.datosPersona.domicilio.departamento = campos[5].value.value
//            solicitud.propietarioAfectado.datosPersona.domicilio.codigoPostal = campos[6].value.value.toInt()
//            solicitud.propietarioAfectado.datosPersona.cuit = campos[7].value.value.toInt()
//            solicitud.propietarioAfectado.datosPersona.email = campos[8].value.value
//            solicitud.propietarioAfectado.datosPersona.telefono = campos[9].value.value
//            solicitud.propietarioAfectado.datosPersona.sexo = sexoSeleccionado.value
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
            solicitud.propietarioAfectado.datosPersona.domicilio.numero = 1020
            solicitud.propietarioAfectado.datosPersona.domicilio.piso = null
            solicitud.propietarioAfectado.datosPersona.domicilio.departamento = null
            solicitud.propietarioAfectado.datosPersona.domicilio.codigoPostal = 7300;
            solicitud.propietarioAfectado.datosPersona.cuit = 20987642848;
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