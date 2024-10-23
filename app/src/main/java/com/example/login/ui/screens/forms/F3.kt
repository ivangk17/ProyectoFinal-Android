package com.example.login.ui.screens.forms

//import androidx.compose.foundation.layout.FlowColumnScopeInstance.align
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.login.components.DropdownMenuSample
import com.example.login.components.FieldStringForms
import com.example.login.components.SwitchCustom
import com.example.login.data.models.poliza.Poliza
import com.example.login.data.models.solicitud.datosSiniestros.HuboDenuncia
import com.example.login.data.models.vehiculos.UsoDelVehiculo
import com.example.login.ui.viewmodels.forms.F3ViewModel

@Composable
fun F3(navController: NavController, viewModel: F3ViewModel, poliza: Poliza){
    val options = UsoDelVehiculo.entries //esto devuelve una lista de opciones

    Column (modifier = Modifier.fillMaxSize()){
        LazyColumn (modifier = Modifier.weight(1f)) {

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
                DropdownMenuSample(
                    options = options,
                    selectedOption = viewModel.usoDelVehiculo.value,
                    onOptionSelected = { viewModel.usoDelVehiculo.value = it },
                    label = { it.name }
                )
            }

        }

            Button(
                onClick = {
                    val solicitud = viewModel.crearSolicitudPoliza()
                    if (solicitud != null) {
                        Log.d("solicitud", "se creo")
                        Log.d("solicitud", "${viewModel.Solicitud.datosSiniestro}")
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

