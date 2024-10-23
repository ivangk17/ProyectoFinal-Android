package com.example.login.ui.viewmodels.forms

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.login.data.models.fields.CheckField
import com.example.login.data.models.fields.FormField
import com.example.login.data.models.fields.TipoCampo
import com.example.login.data.models.personas.Sexo
import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.network.GetServicePolizas
import com.example.login.utilities.ValidacionesCampos.validarCampos
import com.example.login.utilities.validarFecha

class DaniosPersonalesViewModel(
    getServicePolizas: GetServicePolizas
):ViewModel() {
    var solicitud = Solicitud()

    var fechaNacimiento = mutableStateOf<String?>(null)
    var errorFechaNacimiento = mutableStateOf<String?>(null)

    var sexoLesionado =  mutableStateOf(Sexo.INDEFINIDO)

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
        FormField("Sexo", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Estado Civil", mutableStateOf(""), tipo = TipoCampo.TEXTO),
        FormField("Telefono Alternativo", mutableStateOf(""), tipo = TipoCampo.TEXTO),
    )

    val camposCheckeables = listOf(
        CheckField("Peatón/Ciclista"),
        CheckField("Conductor vehículo del tercero"),
        CheckField("Ocupante vehículo del tercero"),
        CheckField("Ocupante vehículo asegurado"),
        CheckField("Asegurado"),
        CheckField("Conductor"),
        CheckField("Relacion con propietario"),
    )

    fun onCampoChange(index: Int, newValue: String) {
        campos[index].value.value = newValue
        campos[index].error.value = null
    }

    fun onFechaChange(newValue: String) {
        fechaNacimiento.value = newValue
        errorFechaNacimiento.value = null
    }

    fun onSwitchChange(index: Int, newState: Boolean) {
        Log.d("switch", "CAMBIO")
        camposCheckeables[index].value.value = newState
    }

    fun crearSolicitud(): Solicitud?{
        validarCampos(campos)
        validarFecha(fechaNacimiento, errorFechaNacimiento, "Debes completar la fecha de nacimiento")

        if (campos.all { it.error.value == null }) {
            solicitud.lesiones.lesionado.nombre = campos[0].value.value
            solicitud.lesiones.lesionado.apellido = campos[1].value.value
            solicitud.lesiones.lesionado.domicilio.calle = campos[2].value.value
            solicitud.lesiones.lesionado.domicilio.localidad = campos[3].value.value
            solicitud.lesiones.lesionado.domicilio.codigoPostal = campos[4].value.value
            solicitud.lesiones.lesionado.domicilio.provincia = campos[5].value.value
            solicitud.lesiones.lesionado.domicilio.pais = campos[6].value.value
            solicitud.lesiones.lesionado.cuit = campos[7].value.value
            solicitud.lesiones.lesionado.email = campos[8].value.value
            solicitud.lesiones.lesionado.telefono = campos[9].value.value
            solicitud.lesiones.lesionado.sexo = campos[10].value.value
            solicitud.lesiones.lesionado.estadoCivil = campos[11].value.value
            solicitud.lesiones.lesionado.telefonoAlternativo = campos[12].value.value

            solicitud.lesiones.lesionado.fechaDeNacimiento = fechaNacimiento.value!!

            cargarCheckeables()
        }else{
            return null
        }

        return solicitud
    }

    private fun cargarCheckeables() {
        solicitud.lesiones.peatonOCiclista = camposCheckeables[0].value.value
        solicitud.lesiones.conductorTercero = camposCheckeables[1].value.value
        solicitud.lesiones.ocupanteTercero = camposCheckeables[2].value.value
        solicitud.lesiones.ocupanteAsgurado = camposCheckeables[3].value.value
        solicitud.lesiones.asegurado = camposCheckeables[4].value.value
        solicitud.lesiones.conductorAsegurado = camposCheckeables[5].value.value
        solicitud.lesiones.relacionConPropietario = camposCheckeables[6].value.value
    }

    companion object{
        fun provideFactory(getServicePolizas: GetServicePolizas): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return DaniosPersonalesViewModel(getServicePolizas) as T
            }
        }
    }
}