package com.example.login.ui.screens.forms

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.login.components.MultipleLine
import com.example.login.data.models.poliza.Poliza
import com.example.login.navigation.Rutas
import com.example.login.ui.screens.gson
import com.example.login.ui.viewmodels.forms.DaniosViewModel


@Composable
fun <T> DaniosDeVehiculos(
    title: String,
    navController: NavHostController,
    viewModel: T,
    poliza: Poliza,
    proximaRuta: Rutas
) where T : ViewModel, T : DaniosViewModel {

    Column {
        MultipleLine(
            titulo = title,
            valor = viewModel.descripcionDanios,
            onValueChange = { newValue -> viewModel.onDescripcionChange(newValue) },
            error = viewModel.errorDescription
        )
        Button(
            onClick = {
                val solicitud = viewModel.crearSolicitud()
                val polizaJson = gson.toJson(poliza)
                if (solicitud != null) {
                    navController.navigate(route = "${proximaRuta.ruta}/${polizaJson}")
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