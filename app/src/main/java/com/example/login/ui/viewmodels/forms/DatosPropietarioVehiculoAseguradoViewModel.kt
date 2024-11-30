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
import com.example.login.data.models.vehiculos.ColorVehiculo
import com.example.login.data.models.vehiculos.TipoVehiculo
import com.example.login.data.models.vehiculos.UsoDelVehiculo
import com.example.login.data.network.models.UserInfoResponse
import com.example.login.data.network.services.GetServicePolizas
import com.example.login.data.network.services.GetServiceUser
import com.example.login.utilities.ValidacionesCampos.validarCampos
import com.example.login.utilities.setTipoVehiculo
import com.example.login.utilities.setColor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DatosPropietarioVehiculoAseguradoViewModel @Inject constructor(
    private val getServiceUser: GetServiceUser
): ViewModel() {
    var Solicitud = Solicitud()
    var usoDelVehiculo = mutableStateOf(UsoDelVehiculo.PARTICULAR)
    var poliza = Poliza()
    var user = mutableStateOf(UserInfoResponse())
    var sexoSeleccionado =  mutableStateOf(Sexo.HOMBRE)
    var colorDelVehiculo = mutableStateOf(ColorVehiculo.Blanco)
    var tipoVehiculo = mutableStateOf(TipoVehiculo.AUTO)



    fun loadInfoUser(polizaParametro: Poliza) {
        viewModelScope.launch {
            user.value = getServiceUser.execute()
            initializeFieldsWithPoliza(polizaParametro)
        }
    }


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
        FormField("TEL", tipo = TipoCampo.TEXTO),
        FormField("Marca", tipo = TipoCampo.TEXTO),
        FormField("Modelo", tipo = TipoCampo.TEXTO),
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
            Solicitud.propietarioAsegurado.datosPersona.nombreCompleto = "${campos[0].value.value} ${campos[1].value.value}"
            Solicitud.propietarioAsegurado.datosPersona.domicilio.calle = campos[2].value.value
            Solicitud.propietarioAsegurado.datosPersona.domicilio.numero = campos[3].value.value.toInt()
            Solicitud.propietarioAsegurado.datosPersona.domicilio.piso = if (campos[4].value.value.isEmpty()) null else campos[4].value.value
            Solicitud.propietarioAsegurado.datosPersona.domicilio.departamento = campos[5].value.value
            Solicitud.propietarioAsegurado.datosPersona.domicilio.codigoPostal = campos[6].value.value.toInt()
            Solicitud.propietarioAsegurado.datosPersona.dni = campos[7].value.value.toInt()
            Solicitud.propietarioAsegurado.datosPersona.email = campos[8].value.value
            Solicitud.propietarioAsegurado.datosPersona.telefono = campos[9].value.value
            Solicitud.propietarioAsegurado.datosPersona.sexo = sexoSeleccionado.value
            Solicitud.propietarioAsegurado.datosPersona.fechaDeNacimiento = user.value.fechaDeNacimiento
            Solicitud.propietarioAsegurado.vehiculo.datosVehiculo.marca = campos[10].value.value
            Solicitud.propietarioAsegurado.vehiculo.datosVehiculo.modelo = campos[11].value.value

            Solicitud.propietarioAsegurado.vehiculo.datosVehiculo.anio = campos[12].value.value.toInt()
            Solicitud.propietarioAsegurado.vehiculo.datosVehiculo.dominio = campos[13].value.value
            Solicitud.propietarioAsegurado.vehiculo.usoDelVehiculo = usoDelVehiculo.value

            Solicitud.propietarioAsegurado.vehiculo.datosVehiculo.color = colorDelVehiculo.value
            Solicitud.propietarioAsegurado.vehiculo.datosVehiculo.tipoVehiculo = tipoVehiculo.value



        }else{
            return null
        }
        return Solicitud
    }

    fun initializeFieldsWithPoliza(poliza: Poliza) {
        campos[0].value.value = user.value.nombre
        campos[1].value.value = user.value.apellido
        campos[2].value.value = user.value.domicilio.calle
        campos[3].value.value = user.value.domicilio.numero.toString()

        if(user.value.domicilio.piso == null){
            campos[4].value.value = ""
        }else{
            campos[4].value.value = user.value.domicilio.piso.toString()
        }
        if (user.value.domicilio.departamento == null){
            campos[5].value.value = ""
        }else{
            campos[5].value.value = user.value.domicilio.departamento.toString()
        }
        campos[6].value.value = user.value.domicilio.codigoPostal.toString()
        campos[7].value.value = user.value.dni.toString()
        campos[8].value.value = user.value.email
        campos[9].value.value = user.value.telefono.toString()
        campos[10].value.value = poliza.vehiculo.marca
        campos[11].value.value = poliza.vehiculo.modelo
        colorDelVehiculo = setColor(poliza.vehiculo.color)
        tipoVehiculo = setTipoVehiculo(poliza.vehiculo.tipoVehiculo)
        campos[12].value.value = poliza.vehiculo.anio.toString()
        campos[13].value.value = poliza.vehiculo.dominio
        Solicitud.idAsegurado = poliza.asegurado
        Solicitud.idAsegurador = poliza.asegurador
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


}