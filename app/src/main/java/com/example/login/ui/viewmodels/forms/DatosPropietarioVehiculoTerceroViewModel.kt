package com.example.login.ui.viewmodels.forms

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.login.data.models.fields.FormField
import com.example.login.data.models.fields.TipoCampo
import com.example.login.data.models.personas.Sexo
import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.models.vehiculos.ColorVehiculo
import com.example.login.data.models.vehiculos.TipoVehiculo
import com.example.login.data.network.services.GetServicePolizas
import com.example.login.utilities.ValidacionesCampos.validarCampos
import com.example.login.utilities.validarCampoMutable
import com.example.login.utilities.validarFechaNacimiento

class DatosPropietarioVehiculoTerceroViewModel (
    getServicePolizas: GetServicePolizas
) : ViewModel() {

    var solicitud = Solicitud()

    var sexoSeleccionado =  mutableStateOf(Sexo.HOMBRE)
    var colorDelVehiculo = mutableStateOf(ColorVehiculo.BLANCO)

    var fechaNacimiento = mutableStateOf<String?>(null)
    var errorFechaNacimiento = mutableStateOf<String?>(null)

    var tipoVehiculo = mutableStateOf(TipoVehiculo.AUTO)

    var fechaDeVencimiento = mutableStateOf<String?>(null)
    var errorFechaVencimiento = mutableStateOf<String?>(null)


    val campos = listOf(
        FormField("Nombre", tipo = TipoCampo.TEXTO),
        FormField("Apellido", tipo = TipoCampo.TEXTO),
        FormField("Calle", tipo = TipoCampo.TEXTO),
        FormField("Numero", tipo = TipoCampo.NUMERICO),
        FormField("Piso", tipo = TipoCampo.NUMERICO),
        FormField("Departamento", tipo = TipoCampo.TEXTO),
        FormField("Codigo Postal", tipo = TipoCampo.CODIGO_POSTAL),
        FormField("DNI", tipo = TipoCampo.DNI),
        FormField("Email", tipo = TipoCampo.TEXTO),
        FormField("Telefono", tipo = TipoCampo.NUMERICO),


        FormField("Marca", tipo = TipoCampo.TEXTO),
        FormField("Modelo", tipo = TipoCampo.TEXTO),
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



    @RequiresApi(Build.VERSION_CODES.O)
    fun crearSolicitudPoliza(): Solicitud? {
        validarCampos(campos)
        validarCampoMutable(fechaDeVencimiento,errorFechaVencimiento,"Debes completar la fecha de vencimiento")
        validarFechaNacimiento(fechaNacimiento, errorFechaNacimiento)


        if(campos.all { it.error.value == null } && errorFechaNacimiento.value == null && errorFechaVencimiento.value == null){
            solicitud.propietarioAfectado.datosPersona.nombre = campos[0].value.value
            solicitud.propietarioAfectado.datosPersona.apellido = campos[1].value.value
            solicitud.propietarioAfectado.datosPersona.domicilio.calle = campos[2].value.value
            solicitud.propietarioAfectado.datosPersona.domicilio.numero = campos[3].value.value.toInt()
            solicitud.propietarioAfectado.datosPersona.domicilio.piso = if (campos[4].value.value.isEmpty()) null else campos[4].value.value.toInt()
            solicitud.propietarioAfectado.datosPersona.domicilio.departamento = campos[5].value.value
            solicitud.propietarioAfectado.datosPersona.domicilio.codigoPostal = campos[6].value.value.toInt()
            solicitud.propietarioAfectado.datosPersona.dni = campos[7].value.value.toInt()
            solicitud.propietarioAfectado.datosPersona.email = campos[8].value.value
            solicitud.propietarioAfectado.datosPersona.telefono = campos[9].value.value
            solicitud.propietarioAfectado.datosPersona.sexo = sexoSeleccionado.value
            solicitud.propietarioAfectado.datosPersona.fechaDeNacimiento = fechaNacimiento.value!!
            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo.tipoVehiculo = tipoVehiculo.value
            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo.marca = campos[10].value.value
            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo.modelo = campos[11].value.value
            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo.color = colorDelVehiculo.value
            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo.anio = campos[12].value.value.toInt()
            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo.dominio = campos[13].value.value
            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.aseguradora = campos[14].value.value
            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.poliza = campos[15].value.value
            solicitud.propietarioAfectado.fechaVencimientoPoliza = fechaDeVencimiento.value!!




//            solicitud.propietarioAfectado.datosPersona.nombre = "Nombre";
//            solicitud.propietarioAfectado.datosPersona.apellido = "Apellido";
//            solicitud.propietarioAfectado.datosPersona.domicilio.calle = "Calle";
//            solicitud.propietarioAfectado.datosPersona.domicilio.numero = 1020
//            solicitud.propietarioAfectado.datosPersona.domicilio.piso = null
//            solicitud.propietarioAfectado.datosPersona.domicilio.departamento = null
//            solicitud.propietarioAfectado.datosPersona.domicilio.codigoPostal = 7300;
//            solicitud.propietarioAfectado.datosPersona.dni = 98764284;
//            solicitud.propietarioAfectado.datosPersona.email = "email@example.com";
//            solicitud.propietarioAfectado.datosPersona.telefono = "123456789";
//            solicitud.propietarioAfectado.datosPersona.sexo = Sexo.MUJER
//            solicitud.propietarioAfectado.datosPersona.fechaDeNacimiento = "1990-10-10"
//
//            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo.tipoVehiculo = TipoVehiculo.CAMION
//            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo.marca = "Marca";
//            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo.modelo = "Modelo";
//            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo.color = ColorVehiculo.VERDE
//            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo.anio = 2020; // Ejemplo de año
//            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo.dominio = "Dominio";
//            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.aseguradora = "Aseguradora";
//            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.poliza = "Poliza";
//
//            solicitud.propietarioAfectado.fechaVencimientoPoliza = "1990-10-10"; // Ejemplo de fecha exacta

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