package com.example.login.ui.screens.forms

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.login.components.DropdownMenuSample
import com.example.login.components.FieldStringForms
import com.example.login.components.SwitchCustom
import com.example.login.data.models.poliza.Poliza
import com.example.login.data.models.solicitud.datosSiniestros.HuboDenuncia
import com.example.login.ui.viewmodels.forms.F2ViewModel

@Composable
fun F2(navController: NavController, viewModel: F2ViewModel, poliza: Poliza){
    val options = HuboDenuncia.entries

    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(viewModel.camposCheckeables.size){ index ->
                val campo = viewModel.camposCheckeables[index]

                SwitchCustom(
                    checked = campo.value.value,
                    onCheckedChange = { newState -> viewModel.onSwitchChange(index, newState) },
                    label = campo.label
                )
            }

            item {
                DropdownMenuSample(
                    options = options,
                    selectedOption = viewModel.huboDenunciaSeleccion.value,
                    onOptionSelected = { viewModel.huboDenunciaSeleccion.value = it },
                    label = { it.name }
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
            }
        }

        Button(
            onClick = {
                val solicitud = viewModel.crearSolicitudPoliza()
                if (solicitud != null) {
                    Log.d("solicitud", "se creo")
                    Log.d("solicitud", "${viewModel.Solicitud.datosSiniestro} ")
                } else {
                    Log.d("solicitud", "no se creo")
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Enviar Solicitud")
        }
    }
}