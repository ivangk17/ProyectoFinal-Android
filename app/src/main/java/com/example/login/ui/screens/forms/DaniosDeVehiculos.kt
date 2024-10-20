package com.example.login.ui.screens.forms

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.login.components.MultipleLine
import com.example.login.ui.viewmodels.forms.DaniosDeVehiculoAseguradoViewModel


@Composable
fun DaniosDeVehiculos(titulo: String, viewModel: DaniosDeVehiculoAseguradoViewModel) {


    Column {
        MultipleLine(
            titulo,
            viewModel.descripcionDanios,
            onValueChange = { newValue -> viewModel.onDescripcionChange(newValue) },
            error = viewModel.errorDescription
        )
        Button(
            onClick = {
                val solicitud = viewModel.crearSolicitud()
                if (solicitud != null) {
                    Log.d("SOLICITUD", viewModel.solicitud.toString())
                } else {
                    Log.d("solicitud", "no se creo")
                }
            }
        ) {
            Text("Siguiente")
        }
    }

}