package com.example.login.components.solicituddetails

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.login.data.models.solicitud.Lesiones

@Composable
fun ClaseLesiones(lesiones: Lesiones) {
    TituloH2Details("Tipo de Lesionado")
    Column {
        if(lesiones.peatonOCiclista){
            CamposCheckeablesDetails("Peaton/Ciclista", lesiones.peatonOCiclista)
        }

        if (lesiones.conductorTercero) {
            CamposCheckeablesDetails("Conductor vehiculo del tercero", lesiones.conductorTercero);
        }
        if (lesiones.ocupanteTercero) {
            CamposCheckeablesDetails("Ocupante vehiculo del tercero", lesiones.ocupanteTercero);
        }
        if (lesiones.conductorAsegurado) {
            CamposCheckeablesDetails("Ocupante vehiculo asegurado", lesiones.conductorAsegurado);
        }
        if (lesiones.asegurado) {
            CamposCheckeablesDetails("Asegurado", lesiones.asegurado);
        }
        if (lesiones.conductor) {
            CamposCheckeablesDetails("Conductor", lesiones.conductor);
        }
        if (lesiones.propietarioVehiculoAsegurado) {
            CamposCheckeablesDetails("Propietario vehiculo asegurado", lesiones.propietarioVehiculoAsegurado);
        }
        if (lesiones.relacionConPropietario) {
            CamposCheckeablesDetails("Relacion con propietario", lesiones.relacionConPropietario);
        }

    }
}