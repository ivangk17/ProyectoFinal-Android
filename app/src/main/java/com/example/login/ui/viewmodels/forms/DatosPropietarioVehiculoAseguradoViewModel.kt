package com.example.login.ui.viewmodels.forms

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.login.data.models.fields.FormField
import com.example.login.data.models.fields.TipoCampo
import com.example.login.data.models.poliza.Poliza
import com.example.login.data.models.solicitud.Solicitud
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

    fun loadInfoUser() {
        viewModelScope.launch {
            user.value = getServiceUser.execute()
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
        FormField("Marca y modelo", tipo = TipoCampo.TEXTO),
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
            Solicitud.conductorAsegurado.nombre = campos[0].value.value
            Solicitud.conductorAsegurado.apellido = campos[1].value.value
            Solicitud.conductorAsegurado.domicilio.calle = campos[2].value.value
            Solicitud.conductorAsegurado.domicilio.localidad = campos[3].value.value
            Solicitud.conductorAsegurado.domicilio.codigoPostal = campos[4].value.value
            Solicitud.conductorAsegurado.domicilio.provincia = campos[5].value.value
            Solicitud.conductorAsegurado.domicilio.pais = campos[6].value.value
            Solicitud.conductorAsegurado.cuit = campos[7].value.value
            Solicitud.conductorAsegurado.email = campos[8].value.value
            Solicitud.conductorAsegurado.telefono = campos[9].value.value
            //falta cargar datos del vehículo a la entidad conductor asegurado
            Solicitud.conductorAsegurado.vehiculo.marca = campos[10].value.value
            Solicitud.conductorAsegurado.vehiculo.modelo = campos[11].value.value
            Solicitud.conductorAsegurado.vehiculo.anio = campos[12].value.value
            Solicitud.conductorAsegurado.vehiculo.dominio = campos[13].value.value
            Solicitud.conductorAsegurado.vehiculo.usoDelVehiculo = usoDelVehiculo.value

        }else{
            return null
        }
        return Solicitud
    }

    fun initializeFieldsWithPoliza(poliza: Poliza) {
            Log.d("Email", user.value.email)
            campos[0].value.value = user.value.nombre
            campos[1].value.value = user.value.apellido
            campos[2].value.value = user.value.domicilio.calle
            campos[3].value.value = user.value.domicilio.localidad
            campos[4].value.value = user.value.domicilio.codigoPostal
            campos[5].value.value = user.value.domicilio.provincia
            campos[6].value.value = user.value.domicilio.pais
            campos[7].value.value = user.value.cuit
            campos[8].value.value = user.value.email
            campos[9].value.value = user.value.telefono

            campos[10].value.value = "${poliza.vehiculo.marca} ${poliza.vehiculo.modelo}"
            campos[11].value.value = poliza.vehiculo.color
            campos[12].value.value = poliza.vehiculo.anio
            campos[13].value.value = poliza.vehiculo.dominio
        if(poliza.vehiculo.usoDelVehiculo.name == "PARTICULAR"){
            usoDelVehiculo.value = UsoDelVehiculo.PARTICULAR
        }else{
            usoDelVehiculo.value = UsoDelVehiculo.COMERCIAL
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