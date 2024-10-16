package com.example.login.ui.screens.forms

import android.content.Context
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
import com.example.login.components.FieldStringForms
import com.example.login.ui.viewmodels.forms.F5ViewModel

@Composable
fun F5(navController: NavController, viewModel: F5ViewModel, context: Context) {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.weight(1f)) {
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
                    Log.d("solicitud", "${solicitud} ")
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
