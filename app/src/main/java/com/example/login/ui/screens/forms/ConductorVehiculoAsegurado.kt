package com.example.login.ui.screens.forms

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.login.components.AppButton
import com.example.login.components.DatePicker
import com.example.login.components.DropdownMenuSample
import com.example.login.components.FieldStringForms
import com.example.login.data.models.personas.Sexo
import com.example.login.data.models.poliza.Poliza
import com.example.login.navigation.Rutas
import com.example.login.ui.screens.gson
import com.example.login.ui.viewmodels.CrearSolicitudViewModel
import com.example.login.ui.viewmodels.forms.ConductorVehiculoAseguradoViewModel
import com.example.login.utilities.showToastError

@Composable
fun ConductorVehiculoAsegurado(
    navController: NavController,
    viewModel: ConductorVehiculoAseguradoViewModel,
    crearSolicitudViewModel: CrearSolicitudViewModel
) {
    val context = LocalContext.current
    val optionsSexo = Sexo.entries
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)
    ) {

        items(viewModel.campos.size) { index ->
            val campo = viewModel.campos[index]


            FieldStringForms(
                label = campo.label,
                value = campo.value,
                error = campo.error,
                onValueChange = { newValue -> viewModel.onCampoChange(index, newValue) }
            )

            if(index == 7){
                DatePicker(
                    label = "Fecha de nacimiento",
                    valor = viewModel.fechaNacimiento,
                    error = viewModel.errorFechaNacimiento,
                    onDateSelected = { newValue -> viewModel.setFechaNacimiento(newValue) }
                )
            }

            if(index == 8){
                DropdownMenuSample(
                    title = "Sexo",
                    options = optionsSexo,
                    selectedOption = viewModel.sexoSeleccionado.value,
                    onOptionSelected = { viewModel.sexoSeleccionado.value = it },
                    label = { it.displayName }
                )
            }

            if( index == 11){
                DatePicker(
                    label = "Fecha de expedicion",
                    valor = viewModel.fechaExpedicion,
                    error = viewModel.errorFechaExpedicion,
                    onDateSelected = { newValue -> viewModel.setFechaExpedicion(newValue) }
                )
                DatePicker(
                    label = "Fecha de vencimiento",
                    valor = viewModel.fechaDeVencimiento,
                    error = viewModel.errorFechaVencimiento,
                    onDateSelected = { newValue -> viewModel.setFechaDeVencimiento(newValue) }
                )
            }
        }

        item {
            Column {
                AppButton(
                    action = {
                        val solicitud = viewModel.crearSolicitudPoliza()
                        if (solicitud != null) {
                            crearSolicitudViewModel.conductorVehiculoAsegurado(solicitud)
                            navController.navigate(route = Rutas.ConductorVehiculoTercero.ruta)
                            Log.d("SOLICITUD", solicitud.conductorAsegurado.toString())
                            navController.navigate(route = Rutas.ConductorVehiculoTercero.ruta)
                        } else {
                            showToastError(context, "error: No se puede crear la solicitud")
                            Log.d("solicitud", "no se creo")
                        }
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = "Siguiente")

            }
        }
    }
    }
