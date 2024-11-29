package com.example.login.ui.viewmodels

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.login.data.models.personas.Sexo
import com.example.login.data.models.personas.user.TipoConductor
import com.example.login.data.models.solicitud.Solicitud
import com.example.login.data.network.services.CrearSolicitudService
import com.example.login.navigation.Rutas
import com.example.login.ui.formstate.ConductorFormState
import com.example.login.utilities.ValidacionesCampos.validarCampos
import com.example.login.utilities.validarCampoMutable
import com.example.login.utilities.validarFechaActual
import com.example.login.utilities.validarFechaNacimiento
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CrearSolicitudViewModel @Inject constructor(
    private val crearSolicitudService: CrearSolicitudService
) : ViewModel() {
    var solicitud = Solicitud()
    private var _solicitud = Solicitud()
   // private val _estadoEnvio = MutableStateFlow<EstadoEnvio>(EstadoEnvio.Idle)
   // val estadoEnvio: StateFlow<EstadoEnvio> = _estadoEnvio

    var conductorAseguradoFormState = ConductorFormState()
    var conductorTerceroFormState = ConductorFormState()

    //ConductorVehiculo (asegurado y tercero)
    fun onCampoChange(formState: ConductorFormState ,index: Int, newValue: String) {
        formState.campos[index].value.value = newValue
        formState.campos[index].error.value = null
    }

    fun setFechaNacimiento(formState: ConductorFormState, newValue: String) {
        formState.fechaNacimiento.value = newValue
        formState.errorFechaNacimiento.value = null
    }

    fun setFechaExpedicion(formState: ConductorFormState, newValue: String) {
        formState.fechaExpedicion.value = newValue
        formState.errorFechaExpedicion.value = null
    }

    fun setFechaDeVencimiento(formState: ConductorFormState,newValue: String) {
        formState.fechaDeVencimiento.value = newValue
        formState.errorFechaVencimiento.value = null
    }

    fun setSexoSeleccionado(formState: ConductorFormState,nuevoSexo: Sexo) {
        formState.sexoSeleccionado.value = nuevoSexo
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun crearSolicitudPoliza(formState: ConductorFormState, tipoConductor: TipoConductor): Solicitud? {
        validarCampos(formState.campos)
        validarFechaNacimiento(
            formState.fechaNacimiento,
            formState.errorFechaNacimiento
        )
        validarFechaActual(
            formState.fechaExpedicion,
            formState.errorFechaExpedicion
        )
        validarCampoMutable(
            formState.fechaDeVencimiento,
            formState.errorFechaVencimiento,
            "Falta completar la fecha de vencimiento"
        )

        if (formState.campos.all { it.error.value == null } && formState.errorFechaNacimiento.value == null && formState.errorFechaVencimiento.value == null && formState.errorFechaExpedicion.value == null) {


            val conductor = when (tipoConductor) {
                TipoConductor.ASEGURADO -> solicitud.conductorAsegurado
                TipoConductor.TERCERO -> solicitud.conductorAfectado
            }

            conductor.apply {


                conductor.datosPersona.nombre =
                    formState.campos[0].value.value
                conductor.datosPersona.apellido =
                    formState.campos[1].value.value
                conductor.datosPersona.nombreCompleto =
                    "${formState.campos[0].value.value} ${formState.campos[1].value.value}"
                conductor.datosPersona.domicilio.calle =
                    formState.campos[2].value.value
                conductor.datosPersona.domicilio.numero =
                    formState.campos[3].value.value.toInt()
                conductor.datosPersona.domicilio.piso =
                    if (formState.campos[4].value.value.isEmpty()) null else formState.campos[4].value.value
                conductor.datosPersona.domicilio.departamento =
                    formState.campos[5].value.value
                conductor.datosPersona.domicilio.codigoPostal =
                    formState.campos[6].value.value.toInt()
                conductor.datosPersona.dni =
                    formState.campos[7].value.value.toInt()
                conductor.datosPersona.telefono =
                    formState.campos[8].value.value
                conductor.datosPersona.sexo =
                    formState.sexoSeleccionado.value
                conductor.datosPersona.email =
                    formState.campos[9].value.value
                conductor.nroRegistro = formState.campos[10].value.value
                conductor.claseRegistro = formState.campos[11].value.value
                conductor.relacionAsegurado =
                    formState.campos[12].value.value

                conductor.datosPersona.fechaDeNacimiento =
                    formState.fechaNacimiento.value!!
                conductor.fechaRegistroVencimiento =
                    formState.fechaDeVencimiento.value!!
                conductor.fechaRegistroExpedicion =
                    formState.fechaExpedicion.value!!


            }

        } else {
            return null
        }

        return solicitud
    }


    fun envioDatosSiniestros(solicitud: Solicitud) {
        _solicitud.datosSiniestro.fechaOcurrencia = solicitud.datosSiniestro.fechaOcurrencia
        _solicitud.datosSiniestro.horaOcurrencia = solicitud.datosSiniestro.horaOcurrencia

        _solicitud.datosSiniestro.lugarOcurrencia = solicitud.datosSiniestro.lugarOcurrencia
        _solicitud.datosSiniestro.codigoPostal = solicitud.datosSiniestro.codigoPostal
        _solicitud.datosSiniestro.cantidadAutosParticipantes =
            solicitud.datosSiniestro.cantidadAutosParticipantes

    }

    fun envioInformacionAdicional(solicitud: Solicitud) {
        _solicitud.datosSiniestro.hubieronDaniosPersonales =
            solicitud.datosSiniestro.hubieronDaniosPersonales
        _solicitud.datosSiniestro.hubieronDaniosMateriales =
            solicitud.datosSiniestro.hubieronDaniosMateriales
        _solicitud.datosSiniestro.hubieronTestigos = solicitud.datosSiniestro.hubieronTestigos
        _solicitud.datosSiniestro.huboDenuncia = solicitud.datosSiniestro.huboDenuncia
    }

    fun datosPropietarioVehiculoAsegurado(solicitud: Solicitud) {
        _solicitud.propietarioAsegurado.datosPersona.nombre =
            solicitud.propietarioAsegurado.datosPersona.nombre
        _solicitud.propietarioAsegurado.datosPersona.apellido =
            solicitud.propietarioAsegurado.datosPersona.apellido
        _solicitud.propietarioAsegurado.datosPersona.nombreCompleto =
            solicitud.propietarioAsegurado.datosPersona.nombreCompleto
        _solicitud.propietarioAsegurado.datosPersona.domicilio.calle =
            solicitud.propietarioAsegurado.datosPersona.domicilio.calle
        _solicitud.propietarioAsegurado.datosPersona.domicilio.numero =
            solicitud.propietarioAsegurado.datosPersona.domicilio.numero
        _solicitud.propietarioAsegurado.datosPersona.domicilio.piso =
            solicitud.propietarioAsegurado.datosPersona.domicilio.piso
        _solicitud.propietarioAsegurado.datosPersona.domicilio.departamento =
            solicitud.propietarioAsegurado.datosPersona.domicilio.departamento
        _solicitud.propietarioAsegurado.datosPersona.domicilio.codigoPostal =
            solicitud.propietarioAsegurado.datosPersona.domicilio.codigoPostal
        _solicitud.propietarioAsegurado.datosPersona.dni =
            solicitud.propietarioAsegurado.datosPersona.dni
        _solicitud.propietarioAsegurado.datosPersona.email =
            solicitud.propietarioAsegurado.datosPersona.email
        _solicitud.propietarioAsegurado.datosPersona.telefono =
            solicitud.propietarioAsegurado.datosPersona.telefono
        _solicitud.propietarioAsegurado.datosPersona.sexo =
            solicitud.propietarioAsegurado.datosPersona.sexo
        _solicitud.propietarioAsegurado.datosPersona.fechaDeNacimiento =
            solicitud.propietarioAsegurado.datosPersona.fechaDeNacimiento

        _solicitud.propietarioAsegurado.vehiculo.datosVehiculo.tipoVehiculo =
            solicitud.propietarioAsegurado.vehiculo.datosVehiculo.tipoVehiculo
        _solicitud.propietarioAsegurado.vehiculo.datosVehiculo.marca =
            solicitud.propietarioAsegurado.vehiculo.datosVehiculo.marca
        _solicitud.propietarioAsegurado.vehiculo.datosVehiculo.modelo =
            solicitud.propietarioAsegurado.vehiculo.datosVehiculo.modelo
        _solicitud.propietarioAsegurado.vehiculo.datosVehiculo.color =
            solicitud.propietarioAsegurado.vehiculo.datosVehiculo.color
        _solicitud.propietarioAsegurado.vehiculo.datosVehiculo.anio =
            solicitud.propietarioAsegurado.vehiculo.datosVehiculo.anio
        _solicitud.propietarioAsegurado.vehiculo.datosVehiculo.dominio =
            solicitud.propietarioAsegurado.vehiculo.datosVehiculo.dominio
        _solicitud.propietarioAsegurado.vehiculo.usoDelVehiculo =
            solicitud.propietarioAsegurado.vehiculo.usoDelVehiculo
        _solicitud.idAsegurado = solicitud.idAsegurado
        _solicitud.idAsegurador = solicitud.idAsegurador
    }

    fun datosPropietarioVehiculoTercero(solicitud: Solicitud) {
        _solicitud.propietarioAfectado.datosPersona.nombre =
            solicitud.propietarioAfectado.datosPersona.nombre
        _solicitud.propietarioAfectado.datosPersona.apellido =
            solicitud.propietarioAfectado.datosPersona.apellido
        _solicitud.propietarioAfectado.datosPersona.nombreCompleto =
            solicitud.propietarioAfectado.datosPersona.nombreCompleto
        _solicitud.propietarioAfectado.datosPersona.domicilio.calle =
            solicitud.propietarioAfectado.datosPersona.domicilio.calle
        _solicitud.propietarioAfectado.datosPersona.domicilio.numero =
            solicitud.propietarioAfectado.datosPersona.domicilio.numero
        _solicitud.propietarioAfectado.datosPersona.domicilio.piso =
            solicitud.propietarioAfectado.datosPersona.domicilio.piso
        _solicitud.propietarioAfectado.datosPersona.domicilio.departamento =
            solicitud.propietarioAfectado.datosPersona.domicilio.departamento
        _solicitud.propietarioAfectado.datosPersona.domicilio.codigoPostal =
            solicitud.propietarioAfectado.datosPersona.domicilio.codigoPostal
        _solicitud.propietarioAfectado.datosPersona.dni =
            solicitud.propietarioAfectado.datosPersona.dni
        _solicitud.propietarioAfectado.datosPersona.email =
            solicitud.propietarioAfectado.datosPersona.email
        _solicitud.propietarioAfectado.datosPersona.telefono =
            solicitud.propietarioAfectado.datosPersona.telefono
        _solicitud.propietarioAfectado.datosPersona.sexo =
            solicitud.propietarioAfectado.datosPersona.sexo
        _solicitud.propietarioAfectado.datosPersona.fechaDeNacimiento =
            solicitud.propietarioAfectado.datosPersona.fechaDeNacimiento
        _solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo.tipoVehiculo =
            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo.tipoVehiculo
        _solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo.marca =
            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo.marca
        _solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo.modelo =
            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo.modelo
        _solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo.color =
            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo.color
        _solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo.anio =
            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo.anio
        _solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo.dominio =
            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.datosVehiculo.dominio
        _solicitud.propietarioAfectado.vehiculoPropietadoAfectado.aseguradora =
            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.aseguradora
        _solicitud.propietarioAfectado.vehiculoPropietadoAfectado.poliza =
            solicitud.propietarioAfectado.vehiculoPropietadoAfectado.poliza

        _solicitud.propietarioAfectado.fechaVencimientoPoliza =
            solicitud.propietarioAfectado.fechaVencimientoPoliza


    }


    fun conductorVehiculoAsegurado(solicitud: Solicitud) {
        _solicitud.conductorAsegurado.datosPersona.nombre =
            solicitud.conductorAsegurado.datosPersona.nombre
        _solicitud.conductorAsegurado.datosPersona.apellido =
            solicitud.conductorAsegurado.datosPersona.apellido
        _solicitud.conductorAsegurado.datosPersona.nombreCompleto =
            solicitud.conductorAsegurado.datosPersona.nombreCompleto
        _solicitud.conductorAsegurado.datosPersona.domicilio.calle =
            solicitud.conductorAsegurado.datosPersona.domicilio.calle
        _solicitud.conductorAsegurado.datosPersona.domicilio.numero =
            solicitud.conductorAsegurado.datosPersona.domicilio.numero
        _solicitud.conductorAsegurado.datosPersona.domicilio.piso =
            solicitud.conductorAsegurado.datosPersona.domicilio.piso
        _solicitud.conductorAsegurado.datosPersona.domicilio.departamento =
            solicitud.conductorAsegurado.datosPersona.domicilio.departamento
        _solicitud.conductorAsegurado.datosPersona.domicilio.codigoPostal =
            solicitud.conductorAsegurado.datosPersona.domicilio.codigoPostal
        _solicitud.conductorAsegurado.datosPersona.dni =
            solicitud.conductorAsegurado.datosPersona.dni
        _solicitud.conductorAsegurado.datosPersona.fechaDeNacimiento =
            solicitud.conductorAsegurado.datosPersona.fechaDeNacimiento
        _solicitud.conductorAsegurado.datosPersona.telefono =
            solicitud.conductorAsegurado.datosPersona.telefono
        _solicitud.conductorAsegurado.datosPersona.sexo =
            solicitud.conductorAsegurado.datosPersona.sexo
        _solicitud.conductorAsegurado.datosPersona.email =
            solicitud.conductorAsegurado.datosPersona.email
        _solicitud.conductorAsegurado.nroRegistro = solicitud.conductorAsegurado.nroRegistro
        _solicitud.conductorAsegurado.claseRegistro = solicitud.conductorAsegurado.claseRegistro
        _solicitud.conductorAsegurado.fechaRegistroExpedicion =
            solicitud.conductorAsegurado.fechaRegistroExpedicion
        _solicitud.conductorAsegurado.fechaRegistroVencimiento =
            solicitud.conductorAsegurado.fechaRegistroVencimiento
        _solicitud.conductorAsegurado.relacionAsegurado =
            solicitud.conductorAsegurado.relacionAsegurado
    }


    fun conductorVehiculoTercero(solicitud: Solicitud) {
        _solicitud.conductorAfectado.datosPersona.nombre =
            solicitud.conductorAfectado.datosPersona.nombre
        _solicitud.conductorAfectado.datosPersona.apellido =
            solicitud.conductorAfectado.datosPersona.apellido
        _solicitud.conductorAfectado.datosPersona.nombreCompleto =
            solicitud.conductorAfectado.datosPersona.nombreCompleto
        _solicitud.conductorAfectado.datosPersona.domicilio.calle =
            solicitud.conductorAfectado.datosPersona.domicilio.calle
        _solicitud.conductorAfectado.datosPersona.domicilio.numero =
            solicitud.conductorAfectado.datosPersona.domicilio.numero
        _solicitud.conductorAfectado.datosPersona.domicilio.piso =
            solicitud.conductorAfectado.datosPersona.domicilio.piso
        _solicitud.conductorAfectado.datosPersona.domicilio.departamento =
            solicitud.conductorAfectado.datosPersona.domicilio.departamento
        _solicitud.conductorAfectado.datosPersona.domicilio.codigoPostal =
            solicitud.conductorAfectado.datosPersona.domicilio.codigoPostal
        _solicitud.conductorAfectado.datosPersona.dni = solicitud.conductorAfectado.datosPersona.dni

        _solicitud.conductorAfectado.datosPersona.fechaDeNacimiento =
            solicitud.conductorAfectado.datosPersona.fechaDeNacimiento
        _solicitud.conductorAfectado.datosPersona.telefono =
            solicitud.conductorAfectado.datosPersona.telefono
        _solicitud.conductorAfectado.datosPersona.sexo =
            solicitud.conductorAfectado.datosPersona.sexo
        _solicitud.conductorAfectado.datosPersona.email =
            solicitud.conductorAfectado.datosPersona.email
        _solicitud.conductorAfectado.nroRegistro = solicitud.conductorAfectado.nroRegistro
        _solicitud.conductorAfectado.claseRegistro = solicitud.conductorAfectado.claseRegistro
        _solicitud.conductorAfectado.fechaRegistroExpedicion =
            solicitud.conductorAfectado.fechaRegistroExpedicion
        _solicitud.conductorAfectado.fechaRegistroVencimiento =
            solicitud.conductorAfectado.fechaRegistroVencimiento
        _solicitud.conductorAfectado.relacionAsegurado =
            solicitud.conductorAfectado.relacionAsegurado
    }

    fun daniosVehiculoAsegurado(solicitud: Solicitud) {
        _solicitud.daniosVehiculoAsegurado = solicitud.daniosVehiculoAsegurado

    }

    fun daniosVehiculosTercero(solicitud: Solicitud) {
        _solicitud.daniosVehiculoAfectado = solicitud.daniosVehiculoAfectado


    }

    fun datosAdicionales(solicitud: Solicitud) {
        _solicitud.datosSiniestro.tipoCamino = solicitud.datosSiniestro.tipoCamino
        _solicitud.datosSiniestro.estadoCamino = solicitud.datosSiniestro.estadoCamino
        _solicitud.datosSiniestro.estadoTiempo = solicitud.datosSiniestro.estadoTiempo
        _solicitud.datosSiniestro.asistioGrua = solicitud.datosSiniestro.asistioGrua
        _solicitud.datosSiniestro.asistioAmbulancia = solicitud.datosSiniestro.asistioAmbulancia
        _solicitud.datosSiniestro.asistioBomberos = solicitud.datosSiniestro.asistioBomberos
        _solicitud.datosSiniestro.observaciones = solicitud.datosSiniestro.observaciones

    }

    fun consecuenciaSiniestro(solicitud: Solicitud) {
        _solicitud.datosSiniestro.consecuenciaSiniestro.danioParcial =
            solicitud.datosSiniestro.consecuenciaSiniestro.danioParcial
        _solicitud.datosSiniestro.consecuenciaSiniestro.roboRueda =
            solicitud.datosSiniestro.consecuenciaSiniestro.roboRueda
        _solicitud.datosSiniestro.consecuenciaSiniestro.roboParcial =
            solicitud.datosSiniestro.consecuenciaSiniestro.roboParcial
        _solicitud.datosSiniestro.consecuenciaSiniestro.danioTerceros =
            solicitud.datosSiniestro.consecuenciaSiniestro.danioTerceros
        _solicitud.datosSiniestro.consecuenciaSiniestro.incendioTotal =
            solicitud.datosSiniestro.consecuenciaSiniestro.incendioTotal
        _solicitud.datosSiniestro.consecuenciaSiniestro.otros =
            solicitud.datosSiniestro.consecuenciaSiniestro.otros
        _solicitud.datosSiniestro.consecuenciaSiniestro.destruccionTotal =
            solicitud.datosSiniestro.consecuenciaSiniestro.destruccionTotal
        _solicitud.datosSiniestro.consecuenciaSiniestro.roboTotal =
            solicitud.datosSiniestro.consecuenciaSiniestro.roboTotal
        _solicitud.datosSiniestro.consecuenciaSiniestro.roturaCristales =
            solicitud.datosSiniestro.consecuenciaSiniestro.roturaCristales
        _solicitud.datosSiniestro.consecuenciaSiniestro.incendioParcial =
            solicitud.datosSiniestro.consecuenciaSiniestro.incendioParcial

    }

    fun relatoAccidente(solicitud: Solicitud) {
        _solicitud.datosSiniestro.relato = solicitud.datosSiniestro.relato

    }

    fun lugarAsistencia(solicitud: Solicitud, navController: NavController) {
        val lugarAsistencia = _solicitud.datosSiniestro.lugarAsistencia
        val solicitudLugarAsistencia = solicitud.datosSiniestro.lugarAsistencia

        if (lugarAsistencia != null && solicitudLugarAsistencia != null) {
            lugarAsistencia.nombreCentro = solicitudLugarAsistencia.nombreCentro
            lugarAsistencia.quedaInternado = solicitudLugarAsistencia.quedaInternado
            lugarAsistencia.estadoLesiones = solicitudLugarAsistencia.estadoLesiones
            lugarAsistencia.descripcionLesiones = solicitudLugarAsistencia.descripcionLesiones

            enviarSolicitud(navController)
        }
    }

    fun sinLugarAsistencia(navController: NavController) {
        _solicitud.datosSiniestro.lugarAsistencia = null
        enviarSolicitud(navController)

    }

    private fun enviarSolicitud(navController: NavController) {
        viewModelScope.launch {
            try {
                Log.d("SOLICITUD_A_ENVIAR", solicitud.toString())
                val respuesta = crearSolicitudService.enviarSolicitud(_solicitud)
                Log.d("RESPUESTA_API_SOLICITUD", respuesta.toString())
                if (respuesta.isSuccessful) {
                    Log.d("Solicitud Enviada", "Exito antes del NAV")
                    println("Solicitud enviada exitosamente")
                    withContext(Dispatchers.Main) {
                        navController.navigate("${Rutas.LoadingScreen.ruta}/{}/${Rutas.SolicitudEnviada.ruta}")
                        Log.d("Solicitud Enviada", "Solicitud enviada exitosamente")
                    }
                } else {
                    println("Error al enviar la solicitud: ${respuesta.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                println("Excepción al enviar la solicitud: ${e.message}")
            }
        }
    }

    fun reiniciarEstados() {
        // Reiniciar todos los valores a sus estados iniciales
        conductorAseguradoFormState = ConductorFormState()  // Por ejemplo
        conductorTerceroFormState = ConductorFormState()  // Si tienes otro estado similar
        solicitud = Solicitud()  // Reemplaza con una nueva instancia de solicitud
        _solicitud = Solicitud()

    }



}

sealed class EstadoEnvio {
    object Idle : EstadoEnvio()
    object Cargando : EstadoEnvio()
    object Exitoso : EstadoEnvio()
    data class Error(val mensaje: String) : EstadoEnvio()
}