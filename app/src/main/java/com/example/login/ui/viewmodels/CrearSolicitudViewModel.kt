package com.example.login.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.login.data.models.solicitud.Solicitud

class CrearSolicitudViewModel: ViewModel()  {
    private var _solicitud = Solicitud()



    fun envioDatosSiniestros(solicitud: Solicitud) {
        _solicitud.datosSiniestro.lugaarOcurrencia = solicitud.datosSiniestro.lugaarOcurrencia
        _solicitud.datosSiniestro.codigoPostal = solicitud.datosSiniestro.codigoPostal
        _solicitud.datosSiniestro.localidad = solicitud.datosSiniestro.localidad
        _solicitud.datosSiniestro.provincia = solicitud.datosSiniestro.provincia
        _solicitud.datosSiniestro.pais = solicitud.datosSiniestro.pais
        _solicitud.datosSiniestro.cantidadAutosParticipantes = solicitud.datosSiniestro.cantidadAutosParticipantes
        _solicitud.datosSiniestro.interseccion = solicitud.datosSiniestro.interseccion

        _solicitud.datosSiniestro.fechaOcurrencia = solicitud.datosSiniestro.fechaOcurrencia
        _solicitud.datosSiniestro.horaOcurrencia = solicitud.datosSiniestro.horaOcurrencia

    }

    fun envioInformacionAdicional(solicitud: Solicitud) {
        _solicitud.datosSiniestro.vigencia = solicitud.datosSiniestro.vigencia
        _solicitud.datosSiniestro.cobertura = solicitud.datosSiniestro.cobertura
        _solicitud.datosSiniestro.franquicia = solicitud.datosSiniestro.franquicia
        _solicitud.datosSiniestro.cobranza = solicitud.datosSiniestro.cobranza
        _solicitud.datosSiniestro.huboDenuncia = solicitud.datosSiniestro.huboDenuncia
        _solicitud.datosSiniestro.hubieronDaniosPersonales = solicitud.datosSiniestro.hubieronDaniosPersonales
        _solicitud.datosSiniestro.hubieronDaniosMateriales = solicitud.datosSiniestro.hubieronDaniosMateriales
        _solicitud.datosSiniestro.hubieronTestigos = solicitud.datosSiniestro.hubieronTestigos
    }

    fun datosPropietarioVehiculoAsegurado(solicitud: Solicitud) {
        // Implementación para enviar datos del propietario del vehículo asegurado
    }

    fun datosPropietarioVehiculoTercero(solicitud: Solicitud) {
        _solicitud.propietarioAfectado.nombre = solicitud.propietarioAfectado.nombre
        _solicitud.propietarioAfectado.apellido = solicitud.propietarioAfectado.apellido
        _solicitud.propietarioAfectado.domicilio.calle = solicitud.propietarioAfectado.domicilio.calle
        _solicitud.propietarioAfectado.domicilio.localidad = solicitud.propietarioAfectado.domicilio.localidad
        _solicitud.propietarioAfectado.domicilio.codigoPostal = solicitud.propietarioAfectado.domicilio.codigoPostal
        _solicitud.propietarioAfectado.domicilio.provincia = solicitud.propietarioAfectado.domicilio.provincia
        _solicitud.propietarioAfectado.domicilio.pais = solicitud.propietarioAfectado.domicilio.pais
        _solicitud.propietarioAfectado.cuit = solicitud.propietarioAfectado.cuit
        _solicitud.propietarioAfectado.email = solicitud.propietarioAfectado.email
        _solicitud.propietarioAfectado.telefono = solicitud.propietarioAfectado.telefono
        _solicitud.propietarioAfectado.vehiculoPropietadoAfectado.marca = solicitud.propietarioAfectado.vehiculoPropietadoAfectado.marca
        _solicitud.propietarioAfectado.vehiculoPropietadoAfectado.modelo = solicitud.propietarioAfectado.vehiculoPropietadoAfectado.modelo
        _solicitud.propietarioAfectado.vehiculoPropietadoAfectado.color = solicitud.propietarioAfectado.vehiculoPropietadoAfectado.color
        _solicitud.propietarioAfectado.vehiculoPropietadoAfectado.anio = solicitud.propietarioAfectado.vehiculoPropietadoAfectado.anio
        _solicitud.propietarioAfectado.vehiculoPropietadoAfectado.dominio = solicitud.propietarioAfectado.vehiculoPropietadoAfectado.dominio
        _solicitud.propietarioAfectado.vehiculoPropietadoAfectado.aseguradora = solicitud.propietarioAfectado.vehiculoPropietadoAfectado.aseguradora
        _solicitud.propietarioAfectado.vehiculoPropietadoAfectado.poliza = solicitud.propietarioAfectado.vehiculoPropietadoAfectado.poliza

        _solicitud.conductorAsegurado.fechaVencimiento = solicitud.conductorAsegurado.fechaVencimiento

    }

