package com.example.login.ui.screens.forms

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.login.components.DropdownMenuSample
import com.example.login.components.MultipleLine
import com.example.login.components.SwitchCustom
import com.example.login.data.models.poliza.Poliza
import com.example.login.data.models.solicitud.datosSiniestros.EstadoCamino
import com.example.login.data.models.solicitud.datosSiniestros.EstadoTiempo
import com.example.login.data.models.solicitud.datosSiniestros.TipoCamino
import com.example.login.navigation.Rutas
import com.example.login.ui.screens.gson
import com.example.login.ui.viewmodels.forms.DatosAdicionalesViewModel

@Composable
fun DatosAdicionales(navController: NavController, viewModel: DatosAdicionalesViewModel, poliza: Poliza){
    val optionsTipoCamino = TipoCamino.entries
    val optionEstadoCamino = EstadoCamino.entries
    val optionEstadoTiempo = EstadoTiempo.entries

    LazyColumn {
        item {
            Column {
                DropdownMenuSample(
                    title = "Seleccionar el tipo de camino",
                    options = optionsTipoCamino,
                    selectedOption = viewModel.tipoCamino.value,
                    onOptionSelected = { viewModel.tipoCamino.value = it },
                    label = { it.name }
                )
                DropdownMenuSample(
                    title = "Seleccionar el estado del camino",
                    options = optionEstadoCamino,
                    selectedOption = viewModel.estadoCamino.value,
                    onOptionSelected = { viewModel.estadoCamino.value = it },
                    label = { it.name }
                )
                DropdownMenuSample(
                    title = "Seleccionar el estado del tiempo",
                    options = optionEstadoTiempo,
                    selectedOption = viewModel.estadoTiempo.value,
                    onOptionSelected = { viewModel.estadoTiempo.value = it },
                    label = { it.name }
                )
            }
        }

        items(viewModel.camposCheckeables.size){ index ->
            val campo = viewModel.camposCheckeables[index]

            SwitchCustom(
                checked = campo.value.value,
                onCheckedChange = { newState -> viewModel.onSwitchChange(index, newState) },
                label = campo.label
            )
        }

        item {
            MultipleLine(
                "Observaciones",
                viewModel.observaciones,
                onValueChange = { newValue -> viewModel.onObservacionChange(newValue) },
                error = viewModel.errorObservaciones
            )
        }

        item{
            Button(
                onClick = {
                    val solicitud = viewModel.crearSolicitud()
                    val polizaJson = gson.toJson(poliza)
                    navController.navigate("${Rutas.ConsecuenciaSiniestro.ruta}/${polizaJson}")
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
}