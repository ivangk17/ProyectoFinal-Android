package com.example.login.ui.screens.forms

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.login.components.AppButton
import com.example.login.components.DatePicker
import com.example.login.components.FieldStringForms
import com.example.login.components.TimePicker
import com.example.login.data.models.poliza.Poliza
import com.example.login.navigation.Rutas
import com.example.login.ui.screens.gson
import com.example.login.ui.viewmodels.CrearSolicitudViewModel
import com.example.login.ui.viewmodels.forms.DatosSiniestroViewModel
import com.example.login.utilities.showToastError

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatosSiniestro(
    navController: NavController,
    viewModel: DatosSiniestroViewModel,
    poliza: Poliza,
    crearSolicitudViewModel: CrearSolicitudViewModel
) {
    val context = LocalContext.current
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)
    ) {

        item {
            DatePicker(
                label = "Fecha de ocurrencia",
                valor = viewModel.fechaOcurrencia,
                error = viewModel.errorFechaOcurrencua,
                onDateSelected = { newValue -> viewModel.setFechaOcurrencia(newValue) }
            )
            //DatePicker2()
            TimePicker(
                label = "Hora de ocurrencia",
                valor = viewModel.horaOcurriencia,
                error = viewModel.errorHoraOcurrencua,
                onTimeSelected = { newValue -> viewModel.setHoraOcurrencia(newValue) })
        }


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
            AppButton(
                text = "Siguiente"
            )
            {
                val solicitud = viewModel.crearSolicitudPoliza()
                val polizaJson = gson.toJson(poliza)

                if (solicitud != null) {
                    crearSolicitudViewModel.envioDatosSiniestros(solicitud)
                    Log.d("SOLICITUD", solicitud.datosSiniestro.toString())
                    navController.navigate(route = "${Rutas.InformacionAdicional.ruta}/${polizaJson}")
                } else {
                    showToastError(context, "error: No se puede crear la solicitud")
                    Log.d("solicitud", "no se creo")
                }

            }
        }

    }
}