    fun conductorVehiculoAsegurado(solicitud: Solicitud) {
        _solicitud.conductorAsegurado.nombre = solicitud.conductorAsegurado.nombre
        _solicitud.conductorAsegurado.apellido = solicitud.conductorAsegurado.apellido
        _solicitud.conductorAsegurado.domicilio.calle = solicitud.conductorAsegurado.domicilio.calle
        _solicitud.conductorAsegurado.domicilio.localidad = solicitud.conductorAsegurado.domicilio.localidad
        _solicitud.conductorAsegurado.domicilio.codigoPostal = solicitud.conductorAsegurado.domicilio.codigoPostal
        _solicitud.conductorAsegurado.domicilio.provincia = solicitud.conductorAsegurado.domicilio.provincia
        _solicitud.conductorAsegurado.domicilio.pais = solicitud.conductorAsegurado.domicilio.pais
        _solicitud.conductorAsegurado.cuit = solicitud.conductorAsegurado.cuit
        _solicitud.conductorAsegurado.telefono = solicitud.conductorAsegurado.telefono
        _solicitud.conductorAsegurado.sexo = solicitud.conductorAsegurado.sexo
        _solicitud.conductorAsegurado.email = solicitud.conductorAsegurado.email
        _solicitud.conductorAsegurado.nroRegistro = solicitud.conductorAsegurado.nroRegistro
        _solicitud.conductorAsegurado.claseRegistro = solicitud.conductorAsegurado.claseRegistro
        _solicitud.conductorAsegurado.relacionAsegurado = solicitud.conductorAsegurado.relacionAsegurado

        _solicitud.conductorAsegurado.fechaDeNacimiento = solicitud.conductorAsegurado.fechaDeNacimiento
        _solicitud.conductorAsegurado.fechaVencimiento = solicitud.conductorAsegurado.fechaVencimiento
        _solicitud.conductorAsegurado.fechaExpedicion = solicitud.conductorAsegurado.fechaExpedicion
    }

    fun conductorVehiculoTercero(solicitud: Solicitud) {
        _solicitud.conductorAfectado.nombre = solicitud.conductorAfectado.nombre
        _solicitud.conductorAfectado.apellido = solicitud.conductorAfectado.apellido
        _solicitud.conductorAfectado.nombreCompleto = "${solicitud.conductorAfectado.nombre} ${solicitud.conductorAfectado.apellido}"
        _solicitud.conductorAfectado.domicilio.calle = solicitud.conductorAfectado.domicilio.calle
        _solicitud.conductorAfectado.domicilio.localidad = solicitud.conductorAfectado.domicilio.localidad
        _solicitud.conductorAfectado.domicilio.codigoPostal = solicitud.conductorAfectado.domicilio.codigoPostal
        _solicitud.conductorAfectado.domicilio.provincia = solicitud.conductorAfectado.domicilio.provincia
        _solicitud.conductorAfectado.domicilio.pais = solicitud.conductorAfectado.domicilio.pais
        _solicitud.conductorAfectado.cuit = solicitud.conductorAfectado.cuit
        _solicitud.conductorAfectado.telefono = solicitud.conductorAfectado.telefono
        _solicitud.conductorAfectado.sexo = solicitud.conductorAfectado.sexo
        _solicitud.conductorAfectado.email = solicitud.conductorAfectado.email
        _solicitud.conductorAfectado.nroRegistro = solicitud.conductorAfectado.nroRegistro
        _solicitud.conductorAfectado.claseRegistro = solicitud.conductorAfectado.claseRegistro
        _solicitud.conductorAfectado.relacionAsegurado = solicitud.conductorAfectado.relacionAsegurado

        _solicitud.conductorAfectado.fechaDeNacimiento = solicitud.conductorAfectado.fechaDeNacimiento
        _solicitud.conductorAfectado.fechaVencimiento = solicitud.conductorAfectado.fechaVencimiento
        _solicitud.conductorAfectado.fechaExpedicion = solicitud.conductorAfectado.fechaExpedicion
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
        _solicitud.datosSiniestro.consecuenciaSiniestro.danioParcial = solicitud.datosSiniestro.consecuenciaSiniestro.danioParcial
        _solicitud.datosSiniestro.consecuenciaSiniestro.roboRueda = solicitud.datosSiniestro.consecuenciaSiniestro.roboRueda
        _solicitud.datosSiniestro.consecuenciaSiniestro.roboParcial = solicitud.datosSiniestro.consecuenciaSiniestro.roboParcial
        _solicitud.datosSiniestro.consecuenciaSiniestro.danioTerceros = solicitud.datosSiniestro.consecuenciaSiniestro.danioTerceros
        _solicitud.datosSiniestro.consecuenciaSiniestro.incendioTotal = solicitud.datosSiniestro.consecuenciaSiniestro.incendioTotal
        _solicitud.datosSiniestro.consecuenciaSiniestro.otros = solicitud.datosSiniestro.consecuenciaSiniestro.otros
        _solicitud.datosSiniestro.consecuenciaSiniestro.destruccionTotal = solicitud.datosSiniestro.consecuenciaSiniestro.destruccionTotal
        _solicitud.datosSiniestro.consecuenciaSiniestro.roboTotal = solicitud.datosSiniestro.consecuenciaSiniestro.roboTotal
        _solicitud.datosSiniestro.consecuenciaSiniestro.roturaCristales = solicitud.datosSiniestro.consecuenciaSiniestro.roturaCristales
        _solicitud.datosSiniestro.consecuenciaSiniestro.incendioParcial = solicitud.datosSiniestro.consecuenciaSiniestro.incendioParcial
    }

