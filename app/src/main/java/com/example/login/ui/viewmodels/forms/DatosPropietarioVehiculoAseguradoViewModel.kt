package com.example.login.ui.viewmodels.forms

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.login.data.models.fields.FormField
import com.example.login.data.models.fields.TipoCampo
import com.example.login.data.models.personas.Sexo
import com.example.login.data.models.poliza.Poliza
import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.models.vehiculos.TipoVehiculo
import com.example.login.data.models.vehiculos.UsoDelVehiculo
import com.example.login.data.network.models.UserInfoResponse
import com.example.login.data.network.services.GetServicePolizas
import com.example.login.data.network.services.GetServiceUser
import com.example.login.utilities.ValidacionesCampos.validarCampos
import kotlinx.coroutines.launch


class DatosPropietarioVehiculoAseguradoViewModel (
    getServicePolizas: GetServicePolizas,
    private val getServiceUser: GetServiceUser
): ViewModel() {
    var Solicitud = Solicitud()
    var usoDelVehiculo = mutableStateOf(UsoDelVehiculo.PARTICULAR)
    var poliza = Poliza()
    var user = mutableStateOf(UserInfoResponse())
    var sexoSeleccionado =  mutableStateOf(Sexo.INDEFINIDO)

    fun loadInfoUser(polizaParametro: Poliza) {
        viewModelScope.launch {
            user.value = getServiceUser.execute()
            initializeFieldsWithPoliza(polizaParametro)
        }
    }


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
        FormField("Marca", tipo = TipoCampo.TEXTO),
        FormField("Modelo", tipo = TipoCampo.TEXTO),
        FormField("Color", tipo = TipoCampo.TEXTO),
        FormField("Año", tipo = TipoCampo.NUMERICO),
        FormField("Dominio", tipo = TipoCampo.TEXTO),
    )
    fun onCampoChange(index: Int, newValue: String){
        campos[index].value.value = newValue
        campos[index].error.value = null
    }


    fun crearSolicitudPoliza(): Solicitud? {
        validarCampos(campos)
        if (campos.all { it.error.value == null }) { //similar a un foreach
            Solicitud.propietarioAsegurado.datosPersona.nombre = campos[0].value.value
            Solicitud.propietarioAsegurado.datosPersona.apellido = campos[1].value.value
            Solicitud.propietarioAsegurado.datosPersona.domicilio.calle = campos[2].value.value
            Solicitud.propietarioAsegurado.datosPersona.domicilio.localidad = campos[3].value.value
            Solicitud.propietarioAsegurado.datosPersona.domicilio.codigoPostal = campos[4].value.value.toInt()
            Solicitud.propietarioAsegurado.datosPersona.domicilio.provincia = campos[5].value.value
            Solicitud.propietarioAsegurado.datosPersona.domicilio.pais = campos[6].value.value
            Solicitud.propietarioAsegurado.datosPersona.cuit = campos[7].value.value.toInt()
            Solicitud.propietarioAsegurado.datosPersona.email = campos[8].value.value
            Solicitud.propietarioAsegurado.datosPersona.telefono = campos[9].value.value
            Solicitud.propietarioAsegurado.datosPersona.sexo = sexoSeleccionado.value
            Solicitud.propietarioAsegurado.datosPersona.fechaDeNacimiento = user.value.fechaDeNacimiento
            Solicitud.propietarioAsegurado.vehiculo.datosVehiculo.tipoVehiculo = poliza.vehiculo.tipoVehiculo
            Solicitud.propietarioAsegurado.vehiculo.datosVehiculo.marca = campos[10].value.value
            Solicitud.propietarioAsegurado.vehiculo.datosVehiculo.modelo = campos[11].value.value
            Solicitud.propietarioAsegurado.vehiculo.datosVehiculo.color = campos[12].value.value
            Solicitud.propietarioAsegurado.vehiculo.datosVehiculo.anio = campos[13].value.value.toInt()
            Solicitud.propietarioAsegurado.vehiculo.datosVehiculo.dominio = campos[14].value.value
            Solicitud.propietarioAsegurado.vehiculo.usoDelVehiculo = usoDelVehiculo.value

            val tipo = poliza.vehiculo.tipoVehiculo.name
            if(tipo== "AUTO"){
                Solicitud.propietarioAsegurado.vehiculo.datosVehiculo.tipoVehiculo = TipoVehiculo.AUTO
            }else if ( tipo == "MOTO"){
                Solicitud.propietarioAsegurado.vehiculo.datosVehiculo.tipoVehiculo = TipoVehiculo.MOTO
            }
            Solicitud.propietarioAsegurado.vehiculo.datosVehiculo.tipoVehiculo = TipoVehiculo.CAMION

        }else{
            return null
        }
        return Solicitud
    }

    fun initializeFieldsWithPoliza(poliza: Poliza) {
        campos[0].value.value = user.value.nombre
        campos[1].value.value = user.value.apellido
        campos[2].value.value = user.value.domicilio.calle
        campos[3].value.value = user.value.domicilio.localidad
        campos[4].value.value = user.value.domicilio.codigoPostal.toString()
        campos[5].value.value = user.value.domicilio.provincia
        campos[6].value.value = user.value.domicilio.pais
        campos[7].value.value = user.value.cuit.toString()
        campos[8].value.value = user.value.email
        campos[9].value.value = user.value.telefono.toString()
        campos[10].value.value = poliza.vehiculo.marca
        campos[11].value.value = poliza.vehiculo.modelo
        campos[12].value.value = poliza.vehiculo.color
        campos[13].value.value = poliza.vehiculo.anio.toString()
        campos[14].value.value = poliza.vehiculo.dominio
        if(poliza.vehiculo.usoDelVehiculo.name == "PARTICULAR"){
            usoDelVehiculo.value = UsoDelVehiculo.PARTICULAR
        }else{
            usoDelVehiculo.value = UsoDelVehiculo.COMERCIAL
        }

        val sexo = user.value.sexo

        if (sexo == "HOMBRE"){
            sexoSeleccionado.value = Sexo.HOMBRE
        }else {
            sexoSeleccionado.value = Sexo.MUJER
        }

    }

    companion object{
        fun provideFactory(getServicePolizas: GetServicePolizas, getServiceUser: GetServiceUser): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return DatosPropietarioVehiculoAseguradoViewModel(getServicePolizas, getServiceUser) as T
            }
        }
    }
}