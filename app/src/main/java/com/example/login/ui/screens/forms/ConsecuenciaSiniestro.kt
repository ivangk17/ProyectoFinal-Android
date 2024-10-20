package com.example.login.ui.screens.forms

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
import com.example.login.components.SwitchCustom
import com.example.login.data.models.poliza.Poliza
import com.example.login.ui.viewmodels.forms.ConsecuenciaSiniestroViewModel
import com.example.login.ui.viewmodels.forms.DatosAdicionalesViewModel

@Composable
fun ConsecuenciaSiniestro(navController: NavController, viewModel: ConsecuenciaSiniestroViewModel, poliza: Poliza){
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(viewModel.camposCheckeables.size) { index ->
                val campo = viewModel.camposCheckeables[index]

                SwitchCustom(
                    checked = campo.value.value,
                    onCheckedChange = { newState -> viewModel.onSwitchChange(index, newState) },
                    label = campo.label
                )
            }

            item {
                Button(
                    onClick = {
                        val solicitud = viewModel.crearSolicitudPoliza()
                        if (solicitud != null) {
                            Log.d("solicitud", "se creo")
                            Log.d("solicitud", solicitud.datosSiniestro.consecuenciaSiniestro.toString())
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
    }
}