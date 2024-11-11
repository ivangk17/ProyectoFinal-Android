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
import com.example.login.data.network.services.GetServicePolizas
import com.example.login.utilities.ValidacionesCampos.validarCampos
import com.example.login.utilities.validarCampoMutable

class DaniosPersonalesViewModel(
    getServicePolizas: GetServicePolizas
):ViewModel() {
    var solicitud = Solicitud()

    var fechaNacimiento = mutableStateOf<String?>(null)
    var errorFechaNacimiento = mutableStateOf<String?>(null)

    var sexoLesionado =  mutableStateOf(Sexo.INDEFINIDO)

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
        FormField("Estado Civil", tipo = TipoCampo.TEXTO),
        FormField("Telefono Alternativo", tipo = TipoCampo.NUMERICO),
    )

    val camposCheckeables = listOf(
        CheckField("Peatón/Ciclista"),
        CheckField("Conductor vehículo del tercero"),
        CheckField("Ocupante vehículo del tercero"),
        CheckField("Conductor vehiculo asegurado"),
        CheckField("Asegurado"),
        CheckField("Conductor"),
        CheckField("Propietario vehiculo asegurado"),
        CheckField("Relacion con el propietario"),
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
//        validarCampos(campos)
//        validarCampoMutable(fechaNacimiento, errorFechaNacimiento, "Debes completar la fecha de nacimiento")

        if (campos.all { it.error.value == null }) {
//            solicitud.lesiones.lesionado.datosPersona.nombre = campos[0].value.value
//            solicitud.lesiones.lesionado.datosPersona.apellido = campos[1].value.value
//            solicitud.lesiones.lesionado.datosPersona.domicilio.calle = campos[2].value.value
//            solicitud.lesiones.lesionado.datosPersona.domicilio.numero = campos[3].value.value.toInt()
//            solicitud.lesiones.lesionado.datosPersona.domicilio.piso = if (campos[4].value.value.isEmpty()) null else campos[4].value.value.toInt()
//            solicitud.lesiones.lesionado.datosPersona.domicilio.departamento = campos[5].value.value
//            solicitud.lesiones.lesionado.datosPersona.domicilio.codigoPostal = campos[6].value.value.toInt()
            solicitud.lesiones.lesionado.datosPersona.dni = campos[7].value.value.toInt()
//            solicitud.lesiones.lesionado.datosPersona.email = campos[8].value.value
//            solicitud.lesiones.lesionado.datosPersona.telefono = campos[9].value.value
//            solicitud.lesiones.lesionado.datosPersona.sexo = sexoLesionado.value
//            solicitud.lesiones.lesionado.estadoCivil = campos[10].value.value
//            solicitud.lesiones.lesionado.telefonoAlternativo = campos[11].value.value
//
//            solicitud.lesiones.lesionado.datosPersona.fechaDeNacimiento = fechaNacimiento.value!!

            solicitud.lesiones.lesionado.datosPersona.nombre = "Nombre";
            solicitud.lesiones.lesionado.datosPersona.apellido = "Apellido";
            solicitud.lesiones.lesionado.datosPersona.domicilio.calle = "Calle";
            solicitud.lesiones.lesionado.datosPersona.domicilio.numero = 1020
            solicitud.lesiones.lesionado.datosPersona.domicilio.piso = null
            solicitud.lesiones.lesionado.datosPersona.domicilio.departamento = null
            solicitud.lesiones.lesionado.datosPersona.domicilio.codigoPostal = 7300;
//            solicitud.lesiones.lesionado.datosPersona.dni = 98764284;
            solicitud.lesiones.lesionado.datosPersona.email = "email@example.com";
            solicitud.lesiones.lesionado.datosPersona.telefono = "123456789";
            solicitud.lesiones.lesionado.datosPersona.sexo = Sexo.MUJER;
            solicitud.lesiones.lesionado.estadoCivil = "Estado Civil";
            solicitud.lesiones.lesionado.telefonoAlternativo = "987654321";

            solicitud.lesiones.lesionado.datosPersona.fechaDeNacimiento = "1990-10-10"; // Ejemplo de fecha exacta

            solicitud.lesiones.peatonOCiclista =true
            solicitud.lesiones.conductorTercero =true
            solicitud.lesiones.ocupanteTercero =true
            solicitud.lesiones.conductorAsegurado =true
            solicitud.lesiones.asegurado =true
            solicitud.lesiones.conductor =true
            solicitud.lesiones.propietarioVehiculoAsegurado =true
            solicitud.lesiones.relacionConPropietario =true

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
        solicitud.lesiones.conductorAsegurado = camposCheckeables[3].value.value
        solicitud.lesiones.asegurado = camposCheckeables[4].value.value
        solicitud.lesiones.conductor = camposCheckeables[5].value.value
        solicitud.lesiones.propietarioVehiculoAsegurado = camposCheckeables[6].value.value
        solicitud.lesiones.relacionConPropietario = camposCheckeables[7].value.value
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