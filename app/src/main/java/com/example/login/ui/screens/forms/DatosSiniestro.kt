package com.example.login.ui.screens.forms

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.login.components.FieldStringForms
import com.example.login.data.models.poliza.Poliza
import com.example.login.navigation.Rutas
import com.example.login.ui.screens.gson
import com.example.login.ui.viewmodels.CrearPolizaViewModel
import com.example.login.ui.viewmodels.forms.DatosSiniestroViewModel

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatosSiniestro(navController: NavController, viewModel: DatosSiniestroViewModel, poliza: Poliza) {
    val crearPolizaViewModel: CrearPolizaViewModel = viewModel(
        factory = CrearPolizaViewModel.provideFactory()
    )
        Column {
//            DataPicker(onDateSelected = { date ->
//                viewModel.FechaOcurrencia.value = date
//            })
//            TimePicker(onTimeSelected = { time ->
//                viewModel.HoraOcurriencia.value = time
//            })
            LazyColumn {
                items(viewModel.campos.size) { index ->
                    val campo = viewModel.campos[index]

                    FieldStringForms(
                        label = campo.label,
                        value = campo.value,
                        error = campo.error,
                        onValueChange = { newValue -> viewModel.onCampoChange(index, newValue) }
                    )
                }

                item {
                    Button(onClick = {
                        val solicitud = viewModel.crearSolicitudPoliza()
                        val polizaJson = gson.toJson(poliza)
                        navController.navigate(route = "${Rutas.InformacionAdicional.ruta}/${polizaJson}")
                        if (solicitud != null) {
                            Log.d("solicitud", "se creo")
                            Log.d("solicitud", "${solicitud.toString()} ")
                            Log.d("Fecha ocurrencia", "${viewModel.HoraOcurriencia}")
                        }else{
                            Log.d("solicitud", "no se creo")
                        }
                    }) {
                        Text("Enviar Solicitud")
                    }
                }
            }
        }
}