    fun relatoAccidente(solicitud: Solicitud) {
        _solicitud.datosSiniestro.relato = solicitud.datosSiniestro.relato
    }

    fun daniosPersonales(solicitud: Solicitud) {
        _solicitud.lesiones.lesionado.nombre = solicitud.lesiones.lesionado.nombre
        _solicitud.lesiones.lesionado.apellido = solicitud.lesiones.lesionado.apellido
        _solicitud.lesiones.lesionado.nombreCompleto = "${solicitud.lesiones.lesionado.nombre} ${solicitud.lesiones.lesionado.apellido}"
        _solicitud.lesiones.lesionado.domicilio.calle = solicitud.lesiones.lesionado.domicilio.calle
        _solicitud.lesiones.lesionado.domicilio.localidad = solicitud.lesiones.lesionado.domicilio.localidad
        _solicitud.lesiones.lesionado.domicilio.codigoPostal = solicitud.lesiones.lesionado.domicilio.codigoPostal
        _solicitud.lesiones.lesionado.domicilio.provincia = solicitud.lesiones.lesionado.domicilio.provincia
        _solicitud.lesiones.lesionado.domicilio.pais = solicitud.lesiones.lesionado.domicilio.pais
        _solicitud.lesiones.lesionado.cuit = solicitud.lesiones.lesionado.cuit
        _solicitud.lesiones.lesionado.email = solicitud.lesiones.lesionado.email
        _solicitud.lesiones.lesionado.telefono = solicitud.lesiones.lesionado.telefono
        _solicitud.lesiones.lesionado.sexo = solicitud.lesiones.lesionado.sexo
        _solicitud.lesiones.lesionado.estadoCivil = solicitud.lesiones.lesionado.estadoCivil
        _solicitud.lesiones.lesionado.telefonoAlternativo = solicitud.lesiones.lesionado.telefonoAlternativo

        _solicitud.lesiones.lesionado.fechaDeNacimiento = solicitud.lesiones.lesionado.fechaDeNacimiento

        _solicitud.lesiones.peatonOCiclista = solicitud.lesiones.peatonOCiclista
        _solicitud.lesiones.conductorTercero = solicitud.lesiones.conductorTercero
        _solicitud.lesiones.ocupanteTercero = solicitud.lesiones.ocupanteTercero
        _solicitud.lesiones.ocupanteAsgurado = solicitud.lesiones.ocupanteAsgurado
        _solicitud.lesiones.asegurado = solicitud.lesiones.asegurado
        _solicitud.lesiones.conductorAsegurado = solicitud.lesiones.conductorAsegurado
        _solicitud.lesiones.relacionConPropietario = solicitud.lesiones.relacionConPropietario



    }

    fun lugarAsistencia(solicitud: Solicitud) {
        _solicitud.datosSiniestro.lugarAsistencia.nombreCentro = solicitud.datosSiniestro.lugarAsistencia.nombreCentro
        _solicitud.datosSiniestro.lugarAsistencia.quedaInternado = solicitud.datosSiniestro.lugarAsistencia.quedaInternado
        _solicitud.datosSiniestro.lugarAsistencia.estadoLesiones = solicitud.datosSiniestro.lugarAsistencia.estadoLesiones
        _solicitud.datosSiniestro.lugarAsistencia.descripcionLesiones = solicitud.datosSiniestro.lugarAsistencia.descripcionLesiones
        Log.d("SOLICITUD TOTAL", _solicitud.datosSiniestro.lugarAsistencia.toString())
    }


    companion object{
        fun provideFactory(): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return CrearSolicitudViewModel() as T
            }
        }
    }
}