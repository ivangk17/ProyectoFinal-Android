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
import com.example.login.components.DatePicker
import com.example.login.components.DropdownMenuSample
import com.example.login.components.FieldStringForms
import com.example.login.data.models.personas.Sexo
import com.example.login.data.models.poliza.Poliza
import com.example.login.data.models.vehiculos.TipoVehiculo
import com.example.login.navigation.Rutas
import com.example.login.ui.screens.gson
import com.example.login.ui.viewmodels.CrearSolicitudViewModel
import com.example.login.ui.viewmodels.forms.DatosPropietarioVehiculoTerceroViewModel
import com.example.login.utilities.showToastError

@Composable
fun DatosPropietarioVehiculoTercero(
    navController: NavController,
    viewModel: DatosPropietarioVehiculoTerceroViewModel,
    poliza: Poliza,
    crearSolicitudViewModel: CrearSolicitudViewModel
) {
    val context = LocalContext.current
    val optionsSexo = Sexo.entries
    val optionsTipoVehiculo = TipoVehiculo.entries
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)
    ) {
        item {
            Text(
                text = "DATOS DEL PROPIETARIO DEL OTRO VEHÍCULO",
                textDecoration = TextDecoration.Underline,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    fontSize = 20.sp
                ),
                modifier = Modifier.padding(20.dp)
            )
        }

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
                DropdownMenuSample(
                    title = "Sexo",
                    options = optionsSexo,
                    selectedOption = viewModel.sexoSeleccionado.value,
                    onOptionSelected = { viewModel.sexoSeleccionado.value = it },
                    label = { it.displayName }
                )
            }
            if (index == 10){
                DropdownMenuSample(
                    title = "Tipo de vehiculo",
                    options = optionsTipoVehiculo,
                    selectedOption = viewModel.tipoVehiculo.value,
                    onOptionSelected = { viewModel.tipoVehiculo.value = it },
                    label = { it.displayName }
                )
            }
        }

        item {
            DatePicker(
                label = "Fecha vencimiento de la poliza",
                valor = viewModel.fechaDeVencimiento,
                error = viewModel.errorFechaVencimiento,
                onDateSelected = { newValue -> viewModel.setFechaDeVencimiento(newValue) }
            )
        }



        item {
            Column {
                Button(
                    onClick = {
                        val solicitud = viewModel.crearSolicitudPoliza()
                        val polizaJson = gson.toJson(poliza)
                        if (solicitud != null) {
                            crearSolicitudViewModel.datosPropietarioVehiculoTercero(solicitud)
                            navController.navigate(route = "${Rutas.ConductorVehiculoAsegurado.ruta}/${polizaJson}")
                        } else {
                            showToastError(context, "error: No se puede crear la solicitud")
                            Log.d("solicitud", "no se creo")
                        }
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text("Siguiente")
                }
            }
        }
    }
}
